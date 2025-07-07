package structures;
import utility.Node;

// CS-2920
// Linked List ADT

public class LinkedList<T> {
    private Node<T> head;

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
    }

    // Delete a node by value
    public void delete(int data) {

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

