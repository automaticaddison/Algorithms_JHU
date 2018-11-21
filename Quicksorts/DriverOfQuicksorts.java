package quicksorts;

import java.io.*;   // Setup for input and output
import java.util.*; // Program prompts for the input file name

/**
 * In this program, we use QUICKSORT from CLRS book that uses a normal pivot 
 * process, and we use QUICKSORT that uses the median-of-three partition
 * process. We test run time analysis of median-of-three, and then compare 
 * the average and worst case run times of QUICKSORT with the pivot processes. 
 * 
 * @version 1.0 2018-10-08
 * @author Addison Sears-Collins
 */

/**
 *  The class where all the work is done to implement the program
 */
public class DriverOfQuicksorts {
	
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
  private static String numOfInputsString;
  private static int amtOfWorkForNormal = 0; // Normal pivot selection
  private static int amtOfWorkForMofT = 0;  // Median-of-Three selection
  
  /**
   *  Main method of the program
   */
  public static void main(String[] args) {

	// Object enables us to invoke methods of this class
    DriverOfQuicksorts array = new DriverOfQuicksorts();
    
    int input_num = 0; // The number we are reading in to the array

    // Prompt for the file input and output name
	Scanner in = new Scanner(System.in);
	
	// Provide instructions to the user on what input the program
	// accepts.
	System.out.println("QUICKSORT RUNTIME ANALYSIS");
	System.out.println("In this program, we use QUICKSORT from CLRS " +
			"book that uses a normal pivot");
	System.out.println("process, and we use QUICKSORT that uses " +
			"the median-of-three partition process.");
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
	
	System.out.println("Now enter your complexity file output " +
			"name (e.g. complexity_10.txt or" +
			" C:\\Users\\Desktop\\complexity_10.txt):");
		complexityOutputFileName = in.nextLine();	
		
	System.out.println("Now enter the number of elements " +
			"in the input file (e.g. 10):");
		numOfInputsString = in.nextLine();	
		numOfInputs = Integer.parseInt(numOfInputsString);
		
		// Initialize both the normal pivot selection process array and the 
		// median-of-three pivot selection process array
		int[] normalArray = new int[numOfInputs];
		int[] medianOfThreeArray = new int[numOfInputs];
		   		
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
    
    // Read the values into each array and run the quicksorts
    try {
    	
    	int counter = 0;
    	
    	/*
    	 * Read the input file line by line.
    	 * Store each integer into both arrays
    	 */
    	while ((sCurrentLine = input.readLine()) != null) {  
    		
    		// Read in the number and store into input_num
    		input_num = Integer.parseInt(sCurrentLine.trim());
 
    		normalArray[counter] = input_num;
    		medianOfThreeArray[counter++] = input_num;;   		
  	   	}
    	
    	// Header of the output file
    	output.write("NORMAL PIVOT SELECTION PROCESS:");
    	output.newLine();
    	output.write("Array Before Sorting = ");
    	output.newLine();
    	
    	// Print the initial array
    	array.printNormalArray(normalArray);
		output.newLine();
		
		// Sort the array using the normal pivot process
		// from the CLRS book
		Quicksort normalMethod = new Quicksort();
		normalMethod.sort(normalArray);
    	output.write("Array After Sorting = ");
    	output.newLine();
    	
    	// Print the array after running quicksort
    	array.printNormalArray(normalArray);
		output.newLine();
    	output.write("----------------");
    	output.newLine();
    	
    	output.write("MEDIAN-OF-THREE PIVOT SELECTION PROCESS:");
    	output.newLine();
    	output.write("Array Before Sorting = ");
    	output.newLine();
    	
    	// Print the initial array
    	array.printMedOfThreeArray(medianOfThreeArray);
		output.newLine();
		
		// Sort the array using the median-of-three pivot selection process
		QuicksortMedianOfThree medOfThreeMethod = new QuicksortMedianOfThree();
		medOfThreeMethod.sort(medianOfThreeArray);
    	output.write("Array After Sorting = ");
    	output.newLine();
    	
    	// Print the array after sorting
    	array.printMedOfThreeArray(medianOfThreeArray);
		output.newLine();
    	
        // Complexity bound analysis
        complexityOutput.write("---------------------------------------------------------------------");
        complexityOutput.newLine();
        complexityOutput.write("RUNTIME STATISTICS: NORMAL PIVOT VS. MEDIAN-OF-THREE");
        complexityOutput.newLine();
        complexityOutput.write("---------------------------------------------------------------------");
        complexityOutput.newLine();
        complexityOutput.write("Number of Elements in the Input File: " 
        		+ numOfInputs + " elements");
        complexityOutput.newLine();
        
        // Display runtime for the normal pivot selection process
        amtOfWorkForNormal = normalMethod.getWork();
        complexityOutput.write("Amount of Work Done for the Normal Pivot Selection Process: " 
        		+ amtOfWorkForNormal + " steps");
        complexityOutput.newLine();
        
        // Display runtime for the median-of-three pivot selection process
        amtOfWorkForMofT = medOfThreeMethod.getWork();
        complexityOutput.write("Amount of Work Done for the Median-of-Three Pivot Selection Process: " 
        		+ amtOfWorkForMofT + " steps");
        complexityOutput.newLine();  

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
  /**
   *  Prints the contents of the normal pivot process array
   */
  public void printNormalArray(int[] normalArray) {
	 try {
		 output.write(Arrays.toString(normalArray));
		 output.newLine();
	 } catch (IOException e) {
	    e.printStackTrace();
	 } 	 
  }
  
  /**
   *  Prints the contents of the median-of-three pivot process array
   */
  public void printMedOfThreeArray(int[] medianOfThreeArray) {
	 try {
		 output.write(Arrays.toString(medianOfThreeArray));
		 output.newLine();
	 } catch (IOException e) {
	    e.printStackTrace();
	 } 	 
  }
}
  
