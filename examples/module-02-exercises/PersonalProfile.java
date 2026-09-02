import java.util.Scanner;

public class PersonalProfile {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read name, age, city, hobby
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        String age = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("Hobby: ");
        String hobby = scanner.nextLine();

        // printf aligned Field | Value table
        System.out.println();
        System.out.printf("%-12s | %-20s%n"+
                "%-12s | %-20s%n" +
                "%-12s | %-20s%n" +
                "%-12s | %-20s%n" +
                "%-12s | %-20s%n" +
                "%-12s | %-20s%n",
                "Field", "Value", "----------", "----------", "Name", name,
                "Age", age, "City", city, "Hobby", hobby);
    }
}
