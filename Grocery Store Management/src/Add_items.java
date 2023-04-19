import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Add_items {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> items = new ArrayList<String>();
    static ArrayList<Integer> quantity = new ArrayList<Integer>();
    static ArrayList<Double> price = new ArrayList<Double>();
    public static void Add_items() {
        String user_input = "";
        String itemchecker;
        int i = 0;
        Main.clearConsole();
        System.out.println("Welcome to Add Items.");
        while(user_input != "N") {
            int j=i+1;
            System.out.println("Enter Name of Item "+ j );
            itemchecker = scanner.nextLine();
//            item redundancy checker
            if (items.contains(itemchecker)) {
                int index = items.indexOf(itemchecker);
                System.out.println("The item is already in your inventory.");
                System.out.println("Enter How many " + items.get(index) + "s you want to add");
                int new_quantity;
//                try and catch for input type mismatch
                while (true) {
                    try {
                        new_quantity = scanner.nextInt() + quantity.get(index);
                        break;
                    } catch (InputMismatchException exception) {
                        System.out.println("You have to type in an integer!");
                    }
                    scanner.nextLine();
                }

                quantity.set(index, new_quantity);
                i = i - 1;
            }else{
                items.add(itemchecker);
                System.out.println("Enter How many "+ items.get(i) + "s you want to add");
//                try and catch for input type mismatch
                while (true) {
                    try {
                        quantity.add(scanner.nextInt());
                        break;
                    } catch (InputMismatchException exception) {
                        System.out.println("You have to type in an integer!");
                    }
                    scanner.nextLine();
                }


                System.out.println("Enter the price per unit of "+items.get(i));
//                try and catch for input type mismatch
                while (true) {
                    try {
                        price.add(scanner.nextDouble());
                        break;
                    } catch (InputMismatchException exception) {
                        System.out.println("You have to type in a double!");
                    }
                    scanner.nextLine();

            }

            }

            scanner.nextLine();

            i+=1;
            System.out.println("Do you want to add more? (Y/N)");
            user_input = scanner.nextLine();
            if ("N".equalsIgnoreCase(user_input)) {
                System.out.println("Thank you for using Add Items.");
                break;}
        }

    }
// To change the quantity of items when same item is purchased multiple times
    public static void change_quantity() {
        int array_to_change = Sales_page.user_selection();
        int new_quantity = quantity.get(array_to_change)-Sales_page.send_quantity();
        quantity.set(array_to_change,new_quantity);
    }
//    To send the corresponding item from the array according to the index
    public static String Send_items(int i) {
        return items.get(i);
    }

    //    To send the corresponding quantity from the array according to the index
    public static int Send_quantity(int i) {
        return quantity.get(i);
    }

    //    To send the corresponding price from the array according to the index
    public static double Send_price(int i) {
        return price.get(i);
    }

    //    To send the size of the array
    public static int Number_of_items() {
        return items.size();
    }
}
