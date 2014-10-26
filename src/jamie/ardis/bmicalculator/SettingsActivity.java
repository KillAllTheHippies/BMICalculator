package jamie.ardis.bmicalculator;

import jamie.ardis.utils.SettingsAdaptor;
import jamie.ardis.utils.User;
import jamie.ardis.utils.UserList;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SettingsActivity extends ActionBarActivity {

	SettingsAdaptor settings;// for persisted values (stored)
	User user;
	ListView list;
	ArrayList<User> users;

	ArrayAdapter<User> adapter;
	android.widget.AdapterView.OnItemClickListener listener;
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		UserList list = new UserList();
		users = list.getUsers();
	
		//UsersAdapter extends ArrayAdapter<User>
		//an ArrayAdapter connects an ArrayList to a ListView
		UsersAdapter  adapter = new UsersAdapter(this, users);
		ListView listView = (ListView) findViewById(R.id.lvUsers);
		//connect the adapter to the view
		listView.setAdapter(adapter);

		//add a click listener
		listener=new UserClickListener(this);
		listView.setOnItemClickListener(listener);
		
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
