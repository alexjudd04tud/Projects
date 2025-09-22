// Linked list implementation of Stack

class StackException extends Exception {
    public StackException (String s) {//This is the constructor of my StackException class
        super(s); //passing String s to the superclass constructor allows for error messages to be retrieved using the built in getMessage() method
    }
    /* 
     StackException is a subclass of javas built in exception class
     by inheriting from Exception, my custom class gains all the properties + methods 
     of the exception class


    */
}

class Stack {//declares class called stack
    
    class Node {//inner class declared inside Stack
        int data; //stores the data value of each element in the stack
        Node next;  //stores reference variable, ie stores location of the next node in the stack
    }
    private Node top;

    /*
        this declares a private node reference variable named top
        the private keyword means that the top variable can only be accessed within the stack
        the top variable will always point towards the most recently added node
        if stack is empty, then top == null     
    */
      
    public Stack() //this is the constructor for the stack class
    { 
        top = null;//top is initialized to null

        //This is because stack is initally empty when a stack is created
                

    }
        
    public void push(int x) {
        Node  t = new Node();
        t.data = x;
        t.next = top;
        top = t;
    }
     
    /*
        Push method:
        This method adds an element (node) to the top of the stack
        int x is the integer value that is going to be added to the stack
        Node t = new Node(): a new node object is created, called t 
        t.data = x; the data value x is assigned to the data field of the new node t (this value is decided when i call the function later on (e.g s.push(10): 10 will be assigned to the data field))
        t.next = top; the next /address field of the new node is assigned to the data field of the new node t (links node to rest of stack)
        top = t; top now points to the newly created node, making it the new top of the stack


    
     */

    //pop method here:
    public int pop() throws StackException
    /*
     * Declares method named pop()
     public means the method can be accessed from any other class
     int means the method will return an integer value(the value that is to be removed from the stack)
     throws StackException is here incase the method could encounter an exception
     */
    {
        if (this.isEmpty())//Checks if the stack is empty, using the isEmpty method that is declared below
        //"this" is a keyword that refers to the current stack object
            throw new StackException("\nIllegal to pop() an empty stack\n");//if true, throws a stackexception
        int x = top.data;
        top = top.next;
        return x;

        /*

         * int x = top.data: integer x is declared, and the data field of the top node is retrieved
         * top = top.next: the top reference variable is reassigned to the next node in the stack
         * return x: returns the value of x: the element that has been popped from the stack
         */
    }
  
    // only to be called if list is non-empty.
    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int c = 0;
        Node t = top;
        while(t != null) {
            ++c;
            t = t.next;
        }
        return c;

    }

    /*
     * The size() methods purpose is to return the number of elements currently present in the stack
     * it can be accessed from any other class, and returns an integer value
     * int c = 0: c is intialized as 0, and acts as a counter to keep track of the number of elemets currently in the stack
     * Node t = top: a temporary pointer t is set to the top of the stack. 
     * while loop is then used to traverse the linked list until it reaches the end (when t == null, youve reached end of list)
     * return c finally just returns the amount of nodes that had been encountered in the loop
     */
    
    
    // Otherwise an exception should be thrown.
       


    public void display() {
        Node t = top;     
        System.out.println("\nStack contents are:  ");
        
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }        
        System.out.println("\n");
    }

    /*
     * The display method prints the contents of the stack.
     * Node t = top: reference variable created to traverse through the stack
     * while loop used to traverse the stack until reaching the end (end = t == null)
     * each iteration of the while loop, we print the data of the current node that t is pointing to
     * t = t.next: t is reassigned to the address of the next pointer in the list
     */

}


public class StackTest {//this declares public class named StackTest;
    public static void main(String[] arg) { //defines the main method
        Stack s = new Stack();//creates a new stack object called s, using my Stack class from above
        // Console.Write("Stack is created\n");
        System.out.println("Stack is created\n");//prints stack is created if stack created successfully

        s.push(10);
        s.push(3);
        s.push(11);
        s.push(7);
        s.display();

        int StackSize = s.size();
        System.out.println("Current size is: " + StackSize);

        try {
            int i = s.pop();//stores the popped element from the stack in the variable i.q

            System.out.println("Just popped " + i);
            s.display();
        } catch (StackException e) {//this catch block is executed if a StackException is thrown within the try block (e.g empty stack scenario)
            System.out.println(e.getMessage());
        }

        StackSize = s.size();
        System.out.println("Current size is: " + StackSize);//size() called again to show the stacks size has decreased by 1.
    }
}


