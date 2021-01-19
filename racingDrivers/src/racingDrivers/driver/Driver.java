
package racingDrivers.driver;

import racingDrivers.util.FileProcessor;
import racingDrivers.util.MyLogger.DebugLevel;

import static racingDrivers.util.MyLogger.*;
/**
 * @author Haniel Sceva
 *
 */
    
    public class Driver {
	
	public static void main(String[] args) {
		int debug_point;  
	    /**
	     * As the build.xml specifies the arguments as argX, in case the
	     * argument value is not given java takes the default value specified in
	     * build.xml. To avoid that, below condition is used
	     */
		
	    if ( (args.length != 3) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
		    System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
		    System.exit(0);
	    } else {
	    	if(Integer.parseInt(args[2])<=4) {
	    		debug_point = Integer.parseInt(args[2]);
	    		/**
	    		 * Sends the input file to FileProcessor for it to fetch data from the file
	    		 */
	    		FileProcessor Fp = new FileProcessor(args[0],args[1],debug_point);
	    	} else {
	    		System.err.println("Error: Incorrect number for debug.");
	    		System.exit(0);
	    	}
	    	
//	    	System.out.println(Fp.total_No_driver);
	    	
	    }
	    setDebugValue(0);
	    writeMessage("Debug level is RELEASE",DebugLevel.RELEASE);
//	    System.out.println("Hello World! Lets get started with the assignment");
	    
	}  // end public static void main
    }  // end public class Driver