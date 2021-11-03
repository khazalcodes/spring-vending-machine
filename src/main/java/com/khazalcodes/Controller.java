package com.khazalcodes;

import com.khazalcodes.enums.HomeAction;
import com.khazalcodes.interfaces.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
            HomeAction userChoice = view.homeMenu(new ArrayList<>(service.getAll().values()));

            if (userChoice == HomeAction.QUIT) {
                userWantsToVend = false;
                break;
            }


        }
    }

}
