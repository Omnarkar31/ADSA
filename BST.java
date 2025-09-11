import java.util.Scanner;
public class BST {
public static void main(String[] args) {
Create tree = new Create();
Scanner sc = new Scanner(System.in);
System.out.print("Enter the No of elements in The BST : ");
int n = sc.nextInt();
System.out.println();
System.out.print("Enter the elements of the BST : ");
for (int i = 0; i < n; i++) {
int value = sc.nextInt();
tree.insert(value);
}
System.out.print("Inorder Traversal : ");
tree.inorder();
System.out.print("Preorder Traversal : ");
tree.preorder();
System.out.print("Postorder Traversal : ");
tree.postorder();
System.out.print("Enter the number to search : ");
int s = sc.nextInt();
boolean ans = tree.search(s);
if (ans) {
System.out.println(ans + " value " + s + " exist");
} else {
System.out.println(ans + " value " + s + " does not exist");
}
sc.close();
}
}
class Node {
int key;
Node left, right;
public Node(int item) {
key = item;
left = right = null;
}
}
class Create {
Node root;

public Create() {
root = null;
}
void insert(int key) {
root = insertRec(root, key);
}

Node insertRec(Node root, int key) {
if (root == null) {
root = new Node(key);
return root;
}
if (key < root.key) {
root.left = insertRec(root.left, key);
} else {
root.right = insertRec(root.right, key);
}
return root;
}
// Inorder
void inorder() {
inorderRec(root);
System.out.println("\n");
}
void inorderRec(Node root) {
if (root != null) {
inorderRec(root.left);
System.out.print(root.key + " ");
inorderRec(root.right);
}
}
// Preorder
void preorder() {
preorderRec(root);
System.out.println("\n");
}
void preorderRec(Node root) {
if (root != null) {
System.out.print(root.key + " ");
preorderRec(root.left);
preorderRec(root.right);

}
}
// Postorder
void postorder() {
postorderRec(root);
System.out.println("\n");
}
void postorderRec(Node root) {
if (root != null) {
postorderRec(root.left);
postorderRec(root.right);
System.out.print(root.key + " ");
}
}
// Search
boolean search(int s) {
return searchRec(root, s);
}
boolean searchRec(Node root, int s) {
if (root == null) {
return false;
}
if (root.key == s) {
return true;
}
if (root.key < s) {
return searchRec(root.right, s);
} else {
return searchRec(root.left, s);
}
}
}
