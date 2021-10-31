package com.khazalcodes;

import com.khazalcodes.interfaces.Dao;
import com.khazalcodes.interfaces.Dto;

import java.nio.file.Path;
import java.util.Map;

public class VendingMachineDao implements Dao {

    private static final Path VENDING_MACHINE_FILE_PATH = Path.of("./src/com/khazalcodes/vending-machine.csv");

    public VendingMachineDao() {

    }

    @Override
    public Map<Integer, Dto> getRecordsAsMap() {
        return null;
    }
}
