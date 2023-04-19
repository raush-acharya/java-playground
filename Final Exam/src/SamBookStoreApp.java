import java.util.ArrayList;
import java.util.Scanner;

public class SamBookStoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book book1 = new Book();
        Book book2 = new Book();

//For First Book Object "book1"
        System.out.print("Enter Book Name:");
        book1.setName(scanner.nextLine());

        System.out.print("Enter Author Name:");
        book1.setAuthor(scanner.nextLine());

        System.out.print("Enter Price:");
        book1.setPrice(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter Quantity:");
        book1.setQuantity(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter Customer Type:");
        book1.setCustomerType(scanner.nextLine());

//For Second Book Object "book2"
        System.out.print("Enter Book Name:");
        book2.setName(scanner.nextLine());

        System.out.print("Enter Author Name:");
        book2.setAuthor(scanner.nextLine());

        System.out.print("Enter Price:");
        book2.setPrice(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter Quantity:");
        book2.setQuantity(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter Customer Type:");
        book2.setCustomerType(scanner.nextLine());


    ArrayList<Book> books = new ArrayList<>();
    books.add(book1);
    books.add(book2);

        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }

        System.out.println("Generating Bill For Customers...");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getCustomerType().equalsIgnoreCase("regular")){
                book.setPrice(book.getPrice()-200);
            }
            System.out.println(books.get(i));
        }
    }
}
