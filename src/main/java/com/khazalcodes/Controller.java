package com.khazalcodes;

import com.khazalcodes.enums.HomeAction;
import com.khazalcodes.enums.VendingMenu;
import com.khazalcodes.interfaces.MenuAction;

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
        boolean userWantsToVend = true;
        View.welcomeMessage();

        while (userWantsToVend) {
            view.displayItems(new ArrayList<>(service.getAll().values()));
            MenuAction userChoice = view.menu(VendingMenu.HOME);

            if (userChoice == HomeAction.QUIT) {
                userWantsToVend = false;
                break;
            }
        }
    }

}
