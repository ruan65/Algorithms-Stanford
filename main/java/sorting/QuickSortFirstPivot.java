package sorting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class QuickSortFirstPivot {

    public static void sort(int[] input) {

        if (input.length < 2) return;

        sortRec(input, 0, input.length);
    }

    private static void sortRec(int[] input, int left, int right) {

        int ind = partition(input, left, right);

        if (left < ind) {
            sortRec(input, left, ind);
        }

        if (ind + 1 < right - 1) {
            sortRec(input, ind + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {

        System.out.println("before: " + Arrays.toString(Arrays.copyOfRange(arr, left, right)) + " left= " + left + " right= " + right);

        int pivot = arr[left];

        int i = left + 1;

        for (int j = left + 1; j < right; j++) {

            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, left, i - 1);

        System.out.println("after:  " + Arrays.toString(Arrays.copyOfRange(arr, left, right)) + " left= " + left + " right= " + right + " index=" + (i - 1));

        return i - 1;
    }

    public static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public static void main(String[] args) throws IOException {

        int[] intArr = Files.lines(Paths.get("10.txt")).mapToInt(Integer::parseInt).toArray();

//        [3, 9, 8, 4, 6, 10, 2, 5, 7, 1]

//        System.out.println(Arrays.toString(intArr));

        sort(intArr);

//        System.out.println(Arrays.toString(intArr));


//        int[] intArr = {3, 8, 2, 5, 1, 4, 7, 6};
//
//        int ind = partition(intArr, 0, intArr.length);
//
        System.out.println(Arrays.toString(intArr));
    }
}
