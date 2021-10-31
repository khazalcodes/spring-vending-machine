package com.khazalcodes;

import com.khazalcodes.interfaces.Dao;
import com.khazalcodes.interfaces.Dto;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class VendingMachineCsvDao implements Dao {

    private static final Path DB_PATH = Path.of("./src/main/resources/vending-machine-items.csv");

    public VendingMachineCsvDao() {}

    @Override
    public Map<Integer, Dto> getDbAsMap() {
        Map<Integer, Dto> vendingMachineItemsHashMap = new HashMap<>();
        List<List<String>> itemStrings = new ArrayList<>();

        try {
            itemStrings = Files.readAllLines(DB_PATH).stream()
                    .map(line -> Arrays.asList(line.split(",")))
                    .collect(Collectors.toList());
            itemStrings.stream()
                    .map()
        } catch (IOException e) {
            System.out.println("File could not be read. Check if path is correct");
        }

        return vendingMachineItemsHashMap;
    }

    @Override
    public void saveDb() {
        return;
    }

    @Override
    public Dto recordAsDto(List<String> itemDetails) { return itemDto(itemDetails); }

    private static ItemDto itemDto(List<String> itemDetails) {
        String name = itemDetails.get(0);
        String price = itemDetails.get(1);
        String stockRemaining = itemDetails.get(2);

        return new ItemDto(name, price, stockRemaining);
    }

    public Path getDbPath() { return DB_PATH; }
}
