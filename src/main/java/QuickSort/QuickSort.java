package QuickSort;

import MyArrayList.MyArrayList;

import java.util.Comparator;

/**
 * Class QuickSort
 * contains quickSort method, that transforms disordered Array to order by using QuickSort algorithm
 * @param <E>
 */
public class QuickSort<E> {
    /**
     * method, that transforms disordered Array to order by using QuickSort algorithm
     * @param list       - Array
     * @param comparator - accepts custom Comparator
     * @param <E>        - works with any object
     */
    public <E> void sort(MyArrayList<E> list, Comparator<E> comparator) {
        try {
            quickSort(list, 0, list.size() - 1, comparator);
        } catch (Exception e) {
            System.out.println("An exception during sorting: " + e);
        }
    }

    private <E> void quickSort(MyArrayList<E> list, int low, int high, Comparator<E> comparator) throws Exception {
        if (low < high) {
            int pivot = partition(list, low, high, comparator);
            quickSort(list, low, pivot - 1, comparator);
            quickSort(list, pivot + 1, high, comparator);
        }
    }

    private <E> int partition(MyArrayList<E> list, int low, int high, Comparator<E> comparator) throws Exception {
        int pivot = high;
        while (low < pivot) {
            if (comparator.compare(list.get(low), list.get(pivot)) > 0) {
                E temp = list.get(pivot - 1);
                list.set(pivot - 1, list.get(pivot));
                list.set(pivot, temp);
                if (low + 1 != pivot) {
                    temp = list.get(low);
                    list.set(low, list.get(pivot));
                    list.set(pivot, temp);
                }
                pivot--;
                low--;
            }
            low++;
        }
        return pivot;
    }

    /**
     * method, that transforms disordered Array to order by using QuickSort algorithm
     * with natural order sorting method
     * @param list - Array
     * @param <E>  - works with plain object
     */
    public <E extends Comparable<E>> void sort(MyArrayList<E> list) {
        try {
            quickSort(list, 0, list.size() - 1);
        } catch (Exception e) {
            System.out.println("An exception during sorting: " + e);
        }
    }

    private <E extends Comparable<E>> void quickSort(MyArrayList<E> list, int low, int high) throws Exception {
        if (low < high) {
            int pivot = partition(list, low, high);
            quickSort(list, low, pivot - 1);
            quickSort(list, pivot + 1, high);
        }
    }

    private <E extends Comparable<E>> int partition(MyArrayList<E> list, int low, int high) throws Exception {
        int pivot = high;
        while (low < pivot) {
            E leftElement = list.get(low);
            E onPivotElement = list.get(pivot);
            if (leftElement.compareTo(onPivotElement) > 0) {
                E temp = list.get(pivot - 1);
                list.set(pivot - 1, list.get(pivot));
                list.set(pivot, temp);
                if (low + 1 != pivot) {
                    temp = list.get(low);
                    list.set(low, list.get(pivot));
                    list.set(pivot, temp);
                }
                pivot--;
                low--;
            }
            low++;
        }
        return pivot;
    }
}
