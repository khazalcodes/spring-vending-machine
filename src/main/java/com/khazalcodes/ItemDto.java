package com.khazalcodes;

import com.khazalcodes.interfaces.DbDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemDto implements DbDto {

    private static final int INVALID_NUMBER = -1;
    private static final int NO_STOCK = 0;

    private final int key;
    private final String name;
    private final BigDecimal price;
    private int stockRemaining;

    public ItemDto(int id, String name, double price, int stockRemaining) {
        this.key = id;
        this.name = name;
        this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        this.stockRemaining = stockRemaining;
    }

    @Override
    public String toString() { return key + ".\t" + name + "\t" + price.toString() + "\t" + stockRemaining; }

    @Override
    public int getKey() { return key; }

    public BigDecimal getPrice() { return price; }

    public int getStockRemaining() { return stockRemaining; }

    public void decrementStock() { this.stockRemaining--; }

    public boolean isDisplayable() {
        return (!this.price.equals(BigDecimal.valueOf(INVALID_NUMBER))  &&
                this.stockRemaining != INVALID_NUMBER &&
                this.stockRemaining != NO_STOCK);
    }
}
