import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sales_page {
    static int S_N;
    static String item;
    static int quantity;
    static ArrayList<String> bill_items = new ArrayList<String>();
    static ArrayList<Integer> bill_quantity = new ArrayList<Integer>();

    static Scanner scanner = new Scanner(System.in);
    public static void Sales_page() {
        int index;
        int input_listener;
        boolean loop_runner;

        Main.clearConsole();
        System.out.println("Welcome to Sales Page");
        Inventory.Inventory();
        do{
            System.out.println("Enter the number corresponding to the item you want to buy.");
            while (true) {
                try {
                    S_N = scanner.nextInt();
                    item = Add_items.Send_items(S_N-1);
                    break;
                } catch (InputMismatchException exception) {
                    System.out.println("You have to type in an integer!");
                }
                catch (IndexOutOfBoundsException exception) {
                System.out.println("Your input is out of range");
            }
                scanner.nextLine();
            }



//            To check if user has already bought the item
            if (bill_items.contains(item)){
                index = bill_items.indexOf(item);
                System.out.println("You've already bought this item.");
                System.out.println("Enter How many "+ bill_items.get(index) + "s you want to add");

//                To check whether we have enough quantity available
                int quantity_check;
                while (true) {
                    try {
                        quantity_check = scanner.nextInt() + bill_quantity.get(index);
                        break;
                    } catch (IndexOutOfBoundsException exception) {
                        System.out.println("The number is out of range");
                    }catch (InputMismatchException exception) {
                        System.out.println("You have to type in an integer!");
                    } catch(Exception exception)
                    {
                        System.out.println("Parent Exception occurred");
                    }

                    scanner.nextLine();
                }


                quantity = Sales_page.Quantity_checker(quantity_check,index);


            }
            else {
                index = S_N-1;
                int quantity_check;
                bill_items.add(item);
                System.out.println("How many "+ item +"s do you want to buy?");
                while (true) {
                    try {
                        quantity_check = scanner.nextInt();
                        break;
                    } catch (InputMismatchException exception) {
                        System.out.println("You have to type in an integer!");
                    }
                    scanner.nextLine();
                }


                quantity =  Sales_page.Quantity_checker(quantity_check,index);
                scanner.nextLine();

                bill_quantity.add(quantity);
            }
            Add_items.change_quantity();
            System.out.println("Press 1 to continue shopping.");
            System.out.println("Press 2 to generate bill.");
            while (true) {
                try {
                    input_listener = scanner.nextInt();
                    break;
                } catch (InputMismatchException exception) {
                    System.out.println("You have to type in an integer!");
                }
                scanner.nextLine();
            }


            switch (input_listener){
                case 1:
                    loop_runner = true;
                    break;
                case 2:
                    loop_runner = false;
                    generate_bill();
                    break;
                default:
                    System.out.println("Please enter 1 to continue shopping or 2 to generate bill.");
                    loop_runner = true;

            }
        }while (loop_runner);
    }

//    to generate bill
    public static void generate_bill(){
        Formatter formatter = new Formatter();
        double Grand_total = 0;
        Main.clearConsole();
        System.out.println("Here is your bill");
        formatter.format("%15s %15s %15s %15s %15s\n","Sn.","Items","Price","Quantity","Total");

        for(int counter = 0; counter < bill_items.size(); counter++){
            String Item = bill_items.get(counter);
            int Quantity = bill_quantity.get(counter);
            double Price = Add_items.Send_price(counter);
            double total = Quantity * Price;
            Grand_total = Grand_total + total;
            System.out.println(formatter.format("%15s %15s %15s %15s %15s\n",counter+1,Item,Price,Quantity,total));

        }
        System.out.println("Please pay Rs."+ Grand_total);
        System.out.println("Thank you for shopping using Grocery Store Management System");
        System.out.println("Press any key to continue.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        bill_quantity.clear();
        bill_items.clear();
    }

//    indexing and calculation in change_quantity in add items class
    public static int user_selection() {
        return S_N-1;
    }
    public static int send_quantity() {
        return quantity;
    }


//    to check whether there is enough quantity of items available in the inventory
    public static int Quantity_checker(int quantity_check, int index){

        if (quantity_check > Add_items.Send_quantity(index)){
            System.out.println("Sorry we don't have enough "+ item + "s.");
            return 0;
        }
        else {
            return quantity_check;
        }

    }
}

