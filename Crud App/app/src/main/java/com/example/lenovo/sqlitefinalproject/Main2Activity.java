package com.example.lenovo.sqlitefinalproject;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
 ListView listView1;
 private Databasehelper databasehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView1=(ListView)findViewById(R.id.listview);
        databasehelper=new Databasehelper(this);
        loaddata();


    }
    public void loaddata()
    {
        ArrayList<String>listdata=new ArrayList<String>();
        Cursor cursor=databasehelper.showdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(getApplicationContext(),"NO DATA Is AVAILABLE",Toast.LENGTH_LONG).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                listdata.add(cursor.getString(0)+"\t"+cursor.getString(1));
            }
        }

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.textview,listdata);
        listView1.setAdapter(adapter);
        //listView.setOnItemClickListener(onItemClick);


    }

}
