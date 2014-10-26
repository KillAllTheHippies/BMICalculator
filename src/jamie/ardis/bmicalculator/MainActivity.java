package jamie.ardis.bmicalculator;

import jamie.ardis.utils.SettingsAdaptor;
import jamie.ardis.utils.User;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
	
	SettingsAdaptor settings;//for persisted values (stored)
	User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // calls onCreate on ActionBarActivity
        setContentView(R.layout.activity_main);
        
        settings = new SettingsAdaptor(getApplicationContext());
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
    	this.startActivity(myIntent);
    }
}
