package sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public static int[] sort(int[] input) {

        return sortList(convertIntArrayToIntList(input))
                .stream().mapToInt(i -> i).toArray();
    }

    public static List<Integer> sortList(List<Integer> input) {

        if (input.size() < 2) return input;

        Integer pivot = input.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) <= pivot) {
                left.add(input.get(i));
            } else {
                right.add(input.get(i));
            }
        }

        List<Integer> result = new ArrayList<>(sortList(left));
        result.add(pivot);
        result.addAll(sortList(right));

        return result;
    }

    public static List<Integer> convertIntArrayToIntList(int[] input) {

        List<Integer> result = new ArrayList<>();

        for (int i : input) {
            result.add(i);
        }
        return result;
    }
}
