// QueueTest.java
// Allocation of Queue objects in main()

class Queue {//defines the queue class, allowing queue objects to be called when the constructor is called

    public class Node {//private inner class created, can only be called within parent class
        int data; //integer variable to store data part of newly created node
        Node next; //reference/pointer variable that stores address of next node in queue
    }

    Node z, head, tail;

    public Queue() {//function to create a new queue
        z = new Node(); //new queue object called z is created using the Queue class
        z.next = z; // sets the next pointer to itself
        head = z;  //initializes the new node as the head of the queue
        tail = null; //tail variable initialized as null
    }
   

    public void enQueue( int x) {//method for inserting node into the queue, returning an integer value
        Node t;

        t = new Node();//new node created using constructor in the Node class
        t.data = x; // Sets the data field of the new node to whatever number was passed as an arguement to the enQueue method
        t.next = z; //Sets the address field of the new node to the location of z

        if(head == z)       // case of empty list
            head = t;//the new node is at the head of the queue
        else                // case of list not empty
            tail.next = t;
            
        tail = t;           // new node is at the tail (end) of the queue
    }

  // assume the queue is non-empty when this method is called
    public int deQueue() {
        
        // missing code
        if (head == z) {//if the queue is empty
            System.out.println("Cannot execute deQueue() with an empty queue");
            return -1;
        }//else, continue:
        int x = head.data; //var x stores the value of the node at the head of the queue (the node that is to be dequeued)

        head = head.next; //head of the queue now becomes the address of the next node along

        if (head == z) {//if after removing a node and the queue is now empty:
            tail = z; //we return to the circular type system as before when we initialized the queue initially
            System.out.println("You have emptied the queue!");
        }


        return x;
    }
    

    public boolean isEmpty() {
        if (head == z && tail == z) {
            System.out.println("This queue is empty!");
            return head == z;
        } 
            return false;
        
        
    }
  
    public boolean isMember(int x) {
        Node current = head;

        while (current != z) { //while it isnt the last node
            if (current.data == x) { //if the data segment contains same int as passed in arguement
                return true;
            }
            current = current.next;
        }
        return false;  
    }

    public void front() {
        Node t = head;
        System.out.println("The front of the queue is: " + t.data);
    }
    
    public void display() {
        System.out.println("\nThe queue values are:\n");

        Node t = head;
        while( t != t.next) {
            System.out.print( t.data + "  ");
            t = t.next;
        }
        System.out.println("\n");
    } 

} // end of Queue class



class QueueTest {
  
  // try out the ADT Queue using static allocation
  public static void main(String[] arg) {

    Queue q = new Queue();

    System.out.println("Inserting ints from 9 to 1 into queue gives:\n");
    for (int i = 9; i > 0; --i) {
       q.enQueue( i);
    }


    q.display();

    System.out.println("\n is 12 in queue? " + q.isMember(12));
	System.out.println("\n is 6 in queue? " + q.isMember(6));
    
    //if( ! q.isEmpty())
        //System.out.println("Deleting value from queue " + q.deQueue() + "\n");

    q.front();

    
    System.out.println("Now dequeueing element by element...");

/* 
    q.enQueue(27);
    q.enQueue(12);
    System.out.println("\n is 12 in queue? " + q.isMember(12));
    q.display();
    System.out.println("Dequeueing head node...");
    q.deQueue();
    q.display();
     System.out.println("Dequeueing head node...");
    q.deQueue();
    q.display();
 */
    

    while (q.head != q.z) {

        int headValue = q.head.data;
        q.deQueue();
        System.out.println("Dequeing " + headValue);
        q.display();

    }

    


  }

} //end of Test class

