package com.khazalcodes;

import com.khazalcodes.Menus;
import com.khazalcodes.UserInput;
import com.khazalcodes.enums.HomeAction;
import com.khazalcodes.exceptions.ActionDoesNotExistException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

public class ValidInput {
    private static final String INVALID_INPUT_INPUT_MESSAGE = "You have entered an invalid input. Please select the " +
            "number that corresponds with the following";

    // These values are based on the options available in the Menus strings.
    private static final int MIN_HOME_CHOICE = 1;
    private static final int MAX_HOME_CHOICE = 2;

    public static HomeAction homeAction() {
        boolean inputIsValid = false;
        HomeAction action = null;

        while (!inputIsValid) {
            try {
                action = HomeAction.fromInt(UserInput.asInt());
                inputIsValid = true;
            } catch (ActionDoesNotExistException e) {
                e.getMessage();
                System.out.println(INVALID_INPUT_INPUT_MESSAGE);
                System.out.println(Menus.HOME_MENU);
            }
        }

        return action;
    }

    private static boolean isValidHomeChoice(int userInput) {
        return (userInput >= MIN_HOME_CHOICE && userInput <= MAX_HOME_CHOICE);
    }
}
