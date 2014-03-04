// In eclipse, class name and file name must be the same.
// Each class has a separate file.

public class enumerate {

    // all runs start at "main"
    public static void main(String[] args) {
        enumerateSubsets(5);
        enumerateCombinations(3, 5);
        enumerate5Permutations();
        enumeratePermutations(5);
    }

    // enumerate all subsets of the set { 1, 2, ..., n }, where n < 32.
    public static void enumerateSubsets (int n) {   
         // Pre: n < 32
         System.out.println("All subsets of " + n + " numbers:"); 
         for (int x = 0; x < (1 << n); x++) {
             System.out.print("{"); 
             for (int j = 1; j <= n; j++)
		 if ((x & (1 << (j-1))) != 0) 
		     System.out.print(j + ", ");
             System.out.print("}\n"); 
         }
    }

    // print the first n elements of the array x as a set.
    public static void printArray(int x[], int n) {
    	System.out.print("{"); 
    	System.out.print(x[0]);
    	for (int i = 1; i < n; i++)
	    System.out.print(", " + x[i]);
    	System.out.print("}\n"); 
    }
    
    // print all k-combinations of n elements.
    public static void enumerateCombinations (int k, int n) {  
    	int x[] = new int[100];    // k <= 100
    	System.out.println("All " + k + "-combinations of " + n + " numbers:"); 
        for (int j = 0; j < k; j++) x[j] = j+1;
        while (true) {
             printArray(x, k);
             if (nextCombination(x, k, n, 0) == false) break;
             
        }
    }

    // This is an awkward method to print all 5! permutations of 5 elements.
    public static void enumerate5Permutations () {   
        // Pre: n = 5
	System.out.println("All permutations of 5 numbers:"); 
        for (int x1 = 1; x1 <= 5; x1++) 
             for (int x2 = 1; x2 <= 5; x2++) if (x1 != x2)
                  for (int x3 = 1; x3 <= 5; x3++) if (x3 != x1 && x3 != x2)
                      for (int x4 = 1; x4 <= 5; x4++) if (x4 != x1 && x4 != x2 && x4 != x3)
                           for (int x5 = 1; x5 <= 5; x5++) 
                               if (x5 != x1 && x5 != x2 && x5 != x3 && x5 != x4) {
				   System.out.print("[ ");
				   System.out.print(x1+", "+x2+", "+x3+", "+x4+", "+x5); 
				   System.out.print("]\n"); 
			       }
    }

    // print all permutations of n elements.
    public static void enumeratePermutations (int n) {  
        int x[] = new int[n];    // n <= 100
	System.out.println("All permuations of " + n + " numbers:"); 
        for (int j = 0; j < n; j++) x[j] = j+1;
        while (true) {
             printArray(x, n);
             if (nextPermutation(x, n) == false) break;
        }
    }

    // modify the array x to generate the next permutation from x.
    // In general, the first permutation of n elements is [ 1, 2, ..., k ] 
    // and the last permutation is [ n, n-1, ..., 1 ].
    public static boolean nextCombination (int x[], int k, int n, int count) {

    	int j = k - 1 - count;
    	
    	if (j >= 0) {	

    		if (x[j] <= (n - k + j)) {
        		x[j]++;

        		for (int i = 1; i < (k - j); i++)
        			x[i+j] = x[j]+i; 

        		return true; 
             }
    		
    		return nextCombination(x,k,n,count+1);
    	}
    	        
	return false;
    }
    
    public static boolean nextPermutation(int[] x, int n) {
    	int temp;
    	
    	if (n < 0) 
			System.out.println("n must be greater than 0");
    	
    	if (n == 0) { //Base case
    		
    		System.out.print("{");
    		for(int i = 0; i < x.length - 1; i++) 
    			System.out.print(x[i] + ", ");
    		
    		System.out.println(x[x.length - 1] + "}");
    		
    	}

    	if (n > 0) {
    		for (int i = 0; i < n; i++) {
        		
    			temp = x[i];
        		x[i] = x[n - 1];  
        		x[n - 1] = temp;
        		nextPermutation(x,(n - 1));
        		temp = x[i];
        		x[i] = x[n - 1];
        		x[n - 1] = temp;
        		
    		}
    	}
    	
    	return false;
    }

}