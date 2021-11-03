package com.khazalcodes.interfaces;

import com.khazalcodes.exceptions.NonExistantActionException;

public interface ActionMenu {
    // Unifies all Action retrieval and verification under one function in ValidInput
    MenuAction getMenuAction(int userInput) throws NonExistantActionException;

    // to unify all menu printings under one function in the view
    void show();
}
