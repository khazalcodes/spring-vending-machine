package com.khazalcodes.interfaces;

import com.khazalcodes.ItemDto;

import java.util.List;
import java.util.Map;

public interface Dao<T> {
    void readDb();
    void saveDb();

    Map<Integer, T> getAll();
    T get(int id);
}
