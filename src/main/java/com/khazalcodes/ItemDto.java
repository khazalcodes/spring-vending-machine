package com.khazalcodes;

import com.khazalcodes.interfaces.DbDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemDto implements DbDto {

    private static int CURRENTLY_AVAILABLE_KEY = 0;
    private static final int INVALID_NUMBER = -1;
    private static final int NO_STOCK = 0;

    private final int key;
    private String name;
    private BigDecimal price;
    private int stockRemaining;

    public ItemDto(String name, String price, String stockRemaining) {
        this.name = name;

        try {
            this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        } catch (NumberFormatException e) {
            System.out.printf("Invalid price in db for %s... Setting price to -1", name);
            this.price = BigDecimal.valueOf(INVALID_NUMBER);
        }

        try {
            this.stockRemaining = Integer.parseInt(stockRemaining);
        } catch (NumberFormatException e) {
            System.out.printf("Invalid stock quantity in db for %s... Setting stock remaining to -1", name);
            this.stockRemaining = INVALID_NUMBER;
        }

        this.key = CURRENTLY_AVAILABLE_KEY;
        CURRENTLY_AVAILABLE_KEY++;
    }

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

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStockRemaining() { return stockRemaining; }

    public void decrementStock() { this.stockRemaining--; }

    public String toCsvString() {
        String sep = ",";
        return name + sep + price.toString() + sep + stockRemaining + System.lineSeparator();
    }

    public boolean isDisplayable() {
        return (!this.price.equals(BigDecimal.valueOf(INVALID_NUMBER))  &&
                this.stockRemaining != INVALID_NUMBER &&
                this.stockRemaining != NO_STOCK);
    }
}
