import java.util.Scanner;

public class Main {

    public static User[] users = new User[100];
    public static int usrCount=0;
    public static Tree usrTree = new Tree();



    public static void main(String[] args) {


        //#############################  TEST ZONE  ##################################

        users[usrCount] = new User("Mohsen", "Qa", usrCount, "pass"); //100 :ID
        usrTree.add(users[usrCount]);
        usrCount++;
        users[usrCount] = new User("Reza", "Bu", usrCount, "pass"); //101
        usrTree.add(users[usrCount]);
        usrCount++;
        users[usrCount] = new User("Sara", "Za", usrCount, "pass"); //102
        usrTree.add(users[usrCount]);
        usrCount++;
        users[usrCount] = new User("Bahar", "Nt", usrCount, "pass"); //103
        usrTree.add(users[usrCount]);
        usrCount++;
        users[usrCount] = new User("Yousef", "Tf", usrCount, "pass"); //104
        usrTree.add(users[usrCount]);
        usrCount++;
        users[usrCount] = new User("Arash", "Ks", usrCount, "pass"); //105
        usrTree.add(users[usrCount]);
        usrCount++;
        users[usrCount] = new User("Mina", "Pz", usrCount, "pass"); //106
        usrTree.add(users[usrCount]);
        usrCount++;
        users[usrCount] = new User("Narges", "Jo", usrCount, "pass"); //107
        usrTree.add(users[usrCount]);
        usrCount++;

        //#############################  TEST ZONE  ##################################
        startMenu();
    }

    public static void startMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                
                ***************************************************
                Enter Your ID/Pass for Login or Press + for Sign Up
                Press '=' for Sorting Users
                or Press '?' for Finding Shortest Link Between Users
                ***************************************************
                User (ID/+/=/?):\s""");
        String choice = scanner.next();

        if (choice.equals("+")) {
            signup();
        }else if (choice.equals("=")) {

            System.out.println("\nUsers Name Sorted By Alphabet\n-----------------------------");
            usrTree.sort(usrTree.root);
            startMenu();

        }else if (choice.equals("?")) {

            int id1, id2;
            try{
                System.out.print("\nFirst User ID: ");
                id1 = scanner.nextInt();
                System.out.print("Second User ID: ");
                id2 = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\nInvalid Input!");
                startMenu();
                return;
            }
            if (id1<100 || id2<100 || id1>=200 || id2>=200) System.out.println("\nInvalid Input");
            else {
                id1-=100;
                id2-=100;
                Graph.shortestPath(id1, id2);
            }
            startMenu();

        }else {

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
                3. Messaging
                4. Requests
                5. My Info
                -----------------
                6. Common Friends
                7. Search
                
                Choose a Number""");
            System.out.print(" " + user.getFirstName() + " (0 for Exit): ");

            try{
                choice = scanner.nextInt();
            }catch (Exception e) {
                System.out.println("\nInvalid Input!");
                userMenu(user);
            }

            switch (choice){
                case 1 -> user.showFriends();
                case 2 -> user.showPosts(true);
                case 3 -> user.chat();
                case 4 -> user.showRequests();
                case 5 -> user.info();
                case 6 -> {
                    int myId = user.getID();
                    int id;
                    try {
                        System.out.print("Common Friends With (ID): ");
                        id = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("\nInvalid Input!");
                        scanner.nextLine();
                        break;
                    }
                    if (id>=200 || id<0) {
                        System.out.println("\nInvalid Input!");
                    }else {
                        myId-=100;
                        id-=100;
                        Graph.commonFriends(myId, id);
                    }
                }
                case 7 -> {
                    System.out.print("\nEnter the Full Name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    String info = usrTree.search(usrTree.root, name);
                    if (info==null) System.out.println("\n❌ Not Found");
                    else System.out.println(info);
                }
                case 0 -> startMenu();
                default -> System.out.println("\nInvalid Input!");
            }
        }

        System.out.println(user.getFullName());
    }

}