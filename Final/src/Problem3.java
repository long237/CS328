import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem3 {
//    static class Node{
//        int data;
//        ArrayList<Vertex> neighborList = new ArrayList<Vertex>();
//        int x_pos;
//        int y_pos;
//        double cost;
//        Node parent = null;
//
//        // Constructor
//        Node(int d, int x_pos, int y_pos) {
//            data = d;
//            parent = null;
//            neighborList = new ArrayList<Vertex>();
//            this.x_pos = x_pos;
//            this.y_pos = y_pos;
//            cost = Double.POSITIVE_INFINITY;
//        }
//
//        Node(int d, int x_pos, int y_pos, double cost) {
//            data = d;
//            parent = null;
//            neighborList = new ArrayList<Vertex>();
//            this.x_pos = x_pos;
//            this.y_pos = y_pos;
//            this.cost = cost;
//        }
//
//
//
//        Node(){
//            data = -1;
//            neighborList = new ArrayList<>();
//            cost = 0;
//            parent = null;
//        }
//
//        public Node(int x_pos, int y_pos) {
//            this.x_pos = x_pos;
//            this.y_pos = y_pos;
//            cost = Double.POSITIVE_INFINITY;
//        }
//
//        @Override
//        public String toString(){
//            return "(" + x_pos + "," + y_pos + ")" + " " + "data: " + data;
//        }
//    }
//
    public static ArrayList<Node> matrixConversion(int[][] matrix) {
        ArrayList<Node> allVList = new ArrayList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                allVList.add(new Node(matrix[r][c], r, c));
            }
        }
        return allVList;
    }

    public static void findComponent(ArrayList<Node> inputar, int[][] matrixDirection, int[][] inputMa){
        for (Node node : inputar){
            if (node.data == 1 && node.parent == null){
                //System.out.println("Execute if");
                node.parent = node;
                for (int r = 0; r < matrixDirection.length; r++){
                    for (int c = 0; c < matrixDirection[r].length - 1; c++){
                        int temp_x = node.x_pos;
                        int temp_y = node.y_pos;
                        temp_x = temp_x + matrixDirection[r][c];
                        temp_y = temp_y + matrixDirection[r][c + 1];
                        while(inBound(inputMa, temp_x, temp_y)){
                            Node neighbor = findNode(inputar, temp_x, temp_y);
                            if (node.data == neighbor.data){                //check to see if neighbor also is a 1
                                neighbor.parent = node;                     //set the node parent to the starting point
                                temp_x = temp_x + matrixDirection[r][c];        //Keep walking in the same direction
                                temp_y = temp_y + matrixDirection[r][c + 1];
                            }
                            else {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static Node findNode (ArrayList<Node> nodeList, int x, int y){
        for (Node node : nodeList){
            if (node.x_pos == x && node.y_pos == y){
                return node;
            }
        }
        return null;
    }

    public static boolean inBound(int[][] inputar, int x, int y){
        if (x < inputar.length && x >= 0 && y < inputar[0].length && y >= 0 ){
            return true;
        }
        return false;
    }

//    public static int countComp(ArrayList<Node> inputar){
//        ArrayList<Node> group = new ArrayList<>();
//        for (Node node : inputar){
//            if (node.data == 1) {
//                Node parent = node.parent;
//                for (Node compGroup : group) {
//                    if (parent != null && !isEqual(parent, compGroup)) {
//                        group.add(parent);
//                    }
//                }
//            }
//        }
//        return group.size();
//    }

    public static int countComp(ArrayList<Node> inputar){
        int num_comp = 0;
        for (Node node : inputar){
            if (node.data == 1 && node.parent == node){
                num_comp++;
            }
        }
        return num_comp;
    }

    public static boolean isEqual(Node a, Node b){
        if (a.data != b.data || a.x_pos != b.x_pos || a.y_pos != b.y_pos){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] m = new int[4][4];
        m[0][0] = 0;
        m[0][1] = 1;
        m[0][2] = 1;
        m[0][3] = 1;
        m[1][0] = 0;
        m[1][1] = 0;
        m[1][2] = 1;
        m[1][3] = 0;
        m[2][0] = 0;
        m[2][1] = 0;
        m[2][2] = 0;
        m[2][3] = 1;
        m[3][0] = 1;
        m[3][1] = 1;
        m[3][2] = 0;
        m[3][3] = 0;

        int[][] m2 = new int[3][5];
        m2[0][0] = 1;
        m2[0][1] = 1;
        m2[0][2] = 1;
        m2[0][3] = 0;
        m2[0][4] = 1;
        m2[1][0] = 1;
        m2[1][1] = 0;
        m2[1][2] = 0;
        m2[1][3] = 0;
        m2[1][4] = 0;
        m2[2][0] = 0;
        m2[2][1] = 0;
        m2[2][2] = 1;
        m2[2][3] = 1;
        m2[2][4] = 0;



        int[][] matrixDirection = new int[8][2];
        matrixDirection[0][0] = -1;
        matrixDirection[0][1] = -1;
        matrixDirection[1][0] = -1;
        matrixDirection[1][1] = 0;
        matrixDirection[2][0] = -1;
        matrixDirection[2][1] = 1;
        matrixDirection[3][0] = 0;
        matrixDirection[3][1] = -1;
        matrixDirection[4][0] = 0;
        matrixDirection[4][1] = 1;
        matrixDirection[5][0] = 1;
        matrixDirection[5][1] = -1;
        matrixDirection[6][0] = 1;
        matrixDirection[6][1] = 0;
        matrixDirection[7][0] = 1;
        matrixDirection[7][1] = 1;



        System.out.println("Input matrix 1: " + Arrays.deepToString(m));
        ArrayList<Node> inputMa = matrixConversion(m);
        System.out.println("ArrayList of Node: " + inputMa);

        findComponent(inputMa, matrixDirection, m);

        for (Node n : inputMa){
            System.out.println("Node " + n + " parent: " + n.parent);
        }

        System.out.println();
        System.out.println("Number of components are: " + countComp(inputMa));

        /**Matrix 2 here: **/
        System.out.println();
        System.out.println("Matrix 2: " + Arrays.deepToString(m2));
        ArrayList<Node> inputMa2 = matrixConversion(m2);
        System.out.println("ArrayList 2: " + inputMa2);
        findComponent(inputMa2, matrixDirection, m2);
        for (Node n : inputMa2){
            System.out.println("Node " + n + " parent: " + n.parent);
        }
        System.out.println();
        System.out.println("Number of components for 2 are: " + countComp(inputMa2));



    }
}
