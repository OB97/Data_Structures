package structures;
import utility.Node;

// CS-2920
// Linked List ADT

public class LinkedList<T> {
    private Node<T> head = null;

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

    // Remove and return a node by index
    public Node<T> remove(int index) {
        if (index >= this.size() || index < 0){
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
        return current;
        }
    }

    // Get the data from the node at the specified index
    public T get(int index){
        if (index >= this.size() || index < 0){
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

    // Clear all nodes from LL
    public void clear(){
        this.head = null;
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

    // Check if LL is empty
    public Boolean isEmpty(){
        return this.head == null;
    }

    // Return the number of elements in LL
    public int size(){
        int total = 0;
        Node<T> current = head;
        while(current != null){
            total ++;
            current = current.next;
        }
        return total;
    }

    public void insertHead(T data){
        Node<T> node = new Node<>(data);
        if(isEmpty()){
            this.head = node;
        }
        else{
            Node<T> temp = head;
            head = node;
            node.next = temp;
        }
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

