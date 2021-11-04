package com.khazalcodes;

import com.khazalcodes.enums.VendingMenu;
import com.khazalcodes.interfaces.base.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class View {
    private static final String WELCOME_MESSAGE = "Welcome to the vending machine. Here are all of the vendables you can buy today:\n";
    private static final String GOODBYE_MESSAGE = "Thanks for vending. See you soon";
    private static final String INSERT_COINS_MESSAGE = "Enter coins by selecting inputting their respective numbers and" +
            " then enter Finish (9) to continue to choosing the item you would like.";
    private static final String ENTER_CHOICE = "Enter the number of the corresponding action you wish to take:";
    private static final String PICK_ITEM = "Please choose the item you wish to purchase by entering its number number " +
            "eg. 5. walkers ... -> Enter the number 5";


    public void welcomeMessage() { System.out.println(WELCOME_MESSAGE); }
    public void goodbyeMessage() { System.out.println(GOODBYE_MESSAGE); }
    public void insertCoinsMessage() { System.out.println(INSERT_COINS_MESSAGE); }



    public Action menu(VendingMenu menu)  {
        System.out.println("\n" + ENTER_CHOICE);
        System.out.println(menu.Text);

        return ValidInput.action(menu);
    }

    public int pickItem(Map<Integer, ItemDto> items) {
        System.out.println(PICK_ITEM);
        displayItems(new ArrayList<>(items.values()));


        return ValidInput.item(items);
    }

    public void displayItems(List<ItemDto> items) {
        items.forEach(value -> System.out.println(value.toString()));
    }
}
