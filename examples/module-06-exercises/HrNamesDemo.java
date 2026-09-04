import java.util.List;

public class HrNamesDemo {
    static void main(String[] args) {
        List<Employee> employees = EmployeeData.sample();

        // filter HR → map name → sorted → toList
        List<String> hrNames = employees.stream()
                .filter(e -> e.department().equalsIgnoreCase("HR"))
                .map(Employee::name)
                .sorted()
                .toList();

        System.out.println("HR Names: " + hrNames);
    }
}
