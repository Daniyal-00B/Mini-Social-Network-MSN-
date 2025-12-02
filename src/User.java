public class User {

    private String name;
    private int ID;
    private String password;
    List friends = new List();
    List posts = new List();
    Queue requests = new Queue();

    User (String name, int ID, String password) {
        setName(name);
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
            System.out.println(user.name);
            ptr=ptr.next;
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
