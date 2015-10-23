import org.junit.Test;
import sorting.*;

import static org.junit.Assert.assertArrayEquals;

public class TestSortingAlgorithms {

    int[] resultArray = {1, 3, 5, 7};


    @Test
    public void testSelectionSorting() {

        int[] testArray = {5, 7, 3, 1};

        assertArrayEquals(SelectionSort.sort(testArray), resultArray);
    }

    @Test
    public void testInsertionSorting() {

        int[] testArray = {5, 7, 3, 1};

        assertArrayEquals(InsertionSort.sort(testArray), resultArray);
    }

    @Test
    public void testBubbleSorting() {

        int[] testArray = {5, 7, 3, 1};

        assertArrayEquals(BubbleSort.sort(testArray), resultArray);
    }

    @Test
    public void testMergeSorting() {

        int[] testArray = {5, 7, 3, 1};

        assertArrayEquals(MergeSort.sort(testArray), resultArray);
    }

    @Test
    public void testQuickSorting() {

        int[] testArray = {5, 7, 3, 1};

        assertArrayEquals(QuickSortImutable.sort(testArray), resultArray);
    }
}
