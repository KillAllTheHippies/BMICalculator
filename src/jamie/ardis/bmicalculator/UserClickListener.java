package jamie.ardis.bmicalculator;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class UserClickListener implements OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Context context = view.getContext();

        TextView textViewItem = ((TextView) view.findViewById(R.id.userName));
        String listItemText = textViewItem.getText().toString();

        Toast.makeText(context, "Item: " + listItemText, Toast.LENGTH_SHORT).show();

    }

}
