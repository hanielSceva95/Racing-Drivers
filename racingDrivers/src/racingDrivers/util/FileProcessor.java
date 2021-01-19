package racingDrivers.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static racingDrivers.util.MyLogger.*;
import racingDrivers.racingDrivers.racingDrivers;
import racingDrivers.util.MyLogger.DebugLevel;

public class FileProcessor {
		racingDrivers Rc = new racingDrivers();
	   public FileProcessor(String input, String output, int debug_point) {
		   setDebugValue(debug_point);
		   writeMessage(" Debug Level is Constructor ",DebugLevel.CONSTRUCTOR);
		   String line;
		   File out_file = new File(output) ;
//				FileReader fileread = new FileReader(file);
//				BufferedReader outputfile = new BufferedReader(fileread);
		   out_file.delete();
//		   } finally {
//			   try{
//				   outputfile.close();
//		    } catch (IOException ex) {
		// ...
//		    }
		   /**
		    * initially it fetches the information about the number of drives and then the distance for each minute
		    */
		   try {
				File file = new File(input) ;
				FileReader fileread = new FileReader(file);
			BufferedReader inputfile = new BufferedReader(fileread);
			Rc.total_No_driver = Integer.parseInt(inputfile.readLine());
			if(Rc.total_No_driver>3) {
			Rc.Distance_covered = new Float [Rc.total_No_driver];
			Rc.drivres_position = new int [Rc.total_No_driver];
			while ((line = inputfile.readLine()) != null) {				
				Rc.Distance_covered_string = line.split(" ");
				/**
				 * as soon as the information for each minute is read we are sending this data for finding the position
				 * and then to find the state of mind of the driver
				 */
				Rc.calculate_position(Rc.Distance_covered_string,output,debug_point);
				Rc.minutes_count = Rc.minutes_count++;
				}
			} else {
				/**
				 * we even check if the number of drivers are more then 3 or not else will print out this error message
				 */
				System.err.println("Minimum 3 drivers are required");
				System.exit(0);
			}
			fileread.close();
			setDebugValue(debug_point);
			   writeMessage(" Debug Level is RELEASE ",DebugLevel.RELEASE);
			}
			catch(IOException e) {
				e.printStackTrace();
				
			}
	    }
	
}
