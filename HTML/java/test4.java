import java.util.Arrays;  // to use Arrays.sort() and Arrays.copyOf()
import java.util.Scanner;

class test4{

    // Method 1: Find Maximum value
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max)
                max = num;
        }
        return max;
    }

    // Method 2: Sort the array
    static void sortArray(int[] arr) {
        Arrays.sort(arr); // built-in sorting
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    // Method 3: Search a value in array
    static boolean searchValue(int[] arr, int key) {
        for (int num : arr) {
            if (num == key)
                return true;
        }
        return false;
    }

    // Method 4: Resize array using Arrays.copyOf()
    static int[] resizeArray(int[] arr, int newSize) {
        int[] newArr = Arrays.copyOf(arr, newSize);
        return newArr;
    }

    // Main method to test all operations
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initial array
        int[] arr = {5, 2, 9, 1, 7};
        System.out.println("Original array: " + Arrays.toString(arr));

        // 1. Find max
        System.out.println("Maximum value: " + findMax(arr));

        // 2. Sort array
        sortArray(arr);

        // 3. Search value
        System.out.print("Enter value to search: ");
        int key = sc.nextInt();
        if (searchValue(arr, key))
            System.out.println(key + " found in array.");
        else
            System.out.println(key + " not found.");

        // 4. Resize array
        System.out.print("Enter new size: ");
        int newSize = sc.nextInt();
        int[] resized = resizeArray(arr, newSize);
        System.out.println("Resized array: " + Arrays.toString(resized));
    }
}
