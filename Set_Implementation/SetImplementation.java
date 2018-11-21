import java.io.*;   // Setup for input and output
import java.util.*; // Program prompts for the input file name

/**
 * In this program, we use a pair of arrays where one array is longer than the
 * other, and both arrays are kept sorted. The length of the shorter array is 
 * the square root of the length of the longer array; although, it may have 
 * empty entries if it is not yet full. To add an element, insertion sort is
 * used to insert the element into the shorter array. If the short array fills 
 * up, the shorter and longer arrays re-allocated. The two old arrays are
 * merged into the new longer array. The new short array is empty.
 * Then, to find an element, binary search is used on both the long and the 
 * short arrays.
 * 
 * @version 3.0 2018-09-26
 * @author Addison Sears-Collins
 */

/**
 *  The class where all the work is done to implement the set
 */
public class SetImplementation {
	
  // Variables used for file input and output
  private static BufferedReader input = null;
  private static BufferedWriter output = null;
  private static BufferedWriter complexityOutput = null;
  private static String inputFileName = null;
  private static String outputFileName = null;
  private static String complexityOutputFileName = null;
  private static String sCurrentLine = null;
  
  // Variables for the complexity analysis
  private static int numOfInputs = 0;
  private static int amtOfWorkForSearch = 0;
  private static int amtOfWorkForInsert = 0;  
  
  // Initialize both the long and short arrays
  int[] shorterArray;
  int[] longerArray;
  
  // Counter to help keep track when the short array is at full capacity
  int shortCount = 0;
  
  /**
   *  Constructor
   *  Create a longer array that has a size of 0
   *  Create a shorter array that has a size of 1
   *  The length of the shorter array is the square root of the length of the
   *  longer array.
   */
  public SetImplementation() {
    longerArray = new int[0];
    shorterArray = new int[1];
  }
  
  /**
   *  Method to insert an element into the shorter array
   *  Uses insertion sort to insert the element into the proper position
   *  @param element The element we want to insert into the shorter array
   */
  public void insert(int element) {
	  
	// If the shorter array is full, we need to reallocate
	// End result of reallocation is a new shorter and longer array
    if(shortCount == shorterArray.length) {
      reallocate();
    }
        
    shorterArray[0] = element;
    
    shortCount++;
	
	// Make sure the array stays sorted
	insertionSort(shorterArray, shorterArray.length);
	
  }
  
  /**
   *  Method executes when the short array fills up
   *  Creates a new longer array by merging the old short and long arrays 
   */
  public void reallocate() {

    // Keep track of the number of times this key procedure is called 
    // in order to track the amount of work done for the insert operation
    amtOfWorkForInsert++;
    
	try {
		output.write("Reallocation is in progress.");
		output.newLine();
	} catch (IOException e) {
	    e.printStackTrace();
	} 

    // Create a new longer array that is equal in size to the sum of the
    //  lengths of the old short and long arrays
    int[] NewLongerArray = new int[longerArray.length + shorterArray.length];

    // Merge the old short and long arrays into the new longer array
    mergeArrays(longerArray, shorterArray, longerArray.length, 
    		shorterArray.length, NewLongerArray);

    // Create a new short array that is empty. The size of this new short array
    // is equal in size to the square root of the length of the longer array
    shorterArray = new int[(int)Math.sqrt(NewLongerArray.length)];

    // After creating a new longer array, update the longerArray variable
    longerArray = NewLongerArray;

    // Reset the counter
    shortCount = 0;
  }

