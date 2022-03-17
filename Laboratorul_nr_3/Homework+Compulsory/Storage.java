package lab3;

import java.util.Locale;

public interface Storage {

    int getStorageCapacity();

    default int convert(String unit) {

        if (unit.equals("MB"))
            return getStorageCapacity() * 1000;
        else if (unit.equals("KB")) {
            return getStorageCapacity() * 1000000;
        } else if (unit.equals("B")) {
            return getStorageCapacity() * 1000000000;
        } else return 0;
    }

}
