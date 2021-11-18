package com.khazalcodes.interfaces;

import com.khazalcodes.interfaces.base.Dao;

import java.util.Map;

public interface DbDao<T> extends Dao {
    void readDb();
    void updateDb(T dto);
    void deleteFromDb(T dto);
    void addToDb(T dto);
    Map<Integer, T> getDbAsMap();
    T get(int id);
}
