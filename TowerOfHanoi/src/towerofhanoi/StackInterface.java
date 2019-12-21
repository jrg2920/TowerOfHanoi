/**
 * 
 */
package towerofhanoi;

/**
 * @author jhanavi ghadia
 * @version 2019.10.20
 * @param <T>  generic data type
 * A stack interface with all the methods
 */
public interface StackInterface<T> {
    /**
     * adds an item on the top of the stack
     * @param item to be pushed
     */
    public void push(T item);


    /**
     * removes an item from the top of the stack
     * @return an entry of type T
     */
    public T pop();


    /**
     * returns the element from the top of the stack
     * @return an entry of type T
     */

    public T peek();


    /**
     * returns true is the stack is empty
     * @return boolean variable
     */
    public boolean isEmpty();


    /**
     * clears the stack
     */
    public void clear();

}
