package com.khazalcodes;

import com.khazalcodes.enums.CoinAction;
import com.khazalcodes.enums.HomeAction;
import com.khazalcodes.enums.VendingMenu;
import com.khazalcodes.exceptions.InsufficientFundsException;
import com.khazalcodes.interfaces.base.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    private final View view;
    private final VendingMachineService vendingMachineService;
    private final UserBalanceService userBalanceService;

    @Autowired
    public Controller (View view, VendingMachineService vendingMachineService,
                       UserBalanceService userBalanceService) {
        this.view = view;
        this.vendingMachineService = vendingMachineService;
        this.userBalanceService = userBalanceService;
    }


    /**
     * The vending machine welcomes the user, displays the items, then enters the maine while loop, which will
     * only terminate if the user chooses exit.
     *
     * If the user wishes to buy something, they must first enter some coins. Another while loop is entered that polls
     * for input about which coin the user wants to insert. The loop will add the value of the coin inserted to the
     * user's balance until the user enters 9 - Finish.
     *
     * The code will then ask the user to pick an item from the vending machine. If the item has a greater value than the
     * users, balance, the user will be asked to put coins in again until they press 9 which will initiate the same check again.
     * Once the user has enough funds, the item will be vended along with any change that the user is due.
     *
     * The loop will repeat thereafter but if the user decides to exit, a good bye message will display and the program will exit.
     * */
    public void vend() {
        view.welcomeMessage();
        boolean noItems = view.displayItems(vendingMachineService.getAll());

        if (noItems) {
            System.out.println("No items in vending machine. Cannot vend. Goodbye.");
            return;
        }

        while (userWantsToBuy()) {
            boolean userWantsToInsertCoins = true;

            while (userWantsToInsertCoins) {
                view.insertCoinsMessage();
                CoinAction coinAction = (CoinAction) view.getMenuAction(VendingMenu.INSERT_COIN);
                if (coinAction == CoinAction.FINISH) {
                    int itemId = view.pickItem(vendingMachineService.getAllAsMap());

                    try {
                        userBalanceService.calculateChange(vendingMachineService.get(itemId).getPrice());
                        vendingMachineService.decrementStock(itemId);
                        userWantsToInsertCoins = false;
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    userBalanceService.increaseBalance(coinAction.Value);
                    view.currentBalance(userBalanceService.getBalanceAsString());
                }
            }
            view.displayChange(userBalanceService.getChange());
            userBalanceService.clearBalance();
        }

        view.goodbyeMessage();
        vendingMachineService.saveDb();
    }

    private boolean userWantsToBuy() {
        Action homeAction = view.getMenuAction(VendingMenu.HOME);
        return homeAction == HomeAction.BUY;
    }
}
