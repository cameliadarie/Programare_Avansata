package lab2;

public class Solution {
    public Problem problema;
    String[][] matrice;

    public Solution(Problem problema) {
        this.problema = problema;
        Event[] events = problema.getEvents();
        Room[] rooms = problema.getRooms();
        this.matrice=new String[rooms.length][24];
        for (int i = 0; i < events.length; i++)
            for (int j = 0; j < rooms.length; j++) {
                if (events[i].size <= rooms[j].size)
                    if (matrice[j][events[i].start] == null) {
                        for (int z = events[i].start; z < events[i].end; z++)
                            matrice[j][z] = events[i].name;
                        break;
                    }

            }

    }

    public void afisare(Problem problema) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 24; j++)
            if (matrice[i][j] != null)
            {System.out.println(matrice[i][j]+"->"+problema.rooms[i].name);
                j=j+(problema.events[i].end-problema.events[i].start);}
        }
    }
}
