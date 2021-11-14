package com.khazalcodes;

import com.khazalcodes.interfaces.Dao;
import com.khazalcodes.interfaces.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Component
public class VendingMachineService implements DbService<ItemDto> {

    private final Dao<ItemDto> dao;

    @Autowired
    public VendingMachineService(@Qualifier("dbDao") Dao<ItemDto> dao) { this.dao = dao; }

    public void decrementStock(int id) { dao.get(id).decrementStock(); }

    @Override
    public List<ItemDto> getAll() { return new ArrayList<>(dao.getAll().values()); }

    @Override
    public Map<Integer, ItemDto> getAllAsMap() { return dao.getAll(); }

    @Override
    public ItemDto get(int id) { return dao.get(id); }

    @Override
    public void saveDb() { dao.saveDb(); }
}
