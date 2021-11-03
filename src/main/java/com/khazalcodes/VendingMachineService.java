package com.khazalcodes;

import com.khazalcodes.interfaces.Service;

import java.util.Map;

public class VendingMachineService implements Service<ItemDto> {

    private final VendingMachineCsvDao csvDao;

    public VendingMachineService(VendingMachineCsvDao csvDao) { this.csvDao = csvDao; }

    public void decrementStock(int id) { csvDao.get(id).decrementStock(); }

    public boolean verifyEnoughMoney() { return false; }

    public void returnChange() { }

    @Override
    public Map<Integer, ItemDto> getAll() { return csvDao.getAll(); }

    @Override
    public ItemDto get(int id) { return csvDao.get(id); }

    @Override
    public void save() { csvDao.saveDb(); }
}
