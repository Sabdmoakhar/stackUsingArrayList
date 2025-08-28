package ics124.c0540507.assignment3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shaa
 */
public class StackUsingArrayTest {

    private StackUsingArray stack;

    public StackUsingArrayTest() {
    }

    @Before
    public void setUp() {
        // Initialize the stack with a size of 5
        stack = new StackUsingArray(5);
    }

    @After
    public void tearDown() {
        // Not necessary for this example
    }

    /**
     * Test of isEmpty method, of class StackUsingArray.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        boolean expResult = true;
        boolean result = stack.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFull method, of class StackUsingArray.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");

        // Push 3 elements (the stack has size 5)
        stack.push(5);  // top = 0
        stack.push(2);  // top = 1
        stack.push(3);  // top = 2
        // The stack shouldnot be full after 3 elements
        boolean expResult = false;
        boolean result = stack.isFull();
        assertEquals("Stack should not be full after pushing three elements", expResult, result);

        // Push two more elements to fill the stack
        stack.push(10);
        stack.push(20);

        // Now the stack should be full
        expResult = true;
        // The stack should be full after pushing 5 elements
        result = stack.isFull();
        assertEquals("Stack should be full after pushing five elements", expResult, result);
    }

    /**
     * Test of peek method, of class StackUsingArray.
     */
    @Test
    public void testPeekEmptyStack() {
        System.out.println("testPeekEmptyStack");

        // Try to peek on an empty stack
        try {
            stack.peek();
            fail("Peek should throw a StackUnderflowException when the stack is empty.");
        } catch (StackUnderflowException e) {
            // Expected exception to verify the message
            assertEquals("Stack is empty", e.getMessage());
        }
    }

    @Test
    public void testPeekNonEmptyStack() {
        System.out.println("testPeekNonEmptyStack");

        // Push an element onto the stack
        stack.push(10);
        Integer expResult = 10;
        Integer result = stack.peek();
        assertEquals("Peek should return the top element without removing it.", expResult, result);

        assertFalse(stack.isEmpty());
    }

    /**
     * Test of pop method, of class StackUsingArray.
     */
    @Test
    public void testPop() {
        System.out.println("testPop");

        // Set up a stack with one element
        stack.push(10);

        // Pop the element
        Integer expResult = 10;
        Integer result = stack.pop();

        // Assert that the popped element is the one that was pushed
        assertEquals("The popped element should be the same as the pushed one.", expResult, result);

        // Now the stack should be empty, so pop should throw an exception
        try {
            // The stack should be full after pushing 5 elements
            stack.pop();
            fail("Pop should throw a StackUnderflowException when the stack is empty.");
        } catch (StackUnderflowException e) {
            assertEquals("Stack is empty", e.getMessage());  // Ensure correct error message
        }
    }
}
