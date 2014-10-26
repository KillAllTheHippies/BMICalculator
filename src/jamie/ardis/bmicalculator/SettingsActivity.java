package jamie.ardis.bmicalculator;

import jamie.ardis.utils.Measurement;
import jamie.ardis.utils.SettingsAdaptor;
import jamie.ardis.utils.User;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SettingsActivity extends ActionBarActivity {

	SettingsAdaptor settings;//for persisted values (stored)
	User user;
	ListView list;
	TextView weight, height;
	Measurement measurement;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		settings = new SettingsAdaptor(getApplicationContext());
		user = new User("Donnie Default");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
