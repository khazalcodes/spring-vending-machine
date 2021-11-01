package com.khazalcodes;

import com.khazalcodes.enums.HomeAction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private static final VendingMachineCsvDao dao = new VendingMachineCsvDao();

    public static Map<Integer, ItemDto> itemsHashMap = new HashMap<>();


    // TODO Try introducing invalid choice exception

    public static void startVending() {
        itemsHashMap = dao.getDbAsMap();

        boolean userWantsToVend = true;

        Arrays.stream(HomeAction.values()).forEach(e -> System.out.println(e.IntValue));
//        System.out.println(HomeAction.values());
//        while(userWantsToVend) {
//            HomeAction userChoice = View.homeMenu;
//        }
    }

}
