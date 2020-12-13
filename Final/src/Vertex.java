import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class Vertex {
    String data;
    ArrayList<Vertex> neighborList = new ArrayList<Vertex>();
    int x_pos;
    int y_pos;
    double cost;
    Vertex parent = null;

    // Constructor
    Vertex(String d, int x_pos, int y_pos) {
        data = d;
        parent = null;
        neighborList = new ArrayList<Vertex>();
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        cost = Double.POSITIVE_INFINITY;
    }

    Vertex(String d, int x_pos, int y_pos, double cost) {
        data = d;
        parent = null;
        neighborList = new ArrayList<Vertex>();
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.cost = cost;
    }

    Vertex(){
        data = "hello world";
        neighborList = new ArrayList<>();
        cost = 0;
        parent = null;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString(){
        return data + " cost: " + cost;
    }

    public static void Prim(ArrayList<Vertex> allVertices){
        Vertex start = allVertices.get(0);
        start.parent = start;
        start.cost = 0;
        ArrayList<Vertex> exploreList = new ArrayList<Vertex>();
        exploreList.add(start);

        while(exploreList.size() > 0){
            Vertex v = findMin(exploreList);
            exploreList.remove(v);
            for(Vertex u : allVertices){
                if (u.parent == null){
                    exploreList.add(u);
                }
                //if (Weight(v, u) != 0 && Weight(v, u) < u.cost){
                if (v.parent != u && Weight(v, u) != 0 && Weight(v, u) < u.cost){
                    u.cost = Weight(v, u);
                    u.parent = v;
                }
            }
        }
    }

    public static Vertex findMin(ArrayList<Vertex> arrayList){
        Vertex min = arrayList.get(0);
        for (Vertex v : arrayList){
            if(v.cost < min.cost){
                min = v;
            }
        }
        return min;
    }

    public static double Weight(Vertex from, Vertex to){
         double distance = Math.sqrt(Math.pow(from.x_pos - to.x_pos, 2) + Math.pow(from.y_pos - to.y_pos, 2));
         return distance;
    }

    public static void printPath(Vertex destination){
        while (destination != destination.parent){
            System.out.print(destination + " -> ");
            destination = destination.parent;
        }
        System.out.println(destination);
    }

    public static void main(String[] args) {
        Vertex a = new Vertex("a",0,0);
        Vertex b = new Vertex("b", 3, 1);
        Vertex c = new Vertex("c", 1,2);
        Vertex d = new Vertex("d", 4, 4);
        Vertex e = new Vertex("e", 5, 5);

        System.out.println("Vertex e cost: " + e.cost);

        ArrayList<Vertex> allVlist = new ArrayList<>();

        allVlist.add(a);
        allVlist.add(b);
        allVlist.add(c);
        allVlist.add(d);

        System.out.println(allVlist);

        Vertex x = new Vertex("x",2,0);
        Vertex y = new Vertex("y",0,0);
        Vertex z = new Vertex("z",0,1);
        Vertex j = new Vertex("j",4,3);
        Vertex k = new Vertex("k",3,0);

        ArrayList<Vertex> graph2 = new ArrayList<>();
        graph2.add(x);
        graph2.add(y);
        graph2.add(z);
        graph2.add(j);
        graph2.add(k);


//        System.out.println("Min node: " + findMin(allVlist));
//        System.out.println("from a to b: " + Weight(a, c));
//        System.out.println("from c to b: " + Weight(c, b));
//        System.out.println("from b to d: " + Weight(b, d));
//        System.out.println("from c to c: " + Weight(c, c));
        System.out.println("Call prim on arrayList");
        Prim(allVlist);
        System.out.println("Path from d: ");
        printPath(d);

        System.out.println();
        System.out.println("Graph 2: " + graph2);
        System.out.println("Call Prim on graph 2: ");
        Prim(graph2);
        System.out.println("Path from j: ");
        printPath(j);
        System.out.println("y parent: " + y.parent);
        System.out.println("z parent: " + z.parent);
        System.out.println("cost of z: " + z.cost);
    }
}
