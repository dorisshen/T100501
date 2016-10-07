package tw.com.pcschool.t100501;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import tw.com.pcschool.t100501.data.Person;
import tw.com.pcschool.t100501.data.PersonDAO;
import tw.com.pcschool.t100501.data.PersonDAOFileImpl;

public class DetailActivity extends AppCompatActivity {
    EditText edName, edTel, edAddr;
    int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent it = getIntent();
        ID = it.getIntExtra("ID", 0);
        PersonDAO impl = new PersonDAOFileImpl(DetailActivity.this);
        Person p = impl.getPerson(ID);
        Log.d("DATA", p.ID + p.Name);
        edName = (EditText) findViewById(R.id.edName);
        edTel = (EditText) findViewById(R.id.edTel);
        edAddr = (EditText) findViewById(R.id.edAddr);

        edName.setText(p.Name);
        edTel.setText(p.Tel);
        edAddr.setText(p.Addr);
    }

}
