import java.util.*;

class QueueException extends Exception {//got this from stack labs
    public QueueException(String msg) {
        super(msg);
    }
}

class Queue {
    public class Node {
        int age;
        String name;
        Node next;

        Node(String name, int age) {
            this.name = name;
            this.age = age;
            this.next = null;
        }
    }

    private Node head, tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public void enQueue(String n, int age) {
        Node t = new Node(n, age);

        if (isEmpty()) {
            head = t;
        } else {
            tail.next = t;
        }
        tail = t;
    }

    public String deQueue() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Cannot Dequeue from an empty queue");
        }
        Node t = head;
        head = head.next;
        if (head == null)
            tail = null;
        return t.name;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int countNames(String s) {
        int count = 0;
        Node t = head;

        while (t != null) {
            if (t.name.equals(s)) {
                count++;
            }
            t = t.next;
        }
        return count;
    }

    public void findYoungest() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue is empty");
           
        }

        Node curr = head;
        Node min = head;

        while (curr != null) {
            if (curr.age < min.age) {
                min = curr;
            }
            curr = curr.next;
        }

        System.out.println("The youngest is " + min.name + " with age " + min.age + "\n");
    }

    public int removeAll(String s) {
        int count = 0;
        Node curr = head, prev = null;

        while (curr != null) {
            if (curr.name.equals(s)) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                if (curr == tail) {
                    tail = prev;
                }
                count++;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return count;
    }

    public void display() {
        System.out.println("My queue now contains");

        Node t = head;
        while (t != null) {
            System.out.print(t.name + " " + t.age + ", ");
            t = t.next;
        }
        System.out.println("\n");
    }

} // end of Queue class

class QueueLabTest {

    // try out the ADT Queue using static allocation
    public static void main(String[] arg) {
        System.out.println("My name is Alex Judd and my student ID is C23435536");

        Queue q = new Queue();

        System.out.println("Inserting into queue\n");

        q.enQueue("tom", 24);
        q.enQueue("joe", 19);
        q.enQueue("elena", 30);
        q.enQueue("joe", 17);
        q.enQueue("elena", 15);
        q.enQueue("joe", 30);
        q.enQueue("tim", 23);

        q.display();
        try {
            q.deQueue();
        } catch (Exception error) {
            System.out.println("Exception is " + error );
        }
        
        System.out.println("joe is in queue " + q.countNames("joe") + " times\n");

        try {
            q.findYoungest();
            
        } catch (Exception error2 ) {
            System.out.println("Exception is: " + error2);
        }
        
        System.out.println("Deleting joes from queue\n");
        int removed = q.removeAll("joe");
        System.out.println("Removed " + removed + " joes.");
        q.display();

    }

} // end of Test class