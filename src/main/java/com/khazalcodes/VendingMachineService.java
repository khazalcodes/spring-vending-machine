package com.khazalcodes;

import com.khazalcodes.interfaces.Dao;
import com.khazalcodes.interfaces.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Component
public class VendingMachineService implements DbService<ItemDto> {

    private final Dao<ItemDto> csvDao;

    @Autowired
    public VendingMachineService(Dao<ItemDto> csvDao) { this.csvDao = csvDao; }

    public void decrementStock(int id) { csvDao.get(id).decrementStock(); }

    @Override
    public List<ItemDto> getAll() { return new ArrayList<>(csvDao.getAll().values()); }

    @Override
    public Map<Integer, ItemDto> getAllAsMap() { return csvDao.getAll(); }

    @Override
    public ItemDto get(int id) { return csvDao.get(id); }

    @Override
    public void saveDb() { csvDao.saveDb(); }
}
