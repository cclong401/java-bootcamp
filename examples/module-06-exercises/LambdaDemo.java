public class LambdaDemo {
    static void main(String[] args) {
        Employee alice = EmployeeData.sample().get(0);

        // anonymous class implementing SalaryCheck — salary > 60_000
        SalaryCheck anonymous = new SalaryCheck() {
            @Override
            public boolean CheckSalary(Employee employee) {
                return employee.salary() > 60_000;
            }
        };

        // lambda with the same SalaryCheck contract and same result
        SalaryCheck lambda = (Employee employee) -> employee.salary() > 60_000;

        System.out.println("Employee: " + alice.name());
        System.out.println("Anonymous result: " + anonymous.CheckSalary(alice));
        System.out.println("Lambda result: " + lambda.CheckSalary(alice));
    }
}
