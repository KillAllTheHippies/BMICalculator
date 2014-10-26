package jamie.ardis.bmicalculator;

import jamie.ardis.utils.User;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



/*
 * https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
 */

public class UsersAdapter extends ArrayAdapter<User> {
    public UsersAdapter(Context context, ArrayList<User> users) {
       super(context, 0, users);
    }

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item for this position
       User user = getItem(position);    

       // Check if an existing view is being reused, otherwise inflate the view
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate( R.layout.item_user, parent, false);
          
       }

       TextView tvName = (TextView) convertView.findViewById(R.id.userName);
       TextView tvMeasure = (TextView) convertView.findViewById(R.id.userMeasure);

       // Populate the data into the template view using the data object
       tvName.setText(user.getName());
       tvMeasure.setText(user.getMeasurement().toString());
       

       // Return the completed view to render on screen
       return convertView;
   }
}

