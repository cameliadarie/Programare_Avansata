package world;

import Db.InfoTable;

/**
 * It models a row in the continent table
 */
public class Continent extends Rows {

    public Continent(InfoTable infoTable) {
        Rows.infoTable = infoTable;
    }

    @Override
    public String toString() {
        return "[id = " + id +
                ", name = '" + name + '\'' +
                ']' + "\n";
    }

}