package jamie.ardis.bmicalculator;

import jamie.ardis.utils.SettingsAdaptor;
import jamie.ardis.utils.User;
import jamie.ardis.utils.UserList;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class UserClickListener implements OnItemClickListener {

	SettingsAdaptor settings;
	UserList users=new UserList();
	
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Context context = view.getContext();

        TextView tv = ((TextView) view.findViewById(R.id.userName));
        String name = tv.getText().toString();
        User user = users.getUser(name);
        // save the selection
        settings = new SettingsAdaptor(context);
        settings.setUser(user.getName());

        //TODO return to Main
        String s = String.format("User %s,  Measure %s", user.getName(), user.getMeasurement());
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();

    }

}
