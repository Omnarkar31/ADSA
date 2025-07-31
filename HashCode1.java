import java.util.Scanner;

public class hashFunction {

    static final int TABLE_SIZE = 10;
    static String[] hashTable = new String[TABLE_SIZE];

    public static int builtInHash(String key) {
        return Math.abs(key.hashCode() % TABLE_SIZE);
    }

    public static int customHash(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += c;
        }
        return hash % TABLE_SIZE;
    }

    public static void insert(String key) {
        int index = customHash(key);
        int startIndex = index;

        while (hashTable[index] != null) {
            index = (index + 1) % TABLE_SIZE;
            if (index == startIndex) {
                System.out.println("Hash table is full!");
                return;
            }
        }

        hashTable[index] = key;
        System.out.println("Inserted '" + key + "' at index " + index);
    }

    public static void displayTable() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.println("Index " + i + ": " + (hashTable[i] == null ? "null" : hashTable[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of keys to insert: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key " + (i + 1) + ": ");
            String key = scanner.nextLine();
            insert(key);
        }

        displayTable();

        scanner.close();
    }
}
