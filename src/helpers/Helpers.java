package helpers;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Helpers {
	
	  public static void setSystemProperties() {
		    System.setProperty("sun.net.client.defaultConnectTimeout", Constants.DEFAULT_CONNECT_TIMEOUT);
		    System.setProperty("sun.net.client.defaultReadTimeout", Constants.DEFAULT_READ_TIMEOUT);
	  }
	  
	  public static Map<String, String> loadConfigFile() {
		    Properties prop = new Properties();
		    Map<String, String> map = new HashMap<String, String>();
		    try {
		      FileInputStream inputStream = new FileInputStream(Constants.CONFIG_FILE_LOCATION);
		      prop.load(inputStream);
		    } catch (Exception e) {
		      System.out.println("Some issue finding or loading file....!!! " + e.getMessage());
		    }
		    for (final Map.Entry<Object, Object> entry : prop.entrySet()) 
		      map.put((String) entry.getKey(), (String) entry.getValue());   
		    return map;
	   }

}
