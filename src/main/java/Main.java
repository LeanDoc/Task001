import CustomClass.Employee;
import CustomClass.EmployeeComparator;
import MyArrayList.MyArrayList;
import QuickSort.QuickSort;

public class Main {

    public static void main(String[] args) throws Exception {
        MyArrayList<Double> arrayList = new MyArrayList();
        arrayList.add(.1);
        arrayList.add(1.1);
        arrayList.add(2.4);
        arrayList.add(.15);
        arrayList.add(.15);
        arrayList.add(.15);
        arrayList.add(.15);
        arrayList.add(.15);
        arrayList.add(.15);
        arrayList.add(.15);
        arrayList.add(.15);
        arrayList.add(.15);
        arrayList.add(.15);
        arrayList.add(.15);
        arrayList.add(10.1);
        arrayList.add(5.12);
        arrayList.add(2.5);
        arrayList.add(3.2);
        arrayList.add(9.9);
        arrayList.add(9.9);
        arrayList.add(9.9);
        arrayList.add(9.9);
        arrayList.add(9.9);
        arrayList.add(9.9);
        arrayList.add(9.9);
        arrayList.add(9.9);
        arrayList.add(1.01);
        arrayList.add(1.01);
        arrayList.add(1.01);
        System.out.println("List Size: " + arrayList.size());
        QuickSort quickSort = new QuickSort();
        System.out.println("Before sorting:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("After sorting:");
        try {
            quickSort.sort(arrayList);
        } catch (Exception e) {
            System.out.println(e + "QuickSort Exeption");
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("List Size: " + arrayList.size());
        System.out.println("REMOVE 1 element");
        arrayList.remove(10.1);
        System.out.println("List Size: " + arrayList.size());
        System.out.println("Clear(): ");
        arrayList.clear();
        System.out.println("List Size: " + arrayList.size());
        MyArrayList<Employee> employeeList = new MyArrayList<Employee>();
        for (int i = 0; i < 25; i++) {
            employeeList.add(new Employee(i, (int) (18 + 3 * Math.random()), ("Mark" + i)));
        }
        System.out.println("Employee size = " + employeeList.size());
        System.out.println("Removing Employee: ");
        for (int j = 0; j < 5; j++) {
            employeeList.remove(j);
        }
        System.out.println("After removing Employee: ");
        System.out.println("Employee size = " + employeeList.size());
        System.out.println("Before quickSort: ");
        for (int k = 0; k < 20; k++) {
            System.out.println(employeeList.get(k));
        }

        quickSort.sort(employeeList, new EmployeeComparator());
        System.out.println("After quickSort: ");
        for (int l = 0; l < 20; l++) {
            System.out.println(employeeList.get(l));
        }
    }
}
