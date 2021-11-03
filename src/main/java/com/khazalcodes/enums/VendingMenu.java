package com.khazalcodes.enums;

import com.khazalcodes.exceptions.NonExistantActionException;
import com.khazalcodes.interfaces.ActionMenu;
import com.khazalcodes.interfaces.MenuAction;

/**
 * This enum class implements the ActionMenu interface which has essentially allowed us to abstract away the
 * all of the Menu specific details of showing and converting to the corresponding Action enum.
 * */
public enum VendingMenu implements ActionMenu {
    HOME {
        @Override
        public void show() {
            System.out.println("\n1. Buy an item\n2. quit");
        }
        @Override
        public MenuAction getMenuAction(int userInput) throws NonExistantActionException {
            return HomeAction.fromInt(userInput);
        }
    },
    INSERT_COIN {
        @Override
        public void show() {
            System.out.println("\n1. 1p\n2. 2p\n3. 5p\n4. 10p\n5. 20p\n6. 50p\n7. £1\n8.  £2\n9. Finish\n");
        }
        @Override
        public MenuAction getMenuAction(int userInput) throws NonExistantActionException {
            return CoinAction.fromInt(userInput);
        }
    };
}
