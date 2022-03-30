package lab5hw.commands;

import lab5hw.Catalog;
import lab5hw.Item;

import java.io.IOException;

/**
 * This class represents the adding command. It receives an item and
 * a catalog and adds that item to the catalog
 */
public class AddCommand implements Command {
    private Item myItem;
    private Catalog myCatalog;

    public AddCommand(Item myItem, Catalog myCatalog) {
        this.myItem = myItem;
        this.myCatalog = myCatalog;
    }

    public Item getMyItem() {
        return myItem;
    }

    public void setMyItem(Item myItem) {
        this.myItem = myItem;
    }

    public Catalog getMyCatalog() {
        return myCatalog;
    }

    public void setMyCatalog(Catalog myCatalog) {
        this.myCatalog = myCatalog;
    }


    /**
     * Adding the item to my catalog
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void executeCommand() throws IOException, ClassNotFoundException {

        myCatalog.getItems().add(myItem);

    }
}
