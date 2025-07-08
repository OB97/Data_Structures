package structures;

// CS-2920
// Stack ADT

import utility.Node;

public class Stack<T> {
    private Node<T> top = null;

    // pop
    public Node<T> pop(){
        if(isEmpty()){
            top = new Node<>(null);
            return top;
        }
        else{
            Node<T> toPop = top;
            top = toPop.next;
            return toPop;
        }
    }

    // push
    public void push(T data){
        if(isEmpty()){
            top = new Node<>(data);
        }
        else{
            Node<T> newNode = new Node<>(data);
            newNode.next = top;
            top = newNode;
        }
    }

    // peek
    public Node<T> peek(){
        if(isEmpty()){
            return null;
        }
        else{
            return top;
        }
    }

    // isEmpty
    public Boolean isEmpty(){
        return top == null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> current = top;

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
