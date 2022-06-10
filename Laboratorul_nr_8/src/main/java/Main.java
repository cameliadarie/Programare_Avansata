import Db.Database;
import Db.InfoTable;
import world.Rows;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Database.createConnection();

            AllClassesDAO allClassesDAO = new AllClassesDAO();
            allClassesDAO.setConnection(Database.getConnection());
            Tool.run(allClassesDAO);
            List<Rows> countryList;
            countryList = allClassesDAO.findAll(InfoTable.COUNTRIES);
            countryList.add(allClassesDAO.findByName(InfoTable.COUNTRIES, "Romania"));
            countryList.add(allClassesDAO.findByName(InfoTable.COUNTRIES, "Spain"));

            allClassesDAO.create("Spain", allClassesDAO.findByName(InfoTable.CONTINENTS, "Europe").id, "Europe");
            allClassesDAO.create("Germany", allClassesDAO.findByName(InfoTable.CONTINENTS, "Europe").id, "Europe");
            allClassesDAO.create("Sweden", allClassesDAO.findByName(InfoTable.CONTINENTS, "Europe").id, "Europe");
            allClassesDAO.create("Bucharest", "Romania", Boolean.TRUE, 143.0, 130.7);
            allClassesDAO.create("Cluj", "Romania", Boolean.FALSE, 101.9, 280.6);
            allClassesDAO.create("South America", 2);
            List<Rows> cityList;
            cityList = allClassesDAO.findAll(InfoTable.CITIES);
            cityList.add(allClassesDAO.findByName(InfoTable.CITIES, "Cluj"));
            cityList.add(allClassesDAO.findByName(InfoTable.CITIES, "Bucharest"));

            Distance.get(allClassesDAO, cityList.get(1), cityList.get(0));
            Database.getConnection().commit();
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.getConnection().rollback();
        }
        Database.closeConnection();
    }

}