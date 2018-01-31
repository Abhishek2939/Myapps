package com.example.hello.airindia;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.hello.airindia.constants.FIFTH_COLUMN;
import static com.example.hello.airindia.constants.FIRST_COLUMN;
import static com.example.hello.airindia.constants.FOURTH_COLUMN;
import static com.example.hello.airindia.constants.SECOND_COLUMN;
import static com.example.hello.airindia.constants.THIRD_COLUMN;

public class Booking2 extends Activity {

    TextView textview31;
    String depar,desti,f1,f2,f3,fno,tno,f4,f5,f6,t1,t2,t3,t4,t5,t6,ano,cno,clas,depdate,desdate;

    int i; String amt;

    private ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking2);
        textview31=(TextView)findViewById(R.id.textView31);

        ano=getIntent().getStringExtra("adults");
        cno=getIntent().getStringExtra("children");
        clas=getIntent().getStringExtra("class");
        depdate=getIntent().getStringExtra("depdate");
        desdate=getIntent().getStringExtra("desdate");

        ListView listView=(ListView)findViewById(R.id.listView1);
        f1="AI101"; t1="9:00";

        list=new ArrayList<HashMap<String,String>>();

        switch (getIntent().getStringExtra("departure")){

            case "New Delhi" :{
                switch (getIntent().getStringExtra("destination")){

                    case "Bombay": {
                        if (clas == "ECONOMY")
                            amt = "12000";
                        else
                            amt = "17000";
                        break;
                    }
                    case "Calcutta":
                    {
                        if (clas == "ECONOMY")
                            amt = "12000";
                        else
                            amt = "17000";
                        break;
                    }
                    case  "chennai":
                    {
                        if (clas == "ECONOMY")
                            amt = "16000";
                        else
                            amt = "23000";
                        break;
                    }
                    case "London":
                    {
                        if (clas == "ECONOMY")
                            amt = "110000";
                        else
                            amt = "130000";
                        break;
                    }case "Canada":
                    {
                        if (clas == "ECONOMY")
                            amt = "150000";
                        else
                            amt = "165000";
                        break;
                    }case "Brazil":{
                        if (clas == "ECONOMY")
                            amt = "140000";
                        else
                            amt = "155000";
                        break;
                    }
                    case "Kathmandu":{
                        if (clas == "ECONOMY")
                            amt = "15000";
                        else
                            amt = "18000";
                        break;
                    }
                    case "Tokyo":{
                        if (clas == "ECONOMY")
                            amt = "125000";
                        else
                            amt = "138000";
                        break;
                    }
                }
                break;
            }

            case "Bombay": {

                switch (getIntent().getStringExtra("destination")) {

                    case "New Delhi": {
                        if (clas == "ECONOMY")
                            amt = "12000";
                        else
                            amt = "17000";
                        break;
                    }
                    case "Calcutta": {
                        if (clas == "ECONOMY")
                            amt = "12000";
                        else
                            amt = "17000";
                        break;
                    }
                    case "chennai": {
                        if (clas == "ECONOMY")
                            amt = "8000";
                        else
                            amt = "12000";
                        break;
                    }
                    case "London": {
                        if (clas == "ECONOMY")
                            amt = "110000";
                        else
                            amt = "130000";
                        break;
                    }
                    case "Canada": {
                        if (clas == "ECONOMY")
                            amt = "150000";
                        else
                            amt = "165000";
                        break;
                    }
                    case "Brazil": {
                        if (clas == "ECONOMY")
                            amt = "140000";
                        else
                            amt = "155000";
                        break;
                    }
                    case "Kathmandu": {
                        if (clas == "ECONOMY")
                            amt = "15000";
                        else
                            amt = "18000";
                        break;
                    }
                    case "Tokyo": {
                        if (clas == "ECONOMY")
                            amt = "125000";
                        else
                            amt = "138000";
                        break;
                    }

                } break;
            }

            case "Calcutta":{
                switch (getIntent().getStringExtra("destination")){

                    case "New Delhi": {
                        if (clas == "ECONOMY")
                            amt = "10000";
                        else
                            amt = "12500";
                        break;
                    }
                    case "Bombay": {
                        if (clas == "ECONOMY")
                            amt = "12000";
                        else
                            amt = "17000";
                        break;
                    }
                    case "chennai": {
                        if (clas == "ECONOMY")
                            amt = "14000";
                        else
                            amt = "16000";
                        break;
                    }
                    case "London": {
                        if (clas == "ECONOMY")
                            amt = "110000";
                        else
                            amt = "130000";
                        break;
                    }
                    case "Canada": {
                        if (clas == "ECONOMY")
                            amt = "150000";
                        else
                            amt = "165000";
                        break;
                    }
                    case "Brazil": {
                        if (clas == "ECONOMY")
                            amt = "140000";
                        else
                            amt = "155000";
                        break;
                    }
                    case "Kathmandu": {
                        if (clas == "ECONOMY")
                            amt = "15000";
                        else
                            amt = "18000";
                        break;
                    }
                    case "Tokyo": {
                        if (clas == "ECONOMY")
                            amt = "125000";
                        else
                            amt = "138000";
                        break;
                    }
                }
            }break;

            case "chennai":{

                switch (getIntent().getStringExtra("destination")){

                    case "New Delhi": {
                        if (clas == "ECONOMY")
                            amt = "12000";
                        else
                            amt = "17000";
                        break;
                    }
                    case "Calcutta": {
                        if (clas == "ECONOMY")
                            amt = "12500";
                        else
                            amt = "15500";
                        break;
                    }
                    case "Bombay": {
                        if (clas == "ECONOMY")
                            amt = "8000";
                        else
                            amt = "12000";
                        break;
                    }
                    case "London": {
                        if (clas == "ECONOMY")
                            amt = "110000";
                        else
                            amt = "130000";
                        break;
                    }
                    case "Canada": {
                        if (clas == "ECONOMY")
                            amt = "150000";
                        else
                            amt = "165000";
                        break;
                    }
                    case "Brazil": {
                        if (clas == "ECONOMY")
                            amt = "140000";
                        else
                            amt = "155000";
                        break;
                    }
                    case "Kathmandu": {
                        if (clas == "ECONOMY")
                            amt = "15000";
                        else
                            amt = "18000";
                        break;
                    }
                    case "Tokyo": {
                        if (clas == "ECONOMY")
                            amt = "125000";
                        else
                            amt = "138000";
                        break;
                    }

                }

            }break;

        }

        final HashMap<String,String> temp=new HashMap<String, String>();
        temp.put(FIRST_COLUMN, f1);
        temp.put(SECOND_COLUMN, getIntent().getStringExtra("departure"));
        temp.put(THIRD_COLUMN, getIntent().getStringExtra("destination"));
        temp.put(FOURTH_COLUMN, t1);
        temp.put(FIFTH_COLUMN, amt);
        list.add(temp);
