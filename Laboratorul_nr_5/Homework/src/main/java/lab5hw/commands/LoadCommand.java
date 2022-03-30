package lab5hw.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab5hw.Catalog;

import java.io.File;
import java.io.IOException;

/**
 * This class is used in order to load the catalog
 * from an external file.
 */
public class LoadCommand implements Command {
    private String path;

    public LoadCommand(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * readValue is used to parse or deserialize JSON content into a Java object.
     * The "path" variable represents the path to the external file used
     *
     * @return the catalog loaded from that json file
     * @throws IOException
     */
    public Catalog load() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog myCatalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return myCatalog;
    }

    /**
     * I print the newly created catalog
     *
     * @throws IOException
     */
    @Override
    public void executeCommand() throws IOException {
        System.out.println(load().toString());
    }
}
