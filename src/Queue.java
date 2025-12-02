public class Queue {

    Node first;
    Node end;

    public void add(Object x) {
        Node newNode = new Node();
        newNode.data = x;

        if (first==null) {
            first = newNode;
        }else{
            end.next = newNode;
        }
        end = newNode;
    }
    public void pop() {
        Node ptr = first;
        first = ptr.next;
        ptr = null;
    }

}
