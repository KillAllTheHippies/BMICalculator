package jamie.ardis.utils;

import android.content.Context;
import android.content.SharedPreferences;

/*
 * SettingsAdaptor persists user data..
 */
public class SettingsAdaptor {

	private static final String PREFS_NAME = "bmiprefs";
	private SharedPreferences prefs;
	SharedPreferences.Editor editor;

	public SettingsAdaptor(Context context) {
		super();
		prefs = context.getSharedPreferences(PREFS_NAME, 0);
		editor = prefs.edit();
	}

	String user;

	public String getUserName() {
		return prefs.getString("user", "Genghis Khan"); // default to Genghis Khan
	}

	public void setUser(String value) {
		editor.putString("user", value).commit(); // saves userName
	}

	String measurement;

	public String getMeasurement() {
		return prefs.getString("measurement", "Default");
	}

	public void setMeasurement(String value) {
		editor.putString("measurement", value).commit(); // saves measurement preference
	}

}
