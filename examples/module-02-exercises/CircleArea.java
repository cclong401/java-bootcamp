import java.util.Scanner;

public class CircleArea {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read radius as double
        System.out.print("Radius: ");
        double radius = Double.parseDouble(scanner.nextLine());

        // area = Math.PI * r * r; printf with decimals
        double area = Math.PI * radius * radius;
        System.out.printf("Area: %.2f%n", area);
    }
}
