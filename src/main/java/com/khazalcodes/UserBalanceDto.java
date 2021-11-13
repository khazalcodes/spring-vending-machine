package com.khazalcodes;

import com.khazalcodes.interfaces.base.Dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This Dto is used solely for holding the state of the total value of coins that the user put in.
 * Everytime the user enters a coin, an instance of this object that is assigned to the userBalanceService is updated
 * with the increase method.
 * */

public class UserBalanceDto implements Dto {
    private BigDecimal balance;

    public UserBalanceDto() {
        balance = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal get() { return balance.setScale(2, RoundingMode.HALF_UP); }

    public void increase(double value) {
        balance = balance.add(new BigDecimal(value)).setScale(2, RoundingMode.HALF_UP);
    }

    public void clear() { balance = BigDecimal.valueOf(0); }
}
