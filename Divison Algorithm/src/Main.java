import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a;
        int b;
        int q;
        int r;
        String continuechecker = "";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("A:");
            a=scanner.nextInt();
            scanner.nextLine();
            System.out.print("B:");
            b=scanner.nextInt();
            scanner.nextLine();
            q = a/b;
            r = a%b;
            System.out.println("Q:"+q);
            System.out.println("R:"+r);
            System.out.println("continue?");
            continuechecker = scanner.nextLine();
        }while (continuechecker != "y");
    }
}