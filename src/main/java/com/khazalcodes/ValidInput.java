package com.khazalcodes;

import com.khazalcodes.enums.VendingMenu;
import com.khazalcodes.exceptions.NoItemInventoryException;
import com.khazalcodes.exceptions.NonExistantActionException;
import com.khazalcodes.interfaces.base.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class was left separate from the service layer since in a regular web app, this kind of validation would be
 * handled on the front end. Since the front end is the command line, user IO should be validated upon entry
 * */
public class ValidInput {
    private static final String INVALID_INPUT_INPUT_MESSAGE = "You have entered an invalid input. Please select the " +
            "number that corresponds with the following";

    public static Action action(VendingMenu menu) {
        Action action;

        while (true) {
            int userChoice = UserInput.asInt();

            try {
                action = menu.getMenuAction(userChoice);
                break;
            } catch (NonExistantActionException e) {
                System.out.println(e.getMessage());;
                System.out.println(INVALID_INPUT_INPUT_MESSAGE);
                System.out.println(menu.Text);
            }
        }

        return action;
    }

    /**
     * Defining this function took a lot of will power. I hate it. I dont like the fact that I am passing
     * */
    public static int item(Map<Integer, ItemDto> items, String itemsText) {
        int itemId;

        while (true) {
            itemId = UserInput.asInt();
            ItemDto itemToGet = items.get(itemId);

            if (itemHasStock(itemToGet)) {
                break;
            }

            System.out.println(INVALID_INPUT_INPUT_MESSAGE);
            System.out.println(itemsText);
        }

        return itemId;
    }

    private static boolean itemHasStock(ItemDto item) {
        return (item != null && item.getStockRemaining() > 0);
    }
}
