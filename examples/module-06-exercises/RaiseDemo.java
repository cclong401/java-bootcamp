import java.util.List;

public class RaiseDemo {
    static void main(String[] args) {
        List<Employee> employees = EmployeeData.sample();

        // map each salary * 1.10 without mutating source employees
        List<Double> raised = employees.stream()
                .map(e -> e.salary() * 1.10)
                .toList();

        System.out.println("Raised salaries:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.printf("%s: %.2f -> %.2f%n", employees.get(i).name(), employees.get(i).salary(), raised.get(i));
        }

        System.out.println("Original Alice salary: " + employees.getFirst().salary());
    }
}
