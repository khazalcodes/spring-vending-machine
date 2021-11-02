package com.khazalcodes;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Map;

class VendingMachineCsvDaoTest {

    VendingMachineCsvDao underTest = new VendingMachineCsvDao();
    Path csvPath = Path.of("./src/main/resources/vending-machine-items.csv");

    @Test
    void getDbAsMap() {
        Map<Integer, ItemDto> dbMap = underTest.getItemsMap();
        assert underTest.getItemsMap() != null;
        Assertions.assertEquals(dbMap.get(0).getName(), "water");
    }


    @Test
    void saveDb() {
    }

    @Test
    @Description("DB path is correct")
    void dbPathIsCorrect() {
        Assertions.assertEquals(underTest.getDbPath(), csvPath);
    }
}