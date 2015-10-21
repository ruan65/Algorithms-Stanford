package stanford_ass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ass1Inversions {

    private int[] array;

    private long counter;

    public Ass1Inversions(int[] array) {
        this.array = array;
    }

    public int[] runDividingAndCountingProcess(int[] input) {

        if (input.length <= 1) return input;

        int m = input.length / 2;

        int[] left = Arrays.copyOfRange(input, 0, m);
        int[] right = Arrays.copyOfRange(input, m, input.length);

        return mergeAndCountInversions(runDividingAndCountingProcess(left), runDividingAndCountingProcess(right));
    }

    int[] mergeAndCountInversions(int[] arr1, int[] arr2) {

        int size = arr1.length + arr2.length;
        int[] result = new int[size];

        int j = 0, k = 0;
        for (int i = 0; i < size; i++) {
            if (k >= arr2.length || (j < arr1.length && arr1[j] < arr2[k])) {
                result[i] = arr1[j++];

            } else {
                result[i] = arr2[k++];
                counter += arr1.length - j; // This is the magic line
            }
        }
        return result;
    }

    public long getNumberOfInversions() {

        runDividingAndCountingProcess(array);
        return counter;
    }

    public static void main(String[] args) throws IOException {

        int[] intArr = Files.lines(Paths.get("IntegerArray.txt")).mapToInt(Integer::parseInt).toArray();

        long inv = new Ass1Inversions(intArr).getNumberOfInversions();

        System.out.println("inversions = " + inv);



    }
}
