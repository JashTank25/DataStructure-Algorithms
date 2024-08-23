import java.util.Scanner;

public class FindMaxMinInBST {
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

    public Node insert(Node t, int data) {

        if (t == null) {
            t = new Node(data);
            return t;
        }

        Node newNode = new Node(data);
        if (t.info > newNode.info) {
            t.lpter = insert(t.lpter, data);
        } else {
            t.rpter = insert(t.rpter, data);
        }
        return t;
    }

    int searchMin(Node t, int min) {
        if (t == null) {
            return min;
        }
        return searchMin(t.lpter, t.info);

    }

    int searchMax(Node t, int max) {
        if (t == null) {
            return max;
        }
        return searchMax(t.rpter, t.info);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FindMaxMinInBST bst = new FindMaxMinInBST();

        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("nodes[" + i + "] = ");
            nodes[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            bst.t = bst.insert(bst.t, nodes[i]);
        }

        System.out.println("Min=" + bst.searchMin(bst.t, bst.t.info));
        System.out.println("Max=" + bst.searchMax(bst.t, bst.t.info));

    }
}
