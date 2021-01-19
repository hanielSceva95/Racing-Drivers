# Racing-Drivers


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in racingDrivers/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile racingDrivers/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile racingDrivers/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile racingDrivers/src/build.xml run -Darg0=<inputFile.txt> -Darg1=<outputFile.txt> -Darg2=<Logger-Value> 

Example:

ant -buildfile racingDrivers/src/build.xml run -Darg0=inputFile.txt -Darg1=outputFile.txt -Darg2=3



-----------------------------------------------------------------------
## Description:
This code takes in an input file reads the distance traveled by a driver for each minute and prints out the state
of mind of that driver for that minute in mentioned output file. 
