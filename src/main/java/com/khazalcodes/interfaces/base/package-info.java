/**
 * base is the most generic interface that is possible for objects related to the vending machine. Initially, the only
 * thing required was defining an empty Action interface. Since every menu has its own actions and since we abstracted
 * away the detail of what kind of menu gets displayed in the View and ValidInput, we needed some way of abstracting
 * away what actions get passed as all menus have actions and we are passing Menu interfaces around. The solution was
 * simply an empty interface that gave the type Action to both of the ****Action enums. Since they are enums, we cannot
 * implement an abstract class here and besides, we don't need any extra functionality apart from being able to pass
 * the enums under a unified name.
 *
 * By that token, it seemed natural to extend this idea to the Dto and Service. Since again no extra functionality was
 * needed, there was no need to create an abstract class.
 * */
package com.khazalcodes.interfaces.base;
