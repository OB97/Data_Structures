package structures;
import utility.Node;

// CS-2920
// Linked List ADT

public class LinkedList<T> {
    private Node<T> head;
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

    // Delete a node by value
    // Need to finish !!
    public Node<T> remove(int node) {
        return head;
    }

    // Get the element at the specified index
    // Need to finish !!
    public T get(int index){
        return head.getData();
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
        this.head = new Node<>(null);
        count = 0;
    }

    // Check if LL contains a data item
    // Need to finish !!
    public boolean contains(T data) {
        return true;
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

