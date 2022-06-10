import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * I extract information from the given file and insert it into my db
 */
public class Tool {
    static int id = 5;

    public static void run(AllClassesDAO allClassesDAO) throws SQLException {
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\camel\\Downloads\\concap.csv"))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        records.remove(0);

        for (List<String> item : records) {
            allClassesDAO.create(item.get(item.size() - 1), id++);
        }

        for (List<String> item : records) {
            allClassesDAO.create(item.get(0), item.get(item.size() - 1));
        }
        for (List<String> item : records) {

            allClassesDAO.create(item.get(1), item.get(0),
                    true, Double.valueOf(item.get(2)), Double.valueOf(item.get(3)));
        }
    }
}