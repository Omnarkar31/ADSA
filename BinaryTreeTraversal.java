import java.util.*;

// Binary Tree Node class
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Main class for Binary Tree Traversal
public class BinaryTreeTraversal {

    Node root;

    BinaryTreeTraversal() {
        root = null;
    }

    // Build binary tree using level order from list of numbers
    void buildTreeFromList(List<Integer> nums) {
        if (nums.isEmpty()) return;

        root = new Node(nums.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < nums.size()) {
            Node current = queue.poll();

            // Insert left child
            if (i < nums.size()) {
                current.left = new Node(nums.get(i++));
                queue.add(current.left);
            }

            // Insert right child
            if (i < nums.size()) {
                current.right = new Node(nums.get(i++));
                queue.add(current.right);
            }
        }
    }

    // Inorder traversal (Left -> Root -> Right)
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Preorder traversal (Root -> Left -> Right)
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder traversal (Left -> Right -> Root)
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter " + n + " numbers to insert into the tree:");
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }

        tree.buildTreeFromList(nums);

        System.out.print("\nInorder traversal: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder traversal: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder traversal: ");
        tree.postorder(tree.root);

        scanner.close();
    }
}
