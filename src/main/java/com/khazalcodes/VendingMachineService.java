package com.khazalcodes;

import com.khazalcodes.interfaces.DbService;

import java.util.Map;

public class VendingMachineService implements DbService<ItemDto> {

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
    public void saveDb() { csvDao.saveDb(); }
}
