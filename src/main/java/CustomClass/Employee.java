package CustomClass;

/**
 * Custom class for Comparator
 */
public class Employee implements Comparable<Employee>{
        private int id;
         private int age;
         private String name;

    public Employee(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 @Override
     public int compareTo(Employee o) {
         return this.id - o.id;
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Employee that = (Employee) o;

         return id == that.id;
     }

     @Override
     public int hashCode() {
         return (int) (id ^ (id >>> 32));       //32???
     }

     @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
