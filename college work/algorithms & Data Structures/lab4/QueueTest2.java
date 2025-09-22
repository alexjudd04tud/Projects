// Exercise to separate ADT Queue from its implementation

// and to provide 2 implementations. Also exception handling.

class QueueException extends Exception {
    // do as in stack example
    public QueueException (String s) {//This is the constructor of my QueueException class
        super(s);
    } //passing String s to the superclass constructor allows for error messages to be retrieved using the built in getMessage() method
}    

// In Java an interface can often be the best way to 
// describe an Abstract Data Type (ADT) such as Queue or Stack
interface Queue {
    public void enQueue(int x) throws QueueException;
    public int deQueue() throws QueueException;
    public boolean isEmpty();   
    public void displayQueue();
}




class QueueLL implements Queue {
    public class Node {//class that defines the nodes structure
        int data;
        Node next;

        Node (int x) {//constructor for node objects
            this.data = x;
            this.next = null;
        }
    }

    private Node head;//creation of head and tail nodes to keep track of top/bottom of queue
    private Node tail;

    public QueueLL() {//method that initializes head and tail as Null (i.e an empty queue)
        head = null;
        tail = null;
    }

    public void enQueue(int x) throws QueueException {//method to insert a node into our queue
        Node t = new Node(x);//new node t is created using our Node class and construtor up abov
       
        if (isEmpty()) {//Checks if queue is empty using method isEmpty underneath the display function
            head = t;//the newly created node is inserted at the head of the queue (bc its the only node present)

        } else {//if queue not empty
            tail.next = t;//tail is pointed at our new node
        }
        tail = t;//newly created node becomes the tail/end of the queue

        
    }
    public void displayQueue() {
        if (isEmpty()) {//checks if queue is empty
            System.out.println("Queue is Empty");
        }

        Node t = head;//we start at the head of the queue
        System.out.print("Queue (LL): ");
        while (t != null) {//while we havent reached the end of the queue
            System.out.print(t.data + " ");//print current node
            t = t.next;//current node is moved on to next node
        }
        System.out.println(); // Newline at the end
    }

    // assume the queue is non-empty when this method is called, otherwise throw exception
    public int deQueue() throws QueueException {//method to remove node from queue
        if (isEmpty()) {//checks if queue is empty when method is called
            throw new QueueException("Cannot dequeue from an empty queue!");//throws exception
        }
        int x = head.data;//int x holds the top node in the queue
        head = head.next;//head pointer is repointed to the next node in the queue

        if (head == null) {//if queue becomes empty after dequeueing
            tail = null;//tail is assigned as null
        }    
        return x;//returns removed value
    }

    public boolean isEmpty() {//method to check if queue is empty
        return head == null;
    }

} // end of QueueLL class



class QueueCB implements Queue {//Class for Queue implementation using Circular Buffer array
    private int q[], back, front; //array q, back and front all declared 
    private int qmax, size;//qmax and size: qmax being the maximum size of the array, and size being current size

 
    public QueueCB() {
        qmax = 4;//maximum size allowed is 4
        size = back = front = 0;//size, back and front all initialized as 0 (array will initially be empty)
        q = new int[qmax];//a new array q created, with max size of 4 from our qmax var
    }

    public void enQueue( int x) throws QueueException  {//method to enqueue a new node onto our queue
        // do it
        if (size == qmax) {//if the array is full; the current size = 4
            throw new QueueException("Queue is too full");//throws exception
        }
        q[back] = x;//the value we pass in the function is assigned to the back of the queue
        back = (back + 1) %qmax;//this allows the array to wrap around: back of queue is pushed back by 1 index each time, until %qmax == 0; signifying the queue is full
        size++;//size of the array is increased by 1.
    }
  
    public int deQueue()  throws QueueException {//method to dequeue a node from a Queue using circular buffer array
        // do it
        if (isEmpty()) { 
            throw new QueueException("Cannot dequeue from an empty queue");//bc u cannot dequeue from an empty queue
        }
        int x = q[front];//the value at the front of the queue is stored in int x
        front = (front + 1) % qmax;//front node is pushed up 1 index
        size--;//size is reduced by 1.
        return x; // just so the code runs
    }

    public void displayQueue() {//method for printing the queue (similar to LL implementation done up above)
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue (CB): ");
        int currentIndex = front;
        int count = 0;

        while (count < size) {
            System.out.print(q[currentIndex] + " ");
            currentIndex = (currentIndex + 1) % qmax;
            count++;
        }
        System.out.println();
    }

    public boolean isEmpty() {
       return size == 0;
    }//end of QueueCB class
}


// here we test both implementations
class QueueTest2 {
    public static void main (String[] arg) {
        Queue q1, q2;
        q1 = new QueueLL();//tests if my queue constructors work fro both the linked list and Circular buffer implementation
        q2 = new QueueCB();
        
        for(int i = 6; i>1; --i) 
        try { 
            q1.enQueue(i);            
        } catch (QueueException e) {
            System.out.println("Exception thrown: " + e); //for loop to test my enqueue method for LL
        }

        for(int i = 5; i>1; --i) 
        try { 
            q2.enQueue(i);            
        } catch (QueueException e) {
            System.out.println("Exception thrown: " + e); //same thing, enqueue method for Circular Buffer
        }
        
            q1.displayQueue();//testing the method to display my queue for both LL and CB
            q2.displayQueue();

            try { 
                q1.deQueue();  
                q1.deQueue();
                q1.deQueue();
                q1.deQueue();
                q1.deQueue();          
            } catch (QueueException e) {
                System.out.println("Exception thrown: " + e); //Testing my deQueue function for Linked lists, also checks if my exceptions work 
            }

            try { 
                q2.deQueue();            
            } catch (QueueException c) {
                System.out.println("Exception thrown: " + c ); 
            }

            q1.displayQueue();
            q2.displayQueue();

            
        
           try {
            q2.deQueue();
            q2.displayQueue();
            q2.deQueue();
            q2.displayQueue();
            q2.deQueue();
            q2.displayQueue();
            q2.deQueue();
           } catch (QueueException e) {
            System.out.println("Exception Thrown " + e);//same again checking if exceptions work when trying to dequeue from an empty queue
           }
           
            q2.displayQueue();
        
        
        // more test code: repeat deQueue() until Queue is empty
        // and deQueue() even when empty to see exceptions working.
    }   
}

