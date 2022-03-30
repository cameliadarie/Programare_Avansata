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
    protected Item my_item;

    public ViewCommand(String name, Item my_item) {
        this.name = name;
        this.my_item = my_item;
    }

    public Item getItem() {
        return my_item;
    }

    protected void setItem(Item item) {
        this.my_item = item;
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
        String location = my_item.getLocation();
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
