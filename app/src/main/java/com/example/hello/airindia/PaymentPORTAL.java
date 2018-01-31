package com.example.hello.airindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PaymentPORTAL extends AppCompatActivity {

    TextView textView101,textView102,textView103,textView104,textView105;
    EditText editText101,editText102,editText103,editText104,editText105;
    Button button;
    RadioGroup radioGroup;
    RadioButton radioButton5,radioButton6,radioButton7;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_portal);

        textView101=(TextView)findViewById(R.id.textView101);
        textView102=(TextView)findViewById(R.id.textView102);
        textView103=(TextView)findViewById(R.id.textView103);
        textView104=(TextView)findViewById(R.id.textView104);
        textView105=(TextView)findViewById(R.id.textView105);

        editText101=(EditText)findViewById(R.id.EditText101);
        editText102=(EditText)findViewById(R.id.EditText102);
        editText103=(EditText)findViewById(R.id.EditText103);
        editText104=(EditText)findViewById(R.id.EditText104);
        editText105=(EditText)findViewById(R.id.EditText105);

        radioGroup=(RadioGroup)findViewById(R.id.Radio);
        radioButton5=(RadioButton)findViewById(R.id.radioButton5);
        radioButton6=(RadioButton)findViewById(R.id.radioButton6);
        radioButton7=(RadioButton)findViewById(R.id.radioButton7);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                pos = radioGroup.indexOfChild(findViewById(checkedId));

                switch (pos) {
                    case 0:
                        radioButton5.setChecked(true);
                        textView101.setVisibility(View.VISIBLE);
                        textView102.setVisibility(View.VISIBLE);
                        textView104.setVisibility(View.VISIBLE);
                        textView105.setVisibility(View.VISIBLE);
                        editText101.setVisibility(View.VISIBLE);
                        editText102.setVisibility(View.VISIBLE);
                        editText104.setVisibility(View.VISIBLE);
                        editText105.setVisibility(View.VISIBLE);
                        textView103.setVisibility(View.INVISIBLE);
                        editText103.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        radioButton6.setChecked(true);
                        textView101.setVisibility(View.VISIBLE);
                        textView102.setVisibility(View.VISIBLE);
                        textView103.setVisibility(View.VISIBLE);
                        textView104.setVisibility(View.VISIBLE);
                        textView105.setVisibility(View.VISIBLE);
                        editText101.setVisibility(View.VISIBLE);
                        editText102.setVisibility(View.VISIBLE);
                        editText103.setVisibility(View.VISIBLE);
                        editText104.setVisibility(View.VISIBLE);
                        editText105.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                    textView101.setVisibility(View.INVISIBLE);
                    textView102.setVisibility(View.INVISIBLE);
                    textView104.setVisibility(View.INVISIBLE);
                    textView105.setVisibility(View.INVISIBLE);
                    editText101.setVisibility(View.INVISIBLE);
                    editText102.setVisibility(View.INVISIBLE);
                    editText104.setVisibility(View.INVISIBLE);
                    editText105.setVisibility(View.INVISIBLE);
                    textView103.setVisibility(View.INVISIBLE);
                    editText103.setVisibility(View.INVISIBLE);
                    break;

                }
                }
            });



            button=(Button)findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PaymentPORTAL.this,Finalpayment4.class);
                intent.putExtra("ano",getIntent().getStringExtra("ano"));
                intent.putExtra("cno",getIntent().getStringExtra("cno"));
                intent.putExtra("sum1",getIntent().getStringExtra("sum1"));
                intent.putExtra("sum2",getIntent().getStringExtra("sum2"));
                intent.putExtra("total",getIntent().getStringExtra("total"));
                startActivity(intent);
            }
        });
    }
}
