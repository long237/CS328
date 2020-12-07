import java.util.ArrayList;
import java.util.LinkedList;

public class graph2 {
    public static void main(String[] args) {
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

        //Add b neighbor
        b.addNeighbor(c);
        b.addNeighbor(d);
        b.addNeighbor(e);

        //Add c neighbor
        c.addNeighbor(e);

        //Add d neighbor
        d.addNeighbor(f);

        //Add e neighbor
        e.addNeighbor(b);
        e.addNeighbor(d);

        //Add f neighbor
        f.addNeighbor(e);

        graphG2.add(a);
        graphG2.add(b);
        graphG2.add(c);
        graphG2.add(d);
        graphG2.add(e);
        graphG2.add(f);

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

        LinkedList<Vertex> sortedList = new LinkedList<Vertex>();
        System.out.println("Input array G2: " + graphG2);
        Vertex.DFS(graphG2, sortedList);
        System.out.println(sortedList);
    }
}
