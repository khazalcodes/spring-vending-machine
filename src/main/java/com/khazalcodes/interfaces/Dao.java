package com.khazalcodes.interfaces;

import com.khazalcodes.ItemDto;

import java.util.List;
import java.util.Map;

public interface Dao<T extends Dto> {
    Map<Integer, T> getDbAsMap();
    void saveDb(Map<Integer, T> itemHashMap);
    Dto recordAsDto(List<String> record);
}
