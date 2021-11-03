package com.khazalcodes;

import com.khazalcodes.enums.VendingMenu;
import com.khazalcodes.interfaces.base.Action;

import java.util.List;

public class View {
    private static final String WELCOME_MESSAGE = "Welcome to the vending machine. Here are all of the vendables you can buy today:\n";
    private static final String GOODBYE_MESSAGE = "Thanks for vending. See you soon";
    private static final String INSERT_COINS_MESSAGE = "Enter coins by selecting inputting their respective numbers and" +
            " then enter Finish (9) to continue to choosing the item you would like.";
    private static final String ENTER_CHOICE = "Enter the number of the corresponding action you wish to take:";

    public void welcomeMessage() { System.out.println(WELCOME_MESSAGE); }
    public void goodbyeMessage() { System.out.println(GOODBYE_MESSAGE); }
    public void insertCoinsMessage() { System.out.println(INSERT_COINS_MESSAGE); }



    public Action menu(VendingMenu menu)  {
        System.out.println("\n" + ENTER_CHOICE);
        System.out.println(menu.Text);

        return ValidInput.action(menu);
    }

    public void displayItems(List<ItemDto> itemsHashMap) {
        itemsHashMap.forEach(value -> System.out.println(value.toString()));
    }
}
