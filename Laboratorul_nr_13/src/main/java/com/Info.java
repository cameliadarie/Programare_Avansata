package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info {

    /**
     * I am printing the information about the locale
     *
     * @param locale
     */
    public static void info(Locale locale) {
        System.out.println("Country : " + locale.getDisplayCountry());
        System.out.println("Language : " + locale.getDisplayLanguage());
        Currency currency = Currency.getInstance(locale);
        System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName() + ")");
        StringBuilder weekDaysString = new StringBuilder();

        String[] weekDays = DateFormatSymbols.getInstance(locale).getWeekdays();

        weekDaysString.append("Week Days: ");
        weekDaysString.append(weekDays[1]);

        for (int i = 2; i < weekDays.length; i++)
            weekDaysString.append(", ").append(weekDays[i]);

        System.out.println(weekDaysString.toString());

        StringBuilder monthsString = new StringBuilder();
        String[] months = DateFormatSymbols.getInstance(locale).getMonths();

        monthsString.append("Months: ");
        monthsString.append(months[0]);

        for (int i = 1; i < months.length - 1; i++) {
            monthsString.append(", ").append(months[i]);
        }
        System.out.println(monthsString.toString());
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        Date today = new Date();
        System.out.println("Today : " + dateFormat.format(today));

    }
}