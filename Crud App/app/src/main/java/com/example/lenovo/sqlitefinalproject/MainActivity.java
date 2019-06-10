package com.example.lenovo.sqlitefinalproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Databasehelper databasehelper;
    private EditText E1,E2;
    Button button,button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creatobj();

        databasehelper=new Databasehelper(this);
         SQLiteDatabase db=databasehelper.getWritableDatabase();
         button.setOnClickListener(this);
         button1.setOnClickListener(this);
         button2.setOnClickListener(this);
         button3.setOnClickListener(this);

    }
    public void creatobj()
    {
        E1=(EditText)findViewById(R.id.edittext1);
        E2=(EditText)findViewById(R.id.edittext2);
        button=(Button)findViewById(R.id.button);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);

    }

    @Override
    public void onClick(View v) {
        String id=E1.getText().toString();
        String name=E2.getText().toString();

        if(v.getId()==R.id.button)
        {
          long rowid= databasehelper.savedata(id,name);
          if(rowid>0)
          {
              Toast.makeText(getApplicationContext(),"Saved Sucessfully",Toast.LENGTH_LONG).show();
          }

        }
        else if(v.getId()==R.id.button1)
        {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);

        }
        else if(v.getId()==R.id.button2)
        {
            boolean result=databasehelper.updatedata(id,name);
            if(result==true)
            {
                Toast.makeText(getApplicationContext(),"Updated Sucessfully",Toast.LENGTH_LONG).show();
            }

        }
        else if(v.getId()==R.id.button3)
        {
            int value=databasehelper.deletedata(id);
            if(value>0)
            {
                Toast.makeText(getApplicationContext(),"Data Deleted",Toast.LENGTH_LONG).show();
            }


        }

    }
}
