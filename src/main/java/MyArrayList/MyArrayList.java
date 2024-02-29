package MyArrayList;

import java.util.*;

public class MyArrayList<E> implements Iterable<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int currentCapacity;
    E[] elements;

    /**
     * Initializing a new Array with 10 empty spaces
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initialization with the required number of empty spaces
     * @param initiationCapacity - number of empty spaces
     */
    public MyArrayList(int initiationCapacity) {
        if (initiationCapacity <= 0) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
        elements = (E[]) new Object[initiationCapacity];
        currentCapacity = initiationCapacity;
    }

    /**
     * Method add(E) - adds an element (Object) to ArrayList
     * @param element
     */
    public void add(E element) {
        if (size == currentCapacity) {
            grow();
        }
        elements[size++] = element;
    }

    /**
     * Method add(index,E) - adds an element (Object) by index to ArrayList
     * If Array is full, it calls the grow() method to increase the empty space
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        if (index >= size || index < 0) {
        size=currentCapacity;
        }
        if (size == currentCapacity) {
            this.grow();
        }
        int shiftCount = size - index;
        System.arraycopy(elements, index, elements, index + 1, shiftCount);
        set(index,element);
        size++;
    }

    /**
     * Method get(index) - returns an element (Object) by index from ArrayList
     * @param index
     * @return
     */
    public E get(int index) {
        if (index > currentCapacity || index < 0) {
            throw new IndexOutOfBoundsException(index + " Out of Bounds");
        }
        return elements[index];
    }

    /**
     * Method remove(index) - delete an element (Object) by index form ArrayList
     * @param index
     */
    public void remove(int index) {
        if (index > currentCapacity || index < 0) {
            throw new IndexOutOfBoundsException(index + " Out of Bounds");
        }
        int shiftCount = size - index - 1;
        System.arraycopy(elements, index + 1, elements, index, shiftCount);
        size--;
    }

    private int contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].hashCode() == element.hashCode() && elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the first one equals Object
     * @param element - the removing Object
     * @return - true if removing was successful, false if not
     */
    public void remove(E element) {
        int indexOfRemovingElement = contains(element);
        if (indexOfRemovingElement != -1) {
            remove(indexOfRemovingElement);
        } else throw new IndexOutOfBoundsException("No Objects " + element);
    }

    /**
     * Method clear - deletes all elements from ArrayList
     */
    public void clear() {
        for (E element : elements) {
            element = null;
        }
        size = 0;
    }

    /**
     * Method size() - returns size of ArrayList
     * @return size of Array
     */
    public int size() {
        return size;
    }

    /**
     * Method grow() - increases the Array size to 1,5x times + 1
     * It copies all elements from the source array to the destination array
     */
    private void grow() {
        int newCurrentCapacity = (currentCapacity * 3) / 2 + 1;
        E[] temp = (E[]) new Object[newCurrentCapacity];
        System.arraycopy(elements, 0, temp, 0, size);
        elements = temp;
        currentCapacity = newCurrentCapacity;
    }

    /**
     * switches element[index] by new element and returns the old one
     * @param index   - number of replacing position
     * @param element - new element on index position
     * @return old element
     */
    public E set(int index, E element) {
        E prevValue = get(index);
        elements[index] = element;
        return prevValue;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                return elements[currentIndex++];
            }

            @Override
            public void remove() {
                int countOfShiftedElements = size - currentIndex - 1;
                System.arraycopy(elements, currentIndex + 1, elements, currentIndex, countOfShiftedElements);
            }
        };
    }
}
