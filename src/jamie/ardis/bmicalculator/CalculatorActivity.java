package jamie.ardis.bmicalculator;

import jamie.ardis.utils.Bmi;
import jamie.ardis.utils.Measure;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class CalculatorActivity extends ActionBarActivity {
	
	EditText weight;
	EditText height;
	TextView result;
	private Measure system = Measure.Metric;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		
		weight = (EditText)findViewById(R.id.edWeight);
		height = (EditText) findViewById(R.id.edHeight);
		result = (TextView) findViewById(R.id.tvResult);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
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
		double r = bmi.getBmi(system);
		result.setText(Double.toString(r));
	}
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.rbMetric:
	            if (checked)
	                system = Measure.Metric;
	            break;
	        case R.id.rbImperial:
	            if (checked)
	            	system = Measure.Imperial;
	            break;
	    }
	}
}
