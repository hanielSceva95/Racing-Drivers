package racingDrivers.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static racingDrivers.util.MyLogger.*;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	   public Results(String Output, String output_file_name, int debuging_point){
		   setDebugValue(debuging_point);
		   writeMessage("Debug level is IN_RESULTS",DebugLevel.IN_RESULTS);
	    	try {
	    		File file = new File(output_file_name);
	    		if (!file.exists()) {
	    		     file.createNewFile();
	    		  }
	    		FileWriter writer = new FileWriter(file,true);
	    		BufferedWriter bufferedWriter = new BufferedWriter(writer);
	    		bufferedWriter.write(Output);
	    		bufferedWriter.newLine();
	    		bufferedWriter.close();
	    		setDebugValue(debuging_point);
	 		   writeMessage("Debug level is FROM_RESULTS",DebugLevel.FROM_RESULTS);
	 		   }
	    	catch (IOException e) {
	    		System.out.println(e);
	    	}
		}
}
