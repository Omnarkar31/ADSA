import java.util.Scanner;

public class SimpleHash {
    static String[] table;

    public static int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % table.length;
    }

    public static void insert(String key) {
        int index = hash(key);
        table[index] = key;
    }

    public static void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": " + (table[i] == null ? "empty" : table[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of hash table: ");
        int size = sc.nextInt();
        sc.nextLine();
        table = new String[size];

        System.out.print("Enter a string key to insert: ");
        String key = sc.nextLine();
        insert(key);

        display();
        sc.close();
    }
}
