/**
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;

/**
 * @author jhanavi ghadia
 * @version 2019.10.19
 * Test class for Linked Stack class
 */
public class LinkedStackTest extends student.TestCase {
    private LinkedStack<String> stack1;
    private LinkedStack<String> stack2;
    private LinkedStack<String> stack3;


    /**
     * set up method to set up the stacks
     */
    public void setUp() {
        stack1 = new LinkedStack<String>();
        stack2 = new LinkedStack<String>();
        stack3 = new LinkedStack<String>();
        stack1.push("a");
        stack2.push("b");
    }


    /**
     * a test method for a class
     */
    public void testSize() {
        assertEquals(1, stack1.size());
        stack1.clear();
        assertEquals(0, stack1.size());
    }


    /**
     * a test method for a class
     */
    public void testPop() {
        assertEquals("a", stack1.pop());
        
        Exception thrown = null;
        try {
            stack3.pop();
            fail("pop() is not throwing an exception when it should");
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertTrue("pop() is throwing the wrong type of exceptions",
            thrown instanceof EmptyStackException);
    }


    /**
     * a test method for a class
     */
    public void testPeek() {
        assertEquals("a", stack1.peek());
        Exception thrown = null;
        try {
            stack1.clear();
            stack1.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * test method for a class
     */
    public void testPush() {
        assertEquals(1, stack1.size());
        stack1.push("c");
        assertEquals(2, stack1.size());
    }


    /**
     * test method for a class
     */
    public void testIsEmpty() {
        assertTrue(stack3.isEmpty());
        assertFalse(stack2.isEmpty());
    }


    /**
     * test method for a class
     */
    public void testToString() {
        stack2.push("a");
        assertEquals("[a, b]", stack2.toString());
    }


    /**
     * test method for a class
     */
    public void testClear() {
        assertEquals(0, stack3.size());
        stack1.clear();
        assertEquals(0, stack1.size());
    }

}
