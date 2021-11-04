package com.khazalcodes.enums;

import com.khazalcodes.exceptions.NonExistantActionException;
import com.khazalcodes.interfaces.base.Action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum HomeAction implements Action {
    BUY(1),
    QUIT(2);

    public final int Id;

    HomeAction(int value) { this.Id = value; }

    /**
     * This design pattern was sourced from here: http://dan.clarke.name/2011/07/enum-in-java-with-int-conversion/
     * To convert integers to enums on the fly, we need to have some sort of mapping between the integer and the Enums
     * Value field. This can be done with a switch case which is brittle. Instead, we can instantiate a hashmap and then
     * write a static code block which runs at the time of loading a class, even before instantiation.
     * Thus, we code will get all of the possible enum values and for each of those, we use their IntValues as the key
     * with the enum value as the value for the HashMap entry. Then we can create a simple method that takes the int
     * we want to convert and uses the parameter as the key to retrieve the enum we want to return.
     * */
    private static final Map<Integer, HomeAction> map = new HashMap<>();
    static { Arrays.stream(HomeAction.values()).forEach(e -> map.put(e.Id, e)); }

    public static HomeAction fromInt(int value) throws NonExistantActionException {
        if (!map.containsKey(value)) {
            throw new NonExistantActionException("\nThe action you chose does not exist");
        }

        return map.get(value);
    }
}