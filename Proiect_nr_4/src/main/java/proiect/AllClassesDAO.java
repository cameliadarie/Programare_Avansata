package proiect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AllClassesDAO {
    private static Connection connection = null;

    public void setConnection(Connection connection) {
        AllClassesDAO.connection = connection;
    }


    public List<Rows> findAll(InfoTable infoTable) throws SQLException {
        var rows = new ArrayList<Rows>();
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs =
                         stmt.executeQuery(
                                 "SELECT * FROM " + infoTable.toString())) {
                while (rs.next()) {
                    if (infoTable == InfoTable.EVENTS) {
                        var tempTable = new Events(InfoTable.EVENTS);
                        tempTable.setId(rs.getInt("id"));
                        tempTable.setName(rs.getString("name"));
                        tempTable.setStart(rs.getInt("start"));
                        tempTable.setEnd(rs.getInt("end"));
                        tempTable.setSize(rs.getInt("size"));
                        rows.add(tempTable);

                    }
                    if (infoTable == InfoTable.ROOMS) {
                        var tempTable = new Rooms(InfoTable.ROOMS);
                        tempTable.setId(rs.getInt("id"));
                        tempTable.setName(rs.getString("name"));
                        tempTable.setCapacity(rs.getInt("capacity"));
                        rows.add(tempTable);
                    }
                }
            }
        }
        return rows;
    }
}
