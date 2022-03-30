package lab5hw.commands;

import lab5hw.Item;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * opens an item using the native operating system application (see the Desktop class);
 */
public class ViewCommand implements Command {

    protected String name;
    protected Item myItem;

    public ViewCommand(String name, Item myItem) {
        this.name = name;
        this.myItem = myItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getMyItem() {
        return myItem;
    }

    public void setMyItem(Item myItem) {
        this.myItem = myItem;
    }

    /**
     * I get the item's location and see if it's a link,
     * if it's not I verify that the location exists and throw
     * an exception if not.
     *
     * @throws IOException
     * @throws InvalidCommandException
     */
    @Override
    public void executeCommand() throws IOException, InvalidCommandException {
        Desktop desktop = Desktop.getDesktop();
        String location = myItem.getLocation();
        boolean matches = location.startsWith("http://")
                || location.startsWith("https://")
                || location.startsWith("ftp://");
        if (!matches) {

            if (new File(location).exists())
                desktop.open(new File(location));
            else
                throw new InvalidCommandException("The file does not exist");
        } else
            desktop.browse(URI.create(location));
    }
}
