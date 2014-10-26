package jamie.ardis.bmicalculator;

import jamie.ardis.utils.SettingsAdaptor;
import jamie.ardis.utils.User;
import jamie.ardis.utils.UserList;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	SettingsAdaptor settings;//for persisted values (stored)
	User user;
	TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // calls onCreate on ActionBarActivity
        setContentView(R.layout.activity_main);
        
        settings = new SettingsAdaptor(getApplicationContext());
        tvUser = (TextView) findViewById(R.id.tvUser);
        //Retrieve the saved user, and display
        String name = settings.getUserName();
        displayUser(name);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    public void launchCalculator(View v)
    {
    	Intent myIntent = new Intent(this, CalculatorActivity.class);
    	this.startActivity(myIntent);
    }
    public void launchSettings(View v)
    {
    	Intent myIntent = new Intent(this, SettingsActivity.class);
    	//calls onActivityResult when SettingsActivity closes
    	this.startActivityForResult(myIntent, 1);
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    	
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String name =data.getStringExtra("name");
                displayUser(name);
                		
            }
            if (resultCode == RESULT_CANCELED) {
                //TODO, not important
            }
        }
    }//onActivityResult


	private void displayUser(String name) {
		UserList list = new UserList();
		user = list.getUser(name);
		String text = String.format("Name: %s\nMeasurement System: %s", user.getName(), user.getMeasurement());
		tvUser.setText(text);
	}
}
