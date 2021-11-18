package com.khazalcodes;

import com.khazalcodes.interfaces.DbDao;
import com.khazalcodes.interfaces.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Component
public class VendingMachineService implements DaoService<ItemDto> {

    private final DbDao<ItemDto> dao;

    @Autowired
    public VendingMachineService(@Qualifier("dbDao") DbDao<ItemDto> dao) { this.dao = dao; }

    public void decrementStock(int id) { dao.get(id).decrementStock(); }

    @Override
    public List<ItemDto> getAll() { return new ArrayList<>(dao.getDbAsMap().values()); }

    @Override
    public Map<Integer, ItemDto> getAllAsMap() { return dao.getDbAsMap(); }

    @Override
    public ItemDto get(int id) { return dao.get(id); }
}
