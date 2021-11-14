package com.khazalcodes;

import com.khazalcodes.interfaces.Dao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Qualifier("dbDao")
public class DbDao implements Dao<ItemDto> {
    @Override
    public void saveDb() {

    }

    @Override
    public Map<Integer, ItemDto> getAll() {
        return new HashMap<>();
    }

    @Override
    public ItemDto get(int id) {
        return null;
    }
}
