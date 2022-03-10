package lab2;

/**
 * @author Darie Camelia
 */
public class Main {

    /**
     * Here I instantiate a problem and its solution
     *
     * @param args
     */
    public static void main(String[] args) {
        Problem problema = new Problem();
        Solution solutie = new Solution(problema);
        solutie.afisare(problema);
    }
}
