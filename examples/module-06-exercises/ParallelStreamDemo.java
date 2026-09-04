import java.util.List;

public class ParallelStreamDemo {
    static void main(String[] args) {
        List<Employee> employees = EmployeeData.sample();

        // sequential count
        long sequentialStart = System.currentTimeMillis();
        long sequential = employees.stream()
                // TODO: .count() or filter+count
                .filter(e -> e.salary() > 60_000)
                .count();
        long sequentialEnd = System.currentTimeMillis() - sequentialStart;

        // parallel count with same logic
        long parallelStart = System.currentTimeMillis();
        long parallel = employees.parallelStream()
                // same terminal logic
                .filter(e -> e.salary() > 60_000)
                .count();
        long parallelEnd = System.currentTimeMillis() - parallelStart;

        System.out.println("Sequential: " + sequential);
        System.out.println("Parallel: " + parallel);
        System.out.println("Sequential Time: " + sequentialEnd);
        System.out.println("Parallel Time: " + parallelEnd);
    }
}
