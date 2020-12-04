import java.util.ArrayList;

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

    public static void DFS(ArrayList<Vertex> Vlist){
        for(Vertex v : Vlist){
            if(v.parent == null){
                v.parent = v;
                DFS_visit(v);
            }
        }
    }

    public static void DFS_visit(Vertex vertex){
        time++;
        vertex.start = time;
        ArrayList<Vertex> neighborList = vertex.getNeighborList();
        for(Vertex neighbor : neighborList){
            if(neighbor.parent == null){
                neighbor.parent = vertex;
                DFS_visit(neighbor);
            }
            else if (neighbor.end == -1){
                System.out.println("Cycle found");
            }
        }
        vertex.end = time++;
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

        b.addNeighbor(d);

        c.addNeighbor(d);
    }
}
