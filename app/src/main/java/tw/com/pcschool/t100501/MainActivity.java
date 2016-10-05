package tw.com.pcschool.t100501;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import tw.com.pcschool.t100501.data.Person;
import tw.com.pcschool.t100501.data.PersonDAO;
import tw.com.pcschool.t100501.data.PersonDAOFileImpl;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        PersonDAO impl = new PersonDAOFileImpl(MainActivity.this);
        ArrayList<Person> mylist = (ArrayList) impl.getList();
        String[] names = new String[mylist.size()];
        for (int i=0;i<mylist.size();i++)
        {
            names[i] = mylist.get(i).Name;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                                        android.R.layout.simple_list_item_1,
                                        names);
        lv.setAdapter(adapter);

    }
}
