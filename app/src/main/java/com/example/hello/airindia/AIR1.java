package com.example.hello.airindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class AIR1 extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    ImageView img;
    Button button1,button2;
    EditText editText,editText2,editText3;
    String name,emailid,passwordd;
    private DBHelper myDb;
    ArrayList<users> allEmployees;
    public static final String TAG = "AIR1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air1);
        textView=(TextView)findViewById(R.id.textView4);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        editText=(EditText)findViewById(R.id.editText13);
        editText3=(EditText)findViewById(R.id.editText3);
        editText2=(EditText)findViewById(R.id.editText2);
        img=(ImageView)findViewById(R.id.imageView);
//        allEmployees = myDb.getAllusers(null);




        button1.setOnClickListener(this);
//                String searchemail = editText3.getText().toString().trim();
//                     editText2.setText("");
//                allEmployees = myDb.getAllusers(searchemail);
//                Log.i(TAG, "Searched Size : " + allEmployees.size());
//                if (allEmployees.size() == 0) {
//                    Toast.makeText(getApplicationContext(), "INVALID INPUT", Toast.LENGTH_SHORT).show();
//                }
//                else {
//
        button2.setOnClickListener(this);
//                Intent intent=new Intent(AIR1.this,Signup.class);
//                startActivity(intent);
//
//            }
//        });
        myDb = new DBHelper(this);

        allEmployees = myDb.getAllusers(null,null);
         name=editText.getText().toString();
         emailid=editText3.getText().toString();
         passwordd=editText2.getText().toString();

    }


    @Override
    public void onClick(View v) {

        if (v == button1) {
            if(name==null||emailid==null||passwordd==null)
                Toast.makeText(getApplicationContext(),"ENTER THE DATA CORRECTLY",Toast.LENGTH_SHORT);
                else {
                String searchemail = editText3.getText().toString().trim();
                String searchpassword=editText2.getText().toString().trim();
                editText.getText().toString().trim();
                allEmployees = myDb.getAllusers(searchemail,searchpassword);
             //   Log.i(TAG, "Searched Size : " + allEmployees.size());
                if (allEmployees.size() == 0) {
                    showToastMessage("INVALID EMAIL OR PASSWORD");
                } else {
                    Intent intent = new Intent(AIR1.this, UserAccount.class);
                    intent.putExtra("name",name );
                    intent.putExtra("email",emailid);
                    startActivity(intent);

                }
            }
    }
        if (v == button2){

            Intent intent=new Intent(AIR1.this,Signup.class);
            startActivity(intent);

        }

        hideKeyBoard();
//        printTable(allEmployees);

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

//    void printTable(ArrayList<users> allEmployees) {
//
//        // Empty text in the TextView to show new values
//        editText.setText("");
//
//        StringBuffer stringBuffer = new StringBuffer();
//        // Append table values in a String buffer
//        for (users emp : allEmployees) {
//            stringBuffer.append("[ " + emp.id + " ] [ " + emp.email + " ] [ " + emp.password + " ] [ " + emp.contact + " ] [ " + emp.country + " ]\n");
//        }
//
//        // Show the table values
//        editText.setText(stringBuffer);

    }