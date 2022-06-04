package com;

import java.util.Locale;

public class DisplayLocales {

    /**
     * I am printing all the available locales
     */
    public void displayInfo() {
        System.out.println("Available locales:");

        Locale available[] = Locale.getAvailableLocales();

        for (Locale locale : available)
            System.out.println(locale.toString());
    }
}