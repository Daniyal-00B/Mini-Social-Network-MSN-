public class Queue {

    Node first;
    Node end;
    int count=0;

    public void add(Object x) {
        Node newNode = new Node();
        newNode.data = x;

        if (first==null) {
            first = newNode;
        }else{
            end.next = newNode;
        }
        end = newNode;
        count++;
    }
    public Object pop() {
        if (first == null) return null;
        Node ptr = first;
        first = ptr.next;
        Object value = ptr.data;
        ptr = null;
        count--;
        return value;
    }

}
