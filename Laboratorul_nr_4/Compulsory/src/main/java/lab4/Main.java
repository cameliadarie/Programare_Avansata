package lab4;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Camelia Darie
 */

public class Main {

    private static HashSet<Intersection> intersection_set = new HashSet<>();
    private static LinkedList<Street> street_list = new LinkedList<>();

    /**
     * Here I sort the list using the method compareTo from the class Street.
     * After that I print the list
     * @param list
     */
    public static void sort_list(LinkedList<Street> list) {
        Collections.sort(list, Street::compareTo);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "-> " + list.get(i));
        }
    }

    /**
     * I verify that the set doesn't have duplicates. I compare each element with all the others
     * and if I find 2 elements that are not the same and have the same hashCode, it means there
     * is a duplicate. I also print if I find any duplicate or not
     * @param set
     */
    public static void has_duplicate(HashSet<Intersection> set) {
        int ok = 1;
        for (Intersection n : set)
            for (Intersection n1 : set)
                if (n1.hashCode() != n.hashCode() && n1.equals(n))
                    ok = 0;
        if (ok == 0)
            System.out.println("Are duplicate");
        else System.out.println("Nu are");
    }

    public static void main(String[] args) {

        var intersections = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("node_" + i))
                .toArray(Intersection[]::new);

        Street s12 = new Street("12", 2, intersections[1], intersections[2]);
        Street s13 = new Street("13", 2, intersections[1], intersections[3]);
        Street s14 = new Street("14", 2, intersections[1], intersections[4]);
        Street s26 = new Street("26", 3, intersections[2], intersections[5]);
        Street s45 = new Street("45", 3, intersections[4], intersections[5]);
        Street s23 = new Street("23", 2, intersections[2], intersections[3]);
        Street s34 = new Street("34", 1, intersections[2], intersections[3]);
        Street s35 = new Street("35", 2, intersections[2], intersections[3]);
        Street s37 = new Street("37", 2, intersections[2], intersections[3]);
        Street s56 = new Street("56", 1, intersections[2], intersections[3]);
        Street s58 = new Street("58", 3, intersections[2], intersections[3]);
        Street s69 = new Street("69", 1, intersections[2], intersections[3]);
        Street s68 = new Street("68", 2, intersections[2], intersections[3]);
        Street s78 = new Street("78", 1, intersections[2], intersections[3]);
        Street s79 = new Street("79", 1, intersections[2], intersections[3]);
        Street s89 = new Street("89", 1, intersections[2], intersections[3]);

        street_list.add(s12);
        street_list.add(s13);
        street_list.add(s14);
        street_list.add(s26);
        street_list.add(s45);
        street_list.add(s23);
        street_list.add(s34);
        street_list.add(s35);
        street_list.add(s37);
        street_list.add(s56);
        street_list.add(s58);
        street_list.add(s69);
        street_list.add(s68);
        street_list.add(s79);
        street_list.add(s89);

        sort_list(street_list);
        intersection_set.addAll(Arrays.asList(intersections));
        has_duplicate(intersection_set);
    }
}