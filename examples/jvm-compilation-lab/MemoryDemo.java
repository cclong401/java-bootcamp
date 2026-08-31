import java.util.ArrayList;
import java.util.List;

public class MemoryDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // loop i from 1 to 100000; add new Employee(i, "Employee-" + i)
        for (int i = 1; i <= 100000; i++) {
            employees.add(new Employee(i, "Employee-" + i));
        }
        // print "Created " + employees.size() + " employees"
        System.out.println("Created " + employees.size() + " employees");
    }
}
