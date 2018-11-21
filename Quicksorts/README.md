Author: Addison Sears-Collins

## COMPILER
Used Java Eclipse IDE (Java 8: JavaSE 1.8) - JDK 8

## MAIN FILE
DriverOfQuicksorts.java contains the main method and is the driver class for the application.<br />

## SUPPORTING FILES
Quicksort.java is the quicksort algorithm taken from the CLRS course textbook. It uses the normal pivot process.<br />
Partitioner.java does the partitioning for Quicksort.java.<br />
Sorter.java is the interface for the sorting algorithm. It is used in Quicksort.java.<br />
QuicksortMedianOfThree.java is the quicksort algorithm that I developed. It uses the median-of-three pivot selection process.<br />

## COMPILING INSTRUCTIONS
If running program from the command line on Windows 7, navigate to where the compiled classes are <br />
located (usually the bin directory) in the file and use the command<br />
     java -cp . quicksorts.DriverOfQuicksorts<br />
in order to run the program. Alternatively, you can delete the package statement on the first line<br />
of the program and run using the command 'javac DriverOfQuicksorts.java' + 'java DriverOfQuicksorts' <br />
in the command prompt<br />

## INSTRUCTIONS TO RUN CODE
The program will prompt for:<br />
•	File input name (e.g. input_10.txt or C:\Users\Addison\Desktop\input_10.txt). The number 10 stands for<br />
    the number of random input integers in the file. e.g. input_1000.txt is a list of 1,000 random integers.<br />
•	File output name (e.g. output_10.txt or C:\Users\Addison\Desktop\output_10.txt). This file contains the<br />
    trace runs for the insert and search operations. The 10 in the file name means that the corresponding<br />
    input file was a list of 10 random integers.<br />
•	Run time analysis file output name (e.g. complexity_10.txt or C:\Users\Addison\Desktop\complexity_10.txt). <br />
    This file contains the results of how much work was done for the normal and median-of-three pivot selection processes.<br />
    The 10 in the file name means that the corresponding input file was a list of 10 random integers.<br />

## CONSTRAINTS
The input file needs to exist in order for the program to run. The output files do not have to exist.

## TEXT FILE LIST (30 files in total)
10 input files, 10 output files, 10 run time analysis output files:<br />
•	input_10.txt – A list of 10 random integers<br />
•	output_10.txt – Contains the arrays before and after running quicksort using both pivot selection methods<br />
•	complexity_10.txt – Contains the run time information for a list of 10 random integers<br />
•	input_100.txt – A list of 100 random integers<br />
•	output_100.txt – Contains the arrays before and after running quicksort using both pivot selection methods<br />
•	complexity_100.txt – Contains the run time information for a list of 100 random integers<br />
•	input_1000.txt – A list of 1000 random integers<br />
•	output_1000.txt – Contains the arrays before and after running quicksort using both pivot selection methods<br />
•	complexity_1000.txt – Contains the run time information for a list of 1000 random integers<br />
•	input_5.txt – A list of 5 random integers<br />
•	output_5.txt – Contains the arrays before and after running quicksort using both pivot selection methods<br />
•	complexity_5.txt – Contains the run time information for a list of 5 random integers<br />
•	input_50.txt – A list of 50 random integers<br />
•	output_50.txt – Contains the arrays before and after running quicksort using both pivot selection methods<br />
•	complexity_50.txt – Contains the run time information for a list of 50 random integers<br />
•	input_500.txt – A list of 500 random integers<br />
•	output_500.txt – Contains the arrays before and after running quicksort using both pivot selection methods<br />
•	complexity_500.txt – Contains the run time information for a list of 500 random integers<br />
•	input_5000.txt – A list of 5000 random integers<br />
•	output_5000.txt – Contains the arrays before and after running quicksort using both pivot selection methods<br />
•	complexity_5000.txt – Contains the run time information for a list of 5000 random integers<br />
•	input_identical_1000_all_1s.txt – A list of 1000 integers...all 1s<br />
•	output_identical_1000_all_1s.txt – Contains the arrays before and after running quicksort using both pivot selection methods<br />
•	complexity_identical_1000_all_1s.txt – Contains the run time information for a list of 1000 1s<br />
•	input_sorted_1000_asc.txt – A list of 1000 integers sorted in ascending order<br />
•	output_sorted_1000_asc.txt – Contains the arrays before and after running quicksort using both pivot selection methods<br />
•	complexity_sorted_1000_asc.txt – Contains the run time information for a list of 1000 integers sorted in ascending order<br />
•	input_sorted_1000_dec.txt – A list of 1000 integers sorted in descending order<br />
•	output_sorted_1000_dec.txt – Contains the arrays before and after running quicksort using both pivot selection methods<br />
•	complexity_sorted_1000_dec.txt – Contains the run time information for a list of 1000 integers sorted in descending order<br />
