package com.khazalcodes;

import com.khazalcodes.enums.CoinAction;
import com.khazalcodes.enums.HomeAction;
import com.khazalcodes.enums.VendingMenu;
import com.khazalcodes.interfaces.base.Action;

import java.util.ArrayList;

public class Controller {

    private final View view;
    private final VendingMachineService vendingMachinService;
    private final UserBalanceService userBalanceService;

    public Controller (View view, VendingMachineService vendingMachineService,
                       UserBalanceService userBalanceService) {
        this.view = view;
        this.vendingMachinService = vendingMachineService;
        this.userBalanceService = userBalanceService;
    }

    // TODO Try introducing invalid choice exception

    public void startVending() {
        view.welcomeMessage();

        while (true) {
            view.displayItems(new ArrayList<>(vendingMachinService.getAll().values()));
            Action homeAction = view.menu(VendingMenu.HOME);

            if (homeAction == HomeAction.QUIT) {
                break;
            }

            boolean userWantsToInsertCoins = true;




            while (userWantsToInsertCoins) {

                view.insertCoinsMessage();
                Action coinAction = view.menu(VendingMenu.INSERT_COIN);

                if (coinAction == CoinAction.FINISH) {
                    // pick item - must be part of user balance toBuy itemDto
                    // check sufficient funds
                    // if yes break, if no then display price, balance, remaining and menu again
                }

            }
        }

        view.goodbyeMessage();
        vendingMachinService.saveDb();
    }

}
