package com.khazalcodes;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        VendingMachineCsvDao csvDao = new VendingMachineCsvDao();
        VendingMachineService service = new VendingMachineService(csvDao);
        Controller controller = new Controller(view, service);
        controller.startVending();
    }
}
