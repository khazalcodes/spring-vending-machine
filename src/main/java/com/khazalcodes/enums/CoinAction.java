package com.khazalcodes.enums;

import com.khazalcodes.exceptions.ActionDoesNotExistException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum CoinAction {
    ONE_P(1),
    TWO_P(2),
    FIVE_P(3),
    TEN_P(4),
    TWENTY_P(5),
    FIFTY_P(6),
    ONE_POUND(7),
    TWO_POUNDS(8),
    FINISH(9);

    public final int IntValue;

    CoinAction(int value) { this.IntValue = value; }

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
    static { Arrays.stream(HomeAction.values()).forEach(e -> map.put(e.IntValue, e)); }

    public static HomeAction fromInt(int value) throws ActionDoesNotExistException {
        if (!map.containsKey(value)) {
            throw new ActionDoesNotExistException("\nThe action you chose does not exist");
        }

        return map.get(value);
    }
}
