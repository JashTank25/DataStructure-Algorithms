import java.util.*;

public class SameTreeOrNot {
    class Node {
        int info;
        Node lpter;
        Node rpter;

        public Node(int data) {
            info = data;
            lpter = null;
            rpter = null;
        }
    }

    public Node t = null;

    public Node buildTree(int[] nodes, int[] idx) {

        if (idx[0] >= nodes.length || nodes[idx[0]] == -1) {
            idx[0]++;
            return null;
        }

        Node newNode = new Node(nodes[idx[0]++]);
        newNode.lpter = buildTree(nodes, idx);
        newNode.rpter = buildTree(nodes, idx);

        return newNode;
    }

    boolean checkSimilar(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.info == t2.info) && checkSimilar(t1.lpter, t2.lpter) && checkSimilar(t1.rpter, t2.rpter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SameTreeOrNot tree1 = new SameTreeOrNot();
        SameTreeOrNot tree2 = new SameTreeOrNot();

        System.out.println("Enter the elements inside TREE1:");
        System.out.println("Enter total number of elements:");
        int n1 = sc.nextInt();
        int[] nodes1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            System.out.print("element" + i + ":");
            nodes1[i] = sc.nextInt();
            System.out.println();
        }
        tree1.t=tree1.buildTree(nodes1, new int[] { 0 });

        System.out.println("Enter the elements inside TREE2:");
        System.out.println("Enter total number of elements:");
        int n2 = sc.nextInt();
        int[] nodes2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            System.out.print("element" + i + ":");
            nodes2[i] = sc.nextInt();
            System.out.println();
        }
        tree2.t=tree2.buildTree(nodes2, new int[] { 0 });

        boolean isSame = tree1.checkSimilar(tree1.t, tree2.t);
        System.out.println(isSame);
    }
}
