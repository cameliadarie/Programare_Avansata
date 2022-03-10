package lab2;

/**
 * Generez solutia problemei
 */
public class Solution {
    public Problem problema;
    String[][] matrice;

    /**
     * Iterez prin evenimente si prin camere. Verific daca size-ul evenimentului este mai mic sau
     * egal decat cel al camerei curente. Daca acest lucru este adevarat, verificam ca acea camera
     * este libera in intervalul orar dorit. In cazul in care aceasta conditie este adevarata, asignam evenimentul i la camera j
     *
     * @param problema o problema
     */
    public Solution(Problem problema) {

        this.problema = problema;
        Event[] events = problema.getEvents();
        Room[] rooms = problema.getRooms();
        this.matrice = new String[rooms.length][24];
        for (int i = 0; i < events.length; i++) {
            for (int j = 0; j < rooms.length; j++) {
                int ok = 1;
                if (events[i].size <= rooms[j].size) {
                    for (int c = events[i].start; c < events[i].end; c++)
                        if (matrice[j][c] != null) {
                            ok = 0;
                            break;
                        }
                    if (ok == 1) {
                        for (int z = events[i].start; z < events[i].end; z++)
                            matrice[j][z] = events[i].name;
                        j = rooms.length + 1;
                    }
                }
            }
        }

    }

    public void afisare(Problem problema) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 24; j++)
                if (matrice[i][j] != null) {
                    System.out.println(matrice[i][j] + "->" + problema.rooms[i].name);
                    j = j + (problema.events[i].end - problema.events[i].start);
                }
        }
    }
}
