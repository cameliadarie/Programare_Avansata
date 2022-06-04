package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;


import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static java.util.ResourceBundle.*;

/**
 * @author Darie Camelia A2
 */
public class LocaleExplore {
    /**
     * Depending on the command the user types in, I do different things such as displaying locales,
     * displaying the information available or setting the locale
     *
     * @param args
     */
    public static void main(String[] args) {
        Locale locale = new Locale("ro", "RO");
        Info info = new Info();
        ResourceBundle resources =
                getBundle("Messages");

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print(resources.getString("prompt") + " ");
            input = scanner.nextLine();

            switch (input) {
                case "Display Locales" -> {
                    System.out.println(resources.getString("locales"));
                    new DisplayLocales().displayInfo();
                }
                case "Info" -> {
                    System.out.println(resources.getString("info"));
                    info.info(Locale.getDefault());
                }
                case "Set Locale" -> {
                    String loc = scanner.nextLine();
                    new SetLocale().set(new Locale(loc));
                }
                default -> System.out.println(resources.getString("invalid"));
            }
        }
    }
}