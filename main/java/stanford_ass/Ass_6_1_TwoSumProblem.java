package stanford_ass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Ass_6_1_TwoSumProblem {

    public static void main(String[] args) throws FileNotFoundException {

        HashSet<Long> integers = new HashSet<>();

        Scanner sc = new Scanner(new File("algo1-programming_prob-2sum.txt"));

        while (sc.hasNextLong()) {
            integers.add(sc.nextLong());
        }

        System.out.println("filling has completed: " + integers.size());

        long before = System.currentTimeMillis();

        int result = 0;

        for (long t = -10000; t <= 10000; t++) {
            if (t % 100 == 0) System.out.println(t + " result = " + result);
            for (long x : integers) {
                if (integers.contains(t - x) && x != t - x) {
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
        System.out.println("it took: " + (System.currentTimeMillis() - before) / 1000 + " sec."); // ~ 40 minutes
    }
}
