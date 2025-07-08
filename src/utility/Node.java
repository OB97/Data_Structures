package utility;

// Generic Node class for CS-2920

public class Node<T> {
    private T data; // Generic type data
    public Node<T> next; // Reference to the next node (for linked structures)

    // Constructor
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    // Getter for data stored in node
    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "utility.Node{" + "data=" + data + '}';
    }
}
