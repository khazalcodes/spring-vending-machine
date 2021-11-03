package com.khazalcodes.interfaces;

import java.util.Map;

public interface Service<T> {
    Map<Integer, T> getAll();
    T get(int id);
    void save();
}
