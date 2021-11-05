package com.khazalcodes;

import com.khazalcodes.enums.CoinAction;
import com.khazalcodes.exceptions.InsufficientFundsException;
import com.khazalcodes.interfaces.base.Service;
import com.sun.jdi.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class UserBalanceService implements Service {
    private static final DecimalFormat df = new DecimalFormat("###.##");
    private final UserBalanceDto userBalance;
    private double changeDue;


    public UserBalanceService() {
        userBalance = new UserBalanceDto();
    }

    public void increaseBalance(double coinValue) {
        userBalance.increase(coinValue);
    }

    public BigDecimal getBalance() {
        return userBalance.get();
    }

    public String getBalanceAsString() {
        return df.format(userBalance.get().doubleValue());
    }

    public double calculateChange(BigDecimal itemPrice) throws InsufficientFundsException {
        BigDecimal change =  userBalance.get().subtract(itemPrice);

        if (change.signum() >= 0) {
            changeDue = change.doubleValue();
            return changeDue;
        }

        throw new InsufficientFundsException(String.format("You didn't put enough money into the machine for this item.\n" +
                "Your current balance is %s\nThe price of the item you chose costs %s\n Please put in at least %s to" +
                "purchase this item.\n",
                df.format(userBalance.get().doubleValue()),
                df.format(itemPrice.doubleValue()),
                df.format(BigDecimal.valueOf(0).subtract(change).doubleValue())));
    }

    public List<CoinAction> getChange() {
        List<CoinAction> change = new ArrayList<>();

        Queue<CoinAction> validCoins =  Arrays.stream(CoinAction.values())
                .filter(c -> c.Value != CoinAction.FINISH.Value)
                .filter(c -> c.Value <= changeDue)
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));


        CoinAction head = validCoins.peek();

        while (changeDue > 0 && head != null) {

            System.out.println("Head is " + head.Value);
            changeDue -= head.Value;
            change.add(head);

            while (head.Value >= changeDue) {
                validCoins.poll();
                if (validCoins.size() > 0) {
                    head = validCoins.peek();
                } else {
                    break;
                }
            }

        }

        return change;
    }
}
