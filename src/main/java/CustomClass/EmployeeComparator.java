package CustomClass;

import java.util.Comparator;

/**
 * Custom class, that implements Comparator
 */
public class EmployeeComparator implements Comparator<Employee> {
    /**
     * compare method
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAge()- o2.getAge();
    }

}

