package com.khazalcodes;

import com.khazalcodes.interfaces.Dto;
import com.khazalcodes.interfaces.ServiceLayer;

import java.util.Map;

public class VendingMachineServiceLayer implements ServiceLayer<ItemDto> {

    private final VendingMachineCsvDao csvDao;

    public VendingMachineServiceLayer(VendingMachineCsvDao csvDao) { this.csvDao = csvDao; }


    @Override
    public Map<Integer, ItemDto> getAll() { return csvDao.getAll(); }



    public void decrementStock(int itemId) {

    }

    public boolean verifyEnoughMoney() {
        return false;
    }

    public void returnChange() {

    }
}
