package statics;

public class debug {
	public static void debugMessage(String sender, String message) {
		System.out.println("DEBUG: "+sender+": "+message);
	}
	public static void errorMessage(String sender, String message) {
		System.out.println("ERROR: "+sender+": "+message);
	}
}
