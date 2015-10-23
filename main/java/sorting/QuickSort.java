package sorting;

public class QuickSort {

    public static void sort(int[] input) {

        if (input.length < 2) return;

        sortRec(input, 0, input.length - 1);
    }

    private static void sortRec(int[] input, int left, int right) {

        int indx = partition(input, left, right);

        if (indx > left) {
            sortRec(input, left, indx);
        }
        if (indx < right) {
            sortRec(input, indx + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {

        int pivot = arr[(left + right) / 2];

        while (left < right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left < right) {
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
}
