class Queue1 {

    public class Node {
        int data;
        Node next;
    }

    Node z, head, tail;

    public void queue() {
        z = new Node();
        z.next = z;
        head = z;
        tail = null;
    }

    public void enQueue(int x) {

        Node t;
        t = new Node();
        t.data = x;
        t.next = z;

        if (head == z) {
            head = t;
        } else {
            tail.next = t;
        }
        tail = t;
    }

    public int deQueue() {
        if (head == z) {
            System.out.println("Cannot dequeue from an empty queue!");
            return -1;
        }
        int x = head.data;
        head = head.next;

        if (head == z) {//if after removing a node and the queue is now empty:
            tail = z; //we return to the circular type system as before when we initialized the queue initially
            System.out.println("You have emptied the queue!");
        }

        return x ;

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

}//end class

class QueueTest {
  
    // try out the ADT Queue using static allocation
    public static void main(String[] arg) {
  
      Queue1 q = new Queue1();
  
      System.out.println("Inserting ints from 9 to 1 into queue gives:\n");
      for (int i = 9; i > 0; --i) {
         q.enQueue( i);
      }
  
  
      q.display();
  
      //System.out.println("\n is 12 in queue? " + q.isMember(12));
      //System.out.println("\n is 6 in queue? " + q.isMember(6));
      
      //if( ! q.isEmpty())
          //System.out.println("Deleting value from queue " + q.deQueue() + "\n");
  
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
  
  } //end of Test cl




    

