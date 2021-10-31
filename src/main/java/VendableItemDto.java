package com.khazalcodes;

import com.khazalcodes.interfaces.Dto;

public class VendableItemDto implements Dto {
    private static int CURRENTLY_AVAILABLE_KEY = 0;
    private final int key;

    public VendableItemDto() {
        this.key = CURRENTLY_AVAILABLE_KEY;
        CURRENTLY_AVAILABLE_KEY++;
    }

    @Override
    public int getKey() { return key; }
}
