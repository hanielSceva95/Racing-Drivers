package racingDrivers.racingDrivers;

import static racingDrivers.util.MyLogger.setDebugValue;
import static racingDrivers.util.MyLogger.writeMessage;

import racingDrivers.driverStates.DriverContextI;
import racingDrivers.driverStates.DriverStateI;
import racingDrivers.util.Results;
import racingDrivers.util.MyLogger.*;

public class racingDrivers implements DriverContextI, DriverStateI {
	 public int total_No_driver; 
	 public String output;
	 public int minutes_count = 0;
	 public Float Distance_covered[];
	 public int debuging_point;
	 public int drivres_position[];
	 public String[] Distance_covered_string;
	 public int[] Drivers_calcutated_position;
	 public String[] Drivers_state_string;
	 
	 /**
	  * 
	  * @param Distance_string is the distance traveled in one minute by the drivers in string 
	  * @param output_file outputfile name
	  * @param debug_point for debugging purpose
	  * 
	  */
	 public void calculate_position(String[] Distance_string, String output_file, int debug_point) {
		 this.output = output_file;
		 setDebugValue(debug_point);
		 Boolean first_condition = false;
		 debuging_point =debug_point; 
		 for(int i =0;i<Distance_string.length;i++) {
			 drivres_position[i] = 1;
			 if(Distance_covered[i]==null) {
				 Distance_covered[i]=(float) 0;
			 }
			 Float temp = Float.parseFloat(Distance_string[i]);
			 Float new_laptime = Distance_covered[i] + temp;
			 Distance_covered[i] = new_laptime;
			 for(int j=0;j<i;j++) {
//				 System.out.println("loop staters");
//				 System.out.println(Distance_covered[i]);
//				 System.out.println(Distance_covered[j]);
				 if(Distance_covered[i]>Distance_covered[j]) {
					 if(drivres_position[i] > drivres_position[j]) {
					 drivres_position[i] = drivres_position[j];
					 }
					 first_condition = true;
					 drivres_position[j] = drivres_position[j]+1;
				 } else if (Distance_covered[i]<Distance_covered[j]) {
					 if(drivres_position[i]<drivres_position[j] && first_condition) {
					 drivres_position[i] =  drivres_position[j]+1;
					 } else {
						 drivres_position[i] =  drivres_position[j]+1;
					 }
				 }
//				 for(int x=0;x<drivres_position.length;x++) {
//					 System.out.println(drivres_position[x]);
//				 }
			 }	 
		 }
		 this.findposition(drivres_position);
	 }
	 /**
	  * this method calculates the position of the driver and finds the state of mind of the driver
	  */
	 public void findposition( int[] driver_position) {
		 Drivers_calcutated_position = new int[total_No_driver];
		 Drivers_state_string = new String[total_No_driver];
		 for(int i=0;i<driver_position.length;i++) {
			 if(driver_position[i]<=this.RoundToClosestInt(0.3*total_No_driver)) {
				 Drivers_calcutated_position[i]= 1; //IF 1 THEN THE DRIVER IS LEADING 
			 } else if (this.RoundToClosestInt(0.3*this.total_No_driver)<=driver_position[i] && driver_position[i]<this.RoundToClosestInt(0.7*total_No_driver)){
				 Drivers_calcutated_position[i]=2; // IF 2 THEN THE DRIVER IS HOLDINGON
			 } else if (driver_position[i]>=this.RoundToClosestInt(0.7*total_No_driver)) {
				 Drivers_calcutated_position[i]=3; //IF 3 THEN THE DRIVER IS LOSING
			 }
		 }
		 writeMessage("Debug Level is IN_RUN",DebugLevel.IN_RUN);
		  	for(int x=0;x<Drivers_calcutated_position.length;x++) {
		 		for(int y=0;y<Drivers_calcutated_position.length;y++) {
		 			if(x!=y) {
		 		if(Drivers_calcutated_position[x] == 1 && Drivers_calcutated_position[x] != Drivers_calcutated_position[y]) {
		 			Drivers_state_string[x]="CONFIDENT";
		 		} else if(Drivers_calcutated_position[x] == 2 && Drivers_calcutated_position[x] != Drivers_calcutated_position[y]) {
		 			Drivers_state_string[x]="CALCULATIVE";
		 		} else if (Drivers_calcutated_position[x] == 3){
		 			Drivers_state_string[x]="RECKLESS";
		 		} else if (Drivers_calcutated_position[x] == Drivers_calcutated_position[y]) {
		 			Drivers_state_string[x]="RECKLESS";
		 			Drivers_state_string[y]="RECKLESS";
		 			}
		 			}
		 		}
		 	}
		  	this.calulate_state(Drivers_state_string);		 
	 }
	 public long RoundToClosestInt(double double_value) {
		 long temp = Math.round(double_value);
		 return temp;
	 }
	 /**
	  * this method appends the state of mind of driver for each lap into a single string and sends it results
	  * to get it printed in the output file.
	  */
	 public void calulate_state(String[] state_of_mind) {
		 StringBuilder builder = new StringBuilder();
		 for(String s : state_of_mind) {
		     builder.append(s);
		     builder.append(" ");
		 }
		 String outputString = builder.toString();
		 Results printoutput = new Results(outputString,output, debuging_point);
		 System.out.println(outputString);
	 }
}
