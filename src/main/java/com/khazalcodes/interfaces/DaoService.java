package com.khazalcodes.interfaces;

import com.khazalcodes.interfaces.base.Service;

import java.util.List;
import java.util.Map;
/**
 * A DaoService will allow the user to create, read, update and delete data transfer objects (DTOs)
 * */
public interface DaoService<T_DTO> extends Service {
    List<T_DTO> getAll();
    Map<Integer, T_DTO> getAllAsMap();
    T_DTO get(int id);
}
