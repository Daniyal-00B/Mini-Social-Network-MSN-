import java.util.Scanner;

public class Main {

    public static User[] users = new User[100];
    public static int usrCount=0;


    public static void main(String[] args) {
        //#############################  TEST ZONE  ##################################

        users[usrCount] = new User("User0", "Test0", usrCount, "pass");
        usrCount++;
        users[usrCount] = new User("User1", "Test1", usrCount, "pass");
        usrCount++;
        users[usrCount] = new User("User2", "Test2", usrCount, "pass");
        usrCount++;
        users[usrCount] = new User("User3", "Test3", usrCount, "pass");
        usrCount++;
        users[usrCount] = new User("User4", "Test4", usrCount, "pass");
        usrCount++;

        //#############################  TEST ZONE  ##################################
        startMenu();
    }

    public static void startMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                
                ***************************************************
                Enter Your ID/Pass for Login or Press + for Sign Up
                ***************************************************
                User (ID/+):\s""");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("+")) {
            signup();
        }else{
            int id=0;
            try {
                id = Integer.parseInt(choice);
            }catch (Exception e) {
                System.out.println("\nInvalid Input!");
                startMenu();
            }
            System.out.print("Enter Your Password: ");
            String pass = scanner.next();
            login(id, pass);
        }
        scanner.close();
    }

    public static void signup() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName, password;
        int id = usrCount;

        System.out.print("Enter Your First Name: ");
        firstName = scanner.next();
        System.out.print("Enter Your Last Name: ");
        lastName = scanner.next();
        System.out.print("Enter a Password: ");
        password = scanner.next();

        users[usrCount] = new User(firstName, lastName, id, password);
        usrCount++;
        System.out.println("\nYou Are Successfully Signed Up!🎉🎉");

        userMenu(users[id]);
    }

    public static void login(int id, String pass) {
        User user=null;
        try{
            user = users[id - 100];
        }catch (Exception e){
            System.out.println("\nInvalid ID/Pass");
            startMenu();
        }
        if (user==null || !pass.equals(user.getPassword())){
            System.out.println("\nInvalid ID/Pass");
            startMenu();
        }else {
            userMenu(user);
        }
    }

    public static void userMenu(User user) {
        Scanner scanner = new Scanner(System.in);

        int choice=-1;
        while (choice!=0){
            System.out.print("""
                
                1. Friends
                2. Post
                3. Send Message
                4. Requests
                5. My Info
                0. Logout
                
                Choose a Number""");
            System.out.print(" " + user.getFirstName() + ": ");
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> user.showFriends();
                case 2 -> user.showPosts(true);
                case 3 -> user.chat();
                case 4 -> user.showRequests();
                case 5 -> user.info();
                case 0 -> startMenu();
                default -> System.out.println("\nInvalid Input!");
            }
        }

        System.out.println(user.getFullName());
    }

}