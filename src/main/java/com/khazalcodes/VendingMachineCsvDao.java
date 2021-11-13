package com.khazalcodes;

import com.khazalcodes.interfaces.Dao;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Very similar to the Dao in the DVD library project. A bit more tidy perhaps. File is read, converted to lines,
 * those lines are converted to String arrays split by comma, thos string arrays are converted to Dto and those Dtos are
 * stored into a hashMap which is the live version of the data that gets passed to the service and vv.
 * That biggest vulnerability here is the manual translation of String arr to Dto. Because there is no db to work with,
 * we can't do much about that unfortunately.
 * Db gets saved by converting the hasmap back to a csv file again.
 * */
@Component
public class VendingMachineCsvDao implements Dao<ItemDto> {

    private static final Path DB_PATH = Path.of("./src/main/resources/vending-machine-items.csv");
    private static final StringBuilder updatedDb = new StringBuilder();

    private final Map<Integer, ItemDto> itemsHashMap = new HashMap<>();

    public VendingMachineCsvDao() {
        readDb();
    }

    private void readDb() {
        List<List<String>> itemStringsList;
        List<String> fileLines;

        try {
            fileLines = Files.readAllLines(DB_PATH);
        } catch (IOException e) {
            System.out.println("File could not be read. Check if path is correct");
            return;
        }

        itemStringsList = fileLines.stream()
                .map(line -> Arrays.asList(line.split(",")))
                .collect(Collectors.toList());

        itemStringsList.stream()
                .map(this::csvLineAsDto)
                .forEach(itemDto -> itemsHashMap.put(itemDto.getKey(), itemDto));
    }

    private ItemDto csvLineAsDto(List<String> itemDetails) {
        String name = itemDetails.get(0);
        String price = itemDetails.get(1);
        String stockRemaining = itemDetails.get(2);

        return new ItemDto(name, price, stockRemaining);
    }

    public Path getDbPath() { return DB_PATH; }

    @Override
    public Map<Integer, ItemDto> getAll() {
        if (itemsHashMap.isEmpty()) {
            readDb();
        }

        return itemsHashMap;
    }

    /**
     * Get a single ItemDto
     * */
    @Override
    public ItemDto get(int id) { return itemsHashMap.get(id);  }

    @Override
    public void saveDb() {
        itemsHashMap.values().forEach(i -> updatedDb.append(i.toCsvString()));

        if (updatedDb.length() > 0) {
            updatedDb.deleteCharAt(updatedDb.length() - 1);
        }

        try {
            Files.writeString(getDbPath(), updatedDb.toString());
        } catch (IOException e) {
            System.out.println("File could not be written to. Check if path is correct");
        }
    }


}
