package MyArrayList;

import java.util.*;


public class MyArrayList<E> {

    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int currentCapacity = DEFAULT_CAPACITY;
    private E[] elements;
    private final E[] DEFAULT_ELEMENTS = (E[]) new Object[DEFAULT_CAPACITY];


    Comparator<E> c = new Comparator<E>() {

        @Override
        /**
         * Compare method provide comparing different types of objects.
         * It returns Integer value:
         * 1 if a > Object b
         * -1 if a < Object b
         * 0 if a == Object b
         */
        public int compare(E o1, E o2) {

            if (o1 == null) {
                return o2 == null ? 0 : -1;
            } else if (o2 == null) {
                return +1;
            } else {

                if (o1 instanceof Integer) {
                    return ((Comparable) o1).compareTo(o2);
                }
                if (o1 instanceof String) {
                    return ((Comparable) o1).compareTo(o2);
                }
                if (o1 instanceof Character) {
                    return ((Comparable) o1).compareTo(o2);
                }
                if (o1 instanceof Long) {
                    return ((Comparable) o1).compareTo(o2);
                }
                if (o1 instanceof Double) {
                    return ((Comparable) o1).compareTo(o2);
                }
                if (o1 instanceof Boolean) {
                    return ((Comparable) o1).compareTo(o2);
                }
                if (o1 instanceof Short) {
                    return ((Comparable) o1).compareTo(o2);
                }
                if (o1 instanceof Byte) {
                    return ((Comparable) o1).compareTo(o2);
                }
                if (o1 instanceof Float) {
                    return ((Comparable) o1).compareTo(o2);
                }
                return ((Comparable) o1).compareTo(o2);
            }
        }
    };

    /**
     * QuickSort method
     * Implements the QuickSort method on MyArrayList
     *
     * @param arr
     * @return
     */
    public MyArrayList<E> qs(MyArrayList<E> arr) {
        QuickSort<E> quickSort1 = new QuickSort<E>();
        quickSort1.quickSort(this.elements, 0, this.elements.length - 1, c);
        return arr;
    }


    /**
     * Initializing a new Array with 10 empty spaces
     */
    public MyArrayList() {
        this.elements = (E[]) new Object[this.DEFAULT_CAPACITY];
    }

    /**
     * конструктор для инициализации ArrayList нужного размера
     *
     * @param initiationCapacity
     */
    public MyArrayList(int initiationCapacity) {
        if (initiationCapacity > 0) {
            this.elements = (E[]) new Object[initiationCapacity];
        } else if (initiationCapacity == 0) {
            this.elements = DEFAULT_ELEMENTS;
        } else
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initiationCapacity);
    }

    /**
     * Method add(E) - adds an element (Object) to ArrayList
     *
     * @param element
     */
    public void add(E element) {
        if (this.size == this.currentCapacity) {
            this.grow();
        }
        this.elements[this.size] = element;
        ++this.size;
    }

    /**
     * Method add(index,E) - adds an element (Object) by index to ArrayList
     * If Array is full, it calls the grow() method to increase the empty space
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {

        if (index > this.currentCapacity || index < 0) {
            throw new IndexOutOfBoundsException(index + " Out of Bounds");
        }

        if (this.size == this.currentCapacity) {
            this.grow();
        }

        System.arraycopy(this.elements, index, this.elements, index + 1, this.elements.length - index - 1);

        this.elements[index] = element;
        ++this.size;
    }

    /**
     * Method get(index) - returns an element (Object) by index from ArrayList
     * @param index
     * @return
     */
    public E get(int index) {
        if (index > this.currentCapacity || index < 0) {
            throw new IndexOutOfBoundsException(index + " Out of Bounds");
        }
        return this.elements[index];
    }

    /**
     * Method remove(index) - delete an element (Object) by index form ArrayList
     *
     * @param index
     */
    public void remove(int index) {
        if (index > this.currentCapacity || index < 0) {
            throw new IndexOutOfBoundsException(index + " Out of Bounds");
        }
        System.arraycopy(this.elements, index + 1, this.elements, index, this.elements.length - index - 1);
        --this.size;
    }

    /**
     * Method clear - deletes all elements from ArrayList
     */
    public void clear() {
        for (int i = 0; i < this.currentCapacity; i++) {
            this.elements[i] = null;
            --this.size;
        }
    }


    /**
     * Method getSize() - returns size of ArrayList
     *
     * @return
     */
    public int getSize() {

        return this.elements.length;
    }

    /**
     * Method grow() - increases the Array size to 1,5 times
     * It copies all elements from the source array to the destination array
     */
    private void grow() {
        this.currentCapacity += (this.currentCapacity / 2); //+1???
        for (int i = 0; i < this.currentCapacity - this.currentCapacity / 2 - 1; ++i) {
            this.elements = Arrays.copyOf(this.elements, this.currentCapacity);
        }
    }
}



