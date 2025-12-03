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
        if (first == null) {
            System.out.println("Queue is Empty");
            return;
        }
        Node ptr = first;
        first = ptr.next;
        ptr = null;
    }

}
