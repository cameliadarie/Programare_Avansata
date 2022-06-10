package world;

import Db.InfoTable;

/**
 * This abstract class models a row in a table. I know for sure that every roe has to have a name and an id column
 */
public abstract class Rows {
    public static InfoTable infoTable;
    public int id;
    String name;

    public Rows() {
    }

    public Rows(int id, String name, InfoTable infoTable) {
        this.id = id;
        this.name = name;
        this.infoTable = infoTable;
    }

    public static InfoTable getTablename() {
        return infoTable;
    }

    public void setTablename(InfoTable infoTable) {
        Rows.infoTable = infoTable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}