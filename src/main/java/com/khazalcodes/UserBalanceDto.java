package com.khazalcodes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UserBalanceDto {
    private BigDecimal balance;
    public UserBalanceDto() {
        balance = new BigDecimal(0).setScale(2, RoundingMode.UNNECESSARY);
    }

    public BigDecimal getBalance() { return balance; }

    public void incrementBalance(double value) {
        balance = balance.add(new BigDecimal(value));
    }

    public void decrementBalance(double value) {
        balance = balance.subtract(new BigDecimal(value));
    }

}
