package sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] input) {

        if (input.length <= 1) return input;

        int m = input.length / 2;

        int[] left = Arrays.copyOfRange(input, 0, m);
        int[] right = Arrays.copyOfRange(input, m, input.length);

        return mergeSortedArrays(sort(left), sort(right));
    }

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        int size = arr1.length + arr2.length;
        int[] result = new int[size];

        int j = 0, k = 0;
        for (int i = 0; i < size; i++) {
            if (k >= arr2.length || (j < arr1.length && arr1[j] < arr2[k])) {
                result[i] = arr1[j++];
            } else {
                result[i] = arr2[k++];
            }
        }
        return result;
    }
}
