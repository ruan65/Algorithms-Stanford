package stanford_ass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Ass4_Find_SCCs {

    static HashMap<Integer,Node> graph = new HashMap<>();
    static HashMap<Integer, Node> reversedGraph = new HashMap<>();
    static HashMap<Integer, Node> reorderedGraph = new HashMap<>();
    static HashMap<Integer, Integer> orderDfs = new HashMap<>();
    static HashMap<Integer, AtomicInteger> sCcs = new HashMap<>();
    static int t = 0;
    static int s = 0;
    static int leader = 0;

    public static void main(String[] args) throws FileNotFoundException {

//        Scanner sc = new Scanner(new File("scc_test1.txt"));
        Scanner sc = new Scanner(new File("SCC.txt"));


        while (sc.hasNextLine()) {
            String[] edge = sc.nextLine().split("\\s+");

            int node = Integer.parseInt(edge[0]);
            int to = Integer.parseInt(edge[1]);

            if (!graph.containsKey(node)) {

                graph.put(node, new Node(node));
            }

            if (!graph.containsKey(to)) {

                graph.put(to, new Node(to));
            }

            if (!reversedGraph.containsKey(to)) {
                reversedGraph.put(to, new Node(to));
            }

            if (!reversedGraph.containsKey(node)) {
                reversedGraph.put(node, new Node(node));
            }

            graph.get(node).addEdge(to);
            reversedGraph.get(to).addEdge(node);
        }
//        System.out.println("Graphs has been created gr: " + graph);
//        System.out.println(reversedGraph);
        System.out.println("Graphs are created");
        getOrderedDfs();
        System.out.println("Ordered Dfs is got");

//        System.out.println(orderDfs);
        reorderGraph();

        System.out.println("Graph reordered");
//        System.out.println(reorderedGraph);
        findAllSccs();
        sCcs.entrySet()
                .stream()
                .map(e -> e.getValue().get())
                        .sorted((x, y) -> y.compareTo(x))
                        .limit(5)
                        .forEachOrdered(e -> System.out.print(e + ","));

        System.out.println();
    }

    public static void reorderGraph() {

        for (int i : graph.keySet()) {
            Node node = graph.get(i);
            int newName = orderDfs.get(i);
            node.name = newName;
            ArrayList<Integer> newEdges = new ArrayList<>();

            for (int edge : node.edges) {
                newEdges.add(orderDfs.get(edge));
            }
            node.edges = newEdges;
            reorderedGraph.put(newName, node);
        }
    }

    public static void findAllSccs() {

        for (int i = reorderedGraph.size(); i > 0; i--) {
            if (!reorderedGraph.get(i).explored) {

                leader = i;
                sCcs.put(leader, new AtomicInteger(1));
                countScc(i);
            }
        }
    }

    public static void getOrderedDfs() {

        for (int i = graph.size(); i > 0; i--) {
            if (!reversedGraph.get(i).explored) {

                innerLoopDfs(i);
            }
        }
    }

    public static void countScc(int index) {

        Node node = reorderedGraph.get(index);
        node.explored = true;

        for (int edge : node.edges) {
            Node nextNode = reorderedGraph.get(edge);

            if (!nextNode.explored) {
                sCcs.get(leader).getAndIncrement();
                countScc(edge);
            }
        }
    }

    public static void innerLoopDfs(int index) {

        Node node = reversedGraph.get(index);
        node.explored = true;

        for (int edge : node.edges) {

            if (!reversedGraph.get(edge).explored) {
                innerLoopDfs(edge);
            }
        }
        t++;
        s = index;
        orderDfs.put(s, t);

    }

    static class Node {

        int name;
        int fTime;

        boolean explored;

        ArrayList<Integer> edges = new ArrayList<>();

        Node(int name) {
            this.name = name;
        }

        public void addEdge(int name) {
            edges.add(name);
        }

        @Override
        public String toString() {
            return "Node{" +
                    name +

                     edges +
                    '}';
        }
    }

}
