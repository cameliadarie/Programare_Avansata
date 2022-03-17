package lab3;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    Map<Node, Integer> time_costs = new HashMap<>();
    String name;
    String hardware_address;
    String location_on_map;

    public Node(String name, String hardware_address, String location_on_map) {
        this.name = name;
        this.hardware_address = hardware_address;
        this.location_on_map = location_on_map;
    }

    public void printCostForNode() {
        time_costs.forEach((key, value) -> System.out.println("From " + name + " to " + key.name + " = " + value));
    }

    /**
     * I compare the nodes based on their ip. To be able to call getAddress in order to get their ips,
     * I had to assert that both of the nodes are identifiable
     *
     * @param other node to compare to
     * @return
     */
    @Override
    public int compareTo(Node other) {
        assert this instanceof Identifiable;
        assert other instanceof Identifiable;
        return ((Identifiable) this).getAddress().compareTo(((Identifiable) other).getAddress());
    }

    @Override
    public String toString() {
        return "Node{" +
                ", name='" + name + '\'' +
                ", hardware_address='" + hardware_address + '\'' +
                ", location_on_map='" + location_on_map + '\'' +
                '}';
    }

}
