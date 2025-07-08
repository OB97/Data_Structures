package structures;
import utility.Node;

// CS-2920
// Linked List ADT

public class LinkedList<T> {
    private Node<T> head = null;
    private int count = 0;

    // Add a new node at the end
    public void add(LinkedList<T> list, T data) {
        Node<T> new_node = new Node<>(data);

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node<T> last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = new_node;
        }
        count ++;
    }

    // Remove and return a node by index
    public Node<T> remove(int index) {
        if (index >= count || index < 0){
            throw new IndexOutOfBoundsException();
        }
        else{
        int i = 0;
        Node<T> current = head;
        Node<T> previous = null;
        while(i != index){
            previous = current;
            current = current.next;
            i++;
        }
        previous.next = current.next;
        count --;
        return current;
        }
    }

    // Get the data from the node at the specified index
    public T get(int index){
        if (index >= count || index < 0){
            throw new IndexOutOfBoundsException();
        }
        else{
            int i = 0;
            Node<T> current = head;
            while(i < index){
                current = current.next;
                i++;
            }
            return current.getData();
        }
    }

    // Check if LL is empty
    public Boolean isEmpty(){
        return count == 0;
    }

    // Return the number of elements in LL
    public int size(){
        return this.count;
    }

    // Clear all nodes from LL
    public void clear(){
        this.head = null;
        count = 0;
    }

    // Check if LL contains a data item
    public boolean contains(T data) {
        Node<T> current = head;
        while(current != null){
            if(current.getData() == data) {
                return true;
            }
            else{
            current = current.next;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> current = head;

        int i = 1;

        result.append("[");
        while (current != null) {
            result.append("Node").append(String.valueOf(i)).append(" Data=").append(current.getData());
            if (current.next != null) {
                i++;
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");

        return result.toString();
    }

}

