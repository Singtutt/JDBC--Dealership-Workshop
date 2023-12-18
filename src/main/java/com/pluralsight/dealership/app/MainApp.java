package com.pluralsight.dealership.app;

import com.pluralsight.dealership.app.ui.Screens;
import com.pluralsight.dealership.dao.connect.DataConnect;

public class MainApp {
    public static void main(String[] args) {
        DataConnect.sourceConnect();
        Screens.mainMenuFlow();
    }
}