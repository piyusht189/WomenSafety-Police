package monika.almanac.womensafety_police;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public Firebase myFirebaseRef;
    int number;
    String[] name;
    String[] msg;
    String[] phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listMain);

        Firebase.setAndroidContext(MainActivity.this);
        myFirebaseRef = new Firebase("https://womensafety.firebaseio.com/ins");
        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                number=Integer.parseInt(dataSnapshot.child("number").getValue().toString());
                name=new String[number];
                msg=new String[number];
                phone= new String[number];
                for(int i=0;i<number;i++)
                {
                    name[i]=dataSnapshot.child(String.valueOf(i)).child("name").getValue().toString();
                    msg[i]=dataSnapshot.child(String.valueOf(i)).child("msg").getValue().toString();
                    phone[i]=dataSnapshot.child(String.valueOf(i)).child("phone").getValue().toString();
                }
                ArrangedListAdapter adapter = new ArrangedListAdapter(MainActivity.this,name,msg,phone);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
