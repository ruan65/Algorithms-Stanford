package sorting;

public class Arr {


    public static int[] testArray = {5, 7, 3, 10, -2};

    public static int[] testArray1 = {10, 5, 15, 2, -1, -1, 0};
    public static int[] testArray2 = {0};
    public static int[] testArray3 = {0, 0, 0};

    public static void swap(int[] arr, int i1, int i2) {

        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
