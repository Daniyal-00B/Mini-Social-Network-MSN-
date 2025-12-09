import java.util.Scanner;

public class User {

    private String firstName;
    private String lastName;
    private String fullName;
    private int ID;
    private String password;
    List friends = new List();
    List posts = new List();
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
        System.out.println("Total Requests: " + requests.count);
        if (requests.count==0) return;
        User user = requests.pop();
        String yOrN="q";
        Scanner scanner = new Scanner(System.in);
        while (!(yOrN.equalsIgnoreCase("Y") || yOrN.equalsIgnoreCase("N"))){
            System.out.println("You Have Friend Request From " + user.getFullName() +
                    "Do You Accept it? (Y/N): ");
            yOrN = scanner.next();
        }
        if (yOrN.equalsIgnoreCase("Y")){
            addFriend(user);
            user.addFriend(Main.users[getID()-100]);
            System.out.println(user.getFullName() + " Added to Your Friend List🎉🎉");
        }
    }
    public void addPost(String message){
        posts.add(message);
    }
    public void addFriend(Object friend) {
        friends.add(friend);
    }
    public void showPosts() {
        Scanner scanner = new Scanner(System.in);
        Node ptr = posts.first;

        while (ptr!=null){
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
        if (posts.first==null) System.out.println("\nYou Have No Posts!");
        System.out.print("Write a New Post or Leave it Blank: ");
        String post = scanner.nextLine();
        if (post.isEmpty()) return;
        addPost(post);
    }
    public void showFriends() {
        Node ptr = friends.first;
        Scanner scanner = new Scanner(System.in);
        while (ptr!=null){
            User user = (User) ptr.data;
            System.out.println(user.fullName);
            ptr=ptr.next;
        }
        if (friends.first==null) System.out.println("\nYour Friend List is Empty");
        System.out.print("For Adding New Friend Enter an ID or Leave it Blank: ");
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
        user.addRequest(user);
    }
    public void requests() {

    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        fullName = firstName + " " + lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = 100 + ID;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
