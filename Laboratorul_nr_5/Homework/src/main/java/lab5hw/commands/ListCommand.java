package lab5hw.commands;

import lab5hw.Catalog;


/**
 * This class is used to list the items of a catalog
 */
public class ListCommand implements Command {
    protected Catalog my_catalog;

    public ListCommand(Catalog catalog) {
        this.my_catalog = catalog;
    }

    public Catalog getCatalog() {
        return my_catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.my_catalog = catalog;
    }

    /**
     * I call the method toString in order to print the items of the catalog
     */
    @Override
    public void executeCommand() {

        System.out.println(my_catalog.getItems().toString());

    }
}
