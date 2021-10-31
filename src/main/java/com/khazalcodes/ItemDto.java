package com.khazalcodes;

import com.khazalcodes.interfaces.Dto;

import java.math.BigDecimal;

public class ItemDto implements Dto {

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
            this.price = new BigDecimal(price);
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

    public boolean isDisplayable() {
        return (!this.price.equals(BigDecimal.valueOf(INVALID_NUMBER))  &&
                this.stockRemaining != INVALID_NUMBER &&
                this.stockRemaining != NO_STOCK);
    }

    @Override
    public int getKey() { return key; }

    public static int getCurrentlyAvailableKey() {
        return CURRENTLY_AVAILABLE_KEY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockRemaining() {
        return stockRemaining;
    }

    public void restock() {
        this.stockRemaining += 10;
    }
}
