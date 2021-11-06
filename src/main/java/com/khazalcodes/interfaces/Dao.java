package com.khazalcodes.interfaces;

import java.util.Map;

public interface Dao<T> {
    void saveDb();
    Map<Integer, T> getAll();
    T get(int id);
}
