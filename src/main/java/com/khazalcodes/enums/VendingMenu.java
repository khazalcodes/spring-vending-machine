package com.khazalcodes.enums;

import com.khazalcodes.exceptions.NonExistantActionException;
import com.khazalcodes.interfaces.ActionMenu;
import com.khazalcodes.interfaces.base.Action;

/**
 * We only need one view and one validate method for this and however many other menus we would hypothetically add.
 * This enum class implements the ActionMenu interface which has essentially allowed us to abstract away the
 * all of the Menu specific details of showing and converting to the corresponding Action enum.
 * */
public enum VendingMenu implements ActionMenu {
    HOME("\n1. Buy an item\n2. quit") {
        @Override
        public Action getMenuAction(int userInput) throws NonExistantActionException {
            return HomeAction.fromInt(userInput);
        }
    },
    INSERT_COIN("\n1. 1p\n2. 2p\n3. 5p\n4. 10p\n5. 20p\n6. 50p\n7. £1\n8.  £2\n9. Finish\n") {
        @Override
        public Action getMenuAction(int userInput) throws NonExistantActionException {
            return CoinAction.fromInt(userInput);
        }
    };

    public String Text;

    VendingMenu(String text) {
        this.Text = text;
    }
}
