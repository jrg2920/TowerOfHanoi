package towerofhanoi;

import java.util.EmptyStackException;

/**
 * 
 * @author jhanavi ghadia
 * @version 2019.10.20
 * @param <T> Generic data type
 * LinkedStack class that implements Stack Interface
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node<T> topNode;
    private int size;


    /**
     * a default constructor
     */
    public LinkedStack() {
        topNode = null;
    }


    /**
     * returns the size of the stack
     * @return size of the stack
     */
    public int size() {
        return size;
    }


    /**
     * pushes an entry on the top of the stack
     * 
     * @param anEntry
     *            a new entry
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;
    }


    /**
     * removes an entry from the top of the stack
     * @ return an entry of type T
     */
    @Override
    public T pop() {
        T top = peek();
        topNode = topNode.next;
        size--;
        return top;
    }


    /**
     * returns the entry from the top of the stack
     * @throws Exception when size is zero
     * @return an entry of type T
     */
    @Override
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    /**
     * checks if the stack is empty
     * @return the boolean variable
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * returns the output in a form of string
     * @return the string output
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        else {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Node<T> temp = topNode;
            while (temp != null) {
                builder.append((temp.getData()));
                temp = temp.next;
                if (temp != null) {
                    builder.append(", ");
                }
            }
            builder.append(']');
            return builder.toString();
        }
    }


    /**
     * clears all the entries of the stack
     */
    @Override
    public void clear() {
        while (size != 0) {
            pop();
        }
    }


    /**
     * private node class
     * @author jhanavi ghadia
     * A node class with is implemented by the linkedStack
     * @param <T> Generic data type
     */
    private class Node<T> {
        private Node<T> next;
        private T data;


        /**
         * A constructor with the node and data as the parameters
         * @param d the data of the node
         * @param nextNode A node as a parameter
         */
        public Node(T d, Node<T> nextNode) {
            next = nextNode;
            data = d;
        }


        /**
         * a getter for the data
         * @return data of the node
         */
        public T getData() {
            return data;
        }
    }
}
