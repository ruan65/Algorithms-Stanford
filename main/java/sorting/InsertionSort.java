package sorting;

public class InsertionSort {

    public static int[] sort(int[] input) {

        for (int i = 1; i < input.length; i++) {

            if (input[i] < input[i - 1]) {

               for (int j = i; j > 0; j--) {

                    if (input[j] < input[j - 1]) {
                        Arr.swap(input, j, j - 1);
                    } else break;
                }
            }
        }
        return input;
    }
}
