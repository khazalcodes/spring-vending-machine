package com.khazalcodes.interfaces;

import java.util.Map;

public interface ServiceLayer<T> {
    Map<Integer, T> getAll();
    T get(int id);
    void save();
}
