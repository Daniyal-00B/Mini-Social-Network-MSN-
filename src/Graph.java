public class Graph {
    public static int[][] graph = new int[100][100];
    public static void commonFriends (int id1, int id2) {
        id1-=100;
        id2-=100;
        int counter = 0;
        Node ptr = Main.users[id1].friends.first;
        System.out.println();
        while (ptr!=null) {
            User friend = (User) ptr.data;
            int id = friend.getID()-100;
            if (graph[id2][id]==1) {
                System.out.println(friend.getFullName());
                counter++;
            }
            ptr=ptr.next;
        }
        if (counter==0) {
            System.out.println("There is No Common Friend With " + (id2+100));
        }
    }

    public static void shortestPath (int src, int dst) {
        int[] visited = new int[Main.usrCount];
        int v=-1;
        boolean isFirst = true;
        String result = "";
        Queue Q = new Queue();
        Q.add(src);
        visited[src] = 1;
        while (Q.first!=null && v!=dst) {
            v = (int)Q.pop();
            if (isFirst) isFirst = false;
            else result = (result + " -> " + (v+100));
            for (int i=0; i<Main.usrCount; i++) {
                if (graph[v][i]==1) {
                    if (visited[i]==0) {
                        Q.add(i);
                        visited[i] = 1;
                    }
                }
            }
        }
        if (v==dst) {
            System.out.println("\nThe Shortest Link Between User " + (src+100)
                               + " and User " + (dst+100) + " is:\n" + (src+100) + result);
        }else System.out.println("\nThere is No Link Between This Users");
    }
}

