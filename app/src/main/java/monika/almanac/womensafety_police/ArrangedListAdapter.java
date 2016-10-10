package monika.almanac.womensafety_police;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Super-Nova on 01-04-2016.
 */
public class ArrangedListAdapter extends ArrayAdapter<String> {
    private final Activity context;

    String[] name1;
    String[] msg1;
    String[] phone1;
    TextView nm,ph,mg;

    public ArrangedListAdapter(Activity context,String[] name,String[] msg,String[] phone) {
        super(context, R.layout.row,name);
        this.context = context;
        this.name1 = name;
        this.msg1 = msg;
        this.phone1 = phone;
        Toast.makeText(getContext(), "Loading Helps..Wait...", Toast.LENGTH_LONG).show();
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row, null, true);

        nm=(TextView)rowView.findViewById(R.id.name);
        mg=(TextView)rowView.findViewById(R.id.msg);
        ph=(TextView)rowView.findViewById(R.id.phone);

        nm.setText(name1[position]);
        mg.setText(msg1[position]);
        ph.setText(phone1[position]);
        return rowView;
    }
}