f2="AI109"; t2="12:00";
        HashMap<String,String> temp2=new HashMap<String, String>();
        temp2.put(FIRST_COLUMN, f2);
        temp2.put(SECOND_COLUMN, getIntent().getStringExtra("departure"));
        temp2.put(THIRD_COLUMN, getIntent().getStringExtra("destination"));
        temp2.put(FOURTH_COLUMN,t2 );
        temp2.put(FIFTH_COLUMN, amt);
        list.add(temp2);
f3="AI104";t3="16:30";
        HashMap<String,String> temp3=new HashMap<String, String>();
        temp3.put(FIRST_COLUMN, f3);
        temp3.put(SECOND_COLUMN, getIntent().getStringExtra("departure"));
        temp3.put(THIRD_COLUMN, getIntent().getStringExtra("destination"));
        temp3.put(FOURTH_COLUMN, t3);
        temp3.put(FIFTH_COLUMN, amt);
        list.add(temp3);
f4="AI129"; t4="19:45";
        HashMap<String,String> temp4=new HashMap<String, String>();
        temp4.put(FIRST_COLUMN,f4 );
        temp4.put(SECOND_COLUMN, getIntent().getStringExtra("departure"));
        temp4.put(THIRD_COLUMN, getIntent().getStringExtra("destination"));
        temp4.put(FOURTH_COLUMN, t4);
        temp4.put(FIFTH_COLUMN, amt);
        list.add(temp4);
f5="AI156";t5="8:30";
        HashMap<String,String> temp5=new HashMap<String, String>();
        temp5.put(FIRST_COLUMN, f5);
        temp5.put(SECOND_COLUMN, getIntent().getStringExtra("departure"));
        temp5.put(THIRD_COLUMN, getIntent().getStringExtra("destination"));
        temp5.put(FOURTH_COLUMN, t5);
        temp5.put(FIFTH_COLUMN, amt);
        list.add(temp5);
