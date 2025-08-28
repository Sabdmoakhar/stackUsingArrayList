package ics124.c0540507.assignment3;

/**
 *
 * @author Shayan Abdmoakhar
 */
public class StackUsingList implements Ics124Stack {

    private Ics124SinglyLinkedList<Integer> data;

    public StackUsingList() {
        data = new Ics124SinglyLinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return data.size() == 0;
    }

    @Override
    public boolean isFull() {
        // Linked list stack is not full
        return false;
    }

    @Override
    public Integer peek() {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }
        return data.get(0); // Get the first element (top of the stack)
    }

    @Override
    public Integer pop() {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }
        // Remove and return the first element (top of the stack)
        return data.remove(0);
    }

    @Override
    public void push(Integer a) {
        // Add the element to the front of the list (top of the stack)
        data.add(0, a);
    }

}
