package com.khazalcodes;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        VendingMachineCsvDao csvDao = new VendingMachineCsvDao();
        VendingMachineService vendingMachineService = new VendingMachineService(csvDao);
        UserBalanceService userBalanceService = new UserBalanceService();

        Controller controller = new Controller(view, vendingMachineService,
                userBalanceService);

        controller.startVending();
    }
}
