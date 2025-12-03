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
        setID(ID);
        setPassword(password);
    }



    public void post(String message){
        posts.add(message);
    }
    public void addFriend(Object friend) {
        friends.add(friend);
    }
    public void showPosts() {
        Node ptr = posts.first;
        while (ptr!=null){
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
    }
    public void showFriends() {
        Node ptr = friends.first;
        while (ptr!=null){
            User user = (User) ptr.data;
            System.out.println(user.fullName);
            ptr=ptr.next;
        }
    }
    public void requests() {

    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        this.fullName = firstName + " " + lastName;
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
