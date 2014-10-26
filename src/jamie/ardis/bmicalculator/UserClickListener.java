package jamie.ardis.bmicalculator;

import jamie.ardis.utils.SettingsAdaptor;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class UserClickListener implements OnItemClickListener {

	SettingsAdaptor settings;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Context context = view.getContext();
        settings = new SettingsAdaptor(context);

        TextView tv = ((TextView) view.findViewById(R.id.userName));
        String text = tv.getText().toString();

        //TODO save settings and pass info back to main
        Toast.makeText(context, "Current User: " + text, Toast.LENGTH_SHORT).show();

    }

}
