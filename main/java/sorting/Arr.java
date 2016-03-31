package sorting;

import java.util.Arrays;

public class Arr {
    public static int[] testArray = {5, 7, 3, 10, -2};
    public static int[] testArray1 = {10, 5, 15, 2, -1, -1, 0};
    public static int[] testArray2 = {0};
    public static int[] testArray3 = {0, 0, 0};

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public static void main(String[] args) {
        printArray(testArray);
        swap(testArray, 0, 4);
        printArray(testArray);
    }
}
