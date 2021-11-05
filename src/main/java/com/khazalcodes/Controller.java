package com.khazalcodes;

import com.khazalcodes.enums.CoinAction;
import com.khazalcodes.enums.HomeAction;
import com.khazalcodes.enums.VendingMenu;
import com.khazalcodes.exceptions.InsufficientFundsException;
import com.khazalcodes.interfaces.base.Action;

import java.math.BigDecimal;

public class Controller {

    private final View view;
    private final VendingMachineService vendingMachineService;
    private final UserBalanceService userBalanceService;

    public Controller (View view, VendingMachineService vendingMachineService,
                       UserBalanceService userBalanceService) {
        this.view = view;
        this.vendingMachineService = vendingMachineService;
        this.userBalanceService = userBalanceService;
    }

    // TODO Try introducing invalid choice exception

    public void startVending() {
        view.welcomeMessage();

        while (true) {
            view.displayItems(vendingMachineService.getAll());
            Action homeAction = view.menu(VendingMenu.HOME);


            if (homeAction == HomeAction.QUIT) {
                break;
            }

            boolean userWantsToInsertCoins = true;

            while (userWantsToInsertCoins) {
                view.insertCoinsMessage();
                CoinAction coinAction = (CoinAction) view.menu(VendingMenu.INSERT_COIN);
                if (coinAction == CoinAction.FINISH) {
                    int itemId = view.pickItem(vendingMachineService.getAllAsMap());

                    try {
                        double changeDue = userBalanceService.calculateChange(
                                vendingMachineService.get(itemId).getPrice());

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
        }

        view.goodbyeMessage();
        vendingMachineService.saveDb();
    }

}
