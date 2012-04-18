package main;

import controller.AppController;
import static tools.Logger.*;

/**
 * Main class. Application entry point.
 * 
 * @author Johan
 *
 */
public class Main {
	
	public static final String VERSION = "0.0.3";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length > 0){
			if(args[0].equalsIgnoreCase("--logging")){
				setLogginEnabled(true);
				
				if(args.length > 1) {
					setLogMode(Integer.parseInt(args[1]));
				}
				else {
					setLogMode(LOG_ALL);
				}
			}
		}
		
		new AppController();
	}
}
