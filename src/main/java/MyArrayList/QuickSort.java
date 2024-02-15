package MyArrayList;

import java.util.Comparator;


/**
 * Class QuickSort
 * Implements Comparator
 * contains quickSort method, that transforms disordered Array to order by using QuickSort algorithm
 * @param <E>
 */
public class QuickSort<E> implements Comparator<E> {
    /**
     * quickSort  - method, that transforms disordered Array to order by using QuickSort algorithm
     * @param sortArr - Array from
     * @param low - left side border index
     * @param high - right side border index
     * @param c - functional interface Comparator
     */
    public void quickSort(E[] sortArr, int low, int high, Comparator<E> c) {
        if (sortArr.length == 0 || low >= high) return;
        int middle = low + (high - low) / 2;
        E border = sortArr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (c.compare(sortArr[i], border) < 0) i++;
            while (c.compare(sortArr[j], border) > 0) j--;
            if (i <= j) {
                E swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }
        if (low < j) quickSort(sortArr, low, j, c);
        if (high > i) quickSort(sortArr, i, high, c);
    }
    /**
     * Compare method provide comparing different types of objects.
     * It returns Integer value:
     * 1 if a > Object b
     * -1 if a < Object b
     * 0 if a == Object b
     */
    @Override
    public int compare(E o1, E o2) {
        if (o1 == null) {
            return o2 == null ? 0 : -1;
        } else if (o2 == null) {
            return +1;
        } else {
            return ((Comparable) o1).compareTo(o2);
        }
    }
}