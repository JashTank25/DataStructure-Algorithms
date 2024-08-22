import java.util.Scanner;

public class CheckSymmetricTree {
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

    boolean checkSymmetric(Node l, Node r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        return (l.info == r.info) && checkSymmetric(l.lpter, r.rpter) && checkSymmetric(l.rpter, r.lpter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CheckSymmetricTree tree = new CheckSymmetricTree();

        System.out.println("Enter total number of elements:");
        int n = sc.nextInt();
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("element" + i + ":");
            nodes[i] = sc.nextInt();
            System.out.println();
        }

        tree.t=tree.buildTree(nodes, new int[] { 0 });

        boolean isSame = tree.checkSymmetric(tree.t.lpter , tree.t.rpter);
        System.out.println(isSame);
    }
}
