package com.khazalcodes.interfaces;

import com.khazalcodes.interfaces.base.Service;

import java.util.Map;

public interface DbService<T> extends Service {
    Map<Integer, T> getAll();
    T get(int id);
    void saveDb();
}
