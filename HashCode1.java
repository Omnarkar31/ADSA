import java.util.Scanner;

public class SimpleHash {

    static String[] table;

    // Simple hash function: sum of character codes modulo SIZE
    public static int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % table.length;
    }

    // Insert key into hash table
    public static void insert(String key) {
        int index = hash(key);
        table[index] = key;  // Just place it at the hash index
        System.out.println("Inserted '" + key + "' at index " + index);
    }

    // Display hash table
    public static void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": " + (table[i] == null ? "empty" : table[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take size of hash table from user
        System.out.print("Enter size of hash table: ");
        int SIZE = sc.nextInt();
        sc.nextLine(); // Consume newline

        table = new String[SIZE]; // Initialize table with user-defined size

        System.out.print("How many keys to insert? ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key " + (i + 1) + ": ");
            String key = sc.nextLine();
            insert(key);
        }

        display();
        sc.close();
    }
}
