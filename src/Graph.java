public class Graph {
    public static int[][] graph = new int[100][100];
    public static void commonFriends (int id1, int id2) {
        id1-=100;
        id2-=100;
        int couter = 0;
        Node ptr = Main.users[id1].friends.first;
        System.out.println();
        while (ptr!=null) {
            User friend = (User) ptr.data;
            int id = friend.getID()-100;
            if (graph[id2][id]==1) {
                System.out.println(friend.getFullName());
                couter++;
            }
            ptr=ptr.next;
        }
        if (couter==0) {
            System.out.println("There is No Common Friend With " + (id2+100));
        }
    }

    public static void shortestPath (int src, int dst) {

    }
}
