package statics;

public class debug {
	private static Integer counter = 0;
	
	public debug() {
	}
	
	public static void debugMessage(String sender, String message) {
		System.out.println(getCounter()+" DEBUG: "+sender+": "+message);
	}
	public static void errorMessage(String sender, String message) {
		System.out.println(getCounter()+" ERROR: "+sender+": "+message);
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
