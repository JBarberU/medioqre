package launcher;

import java.util.prefs.*;


public class PreferenceLoader
{
	private static PreferenceLoader instance;
	private Preferences prefs;
	
	private PreferenceLoader(){
		try {
	        prefs = Preferences.userNodeForPackage(PreferenceLoader.class);
	    }
	    catch (SecurityException disabled) {
	
	    }
	    System.out.println(prefs.getFloat("BGM_VOLUME", 0.8f));
	};
	
	public static PreferenceLoader getInstance(){
		if(instance == null)
			instance = new PreferenceLoader();
		
		return instance;
	}
	
	public float getFloat(String key, float def){
		return prefs.getFloat(key, def);
	}
	
	public void putFloat(String key, float value){
		prefs.putFloat(key, value);
	}
	
	
}
