


   int remove() {
      a[0] = a[1];     // store highest priority value in a[0]
      a[1] = a[N--];  // and replace it with value from end og the heap
      maxHeapify(1);    // and then sift this value down
      return a[0];
   }
