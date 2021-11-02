package com.khazalcodes;

import com.khazalcodes.enums.HomeAction;
import com.khazalcodes.exceptions.ActionDoesNotExistException;

import java.util.Map;

public class View {
    private static final String WELCOME_MESSAGE = "Welcome to the vending machine.";
    private static final String GOODBYE_MESSAGE = "Thanks for vending. See you soon";
    private static final String ENTER_NUMBER_HOME = "Enter the number of the corresponding action you wish to take:";

    public static void welcomeMessage() { System.out.println(WELCOME_MESSAGE); }
    public static void goodbyeMessage() { System.out.println(GOODBYE_MESSAGE); }



    public static HomeAction homeMenu()  {
        System.out.println("\n" + ENTER_NUMBER_HOME);
        System.out.println(Menus.HOME_MENU);

        return ValidInput.homeAction();
    }

    public static void printDVDs(Map<Integer, ItemDto> itemsHashMap) {
        itemsHashMap.forEach((key, value) -> printItemDto(value));
    }

    /**
     * This should be moved to a toString Overriding method in DVDModel but time is of the essence at 00:55 30/10/2021
     * */
    private static void printItemDto(ItemDto item) {
        if (item.isDisplayable()) {
            System.out.printf("%d.\t%s\t%s\t%d\n",
                    item.getKey(), item.getName(), item.getPrice().toString(), item.getStockRemaining());
        }
    }
}
