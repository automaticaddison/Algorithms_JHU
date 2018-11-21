Author: Addison Sears-Collins

## COMPILER
Used Java Eclipse IDE (Java 8: JavaSE 1.8) - JDK 8

## MAIN FILE
SetImplementation.java contains the main method and is the driver class for the application.

## COMPILING INSTRUCTIONS
If running program from the command line on Windows 7, navigate to where the compiled classes are 
located (usually the bin directory) in the file and use the command
     java -cp . set_implementation.SetImplementation 
in order to run the program. Alternatively, you can delete the package statement on the first line
of the program and run using the command 'javac SetImplementation.java' + 'java SetImplementation' 
in the command prompt

## INSTRUCTIONS TO RUN CODE
The program will prompt for:
•	File input name (e.g. input_10.txt or C:\Users\Addison\Desktop\input_10.txt). The number 10 stands for<br />
    the number of random input integers in the file. e.g. input_10000.txt is a list of 10,000 random integers.<br />
•	File output name (e.g. output_10.txt or C:\Users\Addison\Desktop\output_10.txt). This file contains the<br />
    trace runs for the insert and search operations. The 10 in the file name means that the corresponding<br />
    input file was a list of 10 random integers.<br />
•	Complexity verification file output name (e.g. complexity_10.txt or C:\Users\Addison\Desktop\complexity_10.txt). <br />
    This file contains the results of how much work was done for the insert and search operations. It is used to <br />
    verify the predicted complexity bound. The 10 in the file name means that the corresponding input file was a list <br />
    of 10 random integers.<br />

## CONSTRAINTS
The input file needs to exist in order for the program to run. The output files do not have to exist.

## TEXT FILE LIST (15 files in total)
5 input files, 5 output files, 5 complexity output files:<br />
•	input_1.txt – A list of 1 random integer<br />
•	output_1.txt – Contains the trace runs for the insert and search operations on a list of 1 random integer<br />
•	complexity_1.txt – How much work was done for the insert and search operations for a list of 1 random integer<br />
•	input_10.txt – A list of 10 random integers<br />
•	output_10.txt – Contains the trace runs for the insert and search operations on a list of 10 random integers<br />
•	complexity_10.txt – How much work was done for the insert and search operations for a list of 10 random integers<br />
•	input_100.txt – A list of 100 random integers<br />
•	output_100.txt – Contains the trace runs for the insert and search operations on a list of 100 random integers<br />
•	complexity_100.txt – How much work was done for the insert and search operations for a list of 100 random integers<br />
•	input_1000.txt – A list of 1000 random integers<br />
•	output_1000.txt – Contains the trace runs for the insert and search operations on a list of 1000 random integers<br />
•	complexity_1000.txt – How much work was done for the insert and search operations for a list of 1000 random integers<br />
•	input_10000.txt – A list of 10000 random integers<br />
•	output_10000.txt – Contains the trace runs for the insert and search operations on a list of 10000 random integers<br />
•	complexity_10000.txt – How much work was done for the insert and search operations for a list of 10000 random integers<br />
