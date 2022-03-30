package lab5hw.commands;

import lab5hw.Catalog;
import lab5hw.Item;

import java.io.IOException;

/**
 * This class represents the adding command. It receives an item and
 * a catalog and adds that item to the catalog
 */
public class AddCommand implements Command {
    private Item my_item;
    private Catalog my_catalog;

    public AddCommand(Item my_item, Catalog my_catalog) {
        this.my_item = my_item;
        this.my_catalog = my_catalog;
    }

    public Item getMy_item() {
        return my_item;
    }

    public void setMy_item(Item my_item) {
        this.my_item = my_item;
    }

    public Catalog getMy_catalog() {
        return my_catalog;
    }

    public void setMy_catalog(Catalog my_catalog) {
        this.my_catalog = my_catalog;
    }


    /**
     * Adding the item to my catalog
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void executeCommand() throws IOException, ClassNotFoundException {

        my_catalog.getItems().add(my_item);

    }
}
