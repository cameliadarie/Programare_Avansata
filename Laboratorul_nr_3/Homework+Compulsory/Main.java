package lab3;

/**
 * In this method I created the network and added some nodes in it; I also print the whole network and print identifiable nodes ordered after their ip
 */
public class Main {

    public static void main(String[] args) {
        Network network = new Network();
        Node v1 = new Computer("Computer A", "00:00:5e:00:53:af", "Iasi", "192.0.0.1", 5000);
        Node v2 = new Router("Router A", "00:00:0A:BB:28:FC", "Iasi", "192.0.0.2");
        Node v3 = new Switch("Switch A", "00:00:5e:00:53:al", "Iasi");
        Node v4 = new Switch("Switch B", "2C:54:91:88:C9:E3", "Iasi");
        Node v5 = new Router("Router B", "00:00:0A:BB:28:FC", "Iasi", "192.0.0.4");
        Node v6 = new Computer("Computer B", "00:00:5e:00:53:af", "Iasi", "192.0.0.3", 9000);

        v1.time_costs.put(v2, 10);
        v1.time_costs.put(v3, 50);
        v2.time_costs.put(v3, 20);
        v2.time_costs.put(v4, 20);
        v2.time_costs.put(v5, 20);
        v3.time_costs.put(v4, 10);
        v4.time_costs.put(v5, 30);
        v4.time_costs.put(v6, 10);
        v5.time_costs.put(v6, 20);

        network.addNode(v1);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v4);
        network.addNode(v5);
        network.addNode(v6);

        network.print_network();
        network.see_identifiable_nodes(network.nodes);
    }
}
