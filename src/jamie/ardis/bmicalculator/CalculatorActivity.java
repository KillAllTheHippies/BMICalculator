package jamie.ardis.bmicalculator;

import java.text.DecimalFormat;

import jamie.ardis.utils.Bmi;
import jamie.ardis.utils.Measurement;
import jamie.ardis.utils.User;
import jamie.ardis.utils.UserList;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class CalculatorActivity extends ActionBarActivity {
	
	EditText weight;
	EditText height;
	TextView result;
	UserList userList;
	User user;
	Dial dial;
	private Measurement measurement = Measurement.Metric;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		
		userList = new UserList();
		//Get the parameters that were passed from main
		//ie, username
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    String name = extras.getString("name");
		    displayUser(name);
		    
		}
		
		updateLabels();
		
		weight = (EditText)findViewById(R.id.edWeight);
		height = (EditText) findViewById(R.id.edHeight);
		result = (TextView) findViewById(R.id.tvResult);
		
		dial = new Dial(this);
		FrameLayout ivDial = (FrameLayout) findViewById(R.id.ivDial);
		ivDial.addView(dial);
        
	}

	private void updateLabels() {
		TextView tv;
		if(measurement== Measurement.Metric){
			tv =  (TextView)findViewById(R.id.tvWeight);
			tv.setText(String.format(getString(R.string.weight), "Kgs"));
			tv =  (TextView)findViewById(R.id.tvHeight);
			tv.setText(String.format(getString(R.string.height), "cms"));
		}
		else{
			tv =  (TextView)findViewById(R.id.tvWeight);
			tv.setText(String.format(getString(R.string.weight), "Lbs"));
			tv =  (TextView)findViewById(R.id.tvHeight);
			tv.setText(String.format(getString(R.string.height), "Inches"));
		}
	}
	
	private void displayUser(String name) {
		UserList list = new UserList();
		user = list.getUser(name);
		String text = String.format("Name: %s\nMeasurement System: %s", user.getName(), user.getMeasurement());
		TextView tvUser = (TextView) findViewById(R.id.tvUser_Calc);
		tvUser.setText(text);
	}
	
	private void displayUser() {

		String text = String.format("Name: %s\nMeasurement System: %s", user.getName(), user.getMeasurement());
		TextView tvUser = (TextView) findViewById(R.id.tvUser_Calc);
		tvUser.setText(text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {  // boilerplate
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
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
	public void calculate(View v)
	{
		double w = Double.parseDouble(weight.getText().toString());
		double h = Double.parseDouble(height.getText().toString());
		Bmi bmi = new Bmi(w,h);
		double r = bmi.getBmi(measurement);
		DecimalFormat df = new DecimalFormat("0.0");
		String b = df.format(r);
		String s = String.format("BMI: %s \nSeverity: %s", b, bmi.getSeverity(measurement));
		result.setText(s);
	}
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.rbMetric:
	            if (checked)
	                measurement = Measurement.Metric;
	            break;
	        case R.id.rbImperial:
	            if (checked)
	            	measurement = Measurement.Imperial;
	            break;
	    }
	    user.setMeasurement(measurement);//todo, persist the value, see UserList
	    displayUser();
	    updateLabels();
		
	}
}
