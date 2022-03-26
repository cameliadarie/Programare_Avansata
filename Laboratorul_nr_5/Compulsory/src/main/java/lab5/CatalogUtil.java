package lab5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CatalogUtil {
    /**
     * saves the catalog to an external file
     *
     * @param catalog
     * @param path    the path to the json file
     * @throws IOException
     */
    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }

    /**
     * loads the catalog from an external file.
     *
     * @param path
     * @return
     * @throws InvalidCatalogException
     * @throws IOException
     */
    public static Catalog load(String path) throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }

}
