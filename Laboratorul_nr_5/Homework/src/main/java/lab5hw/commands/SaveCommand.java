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
    private Catalog myCatalog;

    public SaveCommand(String path, Catalog catalog) {
        this.path = path;
        this.myCatalog = catalog;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Catalog getMyCatalog() {
        return myCatalog;
    }

    public void setMyCatalog(Catalog myCatalog) {
        this.myCatalog = myCatalog;
    }

    @Override
    public void executeCommand() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                myCatalog);

    }
}

