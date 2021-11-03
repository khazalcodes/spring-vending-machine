package com.khazalcodes;

import com.khazalcodes.enums.HomeAction;
import com.khazalcodes.enums.VendingMenu;
import com.khazalcodes.interfaces.base.Action;

import java.util.ArrayList;

public class Controller {

    private final View view;
    private final VendingMachineService service;

    public Controller (View view, VendingMachineService service) {
        this.view = view;
        this.service = service;
    }

    // TODO Try introducing invalid choice exception

    public void startVending() {
        View.welcomeMessage();

        while (true) {
            view.displayItems(new ArrayList<>(service.getAll().values()));
            Action userChoice = view.menu(VendingMenu.HOME);

            if (userChoice == HomeAction.QUIT) {
                break;
            }
        }

        View.goodbyeMessage();
        service.saveDb();
    }

}
