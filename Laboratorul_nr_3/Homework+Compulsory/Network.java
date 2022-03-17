package lab3;

import java.util.*;

public class Network {
    public List<Node> nodes = new ArrayList<>();

    public Network() {

    }

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void print_network() {

        for (Node node : nodes) {
            node.printCostForNode();
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    /**
     * I check every node in the given list and if it is identifiable,
     * I add it to a list, I sort that list using the compareTo method which compares nodes based on their ip
     *
     * @param network
     */
    public void see_identifiable_nodes(List<Node> network) {

        List<Node> inodes = new ArrayList<>();
        for (Node node : network) {
            if (node instanceof Identifiable) {
                inodes.add(node);
            }
        }

        Collections.sort(inodes, Node::compareTo);

        for (Node node : inodes) {
            System.out.println(node.toString());
        }
    }

    /**
     * Creez matricea de adiacenta deoarece imi trebuie la dijkstra
     * @param n
     * @return
     */
    public int[][] adjacent_matrix(int n) {
        int i, j;
        int[][] mat = new int[n + 1][n + 1];
        for (i = 1; i <= n; i++) {
            for (j = i; j <= n; j++) {
                mat[i][j] = 0;
                mat[j][i] = 0;
            }
        }
        i = 1;
        for (Node node : nodes) {
            int finalI = i;
            node.time_costs.forEach((key, value) -> {
                mat[finalI][nodes.indexOf(key) + 1] = value;
                mat[nodes.indexOf(key) + 1][finalI] = value;
            });
            i = i + 1;
        }

        return mat;
    }


    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}
