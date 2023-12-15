package com.pluralsight;

import static com.pluralsight.ContractFileManager.getContracts;
import static com.pluralsight.UserInterface.*;

public class MainApp {
    public static Dealership newDealership;
    public static void main(String[] args) {
        initialize();
        //getContracts();
        display();
    }
}