package sorting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class App {

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) throws IOException {

//        someWorkflow();
        int[] intArr = {4, 5, 7, -100};
        printArray(intArr);
        Arr.swap(intArr, 0, 3);
        printArray(intArr);

    }

    private static void someWorkflow() throws IOException {
        int[] intArr = Files.lines(Paths.get("IntegerArray.txt")).mapToInt(Integer::parseInt).toArray();

        Instant start = Instant.now();

        int[] sorted = MergeSort.sort(intArr);

        System.out.println(Duration.between(start, Instant.now()) + " " + sorted[0] + " " + sorted[99999]);


        System.out.println(intArr[0] + " " + intArr[99999]);
        start = Instant.now();

//        InsertionSort.sort(intArr);

        Arrays.sort(intArr);
        System.out.println(Duration.between(start, Instant.now()));

        System.out.println(intArr[0] + " " + intArr[99999]);
    }
}
