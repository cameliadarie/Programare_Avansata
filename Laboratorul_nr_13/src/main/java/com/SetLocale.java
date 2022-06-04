package com;

import java.util.Locale;

public class SetLocale {

    /**
     * Setting the default locale
     *
     * @param locale
     */
    public void set(Locale locale) {
        Locale.setDefault(locale);
    }

}