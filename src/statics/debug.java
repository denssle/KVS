package statics;

import java.util.logging.Level;
import java.util.logging.Logger;


public class debug {
	private static Integer counter = 0;
	private static final Logger log = Logger.getLogger("confLogger");
	
	public debug() {
	}
	
	public static void debugMessage(String sender, String message) {
		
		//System.out.println(getCounter()+" DEBUG: "+sender+": "+message);
		log.log( Level.INFO, sender+" : "+message, getCounter()+message);
	}
	
	public static void errorMessage(String sender, String message) {
		//System.out.println(getCounter()+" ERROR: "+sender+": "+message);
		log.log( Level.WARNING, sender+" : "+message, getCounter()+message);
	}
	
	private static String getCounter() {
		counter += 1;
		if(counter <10) {
			return "0"+counter;
		}
		else {
			return counter.toString();
		}
	}
}
