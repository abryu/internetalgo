package helpers;

public class SpiderConstants {
	
	public static final String PROTOCOLS = "http|https";

	public static final String DOMAINS = "edu|com|gov|org|cn|ca";

	public static final String REGEX = "(" + PROTOCOLS + ")://(\\w+\\.)+("+ DOMAINS +")";


}