  /**
   *  Merges the two old arrays into the new longer array 
   *  @param longer The longer array
   *  @param shorter The shorter array
   *  @param longerLength The length of the longer array
   *  @param shorterLength The length of the shorter array
   *  @param newLonger The new longer array that we are merging into
   */
  public void mergeArrays(int[] longer, int[] shorter, int longerLength, 
		  int shorterLength, int[] newLonger) {

    int i = 0; // Initialize current index of the longer array to 0
    int j = 0; // Initialize current index of the shorter array to 0
    int k = 0; // Initialize current index of the new longer array to 0
    
    // Have we reached the end of either array? If not, execute the code in
    // this while loop
    while (i < longerLength && j < shorterLength) { 
      
      // Merge the old short and long arrays into the new long array, making
      // sure that they are merged into sorted order
      if (longer[i] < shorter[j])
        newLonger[k++] = longer[i++];
      else 
        newLonger[k++] = shorter[j++];
    }

    // Have we reached the end of the short array? If so, merge the remainder
    // of the old long array into the new long array
    while (i < longerLength)
      newLonger[k++] = longer[i++];

    // Have we reached the end of the long array? If so, merge the remainder
    // of the short array into the new long array
    while (j < shorterLength)
      newLonger[k++] = shorter[j++];

  }
  
  /**
   *  Insertion Sort method
   *  @param arr The array that we are sorting
   *  @param sizeOfArray The number of elements in the array
   */    
  void insertionSort(int arr[], int sizeOfArray) {
	
	int i, j, key;
    for (j = 1; j < sizeOfArray; j++) {
      key = arr[j];
      i = j - 1;
      
      // Shift the elements of arr[0..i-1] that are greater than key, one 
      // position to the right
      while (i >= 0 && arr[i] > key) {
        arr[i+1] = arr[i];
        i = i-1;
      }
      arr[i+1] = key;
     }
  }
 
  
  /**
   *  Use binary search on both the long and the short arrays
   *  @param element The element we are searching for
   */
  public void search(int element) {

	// Record the index of the element if the element exists 
	// in the longer array  
    int indexLong = binarySearch(longerArray, element);
    
	// Record the index of the element if the element exists 
	// in the shorter array
    int indexShort = binarySearch(shorterArray, element);

    try {
    	// If element is found in both the longer and shorter array
    	if((indexLong >= 0) && (indexShort >= 0)) {
    		output.write(element + " was found in the longer array at index: "
    				+ indexLong);
    		output.newLine();
    		output.write(element + " was found in the shorter array at index: "
    				+ indexShort + "\n");
    		output.newLine();
    		return;
    	}
    
    	// If element is found in the longer array
    	if(indexLong >= 0) {
    		output.write(element + " was found in the longer array at index: "
    				+ indexLong + "\n");
    		output.newLine();
    		return;
    	}
    
    	// If element is found in the shorter array
    	if(indexShort >= 0) {
    		output.write(element + " was found in the shorter array at index: "
    				+ indexShort + "\n");
    		output.newLine();
    		return;
    	}

    	output.write(element + " was not found in the set" + "\n");
    	output.newLine();

    	return;
    } catch (IOException e) {
    	e.printStackTrace();
    } 
  }

  /**
   *  Binary search algorithm
   *  @param list The input array
   *  @param key The element that we are searching for in the array
   */
  public static int binarySearch(int[] list, int key) {
	  int high = list.length - 1;
	  int low = 0;

	  while (high >= low) {
		  
		  // Keep track of the number of times this key while loop is
		  // executed in order to track the amount of work for search.
		  // Worst case for binary search occurs when the key is not 
		  // in the list
		  amtOfWorkForSearch++; 
		  
		  // The meat of the binary search method
		  int middle = (low + high) / 2;
		  if (key < list[middle])
			  high = middle - 1;
		  else if (key == list[middle])
			  return middle;
		  else
			  low = middle + 1;
	  }
	  return - low - 1; // Now high < low, key not found
  }
  
  /**
   *  Prints the contents of both the short and long arrays
   */
  public void printArray() {
	 try {
		 output.write("Long Array: " + Arrays.toString(longerArray));
		 output.newLine();
		 output.write("Short Array: " + Arrays.toString(shorterArray));
	 } catch (IOException e) {
	    e.printStackTrace();
	 } 	 
  }
  
