package main;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import launcher.Launcher;
import static tools.Logger.*;


import launcher.Launcher;
import static controller.AppController.MODE;
import static controller.AppController.PRODUCTION;
import static controller.AppController.DEBUG;

/**
 * Main class. Application entry point.
 * 
 * @author Johan
 *
 */
public class Main {
	
	public static final String VERSION = "0.2";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length > 0 && "--debug".equals(args[0])) {
			MODE = DEBUG; 
		}
		
		String os = System.getProperty("os.name").toLowerCase();	
		if(os.indexOf("mac") != -1) OSXOptions();
		
		
		if(MODE == PRODUCTION){
			new Launcher();
		}
		else{
			new AppController().init();
		}
			
			com.apple.eawt.Application app = com.apple.eawt.Application.getApplication();
			URL dockIconURL = Main.class.getResource("/images/launcher/appicon.png");
			Image icon = Toolkit.getDefaultToolkit().createImage(dockIconURL);
			app.setDockIconImage(icon);
			
		}
		
		com.apple.eawt.Application app = com.apple.eawt.Application.getApplication();
		URL dockIconURL = Main.class.getResource("/images/launcher/appicon.png");
		Image icon = Toolkit.getDefaultToolkit().createImage(dockIconURL);
		app.setDockIconImage(icon);
	}
	
	private static void windowsOptions() {
		
	}
	
	private static void linuxOptions() {
		
	}
}
