package com.khazalcodes.exceptions;

/**
 * If the item is out of stock or if the item does not exist, there is no inventory for it hence this exception will be thrown
 * */
public class NoItemInventoryException extends Exception{
    public NoItemInventoryException(String message) { super(message); }
}
