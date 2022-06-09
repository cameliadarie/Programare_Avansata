package proiect;

import java.sql.SQLException;
import java.util.*;

/**
 * Generation a problem's solution
 */
public class Repartizare {

    String[][] matrice;
    List<Rows> rooms = null;
    List<Rows> events = null;

    /**
     * I iterate through the events and rooms and verify that the size od the event is smaller or equal than the one of the room.
     * If this is true, I verify that the room is available during the hours of the event. In that case,
     * I assignate the event to that room
     */
    public Repartizare() {
        try {
            Database.createConnection();

            AllClassesDAO allClassesDAO = new AllClassesDAO();
            allClassesDAO.setConnection(Database.getConnection());

            events = allClassesDAO.findAll(InfoTable.EVENTS);
            rooms = allClassesDAO.findAll(InfoTable.ROOMS);
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
        ;

        this.matrice = new String[rooms.size()][24];
        for (Rows i : events) {
            int ok2 = 1;
            for (Rows j : rooms) {
                int ok = 1;
                assert i instanceof Events;
                assert j instanceof Rooms;
                if (((Events) i).getSize() <= ((Rooms) j).getCapacity() && ok2 == 1) {
                    for (int c = ((Events) i).getStart(); c < ((Events) i).getEnd() && ok2 == 1; c++)
                        if (matrice[j.getId() - 1][c] != null) {
                            ok = 0;
                            break;
                        }
                    if (ok == 1) {
                        for (int z = ((Events) i).getStart(); z < ((Events) i).getEnd(); z++)
                            matrice[j.getId() - 1][z] = i.getName();
                        ok2 = 0;
                    }
                }
            }
        }

    }

    public List<String> afisare() {
        List<String> afis = new ArrayList<>() {

        };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 24; j++)
                if (matrice[i][j] != null) {
                    afis.add(matrice[i][j] + "-> " + rooms.get(i).getName() + "\n");
                    j += 2;
                }
        }
        return afis;
    }
}
