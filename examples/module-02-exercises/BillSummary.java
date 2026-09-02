import java.util.Scanner;

public class BillSummary {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Product name: ");
        // read name
        String name = scanner.nextLine();

        System.out.print("Quantity: ");
        // read qty (nextLine + Integer.parseInt)
        int qty = Integer.parseInt(scanner.nextLine());

        System.out.print("Unit price: ");
        // read price (nextLine + Double.parseDouble)
        double price = Double.parseDouble(scanner.nextLine());

        // compute total (qty * price), 10% discount, and final amount
        // print Product, Quantity, Unit price, Total, Discount (10%), Final amount
        // hints: %.2f for money; use 10%% in the format string to print a literal %
        double subtotal = price * qty;
        double discount = subtotal * 0.1;
        double total = subtotal - discount;

        System.out.printf(
            "--- Bill Summary ---%n" +
            "Product: %s%n" +
            "Quantity: %d%n" +
            "Unit price: %.2f%n" +
            "Total: %.2f%n" +
            "Discount (10%%): %.2f%n" +
            "Final amount: %.2f%n",
            name, qty, price, subtotal, discount, total);

        scanner.close();
    }
}
