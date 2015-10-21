package sorting;

public class BubbleSort {

    public static int[] sort(int[] input) {

        for (int i = 0; i < input.length - 1; i++) {

            for (int j = input.length - 1; j > i; j--) {

                if (input[j] < input[j - 1]) {
                    Arr.swap(input, j, j - 1);
                }
            }
        }
        return input;
    }
}
