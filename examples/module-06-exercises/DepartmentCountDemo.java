import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentCountDemo {
    static void main(String[] args) {
        List<Employee> employees = EmployeeData.sample();

        // groupingBy department + counting
        Map<String, Long> counts = employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));

        counts.forEach((dept, count) -> System.out.println(dept + ": " + count));
    }
}
