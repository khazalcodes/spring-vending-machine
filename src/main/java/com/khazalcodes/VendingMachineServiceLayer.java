package com.khazalcodes;

import com.khazalcodes.interfaces.ServiceLayer;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineServiceLayer implements ServiceLayer {

    private final VendingMachineCsvDao csvDao;

    public VendingMachineServiceLayer(VendingMachineCsvDao csvDao) {
        this.csvDao = csvDao;
    }


    @Override
    public Map<Integer, ItemDto> getItems() { return csvDao.getDbAsMap(); }

    @Override
    public void decrementStock(int itemId) {

    }

    @Override
    public boolean verifyEnoughMoney() {
        return false;
    }

    @Override
    public void returnChange() {

    }
}
