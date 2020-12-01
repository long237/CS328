import java.util.ArrayList;

public class Graph {
    //Node head;
    Vertex vertex;

//    static class Vertex {
//        String data;
//        ArrayList<Vertex> neighborList = new ArrayList<Vertex>();
//        int distance;
//        Vertex parent = null;
//
//        // Constructor
//        Vertex(String d) {
//            data = d;
//            parent = null;
//            neighborList = new ArrayList<Vertex>();
//            Vertex parent = null;
//        }
//
//        Vertex(){
//            data = "hello world";
//            neighborList = new ArrayList<>();
//            distance = 0;
//            parent = null;
//        }
//
//        public void addNeighbor(Vertex vertex){
//            neighborList.add(vertex);
//        }
//
//        @Override
//        public String toString() {
//            return "Vertex{" +
//                    "data='" + data + '\'' +
//                    ", neighborList=" + neighborList +
//                    ", distance=" + distance +
//                    ", parent=" + parent +
//                    '}';
//        }
//    }

    public static Graph insert(Graph graph, String data){
        //Create new node
        Vertex new_vertex = new Vertex(data);
        new_vertex.parent = null;

        if (graph.vertex == null){
            graph.vertex = new_vertex;
        }

        return graph;
    }

    public static void main(String[] args) {
//        Graph graph = new Graph();
//        graph = insert(graph, "a");
        Vertex v1 = new Vertex("a");
        Vertex v2 = new Vertex("b");
        Vertex v3 = new Vertex("c");
        Vertex v4 = new Vertex("d");
        Vertex v5 = new Vertex("e");
        Vertex v6 = new Vertex("f");
        Vertex v7 = new Vertex("g");
        Vertex v8 = new Vertex("h");

        System.out.println("Vertex a: " + v1);
        System.out.println("Vertex b: " + v2);
        System.out.println("Vertex c: " + v3);
        System.out.println("Vertex d: " + v4);

        //Add v1 (a) neighbor
        v1.addNeighbor(v3);
        v1.addNeighbor(v4);

        //Add v2 (b) neighbor
        v2.addNeighbor(v3);
        v2.addNeighbor(v4);

        //Add v3 (c) neighbor
        v3.addNeighbor(v1);
        v3.addNeighbor(v2);
        v3.addNeighbor(v4);

        System.out.println("Vertex a: " + v1);
        System.out.println("Vertex b: " + v2);
        System.out.println("Vertex c: " + v3);

    }
}