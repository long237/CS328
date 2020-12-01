import java.util.ArrayList;

public class partB {
    public static void main(String[] args) {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");
        Vertex h = new Vertex("h");
        Vertex i = new Vertex("i");

        //Add a neighbors
        a.addNeighbor(d);

        //Add b neighbors
        b.addNeighbor(d);
        b.addNeighbor(f);

        //Add c neighbor
        c.addNeighbor(d);
        c.addNeighbor(e);

        //Add d neighbor
        d.addNeighbor(a);
        d.addNeighbor(b);
        d.addNeighbor(c);

        //Add e neighbor
        e.addNeighbor(c);

        //Add f neighbor
        f.addNeighbor(b);

        //Add g neighbor
        g.addNeighbor(h);
        g.addNeighbor(i);

        //Add h neighbor
        h.addNeighbor(g);
        h.addNeighbor(i);

        //Add i neighbor
        i.addNeighbor(g);
        i.addNeighbor(h);

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
        System.out.print("i neighbor: ");
        i.printNeighbor();

        ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
        vertexList.add(a);
        vertexList.add(b);
        vertexList.add(c);
        vertexList.add(d);
        vertexList.add(e);
        vertexList.add(f);
        vertexList.add(g);
        vertexList.add(h);
        vertexList.add(i);

        ArrayList<Vertex> vertexList2 = new ArrayList<>();
        vertexList2.add(a);
        vertexList2.add(b);
        vertexList2.add(c);
        vertexList2.add(d);
        vertexList2.add(e);
        vertexList2.add(f);

        System.out.println("Before running explore: " + vertexList);

        Vertex.Explore(vertexList);
        System.out.println("After running explore: " + vertexList);
    }
}
