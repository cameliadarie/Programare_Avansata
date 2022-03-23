package lab4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class City {
    private HashSet<Intersection> intersection_set;
    private LinkedList<Street> street_list;

    public City(HashSet<Intersection> intersection_set, LinkedList<Street> street_list) {
        this.intersection_set = intersection_set;
        this.street_list = street_list;
    }

    /**
     * I find out how many streets this street joins
     *
     * @param streets
     * @param street
     * @return the nummber of streets this street joins
     */
    public int get_nr_joined_streets(LinkedList<Street> streets, Street street) {
        int nr = 0;
        for (Street i : streets) {
            if (!i.getName().equals(street.getName())) {
                if (Objects.equals(i.getEnd(), street.getEnd()) || Objects.equals(i.getEnd(), street.getStart()) || Objects.equals(i.getStart(), street.getEnd()) || Objects.equals(i.getStart(), street.getStart()))
                    nr++;
            }
        }
        return nr;
    }

    /**
     * I print the streets that have the length grater than value and join at least 3 street
     *
     * @param streets
     * @param value
     */
    public void get_query(LinkedList<Street> streets, int value) {
        List<Street> new_list = streets.stream()
                .filter(t -> t.getLength() >= value && get_nr_joined_streets(streets, t) >= 3).toList();

        for (Street s : new_list) {
            System.out.println(s);
            System.out.println(get_nr_joined_streets(streets, s));
        }

    }


}
