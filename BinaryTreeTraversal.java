import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeTraversal {

    Node root;

    BinaryTreeTraversal() {
        root = null;
    }

    // Build binary tree using level order from number list
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

    // Inorder traversal
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Preorder traversal
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder traversal
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        System.out.print("Enter numbers to insert into the tree (space-separated): ");
        String input = scanner.nextLine();

        // Convert input to list of integers
        String[] tokens = input.trim().split("\\s+");
        List<Integer> nums = new ArrayList<>();
        for (String token : tokens) {
            nums.add(Integer.parseInt(token));
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
