package com.example.hello.airindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Finalpayment4 extends AppCompatActivity {
    TextView textView106,textView107,textView108,textView109,textView110,textView111,textView112,textView113,textView114,textView115,textView116,textView117;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpayment4);
        textView106=(TextView)findViewById(R.id.textView106);
        textView107=(TextView)findViewById(R.id.textView107);
        textView108=(TextView)findViewById(R.id.textView108);
        textView109=(TextView)findViewById(R.id.textView109);
        textView110=(TextView)findViewById(R.id.textView110);
        textView111=(TextView)findViewById(R.id.textView111);
        textView112=(TextView)findViewById(R.id.textView112);
        textView113=(TextView)findViewById(R.id.textView113);
        textView114=(TextView)findViewById(R.id.textView114);
        textView115=(TextView)findViewById(R.id.textView115);
        textView116=(TextView)findViewById(R.id.textView116);
        textView117=(TextView)findViewById(R.id.textView117);
        button=(Button)findViewById(R.id.button200);

        textView107.setText(getIntent().getStringExtra("ano"));
        textView109.setText(getIntent().getStringExtra("sum1"));
        textView111.setText(getIntent().getStringExtra("cno"));
        textView113.setText(getIntent().getStringExtra("sum2"));
        textView115.setText(getIntent().getStringExtra("total"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"SUCCESS",Toast.LENGTH_SHORT);
                textView116.setVisibility(View.VISIBLE);
                Intent intent=new Intent(Finalpayment4.this,UserAccount.class);
                startActivity(intent);
            }
        });
    }
}
