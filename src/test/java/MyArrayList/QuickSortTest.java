package MyArrayList;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testQuickSortMethod() {
        Integer[] m = {2, 4, 1, 7, 5, 9, 0, 3, 8, 6};


        QuickSort<Integer> quickSort = new QuickSort<Integer>();
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null) {
                    return o2 == null ? 0 : -1;
                } else if (o2 == null) {
                    return +1;
                } else {
                    return ((Comparable) o1).compareTo(o2);
                }
            }
        };
        quickSort.quickSort(m, 0, 9, c);
        assertEquals(0, m[0]);
        assertEquals(1, m[1]);
        assertEquals(2, m[2]);
        assertEquals(3, m[3]);
    }

    @Test
    void testCompareMethod() {
        int a = 5;
        int b = 10;
        QuickSort quickSort = new QuickSort();
        assertEquals(-1, quickSort.compare(5, 10));
    }
}