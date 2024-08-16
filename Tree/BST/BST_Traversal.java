import java.util.Scanner;

public class BST_Traversal {
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

    public void RPREORDER(Node t) {
        if (t == null) {
            return;
        }
        System.out.print(t.info + " ");
        RPREORDER(t.lpter);
        RPREORDER(t.rpter);

    }

    public void RINORDER(Node t) {
        if (t == null) {
            return;
        }

        RINORDER(t.lpter);
        System.out.print(t.info + " ");
        RINORDER(t.rpter);

    }

    public void RPOSTORDER(Node t) {
        if (t == null) {
            return;
        }

        RPOSTORDER(t.lpter);
        RPOSTORDER(t.rpter);
        System.out.print(t.info + " ");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 if you want to insert elements in the bst: ");
        System.out.println("Enter 2 if you want to print PREORDER TRAVERSAL,");
        System.out.println("Enter 3 if you want to print RINORDER TRAVERSAL,");
        System.out.println("Enter 4 if you want to print RPOSTORDER TRAVERSAL,");
        System.out.println("Enter 5 if you want to exit from the process:");

        BST_Traversal bst = new BST_Traversal();

        while (true) {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
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
                    break;
                case 2:
                    bst.RPREORDER(bst.t);
                    System.out.println();
                    break;
                case 3:
                    bst.RINORDER(bst.t);
                    System.out.println();
                    break;
                case 4:
                    bst.RPOSTORDER(bst.t);
                    System.out.println();
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }
        }
    }
}
