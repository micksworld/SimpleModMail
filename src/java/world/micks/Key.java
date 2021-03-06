package world.micks;

public class Key {

	private static final String KEY = System.getenv("TOKEN");
	public static String get() { return KEY; }
	
}
