package jamie.ardis.bmicalculator;

import jamie.ardis.utils.SettingsAdaptor;
import jamie.ardis.utils.User;
import jamie.ardis.utils.UserList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class UserClickListener implements OnItemClickListener {

	SettingsAdaptor settings;
	UserList users=new UserList();
	Activity owner;
	
	
    public UserClickListener(Activity owner) {
		this.owner = owner;
	}

	@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Context context = view.getContext();

        TextView tv = ((TextView) view.findViewById(R.id.userName));
        String name = tv.getText().toString();
        User user = users.getUser(name);
        // save the selection
        settings = new SettingsAdaptor(context);
        settings.setUser(user.getName());

        String s = String.format("User %s,  Measure %s", user.getName(), user.getMeasurement());
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        //Tell the Activity that owns this Listener to finish
        //i.e. close the SettingsActivity, and return to MainActivity
        
        Intent returnIntent = new Intent();
        returnIntent.putExtra("name", user.getName());
        owner.setResult(Activity.RESULT_OK, returnIntent);

        owner.finish();

    }

}
