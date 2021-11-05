package com.khazalcodes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UserBalanceDto {
    private BigDecimal balance;

    public UserBalanceDto() {
        balance = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal get() { return balance.setScale(2, RoundingMode.HALF_UP); }

    public void increase(double value) {
        balance = balance.add(new BigDecimal(value)).setScale(2, RoundingMode.HALF_UP);
    }

    public void decrementBalance(double value) {
        balance = balance.subtract(new BigDecimal(value)).setScale(2, RoundingMode.HALF_UP);
    }
}
