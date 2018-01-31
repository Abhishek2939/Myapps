package com.example.hello.airindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Confirmcancel extends AppCompatActivity {
    TextView textView14,textView15,textView16,textView17,textView18,textView19,textView20,textView21,textView22,textView23,textView24,textView25;
    String del;

    Button button5;
    private DatabaseHandler myDb;
    ArrayList<Contact> allEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmcancel);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 = (TextView) findViewById(R.id.textView15);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView17 = (TextView) findViewById(R.id.textView17);
        textView18 = (TextView) findViewById(R.id.textView18);
        textView19 = (TextView) findViewById(R.id.textView19);
        textView20 = (TextView) findViewById(R.id.textView20);
        textView21 = (TextView) findViewById(R.id.textView21);
        textView22 = (TextView) findViewById(R.id.textView22);
        textView23 = (TextView) findViewById(R.id.textView23);
        textView24 = (TextView) findViewById(R.id.textView24);
        textView25 = (TextView) findViewById(R.id.textView25);
        button5 = (Button) findViewById(R.id.button5);
        myDb = new DatabaseHandler(this);

        allEmployees = myDb.getAllContact(null,null,null);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del=getIntent().getStringExtra("delete");
//                int idToDelete = myDb.getFirstId();
                if (del!=null) {
                    myDb.deleteRow(del);
//                    allEmployees = myDb.getAllContact(null,null,null);
                }
                Toast.makeText(getApplicationContext(),"Your ticket has been cancelled and a message has been sent to your email", Toast.LENGTH_LONG);
                Intent intent4=new Intent(Confirmcancel.this,UserAccount.class);
                startActivity(intent4);
            }


        });
    }
}
