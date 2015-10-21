package sorting;

public class SelectionSort {

    public static int[] sort(int[] input) {

        for (int i = 0; i < input.length; i++) {

            int min = input[i];
            int indxMin = i;

            for (int j = i + 1; j < input.length; j++) {

                if (min > input[j]) {

                    indxMin = j;
                    min = input[j];
                }
            }

            input[indxMin] = input[i];
            input[i] = min;
        }

        return input;
    }
}