f6="AI578";t6="23:30";
        HashMap<String,String> temp6=new HashMap<String, String>();
        temp6.put(FIRST_COLUMN, f6);
        temp6.put(SECOND_COLUMN, getIntent().getStringExtra("departure"));
        temp6.put(THIRD_COLUMN, getIntent().getStringExtra("destination"));
        temp6.put(FOURTH_COLUMN, t6);
        temp6.put(FIFTH_COLUMN, amt);
        list.add(temp6);


        listviewadaptor adapter=new listviewadaptor(this, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
            {   i=position+1;
                depar=getIntent().getStringExtra("departure");
                desti=getIntent().getStringExtra("destination");

        switch(i){
            case 1:
                fno=f1;
                tno=t1;
                Intent intent=new Intent(Booking2.this,Amount.class);
                intent.putExtra("fno",fno);
                intent.putExtra("tno",tno);
                intent.putExtra("depar",depar);
                intent.putExtra("desti",desti);
                intent.putExtra("depdate",depdate);
                intent.putExtra("desdate",desdate);
                intent.putExtra("amount",amt);
                intent.putExtra("ano",ano);
                intent.putExtra("cno",cno);
                startActivity(intent);

                Toast.makeText(Booking2.this, f1+" "+depar+" "+desti+" "+t1, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                fno=f2;
                tno=t2;
                Intent intent1=new Intent(Booking2.this,Amount.class);
                intent1.putExtra("fno",fno);
                intent1.putExtra("tno",tno);
                intent1.putExtra("depar",depar);
                intent1.putExtra("desti",desti);
                intent1.putExtra("depdate",depdate);
                intent1.putExtra("amount",amt);
                intent1.putExtra("ano",ano);
                intent1.putExtra("cno",cno);
                intent1.putExtra("desdate",desdate);
                startActivity(intent1);

                Toast.makeText(Booking2.this, f2+" "+depar+" "+desti+" "+t2, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                fno=f3;
                tno=t3;
                Intent intent2=new Intent(Booking2.this,Amount.class);
                intent2.putExtra("fno",fno);
                intent2.putExtra("tno",tno);
                intent2.putExtra("depar",depar);
                intent2.putExtra("desti",desti);
                intent2.putExtra("depdate",depdate);
                intent2.putExtra("desdate",desdate);
                intent2.putExtra("ano",ano);
                intent2.putExtra("cno",cno);
                intent2.putExtra("amount",amt);
                startActivity(intent2);

                Toast.makeText(Booking2.this, f3+" "+depar+" "+desti+" "+t3, Toast.LENGTH_SHORT).show();
                break;
            case 4:
                fno=f4;
                tno=t4;
                Intent intent3=new Intent(Booking2.this,Amount.class);
                intent3.putExtra("fno",fno);
                intent3.putExtra("tno",tno);
                intent3.putExtra("depar",depar);
                intent3.putExtra("desti",desti);
                intent3.putExtra("depdate",depdate);
                intent3.putExtra("ano",ano);
                intent3.putExtra("cno",cno);
                intent3.putExtra("desdate",desdate);
                intent3.putExtra("amount",amt);
                startActivity(intent3);

                Toast.makeText(Booking2.this, f4+" "+depar+" "+desti+" "+t4, Toast.LENGTH_SHORT).show();
                break;
            case 5:
                fno=f5;
                tno=t5;
                Intent intent4=new Intent(Booking2.this,Amount.class);
                intent4.putExtra("fno",fno);
                intent4.putExtra("tno",tno);
                intent4.putExtra("depar",depar);
                intent4.putExtra("desti",desti);
                intent4.putExtra("ano",ano);
                intent4.putExtra("cno",cno);
                intent4.putExtra("depdate",depdate);
                intent4.putExtra("desdate",desdate);
                intent4.putExtra("amount",amt);
                startActivity(intent4);

                Toast.makeText(Booking2.this, f5+" "+depar+" "+desti+" "+t5, Toast.LENGTH_SHORT).show();
                break;
            case 6:
                fno=f6;
                tno=t6;
                Intent intent5=new Intent(Booking2.this,Amount.class);
                intent5.putExtra("fno",fno);
                intent5.putExtra("tno",tno);
                intent5.putExtra("depar",depar);
                intent5.putExtra("desti",desti);
                intent5.putExtra("depdate",depdate);
                intent5.putExtra("ano",ano);
                intent5.putExtra("cno",cno);
                intent5.putExtra("desdate",desdate);
                intent5.putExtra("amount",amt);
                startActivity(intent5);

                Toast.makeText(Booking2.this, f6+" "+depar+" "+desti+" "+t6, Toast.LENGTH_SHORT).show();
                break;

        }


            }

        });

    }


}
