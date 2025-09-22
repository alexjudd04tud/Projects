// Heap.java
// Skeleton code

class Heap {//heap class is created
  private
	int[] a; //our array to store the values on the heap
	int N;//N = the amount of elements currently in the heap
	static int maxH = 100; //the array can have a max of 100 values

   // two constructors
   Heap() {
      N = 0;//N is initialized to zero (The heap is initially empty when created)
      a = new int[maxH+1]; //a new heap object is constructed with a size of 101 (0 index isnt used to store any elements of the heap)
   }


   Heap(int size) {
      N = 0; //heap initially contains 0 elements
      a = new int[size + 1]; // A new array of size "size + 1" is created
   } 



   void siftUp( int k) {//method to re-organise the heap after inserting a new node, taking arguement k, which is our new node
      int v = a[k]; //int v is assigned the value of the newly inserted node
      a[0] = Integer.MAX_VALUE;//a[0] is a sentinel variable given value of infinity

      // complete yourself from pseudocode in notes
      while (v > a[k/2]) {//while v is greatetr than its parent node
         a[k] = a[k/2];//the parent node is replaced at the index previously occupied by the new node
         k = k/2;//k is reassigned as k/2 (parents previous index)
      }
      a[k] = v; //our new node is placed at index k
      //we have essentially swapped the new node and its parents place
      
   }


/* 
   void siftDown( int k) {//method to re-organise the heap after removing the root node
      int v, j;//variables v and j are declared
      v = a[k];//v is assigned the value of a[k] which is the new root node after moving it from the back/bottom
      while (2*(k) <= N) {//while the current node has children, N represents the current size of the heap
         j = 2*(k);//j is assigned the index of the left child node
         if (j < N && a[j] < a[j+1]) {//checks if the child node is in the heap, and if the left child is bigger than the right child
                                       //essentially aims to find the bigger child
            ++j;//if true, j now points to the right child 

         }
         if (v >= a[j]) {//if v (our new root node) is bigger than the right child
            break;//exits the while loop, as no further iterations are necessary.
         }
         a[k] = a[j]; //the node pointed to by j, is placed at index k 
         k = j; //k is reassigned as the new index of the node being sifted down
      a[k] = v; //our sifted down node is now stored at the updated a[k]

      }
      
   
   }
*/
   //Recursive version of siftDown():

   private void maxHeapify(int i) {
      int left = 2 * i;
      int right = 2 * i + 1;
      int largest = i;

      if (left <= N && a[left] > a[largest]) {
         largest = left;
      }
      if (right <= N && a[right] >a[largest]) {
         largest = right;
      }
      if (largest != i) {
         int temp = a[i];
         a[i] = a[largest];
         a[largest] = temp;
         maxHeapify(largest);
      }

   }


   void insert( int x) {
      a[++N] = x;
      siftUp( N);
   }


   int remove() {
      a[0] = a[1];     // store highest priority value in a[0]
      a[1] = a[N--];  // and replace it with value from end og the heap
      maxHeapify(1);    // and then sift this value down
      return a[0];
   }



   void display() {
      System.out.println("\nThe tree structure of the heaps is:");
      System.out.println( a[1] );
      for(int i = 1; i<= N/2; i = i * 2) {
         for(int j = 2*i; j < 4*i && j <= N; ++j)
            System.out.print( a[j] + "  ");
         System.out.println();
      }
      System.out.println();
   }



   public static void main(String args[]) {

      Heap h = new Heap();
      int r; double x;

      // insert random numbers between 0 and 99 into heap
      for(int i = 1; i <= 10; ++i)  {
         x =  (Math.random()*100.0);
         r = (int) x; 
         System.out.println("Inserting " + r);
         h.insert(r);
      h.display();
      } 
      System.out.println("Removing " + h.a[1] + " ....");
      h.remove();
      h.display();
   }




} // end of Heap class