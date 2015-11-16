package stanford_ass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ass5_DijkstraShortestPath {

    Graph graph;
    HashMap<Integer, Vertex> minScoreHeep;
    Map<Integer, Integer> distance = new HashMap<>();
    Map<Integer, Integer> parents = new HashMap<>();

    Vertex current;

    {
        graph = new Graph();
        try {
            Graph.fillGraph(graph, "dijkstraData.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        graph.source = 1;
        graph.vertexes.get(1).score = 0;

        minScoreHeep = new HashMap<>();
        fillScoreHeep();
    }

    int minScoreVertexIndex(Map<Integer, Vertex> map) {
        int minScore = 1_000_000;
        int index = -1;
        for (int e : map.keySet()) {
            if (minScore > map.get(e).score) {
                index = e;
                minScore = map.get(e).score;
            }
        }
        return index;
    }

    void calculateShortestPaths() {

        current = minScoreHeep.remove(minScoreVertexIndex(minScoreHeep));
        distance.put(current.id, current.score);
        parents.put(current.id, current.parentId);

        while (!minScoreHeep.isEmpty()) {

            for (Edge edge : current.edges) {
                if (minScoreHeep.containsKey(edge.to)) {
                    if (minScoreHeep.get(edge.to).score > edge.w + current.score) {
                        minScoreHeep.get(edge.to).score = edge.w + current.score;
                        parents.put(edge.to, current.id);
                    }
                }

            }

            current = minScoreHeep.remove(minScoreVertexIndex(minScoreHeep));
            distance.put(current.id, current.score);
        }
    }

    void fillScoreHeep() {
        for (int v : graph.vertexes.keySet()) {
            Vertex e = graph.vertexes.get(v);
            minScoreHeep.put(v, e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Ass5_DijkstraShortestPath ass = new Ass5_DijkstraShortestPath();

        ass.calculateShortestPaths();

        String[] ends = "7,37,59,82,99,115,133,165,188,197".split(",");

        String solution = "";

        for (String e : ends) {

            solution += ass.distance.get(Integer.parseInt(e)) + ",";
        }

        System.out.println(solution.substring(0, solution.length() -1));
    }
}

class Vertex {

    int id;
    int score = 1_000_000;
    int parentId = -1;
    ArrayList<Edge> edges = new ArrayList<>();

    public Vertex(int id) {
        this.id = id;
    }

    void addEdge(Edge edge) {
        edges.add(edge);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", score=" + score +
                ", parent=" + parentId +
                ", edges=" + edges +
                '}';
    }
}

class Edge {

    int to;
    int w;

    public Edge(int to, int w) {
        this.to = to;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "to=" + to +
                ", w=" + w +
                '}';
    }
}

class Graph {

    int source;
    Map<Integer, Vertex> vertexes = new HashMap<>();

    void addVertex(Vertex v) {
        vertexes.put(v.id, v);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "source=" + source +
                ", vertexes=" + vertexes +
                '}';
    }

    static void fillGraph(Graph graph, String fileName) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(fileName));

        while (sc.hasNextLine()) {

            String[] vArr = sc.nextLine().split("\\s+");
            graph.addVertex(createVertex(vArr));
        }
    }

    static Vertex createVertex(String[] v) {

        Vertex vertex = new Vertex(Integer.parseInt(v[0]));

        for (int i = 1; i < v.length; i++) {
            String[] pair = v[i].split(",");
            vertex.addEdge(new Edge(Integer.parseInt(pair[0]), Integer.parseInt(pair[1])));
        }
        return vertex;
    }
}
