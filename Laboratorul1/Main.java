import java.util.Random;
import java.util.HashSet;
/**
 * @author Darie Camelia
 */
public class Main {

    /**
     * Cu ajutorul functiei de mai jos validam argumentele. Ex: n si p trebuie sa fie neaparat numere
     * pozitive mai mari decat 0, alfabetul sa contina numai litere, iar acestea sa fie separate printr-un spatiu,
     * literele sa fie distincte intre ele si numarul parametrilor trebuie sa fie mai mare de 3.
     * @param args
     * @return 0 dacacare validarea nu este reusita si 1 in caz contrar
     */
    public static int validare(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: number, number, one or more characters");
            return (0);
        }
        if (args[0].charAt(0) == '-' || args[0].charAt(0) == '0' || !(Character.isDigit(args[0].charAt(0)))) {
            System.out.println("N must be a number bigger than 0 and positive");
            return (0);
        }
        if (args[1].charAt(0) == '-' || args[1].charAt(0) == '0' ||!(Character.isDigit(args[0].charAt(0)))) {
            System.out.println("P must be a number bigger than 0 and positive");
            return (0);
        }
        for(int i=2;i<= args.length-1;i++)
        {   char c=args[i].charAt(0);
            if(Character.isLetter(c)==false)
            {System.out.println("The character typed is not a letter");
                return(0);}
        }
        for(int i=2;i<= args.length-1;i++)
        {   String c=args[i];
            if(c.length()>1)
            {System.out.println("The letters must be separated by a whitespace");
                return(0);}
        }
        HashSet<String> alphabet = new HashSet<String>();
        for(int i=2;i<= args.length-1;i++)
        {
            if(alphabet.contains(args[i])){
                System.out.println("The alphabet must contain unique letters");
                return(0);}
            else alphabet.add(args[i]);

        }
        return (1);
    }
    /**
     * Prin aceasta metoda generez n cuvinte, fiecare avand p litere.
     * @param alphabet
     * @param p
     * @param n
     * @return cuvintele generate
     */
    public static String[] generate(char[] alphabet, int p, int n) {
        int i, j;
        String[] words = new String[n];
        Random r = new Random();
        for (i = 0; i < n; i++) {
            words[i] = "";
            for (j = 0; j < p; j++) {
                int ran = r.nextInt(alphabet.length);
                words[i] = words[i] + alphabet[ran];
            }
        }
        return words;
    }
    /**
     * Aceasta metoda este folosita pentru a verifica daca 2 cuvinte sunt vecine. Daca acestea au o litera
     * in comun.Vom apela aceasta functie in main pentru a genera matricea de adiacenta
     * @param a
     * @param b
     * @param p
     * @param words
     * @return vom returna true, in caz contrar vom returna false

     */
    public static boolean neighbours(int a, int b, int p, String[] words) {
        int j,i;
        for (i = 0; i < p; i++) {
            for (j = 0; j < p; j++)
                if (words[a].charAt(i) == words[b].charAt(j)) {
                    return true;
                }
        }
        return false;
    }
    public static String[] data_structure(boolean[][] neighbours, int n, String[] words){
        int j,i;
        String [] nb= new String[n];

        for (i = 0; i < n; i++) {
            nb[i]="";
            for (j = 0; j < n; j++)
                if (neighbours[i][j] && i!=j)
                    nb[i]=nb[i]+words[j]+ ',';
        }
        return(nb);
    }
    public static void main(String[] args) {
        long startTime=System.nanoTime();
        if (validare(args) == 0)
            System.exit(-1);
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int m = args.length - 2;
        char[] alphabet = new char[m];
        for (int i = 0; i < m; i++) {
            alphabet[i] = args[i + 2].charAt(0);
        }
        String[] words;
        words = generate(alphabet, p, n);
        boolean[][] adjacencyMatrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = neighbours(i, j, p, words);
            }
        }
        String[] nb=data_structure(adjacencyMatrix,n, words);
        if(n>=100)
        {long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("Nanoseconds: " + totalTime);
        }
        else
            for (int i = 0; i < n; i++)
                System.out.println("Vecinii cuvantului " +words[i] +": "+nb[i]);
    }
}
