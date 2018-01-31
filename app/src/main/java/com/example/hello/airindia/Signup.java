package com.example.hello.airindia;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    EditText editText3, editText4, editText5, editText7, editText8, editText9, editText10, editText11;
    Button button3,button4;
    TextView mTv;
    private DBHelper myDb;
    ArrayList<users> allEmployees;

//    AccountRegister air;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
//        air = new AccountRegister(this);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        mTv=(TextView)findViewById(R.id.mTV);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        editText11 = (EditText) findViewById(R.id.editText11);
        myDb = new DBHelper(this);

        allEmployees = myDb.getAllusers(null,null);
        printTable(allEmployees);

        button4 = (Button) findViewById(R.id.button4);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }
    void printTable(ArrayList<users> allEmployees) {

        // Empty text in the TextView to show new values
        mTv.setText("");

        StringBuffer stringBuffer = new StringBuffer();
        // Append table values in a String buffer
        for (users emp : allEmployees) {
            stringBuffer.append("[ " + emp.id + " ] [ " + emp.email + " ] [ " + emp.password + " ] [ " + emp.contact + " ] [ " + emp.country + " ]\n");
        }

        // Show the table values
        mTv.setText(stringBuffer);
    }


    @Override
    public void onClick(View v) {

        if (v == button3) {
            String email = editText4.getText().toString().trim();
            String password = editText5.getText().toString().trim();
            String contact = editText9.getText().toString().trim();
            String country = editText11.getText().toString().trim();

            if (email.length() > 0 && password.length() > 0 && contact.length() > 0 && country.length() > 0) {
                myDb.insert(email,password,contact,country);
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
                editText7.setText("");
                editText8.setText("");
                editText9.setText("");
                editText10.setText("");
                editText11.setText("");
                allEmployees = myDb.getAllusers(null,null);
                Intent intent=new Intent(Signup.this,AIR1.class);
                startActivity(intent);
            } else {
                showToastMessage("Enter the data correctly");
            }
        }

//        if (v == button4) {
//            allEmployees = myDb.getAllusers(null);
//        }

        hideKeyBoard();
        printTable(allEmployees);


    }
    void hideKeyBoard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}