  /**
   *  Main method of the program
   */
  public static void main(String[] args) {

    SetImplementation set = new SetImplementation();
    
    int input_num = 0; // The number we are reading in to the array

    // Prompt for the file input and output name
	Scanner in = new Scanner(System.in);
	
	// Provide instructions to the user on what input the program
	// accepts.
	System.out.println("SET IMPLEMENTATION");
	System.out.println("In this program, we implement a set as " + 
		"described in the Programming Assignment 1 Documentation");
	System.out.println("");
	
	// Prompt for the file input and output name as well as the
	// name for the file that has the complexity verification
	System.out.println("Enter your file input " +
		"name to begin (e.g. input_10.txt" +
		" or C:\\Users\\Desktop\\input_10.txt):");
	inputFileName = in.nextLine();
	
	System.out.println("Now enter your file output " +
		"name (e.g. output_10.txt or" +
		" C:\\Users\\Desktop\\output_10.txt):");
	outputFileName = in.nextLine();	
	
	System.out.println("Now enter your complexity verification file output " +
			"name (e.g. complexity_10.txt or" +
			" C:\\Users\\Desktop\\complexity_10.txt):");
		complexityOutputFileName = in.nextLine();	
		
	// Close the Scanner
	in.close();
	
	// Open the files that will be used for input and output	
    try {        
    	input = new BufferedReader(new FileReader(inputFileName));
        output = new BufferedWriter(new FileWriter(outputFileName));    
        complexityOutput = 
        		new BufferedWriter(new FileWriter(complexityOutputFileName));    
    } catch (Exception ioe) {
    	System.out.println("");
    	System.out.println("Oops! The file cannot be found. Please " +
    			"try again.");
        System.err.println(ioe.toString());
        return;            
    }        
    
    // Read the values and implement the set implementation algorithm 

    try {
    	output.write("SET IMPLEMENTATION RUN");
    	output.newLine();
    	output.newLine();
    	output.write("Author: Addison Sears-Collins");
    	output.newLine();
    	output.write("----------------");
    	output.newLine();
    	
    	// Print the initital array
		set.printArray();
		output.newLine();
    	
    	/*
    	 * Read the input file line by line.
    	 */
    	while ((sCurrentLine = input.readLine()) != null) {  
    		
    		// Keep track of the number of inputs
    		numOfInputs++; 
    		
    		// Read in the number and store into input_num
    		input_num = Integer.parseInt(sCurrentLine.trim());
 
    		output.newLine();
    		output.write("Inserting " + input_num);
    		output.newLine();
    		set.insert(input_num);
    		set.printArray();
        	output.newLine();
    	
    	}
    	
    	// Binary search routine
    	output.newLine();
		output.write("Looking for 324:" + "\n");
        set.search(324);
        
        // Complexity bound analysis
        complexityOutput.write("------------------------------------------");
        complexityOutput.newLine();
        complexityOutput.write("VERIFICATION OF PREDICTED COMPLEXITY BOUND");
        complexityOutput.newLine();
        complexityOutput.write("------------------------------------------");
        complexityOutput.newLine();
        complexityOutput.write("Number of Elements in the Input File: " 
        		+ numOfInputs + " elements");
        complexityOutput.newLine();
        
        complexityOutput.write("Amount of Work Done for Insert: " 
        		+ amtOfWorkForInsert + " operations");
        complexityOutput.newLine();
        
        // Worst case for binary search occurs when the key is not in the list
        complexityOutput.write("Amount of Work Done for Search: " 
        		+ amtOfWorkForSearch + " operations");
        
    	// Binary search routine
		output.write("Looking for 23:" + "\n");
        set.search(23);
        

    }  catch (IOException e) {
    	e.printStackTrace();
    } 
    
    //  Clean up and return to the operating system.
    try {
        input.close();
    	output.close();
    	complexityOutput.close();
    } catch (Exception x) {
        System.err.println(x.toString());
    }
    return;	    
  }
}
