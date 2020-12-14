import java.util.ArrayList;

public class Node {
    int data;
    ArrayList<Vertex> neighborList = new ArrayList<Vertex>();
    int x_pos;
    int y_pos;
    double cost;
    Node parent = null;

    // Constructor
    Node(int d, int x_pos, int y_pos) {
        data = d;
        parent = null;
        neighborList = new ArrayList<Vertex>();
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        cost = Double.POSITIVE_INFINITY;
    }

    Node(int d, int x_pos, int y_pos, double cost) {
        data = d;
        parent = null;
        neighborList = new ArrayList<Vertex>();
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.cost = cost;
    }



    Node(){
        data = -1;
        neighborList = new ArrayList<>();
        cost = 0;
        parent = null;
    }

    public Node(int x_pos, int y_pos) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        cost = Double.POSITIVE_INFINITY;
    }

    @Override
    public String toString(){
        return "(" + x_pos + "," + y_pos + ")" + " " + "data: " + data;
    }

}
