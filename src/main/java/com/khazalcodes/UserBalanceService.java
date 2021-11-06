package com.khazalcodes;

import com.khazalcodes.enums.CoinAction;
import com.khazalcodes.exceptions.InsufficientFundsException;
import com.khazalcodes.interfaces.base.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The service responsible for keeping track of the user's coin balance and returning change.
 * It does this through the UserBalanceDto.
 * Various methods are defined that interact with the Dto's methods.
 * The two big boys are the calculateChange and getChange methods.
 *
 * calculateChange will receive the prices of the item picked by the user and then subtract that from the user's balance.
 * If the value is positive, change is due, that value is recorded in the changeDue variable (which is used later) and
 * then changeDue is returned to the controller. Otherwise, an Insifficient funds exception is returned with appropriate text.
 *
 * getChange will return a list of CoinActions which will be output to the screen and shown as the user's change.
 * This occurs through getting all coins whos values are less than or equal to the changeDue and putting them into a
 * queue with the most valuable coin first. It will then iterate over that queue, decreasing the value of changeDue and
 * adding that coin to the change list until there is no more change after which it returns.
 * */
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

    public String getBalanceAsString() { return df.format(userBalance.get().doubleValue()); }

    public void clearBalance() { userBalance.clear(); }

    public void calculateChange(BigDecimal itemPrice) throws InsufficientFundsException {

        BigDecimal change = getBalance().subtract(itemPrice).setScale(2, RoundingMode.HALF_UP);
        if (change.signum() >= 0) {
            changeDue = change.doubleValue(); // The change value is copied to changeDue instead of being returned directly as this will be used later
            return;
        }

        throw new InsufficientFundsException(String.format("You didn't put enough money into the machine for this item.\n" +
                "Your current balance is £%s\nThe price of the item you chose costs £%s\nPlease put in at least £%s to" +
                "purchase this item.\n",
                df.format(userBalance.get().doubleValue()),
                df.format(itemPrice.doubleValue()),
                df.format(BigDecimal.valueOf(0).subtract(change).doubleValue()))); // We subtract because the change is negative
    }

    public List<CoinAction> getChange() {
        List<CoinAction> change = new ArrayList<>();

        Queue<CoinAction> validCoins =  Arrays.stream(CoinAction.values())
                .filter(c -> c.Value != CoinAction.FINISH.Value)
                .filter(c -> c.Value <= changeDue)
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        validCoins.forEach(System.out::println);

        while (!validCoins.isEmpty() && changeDue > 0) {
            CoinAction head = validCoins.peek();

            if (head.Value > changeDue) {
                validCoins.poll();
            } else {
                changeDue -= head.Value;
                change.add(head);
            }
        }

        return change;
    }
}
