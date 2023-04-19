import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Grocery Store Management System");
        Scanner scanner = new Scanner(System.in);
        int continue_input;
        do {
            clearConsole();
            System.out.println("Welcome To Grocery Store Management System \n");
            System.out.println("Please type the corresponding number to select one of the following options." );
            System.out.println("1: Add items to inventory");
            System.out.println("2: View inventory");
            System.out.println("3: Sales Page");
            System.out.println("4: Exit");

//            Try and catch for input type mismatch
            while (true) {
                try {
                    continue_input = scanner.nextInt();
                    break;
                } catch (InputMismatchException exception) {
                    System.out.println("You have to type in an integer!");
                }
                scanner.nextLine();
            }
            
            switch (continue_input){
                case 1:
                    Add_items.Add_items();
                    break;
                case 2:
                    Inventory.Inventory();
                    System.out.println("Press any key to continue.");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:
                    Sales_page.Sales_page();
                    break;
                case 4:
                    System.out.println("Thank you for using Grocery Store Management System");
                    break;
                default:
                    System.out.println("Your input is invalid. Please type the corresponding number.");
            }
        }while (continue_input != 4);
    }

//    METHOD TO CLEAR CONSOLE
    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
