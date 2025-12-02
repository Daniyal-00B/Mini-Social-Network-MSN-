public class Main {
    public static void main(String[] args) {

        User[] users = new User[100];
        int usrCount=0;
//#########################(TEST ZONE)###########################
        users[0] = new User("TEST", 100, "PASS");
        users[1] = new User("TEST01", 101, "PASS");
        users[2] = new User("TEST02", 102, "PASS");

        users[0].post("Test Message 01");
        users[0].post("Test Message 02");
        users[0].post("Test Message 03");
        users[0].post("Test Message 04");

        users[0].addFriend(users[1]);
        users[0].addFriend(users[2]);

        users[0].showPosts();
        users[0].showFriends();

        users[0].posts.remove("Test Message 04");
        users[0].posts.remove("Test Message 01");
        users[0].post("Test Message 05");

        users[0].showPosts();

//#########################(TEST ZONE)###########################


    }
}