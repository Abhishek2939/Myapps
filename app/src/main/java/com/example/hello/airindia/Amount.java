package com.example.hello.airindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Amount extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3;
    TextView textView1,textView11,textView12, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10,mtv;
    String amountstring;
    RadioGroup radioGroup;
    int no, ano, cno, i, sum1,sum2, Total=0,pos;
    int amountint;
    int j;
    Button button;
    RadioButton radioButton, radioButton3;
    public static final String TAG = "AMOUNT";
    private DatabaseHandler myDb;
    ArrayList<Contact> allEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        editText1 = (EditText) findViewById(R.id.EditText1);
        editText2 = (EditText) findViewById(R.id.EditText2);
        editText3 = (EditText) findViewById(R.id.EditText3);
        textView1 = (TextView) findViewById(R.id.TextView1);
        textView2 = (TextView) findViewById(R.id.TextView2);
        textView3 = (TextView) findViewById(R.id.TextView3);
        textView4 = (TextView) findViewById(R.id.TextView4);
        textView5 = (TextView) findViewById(R.id.TextView5);
        textView6 = (TextView) findViewById(R.id.TextView6);
        textView7 = (TextView) findViewById(R.id.TextView7);
        textView8 = (TextView) findViewById(R.id.TextView8);
        textView9 = (TextView) findViewById(R.id.TextView9);
        textView10 = (TextView) findViewById(R.id.TextView10);
        textView11 = (TextView) findViewById(R.id.TextView11);
        textView12 = (TextView) findViewById(R.id.TextView12);
        mtv=(TextView)findViewById(R.id.MTV2);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup100);
        radioButton = (RadioButton) findViewById(R.id.radiobutton);
        radioButton3 = (RadioButton) findViewById(R.id.radiobutton3);
        button = (Button) findViewById(R.id.button100);


        textView2.setText(getIntent().getStringExtra("fno"));
        textView6.setText(getIntent().getStringExtra("depar"));
        textView8.setText(getIntent().getStringExtra("desti"));
        textView10.setText(getIntent().getStringExtra("depdate"));
        textView12.setText(getIntent().getStringExtra("tno"));


        amountint = Integer.parseInt(getIntent().getStringExtra("amount"));
        ano = Integer.parseInt(getIntent().getStringExtra("ano"));
        cno = Integer.parseInt(getIntent().getStringExtra("cno"));
        i = ano ;
        j=cno;

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                pos = radioGroup.indexOfChild(findViewById(checkedId));

                switch (pos) {
                    case 0:
                        sum1=0;sum2=0;
                        radioButton.setChecked(true);
                        amountstring = String.valueOf((amountint ));
                        textView4.setText(amountstring);
                        sum1 =  (amountint );
                        break;
                    case 1:sum1=0;sum2=0;
                        amountstring = String.valueOf((amountint/2));
                        textView4.setText(amountstring);
                        sum2 =  (amountint/2);
                        break;
                }
            }
        });


        button.setOnClickListener(this);
        myDb = new DatabaseHandler(this);
        allEmployees = myDb.getAllContact(null,null,null);

        /**
         * CRUD Operations
         *
         * */
    }
    void printTable(ArrayList<Contact> allEmployees) {

        // Empty text in the TextView to show new values
        mtv.setText("");

        StringBuffer stringBuffer = new StringBuffer();
        // Append table values in a String buffer
        for (Contact emp : allEmployees) {
            stringBuffer.append("[ " + emp.id + " ] [ " + emp.name + " ] [ " + emp.phone_number + " ] [ " + emp.email + " ][ " + emp.amount + " ][ " + emp.Date + " ] [ " + emp.deploc + " ] [ " + emp.destloc + " ] [ " + emp.Fno + " ] [ " + emp.tno + " ] ");
        }

        // Show the table values
        mtv.setText(stringBuffer);
    }



    @Override
    public void onClick(View v) {


        if (v == button) {

                String name = editText1.getText().toString().trim();
                String phonenumber = editText3.getText().toString().trim();
                String email = editText2.getText().toString().trim();
                String amount = textView4.getText().toString().trim();
                String date = textView10.getText().toString().trim();
                String deploc = textView6.getText().toString().trim();
                String destloc = textView8.getText().toString().trim();
                String fno = textView2.getText().toString().trim();
                String tno = editText1.getText().toString().trim();
            if(i>0||j>0) {
                if (name.length() > 0 && phonenumber.length() > 0 && email.length() > 0 && amount.length() > 0
                        && date.length() > 0 && deploc.length() > 0 && destloc.length()
                        > 0 && fno.length() > 0 && tno.length() > 0) {
                    myDb.insert(name, phonenumber, email, amount, date, deploc, destloc, fno, tno);
                    allEmployees = myDb.getAllContact(null, null, null);
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    if (pos == 0 && i > 0 && j >= 0) {
                        i--;
                        Total = Total + sum1 + sum2;
                        showToastMessage("SUCCESS! ");
                        showToastMessage("TOTAL AMOUNT = Rs" + Total);
                    }
                    else{
                    if (pos == 1 && j > 0 && i >= 0) {
                        j--;
                        Total = Total + sum1 + sum2;
                        showToastMessage("SUCCESS! ");
                        showToastMessage("TOTAL AMOUNT = Rs" + Total);
                    } else
                        showToastMessage(" NO. OF ADULTS = "+ano+" NO. OF CHILDREN = "+cno);
                }}
                else
                    showToastMessage("ENTER THE DATA CORRECTLY  ");
            }

                if (i == 0 && j == 0) {
                    Intent intent = new Intent(Amount.this, PaymentPORTAL.class);
                    intent.putExtra("ano", getIntent().getStringExtra("ano"));
                    intent.putExtra("cno", getIntent().getStringExtra("cno"));
                    intent.putExtra("total", String.valueOf(Total));
                    intent.putExtra("sum1", String.valueOf(amountint * ano));
                    intent.putExtra("sum2", String.valueOf((amountint / 2) * cno));
                    startActivity(intent);

            }
        }

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
