import java.util.*;

public class BST_Insert_Search_Delete {
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

    public boolean search(Node t, int data) {
        if (t == null) {
            return false;
        }
        if (t.info == data) {
            return true;
        }

        if (t.info > data) {
            return search(t.lpter, data);
        } else {
            return search(t.rpter, data);
        }

    }

    public Node delete(Node t, int data) {
        if (t.info < data) {
            t.rpter = delete(t.rpter, data);
        } else if (t.info > data) {
            t.lpter = delete(t.lpter, data);
        } else {
            if (t.lpter == null && t.rpter == null) {
                return null;
            } else if (t.lpter == null) {
                return t.rpter;
            } else if (t.rpter == null) {
                return t.lpter;
            } else {
                Node is = inorderSuccessor(t.rpter);
                t.info = is.info;
                t.rpter = delete(t.rpter, is.info);
            }
        }
        return t;
    }

    // Method to find inorder Successor
    public Node inorderSuccessor(Node t) {
        while (t.lpter != null) {
            t = t.lpter;
        }
        return t;
    }

    public void RINORDER(Node t) {
        if (t == null) {
            return;
        }

        RINORDER(t.lpter);
        System.out.print(t.info + " ");
        RINORDER(t.rpter);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 if you want to insert elements in the bst: ");
        System.out.println("Enter 2 if you want to search any element in the bst: ");
        System.out.println("Enter 3 if you want to delete any element in the bst: ");
        System.out.println("Enter 4 if you want to see elements of the bst in inorder:");
        System.out.println("Enter 5 if you want to exit from the process:");

        BST_Insert_Search_Delete bst = new BST_Insert_Search_Delete();

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
                    System.out.println("Enter the number to serach:");
                    int k = sc.nextInt();
                    if (bst.search(bst.t, k)) {
                        System.out.println("found");
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 3:
                    System.out.println("Enter the number to delete:");
                    int del = sc.nextInt();
                    bst.delete(bst.t, del);
                    break;
                case 4:
                    bst.RINORDER(bst.t);
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
