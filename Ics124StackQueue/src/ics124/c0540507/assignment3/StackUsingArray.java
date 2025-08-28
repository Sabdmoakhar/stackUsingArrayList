package ics124.c0540507.assignment3;

import ics124.c0540507.assignment3.Ics124Stack;
import ics124.c0540507.assignment3.StackOverflowException;
import ics124.c0540507.assignment3.StackUnderflowException;

public class StackUsingArray implements Ics124Stack {

    private Integer[] data;
    private int top;

    // Constructor that accepts the size of the stack
    public StackUsingArray(int size) {
        data = new Integer[size];
        // Initialize top to 0 (empty stack)
        top = 0;
    }

    StackUsingArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == data.length;
    }

    @Override
    public void push(Integer a) {
        if (isFull()) {
            throw new StackOverflowException("Stack is full");
        }
        // Increment top and then assign the value
        data[top++] = a;
    }

    @Override
    public Integer pop() {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }

        // Decrease top to get the last added element (pre-decrementing)
        // decrement top first, then get the value
        Integer savedValue = data[--top];
        return savedValue;
    }

    @Override
    public Integer peek() {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }
        // Return the top element without removing it
        return data[top - 1];
    }
}
