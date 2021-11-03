package com.khazalcodes;

import com.khazalcodes.enums.HomeAction;
import java.util.List;

public class View {
    private static final String WELCOME_MESSAGE = "Welcome to the vending machine.";
    private static final String CUE_VENDABLES = "Here are all of the vendables you can buy today:\n";
    private static final String GOODBYE_MESSAGE = "Thanks for vending. See you soon";
    private static final String ENTER_NUMBER_HOME = "Enter the number of the corresponding action you wish to take:";

    public static void welcomeMessage() { System.out.println(WELCOME_MESSAGE); }
    public static void goodbyeMessage() { System.out.println(GOODBYE_MESSAGE); }



    public HomeAction homeMenu(List<ItemDto>  items)  {
        System.out.println(CUE_VENDABLES);
        printItems(items);
        System.out.println("\n" + ENTER_NUMBER_HOME);
        System.out.println(Menus.HOME_MENU);

        return ValidInput.homeAction();
    }



    public static void printItems(List<ItemDto> itemsHashMap) {
        itemsHashMap.forEach(value -> System.out.println(value.toString()));
    }
}
