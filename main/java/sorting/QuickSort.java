package sorting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] input) {

        if (input.length < 2) return;

        sortRec(input, 0, input.length - 1);
    }

    private static void sortRec(int[] input, int left, int right) {

        int indx = partition(input, left, right);

        if (left < indx - 1) {
            sortRec(input, left, indx - 1);
        }

        if (indx < right) {
            sortRec(input, indx, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {

        int pivot = arr[(left + right) / 2];

        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                swap(arr, left++, right--);
            }
        }
        return left;
    }


    public static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public static void main(String[] args) throws IOException {

        int[] intArr = Files.lines(Paths.get("10.txt")).mapToInt(Integer::parseInt).toArray();

        // [3, 9, 8, 4, 6, 10, 2, 5, 7, 1]

        System.out.println(Arrays.toString(intArr));

        sort(intArr);

        System.out.println(Arrays.toString(intArr));


//        int ind = partition(intArr, 0, intArr.length - 1);
//
//        System.out.println(Arrays.toString(intArr) + " ind=" + ind);
    }


}
