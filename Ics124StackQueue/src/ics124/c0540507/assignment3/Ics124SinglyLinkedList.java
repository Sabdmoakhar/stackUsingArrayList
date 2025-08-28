package ics124.c0540507.assignment3;

public class Ics124SinglyLinkedList<T> {

    class SlNode {

        T x;
        SlNode next;
    };
    SlNode head;
    SlNode tail;
    int n;

    public Ics124SinglyLinkedList() {
        head = null;
        tail = null;
        n = 0;
    }

    public int size() {
        return n;
    }//end of size

    public SlNode findNode(int i) {
        SlNode current = head;
        for (int j = 0; j < i; j++) {
            //moving to the next current each iteration
            current = current.next;
        }
        return current;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }
        //calling the helper method to do the loop
        SlNode current = findNode(i);
        return current.x;
    }//end of get

    public void set(int i, T x) {
        if (i < 0 || i > n) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        if (n == 0) {
            // If the list is empty, add the item
            add(i, x);
            return;
        }
        if (i == n) {
            // If the i is equal to the list size, add the item
            add(i, x);
            return;
        }
        // If the index is within bounds (not at the end), simply update the value at that position
        SlNode current = findNode(i);
        current.x = x;
    }//end of set

    public void add(int i, T x) {
        if (i < 0 || i > n) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        SlNode addNode = new SlNode();
        addNode.x = x;

        //insertion at beginning and end if the list is empty
        //O(1)
        if (n == 0) {
            head = addNode;
            tail = addNode;
            //insertion at beginning
            //O(1) 
        } else if (i == 0) {
            addNode.next = head;
            head = addNode;
            //insertion at the end
        } else if (i == n) {
            tail.next = addNode;
            tail = addNode;
            //insertion at anywhere other than beginning and end 
        } else {
            SlNode current = findNode(i - 1);
            addNode.next = current.next;
            current.next = addNode;
        }
        n++;
    }//end of add

    public T remove(int i) {
        if (i >= n || i < 0) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        T result;
        // Case 1: Removing from the front (head)
        if (i == 0) {
            result = head.x;  // Store the value of the node to be removed
            head = head.next;  // Update head to the next node

            // If the list becomes empty after removal set tail to null
            if (head == null) {
                tail = null;
            }
            // Case 2: Removing from the end (tail)
        } else if (i == n - 1) {
            // Store the value of the tail node
            result = tail.x;
            // Start from the head to find the second-to-last node
            SlNode current = head;
            while (current.next != tail) {
                current = current.next;
            }
            // Update the second-to-last node's next to null
            current.next = null;
            tail = current;  // Update tail to the second-to-last node
        }// Case 3: Removing from the middle
        else {
            // Find the node before the one to be removed
            SlNode current = findNode(i - 1);
            // Store the value of the node to be removed
            result = current.next.x;
            // Remove the node by skipping it
            current.next = current.next.next;
            // If we removed the last node, update the tail
            if (i == n - 1) {
                tail = current;
            }
        }
        n--;
        return result;
    }//end of remove method
}//end of the class
