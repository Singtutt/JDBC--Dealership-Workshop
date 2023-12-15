package com.pluralsight.dealership.app;

import com.pluralsight.dealership.dao.connect.DataConnect;
import com.pluralsight.dealership.model.Dealership;

import static com.pluralsight.dealership.app.UserInterface.*;

public class MainApp {
    public static void main(String[] args) {
        DataConnect.sourceConnect();
        UserInterface.display();
    }
}