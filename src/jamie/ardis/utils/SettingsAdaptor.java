package jamie.ardis.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsAdaptor {

	private static final String PREFS_NAME = "bmiprefs";
	private SharedPreferences prefs;
	private Context context;//SharedPreferences need a Context
	SharedPreferences.Editor editor;
	
	public SettingsAdaptor(Context context) {
		super();
		this.context = context;
		prefs = context.getSharedPreferences(PREFS_NAME, 0);
		editor = prefs.edit();
	}
	
	String user;
	public String getUser() {
		return prefs.getString("user", "Genghis Khan");
	}
	public void setUser(String value) {
		editor.putString("user", value).commit();
	}
	
	String measurement;
	public String getMeasurement() {
		return prefs.getString("measurement", "Default");
	}
	public void setMeasurement(String value) {
		editor.putString("measurement", value).commit();
	}
	
	
	
}
