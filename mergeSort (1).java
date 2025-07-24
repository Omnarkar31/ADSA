import java.util.Scanner;

public class mergeSort {

    // Merge two subarrays into arr[]
    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;     // idx for 1st sorted part
        int j = mid + 1; // idx for 2nd sorted part
        int k = 0;      // index for temp

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements of left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right half
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp back to the original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // Main function that sorts arr[si..ei]
    public static void Mergesort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = (si + ei) / 2;
        Mergesort(arr, si, mid);
        Mergesort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Mergesort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
