import java.util.Scanner;

public class ProductInfo {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read name (String), quantity (int via parse), price (double via parse)
        System.out.print("Product name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        // print labeled summary
        System.out.printf("Product: %s | Qty: %d | Price: %.2f%n",
                name, quantity, price);
    }
}
