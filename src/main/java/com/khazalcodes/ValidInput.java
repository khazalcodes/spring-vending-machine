package com.khazalcodes;

import com.khazalcodes.enums.CoinAction;
import com.khazalcodes.enums.VendingMenu;
import com.khazalcodes.enums.HomeAction;
import com.khazalcodes.exceptions.NonExistantActionException;
import com.khazalcodes.interfaces.MenuAction;

/**
 * This class was left separate from the service layer since in a regular web app, this kind of validation would be
 * handled on the front end. Since the front end is the command line, user IO should be validated upon entry
 * */
public class ValidInput {
    private static final String INVALID_INPUT_INPUT_MESSAGE = "You have entered an invalid input. Please select the " +
            "number that corresponds with the following";

    public static MenuAction action(VendingMenu menu) {
        boolean inputIsValid = false;
        MenuAction action = null;
        int userChoice = UserInput.asInt();


        while (!inputIsValid) {
            try {
                action = menu.getMenuAction(userChoice);
                inputIsValid = true;
            } catch (NonExistantActionException e) {
                System.out.println(e.getMessage());;
                System.out.println(INVALID_INPUT_INPUT_MESSAGE);
                menu.show();
            }
        }

        return action;
    }
}
