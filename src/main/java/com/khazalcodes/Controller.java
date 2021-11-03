package com.khazalcodes;

import com.khazalcodes.enums.HomeAction;
import com.khazalcodes.interfaces.Service;

public class Controller {

    private View view;
    private Service<ItemDto> vendingMachineService;

    public Controller (View view, Service<ItemDto> vendingMachineService) {
        this.view = view;
        this.vendingMachineService = vendingMachineService;
    }

    // TODO Try introducing invalid choice exception

    public static void startVending() {

        boolean userWantsToVend = true;

        while (userWantsToVend) {
            HomeAction userChoice = view.homeMenu();
        }
    }

}
