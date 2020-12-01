import com.sun.jdi.connect.spi.TransportService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Vertex {
    String data;
    ArrayList<Vertex> neighborList = new ArrayList<Vertex>();
    int distance;
    String color;
    Vertex parent = null;

    // Constructor
    Vertex(String d) {
        data = d;
        parent = null;
        neighborList = new ArrayList<Vertex>();
        parent = null;
        color = "gray";
    }

    Vertex(){
        data = "hello world";
        neighborList = new ArrayList<>();
        distance = 0;
        parent = null;
    }

    public void addNeighbor(Vertex vertex){
        neighborList.add(vertex);
    }

    public void printNeighbor(){
        System.out.println(this.neighborList);
    }

    public ArrayList<Vertex> getNeighborList() {
        return neighborList;
    }

    @Override
    public String toString() {
        return data + " color: " + color;
    }

    public static void BFS(Vertex start){
        start.distance = 0;
        start.parent = start;
        Queue<Vertex> Fqueue = new LinkedList<Vertex>();
        Fqueue.add(start);

        while(Fqueue.size() > 0){
            Vertex currentVertex = Fqueue.remove();
            ArrayList<Vertex> neighborList = currentVertex.getNeighborList();

            for(int i = 0; i < neighborList.size(); i++){
                Vertex neighbor = neighborList.get(i);
                if(neighbor.parent == null){
                    neighbor.distance = currentVertex.distance + 1;
                    neighbor.parent = currentVertex;
                    Fqueue.add(neighbor);
                }
            }
        }
    }

    public static void printPath(Vertex destination){
        while (destination != destination.parent){
            System.out.print(destination + " -> ");
            destination = destination.parent;
        }
        System.out.println(destination);
    }

    public static void Explore(ArrayList<Vertex> verticesList){
        Vertex first_v = verticesList.get(0);
        first_v.color = "blue";
        boolean result = Is_bipartite(first_v);
        for (int i = 0; i < verticesList.size() && result; i++){
            Vertex temp_v = verticesList.get(i);
            if(temp_v.color.equals("gray")){
                temp_v.color = "blue";
                result = Is_bipartite(temp_v);
            }
        }
        if (result == true) {
            System.out.println("Is bipartite");
        }
        else{
            System.out.println("Not bipartite");
        }
    }

    public static boolean Is_bipartite(Vertex start){
        start.distance = 0;
        start.parent = start;
        Queue<Vertex> Fqueue = new LinkedList<Vertex>();
        Fqueue.add(start);

        while(Fqueue.size() > 0){
            Vertex currentVertex = Fqueue.remove();
            ArrayList<Vertex> neighborList = currentVertex.getNeighborList();

            for(int i = 0; i < neighborList.size(); i++){
                Vertex neighbor = neighborList.get(i);
                if(neighbor.color.equals("gray")){
                    //neighbor.distance = currentVertex.distance + 1;
                    neighbor.parent = currentVertex;
                    if(currentVertex.color.equals("blue")){
                        neighbor.color = "red";
                    }
                    else if(currentVertex.color.equals("red")){
                        neighbor.color = "blue";
                    }
                    Fqueue.add(neighbor);
                }
                else if(currentVertex.color.equals(neighbor.color)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");
        Vertex h = new Vertex("h");

        System.out.println("Vertex a: " + a);
        System.out.println("Vertex b: " + b);
        System.out.println("Vertex c: " + c);
        System.out.println("Vertex d: " + d);

        //Add (a) neighbor
        a.addNeighbor(c);
        a.addNeighbor(d);

        //Add (b) neighbor
        b.addNeighbor(c);
        b.addNeighbor(e);

        //Add c neighbor
        c.addNeighbor(a);
        c.addNeighbor(b);
        c.addNeighbor(d);

        //Add d neighbor
        d.addNeighbor(a);
        d.addNeighbor(c);
        d.addNeighbor(e);
        d.addNeighbor(f);

        //Add e neighbors
        e.addNeighbor(b);
        e.addNeighbor(d);
        e.addNeighbor(f);

        //Add f neighbors
        f.addNeighbor(d);
        f.addNeighbor(e);
        f.addNeighbor(h);

        //Add h neighbors
        h.addNeighbor(f);



        System.out.println("Vertex a: " + a);
        System.out.print("a neighbor: ");
        a.printNeighbor();
        System.out.print("b neighbor: ");
        b.printNeighbor();
        System.out.print("c neighbor: ");
        c.printNeighbor();
        System.out.print("d neighbor: ");
        d.printNeighbor();
        System.out.print("e neighbor: ");
        e.printNeighbor();
        System.out.print("f neighbor: ");
        f.printNeighbor();
        System.out.print("g neighbor: ");
        g.printNeighbor();
        System.out.print("h neighbor: ");
        h.printNeighbor();

        ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
        vertexList.add(a);
        vertexList.add(b);
        vertexList.add(c);
        vertexList.add(d);
        vertexList.add(e);
        vertexList.add(f);
        vertexList.add(g);
        vertexList.add(h);

        //Calling BFS;
//        BFS(b);
//        System.out.println("Path from h to c: ");
//        printPath(h);
//        System.out.println("");
//        System.out.println("Path from f to c: ");
//        printPath(f);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a letter for BFS: ");
        String user_input = scanner.nextLine();
        Vertex user_v = null;
        for (Vertex vertex : vertexList){
            if(vertex.data.equals(user_input)){
                user_v = vertex;
            }
        }
        BFS(user_v);
        System.out.println("Path from h to " + user_v.data);
        printPath(h);
        System.out.println("");
        System.out.println("Path from f to " + user_v.data);
        printPath(f);
    }
}
