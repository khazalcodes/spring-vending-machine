package com.khazalcodes.interfaces;

import com.khazalcodes.interfaces.base.Service;

import java.util.List;
import java.util.Map;

public interface DbService<T> extends Service {
    List<T> getAll();
    Map<Integer, T> getAllAsMap();
    T get(int id);
    void saveDb();
}
