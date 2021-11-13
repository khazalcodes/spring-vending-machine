package com.khazalcodes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
/**
 * Due to time constraints, I have not implemented the Unit tests nor did I do the AuditDao. My main focus here was to
 * go hard on the idea of using interfaces and dependency injection. I put a lot of thought into what gets returned and how
 * albeit some stuff that I implemented last night was of sub par quality due to it being late and in a hurry.
 *
 * Nonetheless, Welcome to the vending machine, main, will instantiate the necessary application components and then
 * pass the view and services on to the controller which will then begin the vending machine.
 * */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.khazalcodes");
        applicationContext.refresh();

        Controller controller = applicationContext.getBean("controller", Controller.class);

        controller.vend();
    }
}