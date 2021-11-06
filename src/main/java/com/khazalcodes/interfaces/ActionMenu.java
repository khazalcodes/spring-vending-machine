package com.khazalcodes.interfaces;

import com.khazalcodes.exceptions.NonExistantActionException;
import com.khazalcodes.interfaces.base.Action;

/**
 * This interface allows multiple menus to be defined for the vending machin yet all share some common characteristics,
 * in such a way that printing them out, validating input and anything else that can be defined for the menus can be
 * declared here. The result is that the View and ValidInput classes do not need to repeat methods as much and so the
 * code is cleaner.
 * */
public interface ActionMenu {
    Action getMenuAction(int userInput) throws NonExistantActionException;
}
