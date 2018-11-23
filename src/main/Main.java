package main;
import helpers.Helpers;

public class Main {
	
	public static void main (String[] args) {
		
		Helpers.setSystemProperties();
		
		new Controller().startParllerCrawler();
			
		
	}

}
