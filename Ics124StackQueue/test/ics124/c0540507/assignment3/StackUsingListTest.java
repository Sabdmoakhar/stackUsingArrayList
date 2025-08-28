package ics124.c0540507.assignment3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shayan Abdmoakhar
 */
public class StackUsingListTest {

    private StackUsingList stack;

    public StackUsingListTest() {
    }

    @Before
    public void setUp() {
        stack = new StackUsingList();
    }

    @After
    public void tearDown() {
        // Not necessary for this example
    }

    /**
     * Test of isEmpty method, of class StackUsingList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        // When the stack is just created it should be empty
        boolean expResult = true;
        boolean result = stack.isEmpty();
        assertEquals("Stack should be empty when initialized", expResult, result);

        // After pushing an element the stack should not be empty
        stack.push(10);
        expResult = false;
        result = stack.isEmpty();
        assertEquals("Stack should not be empty after pushing an element", expResult, result);
    }

    /**
     * Test of isFull method, of class StackUsingList.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");
        // A stack implemented with linked list is never full
        boolean expResult = false;
        boolean result = stack.isFull();
        assertEquals("Stack should not be full as it uses a linked list", expResult, result);
    }

    /**
     * Test of peek method, of class StackUsingList.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        // Try to peek on an empty stac expecting a StackUnderflowException
        try {
            stack.peek();
            fail("Peek should throw a StackUnderflowException when the stack is empty.");
        } catch (StackUnderflowException e) {
            assertEquals("Stack is empty", e.getMessage());
        }

        // pushing an element and peek
        stack.push(10);
        Integer expResult = 10;
        Integer result = stack.peek();
        assertEquals("Peek should return the top element without removing.", expResult, result);
    }

    /**
     * Test of pop method, of class StackUsingList.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        // popping from an empty stack expecting a StackUnderflowException
        try {
            stack.pop();
            fail("Pop should throw a StackUnderflowException when the stack is empty.");
        } catch (StackUnderflowException e) {
            assertEquals("Stack is empty", e.getMessage());
        }

        // Push an element and pop it
        stack.push(10);
        Integer expResult = 10;
        Integer result = stack.pop();
        assertEquals("The popped element should be the same as the pushed one.", expResult, result);

        // The stack should be empty after popping
        assertTrue("Stack should be empty after popping the only element", stack.isEmpty());
    }

    /**
     * Test of push method, of class StackUsingList.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Check if the top element is 30 last in first out
        Integer expResult = 30;
        Integer result = stack.peek();
        assertEquals("The top element should be the last pushed element", expResult, result);

        // Pop the element and check if it matches the expected value
        result = stack.pop();
        assertEquals("The popped element should be 30", expResult, result);

        // After popping, check the new top element
        expResult = 20;
        result = stack.peek();
        assertEquals("The new top element should be 20", expResult, result);
    }
}
