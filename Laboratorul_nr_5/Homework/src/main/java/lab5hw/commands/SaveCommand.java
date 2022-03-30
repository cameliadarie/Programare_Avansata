package lab5hw.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab5hw.Catalog;

import java.io.File;
import java.io.IOException;

/**
 * saves the catalog to an external file using JSON format; you may use Jackson or other library;
 */
public class SaveCommand implements Command {
    private String path;
    private Catalog catalog;

    public SaveCommand(String path, Catalog catalog) {
        this.path = path;
        this.catalog = catalog;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void executeCommand() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);

    }
}

