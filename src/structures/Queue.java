package structures;
import utility.Node;

// CS-2920
// Queue ADT (FIFO)

public class Queue<T> {
    private Node<T> head = null;

    // Add node to Queue
    public void add(Queue<T> queue, T data){
        Node<T> newNode = new Node<>(data);

        // If the Queue is empty,
        // then make the new node as head
        if (queue.head == null) {
            queue.head = newNode;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node<T> last = queue.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = newNode;
        }
    }

    // Peek at first item in the Queue
    public Node<T> peek(Queue<T> queue){
        return queue.head;
    }

    // Remove and return the head of the Queue
    public Node<T> remove(Queue<T> queue){
        Node<T> oldHead = queue.head;
        if(oldHead != null){
            queue.head = (queue.head.next);
        }
        return oldHead;
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
