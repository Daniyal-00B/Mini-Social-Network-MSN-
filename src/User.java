import java.util.Scanner;

public class User {

    private String firstName;
    private String lastName;
    private String fullName;
    private int ID;
    private String password;
    List friends = new List();
    List posts = new List();
    List messages = new List();
    Queue requests = new Queue();



    User (String firstName, String lastName, int ID, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setFullName();
        setID(ID);
        setPassword(password);
    }


    public void addRequest(User user){
        requests.add(user);
    }
    public void showRequests(){
        System.out.println("\nTotal Requests: " + requests.count);
        if (requests.count==0) return;
        User user = (User)requests.pop();
        String yOrN="q";
        Scanner scanner = new Scanner(System.in);
        while (!(yOrN.equalsIgnoreCase("Y") || yOrN.equalsIgnoreCase("N"))){
            System.out.print("You Have a Friend Request From " + user.getFullName() +
                    "\nDo You Accept it? (Y/N): ");
            yOrN = scanner.next();
        }
        if (yOrN.equalsIgnoreCase("Y")){
            addFriend(user);
            user.addFriend(Main.users[getID()-100]);
            System.out.println("\n" + user.getFullName() + " Added to Your Friend List🎉🎉");
        }
    }

    public void addPost(String message){
        posts.add(message);
    }
    public void showPosts(boolean isMe) {
        Scanner scanner = new Scanner(System.in);
        Node ptr = posts.first;

        System.out.println("""
                *************************
                POSTS""");
        while (ptr!=null){
            System.out.println("---------------------\n" + ptr.data);
            ptr=ptr.next;
        }
        System.out.println("*************************");
        if (!isMe) return;
        if (posts.first==null) System.out.println("\nYou Have No Posts!");
        System.out.print("Make a New Post or Leave it Blank: ");
        String post = scanner.nextLine();
        if (post.isEmpty()) return;
        addPost(post);
    }

    public void addFriend(Object friend) {
        friends.add(friend);
        User them = (User)friend;
        Graph.graph[getID()-100][(them.getID())-100] = 1;
    }
    public void showFriends() {
        Node ptr = friends.first;
        Scanner scanner = new Scanner(System.in);
        User friend;
        int count = 0;
        System.out.print("""
                
                *************************
                      FRIENDS LIST
                *************************
                """);
        while (ptr!=null){
            friend = (User) ptr.data;
            System.out.println("      " + friend.getID() + ". " + friend.fullName + "\n-------------------------");
            ptr=ptr.next;
            count++;
        }

        if (friends.first==null) System.out.println("\nYour Friend List is Empty");
        System.out.println("Total Friends: " + count);
        System.out.print("For Adding/Selecting Friend Enter an ID or Leave it Blank: ");
        String input = scanner.nextLine();
        if (input.isEmpty()) return;
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (Exception e){
            System.out.println("\nInvalid Input!");
            return;
        }
        User user;
        try{
            user = Main.users[id-100];
        }catch (Exception e){
            System.out.println("This User Does not Exist");
            return;
        }
        if (user==null){
            System.out.println("This User Does not Exist");
            return;
        }
        if(isFriend(user)) {
            user.info();
            user.showPosts(false);
        }
        user.addRequest(Main.users[getID()-100]);
        System.out.println("\nYour Friend Request Sent to User " + user.getID());
    }
    public boolean isFriend(User x) {

        Node ptr = friends.first;
        User user;
        while (ptr!=null) {
            user = (User) ptr.data;
            if (x.getID()==user.getID()) return true;
            ptr = ptr.next;
        }
        return false;
    }

    public void info() {
        String info = "First Name: " + getFirstName() +  "\nLast Name: " + getLastName()
                + "\nID: " + getID() + "\n*************************";
        System.out.println("""
                           
                           *************************
                           User Info
                           -------------------------
                           """ + info);
    }

    public void chat() {

        Node ptr = messages.first;
        if (ptr!=null) System.out.println("\n*********( New Messages )*********");
        String message;
        while (ptr!=null) {
            message = (String)ptr.data;
            System.out.println(message +  "\n----------------------------------");
            messages.remove(message);
            ptr = ptr.next;
        }


        System.out.print("Enter an ID to Start a Chat: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isEmpty()) return;
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (Exception e){
            System.out.println("\nInvalid Input");
            return;
        }
        User user;
        try {
           user = Main.users[id-100];
        }catch (Exception e){
            System.out.println("\nThis User Does Not Exist");
            return;
        }
        if (user==null) {
            System.out.println("\nThis User Does Not Exist");
            return;
        }

        System.out.print("Write a Message to User " + user.getID() + ": ");

        message = scanner.nextLine();
        message = "User (" + getID() + "):  " + message;
        user.messages.add(message);
    }



    public void setID(int ID) {
        this.ID = 100 + ID;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFullName() {
        fullName = firstName + " " + lastName;
    }


    public int getID() {
        return ID;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return fullName;
    }
}
