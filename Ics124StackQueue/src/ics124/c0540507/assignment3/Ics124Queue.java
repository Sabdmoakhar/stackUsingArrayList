package ics124.c0540507.assignment3;

import ics124.c0540507.assignment3.Ics124SinglyLinkedList;

public class Ics124Queue<E> {

    private Ics124SinglyLinkedList<E> data;

    public Ics124Queue() {
        data = new Ics124SinglyLinkedList<>();
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public boolean isFull() {
        return false;
    }
    // Add size() method

    public int size() {
        return data.size();
    }

    // This method accept an element of type E and add it to the edn of the queue
    public void enqueue(E e) {
        // Add at the end of the list
        data.add(data.size(), e);
    }

    // This method removes and returns the element at the front of the queue
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        // Remove and return from the front of the list
        return data.remove(0);
    }

    // This method returns the element at the front of the queue without removing it
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        // Return the first element (front of the queue)
        return data.get(0);
    }
}
