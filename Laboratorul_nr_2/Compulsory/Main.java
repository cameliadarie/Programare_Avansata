package lab2;

/**
 * @author Darie Camelia
 */
public class Main {

    /**
     * Aici instantiez toate obievtele si le si afisez, asa cum cere la punctul 4
     * @param args
     */
    public static void main(String[] args) {
        Event C1 = new Event(8,10,"C1",100);
        Event C2 = new Event(10, 112, "c2",100);
        Event L1 = new Event(8, 10, "L1",30);
        Event L2 = new Event(8, 10, "L2",30);
        Event L3 = new Event(10, 12, "L3",30);
        Room R401 = new Room ( "R401",30, Types.lab);
        Room R405 = new Room("R405",30, Types.lab);
        Room R309 = new Room("R309",30, Types.lecture);

        System.out.println(C1.toString());
        System.out.println(C2.toString());
        System.out.println(L1.toString());
        System.out.println(L1.toString());
        System.out.println(L3.toString());
        System.out.println(R401.toString());
        System.out.println(R405.toString());
        System.out.println(R309.toString());




    }
}
