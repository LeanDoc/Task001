package MyArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void qs() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add(9);
        arrayList.add(1);
        arrayList.add(7);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(6);
        arrayList.add(0);
        arrayList.add(8);
        arrayList.add(10);
        arrayList.add(4);
        MyArrayList<Object> arrayList1 = new MyArrayList<>();
        for (int i = 0; i < 11; i++) {
            arrayList1.add(i);
        }
        assertEquals(0, arrayList1.get(0));
        assertEquals(1, arrayList1.get(1));
        assertEquals(2, arrayList1.get(2));
        assertEquals(3, arrayList1.get(3));
        assertEquals(4, arrayList1.get(4));
    }

    @Test
    void add() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(1);
        arrayList.add(2, 23);
        assertEquals(23, arrayList.get(2));
    }

    @Test
    void testAdd() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add(23);
        assertEquals(23, arrayList.get(0));
    }

    @Test
    void get() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        assertEquals("a", arrayList.get(1));
    }

    @Test
    void remove() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        arrayList.remove(0);
        assertEquals("a", arrayList.get(0));
    }

    @Test
    void clear() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        arrayList.clear();
        assertEquals(null, arrayList.get(3));
    }

    @Test
    void getSize() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        assertEquals(10, arrayList.getSize());
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        arrayList.add("g");
        assertEquals(10, arrayList.getSize());
        arrayList.add("a");
        arrayList.add("z");
        assertEquals(15, arrayList.getSize());
        arrayList.add("c");
        assertEquals(15, arrayList.getSize());
    }
}