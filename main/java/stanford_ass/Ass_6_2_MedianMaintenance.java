package stanford_ass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ass_6_2_MedianMaintenance {

    public static void main(String[] args) throws FileNotFoundException {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        Scanner sc = new Scanner(new File("Median.txt"));

        int first = sc.nextInt();

        int sum = first;
        minHeap.add(first);

        while (sc.hasNextInt()) {

            int next = sc.nextInt();

            if (next <= minHeap.peek()) {
                maxHeap.add(next);
            } else {
                minHeap.add(next);
            }
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
            sum += maxHeap.peek();
        }
        System.out.println(sum % 10000);
    }
}
