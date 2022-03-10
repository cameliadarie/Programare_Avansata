package lab2;

/**
 * @author Darie Camelia
 */
public class Main {

    /**
     * Aici instantiez toate obievtele si le si afisez, asa cum cere la punctul 4
     *
     * @param args
     */
    public static void main(String[] args) {
     Problem problema= new Problem();
     Solution solutie= new Solution(problema);
     solutie.afisare(problema);
    }
}
