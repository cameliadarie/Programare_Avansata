package lab5hw;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a catalog. It has a list of items and
 * a name
 */
public class Catalog implements Serializable {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public Catalog(String name) {
        this.name = name;
    }

    public Catalog() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
