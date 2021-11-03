package com.khazalcodes;

import com.khazalcodes.enums.VendingMenu;
import com.khazalcodes.interfaces.MenuAction;

import java.util.List;

public class View {
    private static final String WELCOME_MESSAGE = "Welcome to the vending machine. Here are all of the vendables you can buy today:\n";
    private static final String GOODBYE_MESSAGE = "Thanks for vending. See you soon";
    private static final String ENTER_CHOICE = "Enter the number of the corresponding action you wish to take:";

    public static void welcomeMessage() { System.out.println(WELCOME_MESSAGE); }
    public static void goodbyeMessage() { System.out.println(GOODBYE_MESSAGE); }



    public MenuAction menu(VendingMenu menu)  {
        System.out.println("\n" + ENTER_CHOICE);
        menu.show();

        return ValidInput.action(menu);
    }



    public void displayItems(List<ItemDto> itemsHashMap) {
        itemsHashMap.forEach(value -> System.out.println(value.toString()));
    }
}
