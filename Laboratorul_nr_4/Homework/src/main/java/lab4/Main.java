package lab4;

import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;

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
     *
     * @param list
     */
    public static void sort_list(LinkedList<Street> list) {
        list.sort(Street::compareTo);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "-> " + list.get(i));
        }
    }

    /**
     * I verify that the set doesn't have duplicates. I compare each element with all the others
     * and if I find 2 elements that are not the same and have the same hashCode, it means there
     * is a duplicate. I also print if I find any duplicate or not
     *
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


    /**
     * Here I solve the problem
     */
    public static void prim() {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        for (Intersection i : intersection_set)
            graph.addVertex(i.getName());
        for (Street i : street_list)
            graph.addEdge(i.getStart().getName(), i.getEnd().getName());
        PrimMinimumSpanningTree<String, DefaultEdge> alg = new PrimMinimumSpanningTree<>(graph);
        System.out.println(alg.getSpanningTree());

    }

    public static void main(String[] args) {
        Faker f = new Faker();
        var intersections = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Intersection(f.address().streetName()))
                .toArray(Intersection[]::new);

        Street s12 = new Street(f.address().streetName(), 2, intersections[1], intersections[2]);
        Street s13 = new Street(f.address().streetName(), 2, intersections[1], intersections[3]);
        Street s14 = new Street(f.address().streetName(), 2, intersections[1], intersections[4]);
        Street s26 = new Street(f.address().streetName(), 3, intersections[2], intersections[6]);
        Street s45 = new Street(f.address().streetName(), 3, intersections[4], intersections[5]);
        Street s23 = new Street(f.address().streetName(), 2, intersections[2], intersections[3]);
        Street s34 = new Street(f.address().streetName(), 1, intersections[3], intersections[4]);
        Street s35 = new Street(f.address().streetName(), 2, intersections[3], intersections[5]);
        Street s37 = new Street(f.address().streetName(), 2, intersections[3], intersections[7]);
        Street s56 = new Street(f.address().streetName(), 1, intersections[5], intersections[6]);
        Street s58 = new Street(f.address().streetName(), 3, intersections[5], intersections[8]);
        Street s69 = new Street(f.address().streetName(), 1, intersections[6], intersections[9]);
        Street s68 = new Street(f.address().streetName(), 2, intersections[6], intersections[8]);
        Street s78 = new Street(f.address().streetName(), 1, intersections[7], intersections[8]);
        Street s79 = new Street(f.address().streetName(), 1, intersections[7], intersections[9]);
        Street s89 = new Street(f.address().streetName(), 1, intersections[8], intersections[9]);

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
        street_list.add(s78);
        street_list.add(s89);

        sort_list(street_list);
        intersection_set.addAll(Arrays.asList(intersections));
        has_duplicate(intersection_set);

        City new_city = new City(intersection_set, street_list);

        new_city.get_query(street_list, 3);
        prim();
    }

}