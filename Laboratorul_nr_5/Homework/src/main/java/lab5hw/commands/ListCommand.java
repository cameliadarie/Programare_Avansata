package lab5hw.commands;

import lab5hw.Catalog;


/**
 * This class is used to list the items of a catalog
 */
public class ListCommand implements Command {
    protected Catalog myCatalog;

    public ListCommand(Catalog catalog) {
        this.myCatalog = catalog;
    }

    public Catalog getMyCatalog() {
        return myCatalog;
    }

    public void setMyCatalog(Catalog myCatalog) {
        this.myCatalog = myCatalog;
    }

    /**
     * I call the method toString in order to print the items of the catalog
     */
    @Override
    public void executeCommand() {

        System.out.println(myCatalog.getItems().toString());

    }
}
