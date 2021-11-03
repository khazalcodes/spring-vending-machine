package com.khazalcodes.interfaces;

import com.khazalcodes.ItemDto;

import java.util.HashMap;
import java.util.Map;

public interface ServiceLayer<T> {
    Map<Integer, T> getAll();
    T get();
    void save();
}
