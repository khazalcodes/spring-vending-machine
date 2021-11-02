package com.khazalcodes;

import com.khazalcodes.interfaces.Dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class VendingMachineCsvDao implements Dao {

    private static final Path DB_PATH = Path.of("./src/main/resources/vending-machine-items.csv");
    private static final StringBuilder updatedDb = new StringBuilder();

    private final Map<Integer, ItemDto> itemsHashMap = new HashMap<>();
    public VendingMachineCsvDao() {
        readDb();
    }

    public Map<Integer, ItemDto> getItemsMap() {
        Map<Integer, ItemDto> itemsHashMap = new HashMap<>();
        List<List<String>> itemStringsList;
        List<String> fileLines;

        try {
            fileLines = Files.readAllLines(DB_PATH);
        } catch (IOException e) {
            System.out.println("File could not be read. Check if path is correct");
            return null;
        }

        itemStringsList = fileLines.stream()
                .map(line -> Arrays.asList(line.split(",")))
                .collect(Collectors.toList());

        itemStringsList.stream()
                .map(this::recordAsDto)
                .forEach(itemDto -> itemsHashMap.put(itemDto.getKey(), itemDto));

        return itemsHashMap;
    }

    @Override
     public void readDb() {
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
                .map(this::recordAsDto)
                .forEach(itemDto -> itemsHashMap.put(itemDto.getKey(), itemDto));
    }

    @Override
    public void saveDb() {
        itemsHashMap.values().forEach(VendingMachineCsvDao::appendToUpdatedLibrary);

        if (updatedDb.length() > 0) {
            updatedDb.deleteCharAt(updatedDb.length() - 1);
        }

        try {
            Files.writeString(getDbPath(), updatedDb.toString());
        } catch (IOException e) {
            System.out.println("File could not be written to. Check if path is correct");
        }
    }

    private static void appendToUpdatedLibrary(ItemDto itemDto) {
        String sep = ",";

        updatedDb.append(itemDto.getName()).append(sep)
                .append(itemDto.getPrice()).append(sep)
                .append(itemDto.getStockRemaining()).append(System.lineSeparator());
    }

    @Override
    public ItemDto recordAsDto(List<String> itemDetails) {
        String name = itemDetails.get(0);
        String price = itemDetails.get(1);
        String stockRemaining = itemDetails.get(2);

        return new ItemDto(name, price, stockRemaining);

    }

    public Path getDbPath() { return DB_PATH; }
}
