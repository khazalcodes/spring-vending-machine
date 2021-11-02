package com.khazalcodes;

public interface VendingMachineServiceLayer {
    void getItems();
    void decrementStock(int itemId);
    boolean verifyEnoughMoney();
    void returnChange();
}
