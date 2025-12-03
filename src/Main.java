import java.util.Scanner;

public class Main {

    public static User[] users = new User[100];
    public static int usrCount=0;

    public static void main(String[] args) {
        startMenu();
    }

    public static void startMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                ***************************************************
                Enter Your Name/ID for Login or Press + for Sign Up
                ***************************************************
                User:\s""");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("+")) {
            signup();
        }else{
            login();
        }
        scanner.close();
    }

    public static void signup() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName, password;
        System.out.print("Enter Your First Name: ");
        firstName = scanner.next();
        System.out.print("Enter Your Last Name: ");
        lastName = scanner.next();
        System.out.print("Enter a Password: ");
        password = scanner.next();

        users[usrCount] = new User(firstName, lastName, usrCount, password);
        usrCount++;
        System.out.println("\nYou Are Successfully Signed Up!🎉🎉");
    }

    public static void login() {
        System.out.println("login");
    }
}