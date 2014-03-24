import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Arrays;

public class sorting {
    
    private static int[] arr;
    private static int[] arrCopy;
    private static BufferedReader read;
    private static Random randomGenerator;
    
    private static int size;
    private static int random;
    
    private static int n;

    //checks if array is already sorted
    private static boolean isSorted(int low, int high) {
    	
    	for (int i = low; i < high; i++) {
    		
    		if (arr[i] > arr[i+1]) 
    			return false;
    	}
    	
    	return true;
    }
    
    private static void printArray() {
    	System.out.print("[" + arr[0]);
        for(int i=1; i<size; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.println("]");
    }
    
    public static void buildheap(){
        n=arr.length-1;
        for(int i=n/2;i>=0;i--){
            heapify(i);
        }
    }
    
    public static void heapify(int i){ 
        int largest;
        int left=2*i;
        int right=2*i+1;
        if(left <= n && arr[left] > arr[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && arr[right] > arr[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            heapify(largest);
        }
    }
    
    public static void exchange(int i, int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t; 
   }
    
    public static void heapsort(){
        buildheap();    
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            heapify(0);
        }
    }
    
    private static void mergesort(int low, int high) {
        // Check if low is smaller then high, if not then the array is sorted
        if (low < high) {
          // Get the index of the element which is in the middle
          int middle = low + (high - low) / 2;
          // Sort the left side of the array
          mergesort(low, middle);
          // Sort the right side of the array
          mergesort(middle + 1, high);
          // Combine them both
          merge(low, middle, high);
        }
      }

    private static void merge(int low, int middle, int high) {

        // Copy both parts into the arrCopy array
        for (int i = low; i <= high; i++) {
          arrCopy[i] = arr[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
          if (arrCopy[i] <= arrCopy[j]) {
            arr[k] = arrCopy[i];
            i++;
          } else {
            arr[k] = arrCopy[j];
            j++;
          }
          k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
          arr[k] = arrCopy[i];
          k++;
          i++;
        }

      }
      
    private static void quicksort(int low, int high) {
    	    int i = low, j = high;
    	    // Get the pivot element from the middle of the list
    	    int pivot = arr[(high+low)/2];

    	    // Divide into two lists
    	    while (i <= j) {
    	      // If the current value from the left list is smaller then the pivot
    	      // element then get the next element from the left list
    	      while (arr[i] < pivot) {
    	        i++;
    	      }
    	      // If the current value from the right list is larger then the pivot
    	      // element then get the next element from the right list
    	      while (arr[j] > pivot) {
    	        j--;
    	      }

    	      // If we have found a values in the left list which is larger then
    	      // the pivot element and if we have found a value in the right list
    	      // which is smaller then the pivot element then we exchange the
    	      // values.
    	      // As we are done we can increase i and j
    	      if (i < j) {
    	        exchange(i, j);
    	        i++;
    	        j--;
    	      } else if (i == j) { i++; j--; }
    	    }

    	    // Recursion
    	    if (low < j)
    	      quicksort(low, j);
    	    if (i < high)
    	      quicksort(i, high);
    	  }

    private static void quicksortA(int low, int high) {
    	
    	if ((high - low) < 100) {
    		insertSort(low,high);
    		return;
    	}
    	
	    int i = low, j = high;
	    int pivot;
	    // Get the pivot element from the middle of the list
	    
	    int pivotValue_o = (high+low)/2;
	    int pivot_o = arr[pivotValue_o];
	    
	    int pivotValue_l = (pivotValue_o+low)/2;
	    int pivot_l = arr[pivotValue_l];
	    
	    int pivotValue_h = (pivotValue_o+high)/2;
	    int pivot_h = arr[pivotValue_h];
	    
	    if (((pivot_o < pivot_l) && (pivot_o > pivot_h)) || ((pivot_o < pivot_h) && (pivot_o > pivot_l))) {
	    	pivot = pivot_o;
	    }
	    else if (((pivot_l < pivot_o) && (pivot_l > pivot_h)) || ((pivot_l < pivot_h) && (pivot_l > pivot_o))){
	    	pivot = pivot_l;
	    }
	    else pivot = pivot_h;

	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (arr[i] < pivot) {
	        i++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (arr[j] > pivot) {
	        j--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i < j) {
	        exchange(i, j);
	        i++;
	        j--;
	      } else if (i == j) { 
	    	  i++; 
	    	  j--; 	    	 
	      }
	    }

	    // Recursion
	    if (low < j)
	      quicksortA(low, j);
	    if (i < high)
	      quicksortA(i, high);
	  }
    
    private static void quicksortB(int low, int high) {
    	
    	if ((high - low) < 100) {
    		insertSort(low,high);
    		return;
    	}
    	
	    int i = low, j = high;
	    int pivot;
	    int pivotA;
	    int pivotB;
	    int pivotC;
	    // Get the pivot element from the middle of the list
	    
	    int third_1 = (high - low)/3;
	    int third_2 = 2*((high - low)/3);

	    int pivotValue_11 = (third_1+low)/2;
	    int pivot_11 = arr[pivotValue_11];
	    int pivotValue_21 = (pivotValue_11+low)/2;
	    int pivot_21 = arr[pivotValue_21];
	    int pivotValue_31 = (pivotValue_11+high)/2;
	    int pivot_31 = arr[pivotValue_31];
	    
	    // find the median of the first section of the array
	    if (((pivot_11 < pivot_21) && (pivot_11 > pivot_31)) || ((pivot_11 < pivot_31) && (pivot_11 > pivot_21))) 
	    	pivotA = pivot_11;
	    else if (((pivot_21 < pivot_11) && (pivot_21 > pivot_31)) || ((pivot_21 < pivot_31) && (pivot_21 > pivot_11)))
	    	pivotA = pivot_21;
	    else pivotA = pivot_31;
	    
	    int pivotValue_12 = (third_1 + third_2)/2;
	    int pivot_12 = arr[pivotValue_12];
	    int pivotValue_22 = (pivotValue_12+third_1)/2;
	    int pivot_22 = arr[pivotValue_22];
	    int pivotValue_32 = (pivotValue_12+third_2)/2;
	    int pivot_32 = arr[pivotValue_32];

	 // find the median of the second section of the array
	    if (((pivot_12 < pivot_22) && (pivot_12 > pivot_32)) || ((pivot_12 < pivot_32) && (pivot_12 > pivot_22))) 
	    	pivotB = pivot_12;
	    else if (((pivot_22 < pivot_12) && (pivot_22 > pivot_32)) || ((pivot_22 < pivot_32) && (pivot_22 > pivot_12)))
	    	pivotB = pivot_22;
	    else pivotB = pivot_32;
	    
	    int pivotValue_13 = (third_2 + high)/2;
	    int pivot_13 = arr[pivotValue_13];
	    int pivotValue_23 = (pivotValue_13 + third_2)/2;
	    int pivot_23 = arr[pivotValue_23];
	    int pivotValue_33 = (pivotValue_13+high)/2;
	    int pivot_33 = arr[pivotValue_33];

	    // find the median of the third section of the array
	    if (((pivot_13 < pivot_23) && (pivot_13 > pivot_33)) || ((pivot_13 < pivot_33) && (pivot_13 > pivot_23)))
	    	pivotC = pivot_13;
	    else if (((pivot_23 < pivot_13) && (pivot_23 > pivot_33)) || ((pivot_23 < pivot_33) && (pivot_23 > pivot_13)))
	    	pivotC = pivot_23;
	    else pivotC = pivot_33;
	    
	    // find the median of the three local medians
	    if (((pivotA < pivotB) && (pivotA > pivotC)) || ((pivotA < pivotC) && (pivotA > pivotB))) 
	    	pivot = pivotA;
	    else if (((pivotB < pivotA) && (pivotB > pivotC)) || ((pivotB < pivotC) && (pivotB > pivotA)))
	    	pivot = pivotB;
	    else pivot = pivotC;
	    	
	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (arr[i] < pivot) {
	        i++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (arr[j] > pivot) {
	        j--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i < j) {
	        exchange(i, j);
	        i++;
	        j--;
	      } else if (i == j) { 
	    	  i++; 
	    	  j--; 	    	 
	      }
	    }

	    // Recursion
	    if (low < j)
	      quicksortA(low, j);
	    if (i < high)
	      quicksortA(i, high);
	  }
    
    private static void quicksortC(int low, int high) {
    	
    	if ((high - low) < 100) {
    		insertSort(low,high);
    		return;
    	}
    	
	    int i = low, j = high;
	    // Get the pivot element from the middle of the list
	    int pivot = arr[(high+low)/2];

	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (arr[i] < pivot) {
	        i++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (arr[j] > pivot) {
	        j--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i < j) {
	        exchange(i, j);
	        i++;
	        j--;
	      } else if (i == j) { i++; j--; }
	    }

	    // Recursion
	    if (low < j) {
	    	if(!isSorted(low,j))
	    		quicksort(low, j);
	    }
	    if (i < high) {
	    	if(!isSorted(i,high))
	    		quicksort(i, high);
	    }
	  }
    
    private static void quicksortD(int low, int high) {
    	
    	if ((high - low) < 100) {
    		insertSort(low,high);
    		return;
    	}
    	
	    int i = low, j = high;
	    int pivot;
	    // Get the pivot element from the middle of the list
	    
	    int pivotValue_o = (high+low)/2;
	    int pivot_o = arr[pivotValue_o];
	    
	    int pivotValue_l = (pivotValue_o+low)/2;
	    int pivot_l = arr[pivotValue_l];
	    
	    int pivotValue_h = (pivotValue_o+high)/2;
	    int pivot_h = arr[pivotValue_h];
	    
	    if (((pivot_o < pivot_l) && (pivot_o > pivot_h)) || ((pivot_o < pivot_h) && (pivot_o > pivot_l))) {
	    	pivot = pivot_o;
	    }
	    else if (((pivot_l < pivot_o) && (pivot_l > pivot_h)) || ((pivot_l < pivot_h) && (pivot_l > pivot_o))){
	    	pivot = pivot_l;
	    }
	    else pivot = pivot_h;

	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (arr[i] < pivot) {
	        i++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (arr[j] > pivot) {
	        j--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i < j) {
	        exchange(i, j);
	        i++;
	        j--;
	      } else if (i == j) { 
	    	  i++; 
	    	  j--; 	    	 
	      }
	    }

	    //Recursion
	    if (low < j) {
	    	if(!isSorted(low,j))
	    		quicksort(low, j);
	    }
	    if (i < high) {
	    	if(!isSorted(i,high))
	    		quicksort(i, high);
	    }
	  }
    
    private static void quicksortE(int low, int high) {
    	
    	if ((high - low) < 100) {
    		insertSort(low,high);
    		return;
    	}
    	
	    int i = low, j = high;
	    int pivot;
	    int pivotA;
	    int pivotB;
	    int pivotC;
	    // Get the pivot element from the middle of the list
	    
	    int third_1 = (high - low)/3;
	    int third_2 = 2*((high - low)/3);

	    int pivotValue_11 = (third_1+low)/2;
	    int pivot_11 = arr[pivotValue_11];
	    int pivotValue_21 = (pivotValue_11+low)/2;
	    int pivot_21 = arr[pivotValue_21];
	    int pivotValue_31 = (pivotValue_11+high)/2;
	    int pivot_31 = arr[pivotValue_31];
	    
	    // find the median of the first section of the array
	    if (((pivot_11 < pivot_21) && (pivot_11 > pivot_31)) || ((pivot_11 < pivot_31) && (pivot_11 > pivot_21))) 
	    	pivotA = pivot_11;
	    else if (((pivot_21 < pivot_11) && (pivot_21 > pivot_31)) || ((pivot_21 < pivot_31) && (pivot_21 > pivot_11)))
	    	pivotA = pivot_21;
	    else pivotA = pivot_31;
	    
	    int pivotValue_12 = (third_1 + third_2)/2;
	    int pivot_12 = arr[pivotValue_12];
	    int pivotValue_22 = (pivotValue_12+third_1)/2;
	    int pivot_22 = arr[pivotValue_22];
	    int pivotValue_32 = (pivotValue_12+third_2)/2;
	    int pivot_32 = arr[pivotValue_32];

	 // find the median of the second section of the array
	    if (((pivot_12 < pivot_22) && (pivot_12 > pivot_32)) || ((pivot_12 < pivot_32) && (pivot_12 > pivot_22))) 
	    	pivotB = pivot_12;
	    else if (((pivot_22 < pivot_12) && (pivot_22 > pivot_32)) || ((pivot_22 < pivot_32) && (pivot_22 > pivot_12)))
	    	pivotB = pivot_22;
	    else pivotB = pivot_32;
	    
	    int pivotValue_13 = (third_2 + high)/2;
	    int pivot_13 = arr[pivotValue_13];
	    int pivotValue_23 = (pivotValue_13 + third_2)/2;
	    int pivot_23 = arr[pivotValue_23];
	    int pivotValue_33 = (pivotValue_13+high)/2;
	    int pivot_33 = arr[pivotValue_33];

	    // find the median of the third section of the array
	    if (((pivot_13 < pivot_23) && (pivot_13 > pivot_33)) || ((pivot_13 < pivot_33) && (pivot_13 > pivot_23)))
	    	pivotC = pivot_13;
	    else if (((pivot_23 < pivot_13) && (pivot_23 > pivot_33)) || ((pivot_23 < pivot_33) && (pivot_23 > pivot_13)))
	    	pivotC = pivot_23;
	    else pivotC = pivot_33;
	    
	    // find the median of the three local medians
	    if (((pivotA < pivotB) && (pivotA > pivotC)) || ((pivotA < pivotC) && (pivotA > pivotB))) 
	    	pivot = pivotA;
	    else if (((pivotB < pivotA) && (pivotB > pivotC)) || ((pivotB < pivotC) && (pivotB > pivotA)))
	    	pivot = pivotB;
	    else pivot = pivotC;
	    	
	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (arr[i] < pivot) {
	        i++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (arr[j] > pivot) {
	        j--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i < j) {
	        exchange(i, j);
	        i++;
	        j--;
	      } else if (i == j) { 
	    	  i++; 
	    	  j--; 	    	 
	      }
	    }

	    //Recursion
	    if (low < j) {
	    	if(!isSorted(low,j))
	    		quicksort(low, j);
	    }
	    if (i < high) {
	    	if(!isSorted(i,high))
	    		quicksort(i, high);
	    }
	  }
    
    private static void insertSort(int low, int high) {
      	int j;
      	
      	for (int i = low; i <= high; i++) {
      		j = i;
      		while ((j > low) && (arr[j] < arr[j-1]) ) {
      			
      			exchange(j,j-1);
      			j= j- 1;
      		}      		
      	}
    }
      
    public static void main(String[] args) {
        
        read = new BufferedReader(new InputStreamReader(System.in));
        
        randomGenerator = new Random();
       
        // looping 10 times

        	System.out.print("*****************\n");
        try
        {
            System.out.print("Please enter array size : 100,000\n");
            //size = Integer.parseInt(read.readLine());
            size = 100000;
            
            System.out.print("Please enter the random range : 1,100,000,000\n");
            //random = Integer.parseInt(read.readLine());
            random = 1100000000;
            
            // create array
            arr = new int[size];
            arrCopy = new int[size];
            
            
            // fill array
            for(int i=0; i<size; i++) {
                arr[i] = arrCopy[i] = randomGenerator.nextInt(random);
            }
            if (size < 101) { 
            	System.out.println("Initial array:");
            	printArray();
            }

            long start = System.currentTimeMillis();
            Arrays.sort(arr);
            if (size < 101) printArray();
            long finish = System.currentTimeMillis();
            System.out.println("Arrays.sort: " + (finish-start) + " milliseconds.");
            
            // Heap sort      
            start = finish;
            heapsort();
            if (size < 101) printArray();
            finish = System.currentTimeMillis();
            System.out.println("heapsort: " + (finish-start) + " milliseconds.");
 
            // Quick sort
            start = finish;
            for(int i=0; i<size; i++) arr[i] = arrCopy[i];
            quicksort(0, size-1);
            if (size < 101) printArray();
            finish = System.currentTimeMillis();
            System.out.println("quicksort: " + (finish-start) + " milliseconds.");
            
            // Quick sort A
            start = finish;
            for(int i=0; i<size; i++) arr[i] = arrCopy[i];
            quicksortA(0, size-1);
            if (size < 101) printArray();
            finish = System.currentTimeMillis();
            System.out.println("quicksort A: " + (finish-start) + " milliseconds.");
            
            // Quick sort B
            start = finish;
            for(int i=0; i<size; i++) arr[i] = arrCopy[i];
            quicksortB(0, size-1);
            if (size < 101) printArray();
            finish = System.currentTimeMillis();
            System.out.println("quicksort B: " + (finish-start) + " milliseconds.");
            
            // Quick sort C
            start = finish;
            for(int i=0; i<size; i++) arr[i] = arrCopy[i];
            quicksortC(0, size-1);
            if (size < 101) printArray();
            finish = System.currentTimeMillis();
            System.out.println("quicksort C: " + (finish-start) + " milliseconds.");
            
            // Quick sort D
            start = finish;
            for(int i=0; i<size; i++) arr[i] = arrCopy[i];
            quicksortD(0, size-1);
            if (size < 101) printArray();
            finish = System.currentTimeMillis();
            System.out.println("quicksort D: " + (finish-start) + " milliseconds.");
            
            // Quick sort E
            start = finish;
            for(int i=0; i<size; i++) arr[i] = arrCopy[i];
            quicksortE(0, size-1);
            if (size < 101) printArray();
            finish = System.currentTimeMillis();
            System.out.println("quicksort E: " + (finish-start) + " milliseconds.");
            
            // insertion sort
            start = finish;
            for(int i=0; i<size; i++) arr[i] = arrCopy[i];
            insertSort(0, size-1);
            if (size < 101) printArray();
            finish = System.currentTimeMillis();
            System.out.println("insertSort: " + (finish-start) + " milliseconds.");
            
            // Merge sort, which destroys arrCopy[].
            start = finish;
            for(int i=0; i<size; i++) arr[i] = arrCopy[i];
            mergesort(0, size-1);
            if (size < 101) printArray();
            finish = System.currentTimeMillis();
            System.out.println("mergesort: " + (finish-start) + " milliseconds.");
      
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}