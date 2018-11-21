package quicksorts;

/**
 * This is the class that implements Quicksort using the median-of-three
 * pivot selection process. 
 * @version 1.0 2018-10-09
 * @author Addison Sears-Collins
 */

/**
 *  The class where the median of three pivot selection process is implemented
 */
public class QuicksortMedianOfThree {
	
	// Keeps track of the amount of work done for quicksort that uses the 
	// median-of-three pivot selection process
    private static int amtOfWorkForMedOfThree = 0;

	/**
	  *  Method that calls the recursive quicksort algorithm
	  *  @param intArray An array of integers
	  */
	public void sort(int[] intArray) {
		
		int left = 0;
		int right = intArray.length - 1;
		quickSort(intArray, left, right);
	}
	
	/**
	  *  The recursive quicksort method. 
	  *  @param intArray An array of integers
	  *  @param left The left end of the array
	  *  @param right The right end of the array
	  */
	private void quickSort(int[] intArray, int left, int right) {
		
		// Keep track of the amount of work done
		amtOfWorkForMedOfThree++;

		// Exit method if no scanning to do
		if(left >= right)
			return;

		// Seletion of pivot requires taking the median of the 
		// left, middle, and right elements of the array
		int pivot = getMedian(intArray, left, right);
		int partition = partition(intArray, left, right, pivot);

		// Recursive calls to the quicksort method on left subarray and
		// right subarray
		quickSort(intArray, left, partition - 1);
		quickSort(intArray, partition + 1, right);
	}
	
	/**
	  *  This is the workhorse method for the class that does the partitioning
	  *  of the elements based on the pivot
	  *  @param intArray An array of integers
	  *  @param left The left end of the array
	  *  @param right The right end of the array
	  *  @return int Integer of pivot index
	  */
	private int partition(int[] intArray, int left, int right, int pivot) {
		
		int leftPointer = left - 1; 
		int rightPointer = right;
		
		//Keep looping until pointers cross
		while(leftPointer < rightPointer) { 
			
			// Moving right, search for an element greater than the pivot
			while(intArray[++leftPointer] < pivot); 
			
			// Moving left, search for an element smaller than the pivot
			while(intArray[--rightPointer] > pivot && rightPointer > 0);
	
			// If pointers have crossed, we are done partitioning
			if(leftPointer >= rightPointer) {
				break;
			}
			// Swap elements if we are not done partitioning
			else {
				swap(intArray, leftPointer, rightPointer);
			}			

		}
		// Put pivot in its proper place
		swap(intArray, leftPointer, right);
		
		// Return the locaiton of the pivot
		return leftPointer;
	}

	/**
	  *  This is method calculates the median of three numbers
	  *  @param intArray An array of integers
	  *  @param left The left end of the array
	  *  @param right The right end of the array
	  *  @return int Returns the median of three numbers
	  */
	public int getMedian(int[] intArray, int left, int right) {
		
		// represents floor(i+j)/2 described in the problem statement
		int middle = (left + right)/2; 
		
		if(intArray[left] > intArray[middle])
			swap(intArray, left, middle);
	
		if(intArray[left] > intArray[right])
			swap(intArray, left, right);

		if(intArray[middle] > intArray[right])
			swap(intArray, middle, right);
	
		swap(intArray, middle, right);
		
		return intArray[right];
	}
	
	/**
	  *  This is method swaps elements at different positions within
	  *  an array.
	  *  @param intArray An array of integers
	  *  @param left The left end of the array
	  *  @param right The right end of the array
	  */ 
	public void swap(int[] intArray, int left, int right) {
		
		// left into temp
		int temp = intArray[left]; 
		
		// right into left
		intArray[left] = intArray[right]; 
		
		// temp into right
		intArray[right] = temp; 
	}
	
    /**
     * Returns the amount of work done
     *
     * @return amtOfWorkForMedOfThree Work done
     */
    public int getWork() {
    	return amtOfWorkForMedOfThree;
    }
}
