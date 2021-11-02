package com.khazalcodes.interfaces;

import com.khazalcodes.ItemDto;

import java.util.List;
import java.util.Map;

public interface Dao {
    void readDb();
    void saveDb();
    Dto recordAsDto(List<String> record);
}
