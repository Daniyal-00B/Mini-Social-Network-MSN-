public class List {

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
    public void remove(Object x) {
        Node ptr = first, prePtr = first;
        if (ptr.data == x) {
            first = ptr.next;
            ptr = null;
            return;
        }
        while (ptr.data != x) {
            prePtr = ptr;
            ptr = ptr.next;
        }
        prePtr.next = ptr.next;
        ptr = null;
        if (prePtr.next == null) end = prePtr;
    }

}
