package stanford_ass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ass2_2_Comparisons {

    public static int counter;

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


        counter += right - left - 1;

//        swap(arr, left, right - 1); // task 2

        swap(arr, left, defineMedianPivotIndex(arr, left, right));

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

    private static int defineMedianPivotIndex(int[] arr, int l, int r) {

        int left = arr[l], right = arr[r], med = arr[(r - l) / 2 + l];

        if ((med <= right && med >= left) || (med >= right && med <= left)) {
            return (r - l) / 2 + l;
        } else if ((left <= med && left >= right) || (left >= med && left <= right)) {
            return l;
        } else return r;
    }

    public static void main(String[] args) throws IOException {

        int[] arr = {1, 2, 3, 4, 6, 10, 9, 5, 7, 8};

//        int ind = partition(arr, 0, arr.length);
//
//        System.out.println(Arrays.toString(arr) + " ind=" + ind);

//        int[] intArr = Files.lines(Paths.get("QuickSort.txt")).mapToInt(Integer::parseInt).toArray();

//        int[] intArr = Files.lines(Paths.get("1000.txt")).mapToInt(Integer::parseInt).toArray();
//
//
//        System.out.println(Arrays.toString(intArr) + " counter=" + counter);
//
//        sort(intArr);
//
//        System.out.println(Arrays.toString(intArr));
//        System.out.println("counter=" + counter);

        System.out.println(arr[defineMedianPivotIndex(arr, 0, 9)]);
    }
}
