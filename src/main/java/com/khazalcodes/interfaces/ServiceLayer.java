package com.khazalcodes.interfaces;

import com.khazalcodes.ItemDto;

import java.util.HashMap;
import java.util.Map;

public interface ServiceLayer {
    Map<Integer, ItemDto> getItems();
    void decrementStock(int itemId);
    boolean verifyEnoughMoney();
    void returnChange();
}
