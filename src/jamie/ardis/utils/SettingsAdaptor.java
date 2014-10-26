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
		return prefs.getString("user", "Default");
	}

	public void setUser(String user) {
		editor.putString("user", user);
		editor.commit();
	}
	
	
	
}
