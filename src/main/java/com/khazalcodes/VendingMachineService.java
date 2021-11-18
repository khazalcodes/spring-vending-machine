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
    private final Map<Integer, ItemDto> itemsMap;

    @Autowired
    public VendingMachineService(@Qualifier("dbDao") DbDao<ItemDto> dao) {
        this.dao = dao;
        this.itemsMap = dao.getDbAsMap();
    }

    public void decrementStock(int id) {
        ItemDto item = itemsMap.get(id);
        item.decrementStock();
        dao.updateRow(item);
    }

    @Override
    public List<ItemDto> getAll() { return new ArrayList<>(itemsMap.values()); }

    @Override
    public Map<Integer, ItemDto> getAllAsMap() { return itemsMap; }

    @Override
    public ItemDto get(int id) { return itemsMap.get(id); }
}
