import java.util.Scanner;

public class SimpleHash {

    static final int SIZE = 10;
    static String[] table = new String[SIZE];

    public static int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % SIZE;
    }

    public static void insert(String key) {
        int index = hash(key);
        int originalIndex = index;

        // Linear probing
        while (table[index] != null) {
            index = (index + 1) % SIZE;
            if (index == originalIndex) {
                System.out.println("Hash table is full. Can't insert '" + key + "'.");
                return;
            }
        }

        table[index] = key;
        System.out.println("Inserted '" + key + "' at index " + index);
    }

    public static void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + ": " + (table[i] == null ? "empty" : table[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many keys to insert? ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key " + (i + 1) + ": ");
            String key = sc.nextLine();
            insert(key);
        }

        display();
        sc.close();
    }
}

