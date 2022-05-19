import java.util.ArrayList;
import java.util.List;

/**
 * This class models a network. It contains a list with all the ppl in this network
 */
public class Network {
    List<String> people = new ArrayList();

    public void addPerson(String human) {
        people.add(human);
    }

    @Override
    public String toString() {
        return "Network{" +
                "people=" + people +
                '}';
    }
}
