package lab5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public Catalog(String name) {
        this.name = name;
        this.items = items;
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

    /**
     * Adding an item to the Catalog
     *
     * @param item the item we want to add
     */
    public void add(Item item) {
        items.add(item);
    }

    /**
     * We are finding an item by its id
     *
     * @param id the we are looking for
     * @return
     */
    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
