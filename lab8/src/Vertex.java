import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Vertex {
    public static int time = 0;
    String data;
    int start = -1;
    int end = -1;
    ArrayList<Vertex> neighborList = new ArrayList<Vertex>();
    Vertex parent = null;

    // Constructor
    Vertex(String d) {
        data = d;
        parent = null;
        neighborList = new ArrayList<Vertex>();
        parent = null;
    }

    Vertex(){
        data = "hello world";
        neighborList = new ArrayList<>();
        parent = null;
    }

    public String getData() {
        return data;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
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
        return data;
    }

    public static void DFS(ArrayList<Vertex> Vlist, LinkedList<Vertex> sortedList){
        for(Vertex v : Vlist){
            if(v.parent == null){
                v.parent = v;
                DFS_visit(v,sortedList);
            }
            //System.out.println("Vertex " + v.getData() + " start: " + v.getStart() + " end: " + v.getEnd());
        }
    }

    public static void DFS_visit(Vertex vertex, LinkedList<Vertex> sortedList){
        time++;
        vertex.start = time;
        ArrayList<Vertex> neighborList = vertex.getNeighborList();
        for(Vertex neighbor : neighborList){
            if(neighbor.parent == null){
                neighbor.parent = vertex;
                DFS_visit(neighbor, sortedList);
            }
            else if (neighbor.end == -1){
                System.out.println("Cycle found, topological sort is impossible");
            }
        }
        time++;
        vertex.end = time;
        sortedList.add(vertex);
    }


    public static void printSorted(LinkedList<Vertex> vList){
        for (int i = vList.size() - 1; i >= 0; i--){
            System.out.println(vList.get(i));
        }
    }

    public static void main(String[] args) {
        int temp = -1;
        System.out.println("temp value: " + temp);

        ArrayList<Vertex> graphG1 = new ArrayList<Vertex>();
        ArrayList<Vertex> graphG2 = new ArrayList<Vertex>();

        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");

        //Add a neighbor
        a.addNeighbor(b);
        a.addNeighbor(c);
        a.addNeighbor(d);

        //Add b neighbor
        b.addNeighbor(d);

        //Add c neighbor
        c.addNeighbor(d);

        //Add d neighbor
        d.addNeighbor(e);

        //Add e neighbor
        e.addNeighbor(g);

        //Add f neighbor
        f.addNeighbor(e);

        graphG1.add(a);
        graphG1.add(b);
        graphG1.add(c);
        graphG1.add(d);
        graphG1.add(e);
        graphG1.add(f);
        graphG1.add(g);


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

        LinkedList<Vertex> sortedList = new LinkedList<Vertex>();
        Stack<Vertex> sortedStack = new Stack<Vertex>();

        System.out.println("Input array G1: " + graphG1);
        DFS(graphG1, sortedList);
        System.out.println(sortedList);
        System.out.println("Sorted order: ");
        printSorted(sortedList);

    }
}
