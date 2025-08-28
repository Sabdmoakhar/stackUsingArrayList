package ics124.c0540507.assignment3;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Shayan Abdmoakhar
 */
public class Ics124QueueNGTest {

    private Ics124Queue<String> queue;

    ;
     
    public Ics124QueueNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        queue = new Ics124Queue<>();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of isEmpty method, of class Ics124Queue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Ics124Queue instance = new Ics124Queue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFull method, of class Ics124Queue.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");
        Ics124Queue<String> instance = new Ics124Queue<>();
        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(result, expResult);
    }

    /**
     * Test of enqueue method, of class Ics124Queue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("testEnqueue");

        String element = "item1";  // The element we want to enqueue

        // Enqueue the element
        queue.enqueue(element);

        // Verify the size of the queue is 1 after enqueuing an element
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

        // Verify that the element is at the front of the queue
        assertEquals(element, queue.peek());
    }

    /**
     * Test of dequeue method, of class Ics124Queue.
     */
    @Test
    public void testDequeueEmptyQueue() {
        System.out.println("testDequeueEmptyQueue");

        try {
            // Try to dequeue from an empty queue
            queue.dequeue();
            // If no exception is thrown, fail the test
            fail("Dequeuing from an empty queue should have thrown a RuntimeException.");
        } catch (RuntimeException e) {
            // Check if the exception is the expected one
            assertEquals("Queue is empty", e.getMessage(), "Exception message should be 'Queue is empty'");
        }
    }

    @Test
    public void testPeekEmptyQueue() {
        System.out.println("testPeekEmptyQueue");

        // Try to peek from an empty queue.expecting a RuntimeException
        try {
            queue.peek();
            fail("Peeking from an empty queue should throw RuntimeException.");
        } catch (RuntimeException e) {
            // Check if the exception message is correct
            assertEquals("Queue is empty", e.getMessage());
        }
    }

    @Test
    public void testPeek() {
        System.out.println("testPeek");

        // Enqueue an element
        String element = "item1";
        queue.enqueue(element);

        // Peek the element and verify it's the one we enqueued
        String result = queue.peek();
        assertEquals(element, result);

        // The queue should still have the element, i.e., it should not be empty
        assertFalse(queue.isEmpty());
    }
}
