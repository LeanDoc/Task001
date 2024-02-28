package MyArrayList;

import CustomClass.Employee;
import CustomClass.EmployeeComparator;
import QuickSort.QuickSort;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void TestOfObjectArraySize() {
        MyArrayList<Employee> employeeList = new MyArrayList<Employee>();
        for (int i = 0; i < 1000; i++) {
            employeeList.add(new Employee(i, (int) (18 + 3 * Math.random()), ("Mark" + i)));
        }
        assertEquals(1000, employeeList.size());
    }

    @Test
    void ObjectQuickSort() throws Exception {
        MyArrayList<Employee> employeeList = new MyArrayList<Employee>();
        for (int i = 0; i < 6; i++) {
            employeeList.add(new Employee(i, (18 + i), ("Mark" + i)));
        }
        QuickSort<Employee> employeeQuickSort = new QuickSort<Employee>();
        Comparator<Employee> employeeComparator = new EmployeeComparator();
        employeeQuickSort.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        assertEquals(18, employeeList.get(0).getAge());
        assertEquals(19, employeeList.get(1).getAge());
        assertEquals(20, employeeList.get(2).getAge());
        assertEquals(21, employeeList.get(3).getAge());
        assertEquals(22, employeeList.get(4).getAge());
        assertEquals(23, employeeList.get(5).getAge());
    }

    @Test
    void naturalOrderQuickSortTest() throws Exception {
        MyArrayList<String> arrayList = new MyArrayList<String>();
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        QuickSort<String> quickSort = new QuickSort<String>();
        quickSort.sort(arrayList);
        assertEquals("a", arrayList.get(0));
        assertEquals("c", arrayList.get(1));
        assertEquals("g", arrayList.get(2));
        assertEquals("z", arrayList.get(3));
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
    void removeByIndexTest() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        arrayList.remove(0);
        assertEquals("a", arrayList.get(0));
    }

    @Test
    void removeByElementTest() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        arrayList.remove("a");
        assertEquals("z", arrayList.get(1));
    }

    @Test
    void clearTest() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    @Test
    void sizeTest() {
        MyArrayList<Object> arrayList = new MyArrayList<>();
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        arrayList.add("g");
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("c");
        assertEquals(12, arrayList.size());
    }

    @Test
    void addByIndexTest() {
        MyArrayList<Double> myArrayList = new MyArrayList<Double>();
        myArrayList.add(0, 0.0);
        myArrayList.add(1, 1.0);
        myArrayList.add(2, 2.0);
        myArrayList.add(3, 3.0);
        assertEquals(2.0, myArrayList.get(2));
    }

    @Test
    void setTest() {
        MyArrayList<Double> myArrayList = new MyArrayList<Double>();
        myArrayList.add(0, 0.0);
        myArrayList.add(1, 1.0);
        myArrayList.add(2, 2.0);
        myArrayList.add(3, 3.0);
        myArrayList.set(2, 5.0);
        assertEquals(5.0, myArrayList.get(2));
    }
}
