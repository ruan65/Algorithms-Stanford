import org.junit.Test;
import sorting.*;

import static org.junit.Assert.assertArrayEquals;

public class TestSortingAlgorithms {

    int[] resultArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


    @Test
    public void testSelectionSorting() {

        int[] testArray = {3, 9, 8, 4, 6, 10, 2, 5, 7, 1};

        assertArrayEquals(SelectionSort.sort(testArray), resultArray);
    }

    @Test
    public void testInsertionSorting() {

        int[] testArray = {3, 9, 8, 4, 6, 10, 2, 5, 7, 1};

        assertArrayEquals(InsertionSort.sort(testArray), resultArray);
    }

    @Test
    public void testBubbleSorting() {

        int[] testArray = {3, 9, 8, 4, 6, 10, 2, 5, 7, 1};

        assertArrayEquals(BubbleSort.sort(testArray), resultArray);
    }

    @Test
    public void testMergeSorting() {

        int[] testArray = {3, 9, 8, 4, 6, 10, 2, 5, 7, 1};

        assertArrayEquals(MergeSort.sort(testArray), resultArray);
    }

    @Test
    public void testQuickSorting() {

        int[] testArray = {3, 9, 8, 4, 6, 10, 2, 5, 7, 1};

        assertArrayEquals(QuickSortImmutable.sort(testArray), resultArray);
    }

    @Test
    public void testQuickSort() {

        int[] testArray = {3, 9, 8, 4, 6, 10, 2, 5, 7, 1};

        QuickSort.sort(testArray);

        assertArrayEquals(testArray, resultArray);
    }

    @Test
    public void testQuickSortFirstPivot() {

        int[] testArray = {3, 9, 8, 4, 6, 10, 2, 5, 7, 1};

        QuickSortFirstPivot.sort(testArray);

        assertArrayEquals(testArray, resultArray);
    }
}
