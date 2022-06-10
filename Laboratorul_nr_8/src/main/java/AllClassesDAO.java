import Db.*;
import world.City;
import world.Continent;
import world.Country;
import world.Rows;

import java.sql.*;
import java.util.ArrayList;


public class AllClassesDAO {
    private static Connection connection = null;
    private int id = 5;

    public void setConnection(Connection connection) {
        AllClassesDAO.connection = connection;
    }

    /**
     * method for inserting into the continents table
     *
     * @param name
     * @param id
     * @throws SQLException
     */
    public void create(String name, int id) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO theworld.continents (name,id) VALUES (?,?)")) {

            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Continent insert complete!");

        } catch (SQLException e) {
            System.err.println("Insertion fail: " + e);
        }
    }

    /**
     * method for inserting into the cities table
     *
     * @param name
     * @param country
     * @param capital
     * @param latitude
     * @param longitude
     * @throws SQLException
     */
    public void create(String name, String country, Boolean capital, Double latitude, Double longitude) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO theworld.cities (name, country, capital, latitude, longitude) VALUES (?,?,?,?,?)")) {

            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.setObject(3, capital);
            pstmt.setDouble(4, latitude);
            pstmt.setDouble(5, longitude);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Insertion fail: " + e);
        }
    }

    /**
     * method for inserting into the countries table
     *
     * @param name
     * @param continent
     * @throws SQLException
     */
    public void create(String name, String continent) throws SQLException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(
                "INSERT INTO theworld.countries (name, continent) VALUES (?,?)")) {

            prepareStatement.setString(1, name);
            prepareStatement.setString(2, continent);
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Insertion fail: " + e);
        }
    }

    /**
     * method for inserting into the countries table. I needed 2. One for me and one for the tool
     *
     * @param name
     * @param continent
     * @throws SQLException
     */
    public void create(String name, int id, String continent) throws SQLException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(
                "INSERT INTO theworld.countries (name, id, continent) VALUES (?,?,?)")) {

            prepareStatement.setString(1, name);
            prepareStatement.setInt(2, id);
            prepareStatement.setString(3, continent);
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Insertion fail: " + e);
        }
    }

    /**
     * This method gets (with select) every row from a given table and returns the list
     *
     * @param infoTable
     * @return
     * @throws SQLException
     */
    public ArrayList<Rows> findAll(InfoTable infoTable) throws SQLException {
        var rows = new ArrayList<Rows>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM " + infoTable.toString())) {
            while (rs.next()) {
                if (infoTable == InfoTable.CITIES) {
                    var tempTable = new City(InfoTable.CITIES);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    tempTable.setCapital(rs.getBoolean("capital"));
                    tempTable.setLongitude(rs.getDouble("longitude"));
                    tempTable.setLatitude(rs.getDouble("latitude"));
                    rows.add(tempTable);
                }
                if (infoTable == InfoTable.COUNTRIES) {
                    var tempTable = new Country(InfoTable.COUNTRIES);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    tempTable.setCode(rs.getInt("code"));
                    tempTable.setContinent(rs.getString("continent"));
                    rows.add(tempTable);
                }
                if (infoTable == InfoTable.CONTINENTS) {
                    var tempTable = new Continent(InfoTable.CONTINENTS);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    rows.add(tempTable);
                }
            }
            return rows;
        }
    }

    /**
     * I only select the rows from a given table where the name is a specified value.
     *
     * @param infoTable
     * @param name
     * @return
     * @throws SQLException
     */
    public Rows findByName(InfoTable infoTable, String name) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM " + infoTable.toString() + " WHERE name='" + name + "'")) {
            if (rs.next()) {
                if (infoTable == InfoTable.CITIES) {
                    var tempTable = new City(InfoTable.CITIES);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    tempTable.setCapital(rs.getBoolean("capital"));
                    tempTable.setLongitude(rs.getDouble("longitude"));
                    tempTable.setLatitude(rs.getDouble("latitude"));
                    tempTable.setCountry(rs.getString("country"));
                    System.out.println(rs.getInt("id"));
                    return tempTable;
                }
                if (infoTable == InfoTable.COUNTRIES) {
                    var tempTable = new Country(InfoTable.COUNTRIES);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    tempTable.setCode(rs.getInt("code"));
                    tempTable.setContinent(rs.getString("continent"));
                    return tempTable;
                }
                if (infoTable == InfoTable.CONTINENTS) {
                    var tempTable = new Continent(InfoTable.CONTINENTS);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    return tempTable;
                }
            }
            return null;
        }
    }

    /**
     * * I only select the rows from a given table where the id is a specified value.
     *
     * @param rows
     * @param id
     * @return
     * @throws SQLException
     */
    public Rows findById(Rows rows, int id) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM " + rows.toString() + " WHERE id=" + id)) {
            rs.next();
            if (rows.infoTable == InfoTable.CITIES) {
                var tempTable = new City(InfoTable.CITIES);
                tempTable.setId(rs.getInt("id"));
                tempTable.setName(rs.getString("name"));
                tempTable.setCapital(rs.getBoolean("capital"));
                tempTable.setLongitude(rs.getDouble("longitude"));
                tempTable.setLatitude(rs.getDouble("latitude"));
                tempTable.setCountry(rs.getString("country"));
                return tempTable;
            }
            if (rows.infoTable == InfoTable.COUNTRIES) {
                var tempTable = new Country(InfoTable.COUNTRIES);
                tempTable.setId(rs.getInt("id"));
                tempTable.setName(rs.getString("name"));
                tempTable.setCode(rs.getInt("code"));
                tempTable.setContinent(rs.getString("continent"));
                return tempTable;
            }
            if (rows.infoTable == InfoTable.CONTINENTS) {
                var tempTable = new Continent(InfoTable.CONTINENTS);
                tempTable.setId(rs.getInt("id"));
                tempTable.setName(rs.getString("name"));
                return tempTable;
            }
            return null;
        }
    }

    /**
     * I need this method for the tool class. In case I call it for a country or  a continent, I return -1.0,
     * else I return city's lat value
     *
     * @param city
     * @return
     */
    public Double getLatitude(Rows city) {
        if (city instanceof Country || city instanceof Continent)
            return -1.0;

        return ((City) city).getLatitude();
    }

    /**
     * I need this method for the tool class. In case I call it for a country or  a continent, I return -1.0,
     * else I return city's lon value
     *
     * @param city
     * @return
     */
    public Double getLongitude(Rows city) {
        if (city instanceof Country || city instanceof Continent)
            return -1.0;
        return ((City) city).getLongitude();
    }
}