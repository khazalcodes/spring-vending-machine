package com.khazalcodes;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private static final VendingMachineCsvDao dao = new VendingMachineCsvDao();

    public static Map<Integer, ItemDto> itemsHashMap = new HashMap<>();


    // TODO Try introducing invalid choice exception

    public static void startVending() {
        itemsHashMap = dao.getDbAsMap();

        boolean userWantsToVend = true;

        while(userWantsToVend) {
            HomeAction userChoice = View.homeMenu;
        }
    }

}
