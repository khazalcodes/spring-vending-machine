package com.khazalcodes.interfaces;

import java.util.List;
import java.util.Map;

public interface Dao {
    Map<Integer, Dto> getDbAsMap();
    void saveDb();
    Dto toDto(List record);
}
