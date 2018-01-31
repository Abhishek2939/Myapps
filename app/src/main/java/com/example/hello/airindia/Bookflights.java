package com.example.hello.airindia;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

/**
 * Created by hp on 6/16/2017.
 */

public class Bookflights extends Fragment implements DatePickerDialog.OnDateSetListener{
    TextView textView5, textView6, textView7,textView100;
    Button button6;
    AutoCompleteTextView autoCompleteTextView1, autoCompleteTextView2;
    Spinner spinner1, spinner2, spinner3;
    String strloc[] = {"New Delhi", "Bombay", "Calcutta", "chennai"};
    String str[] = {"New Delhi", "Bombay", "Calcutta", "chennai", "London", "Canada", "Brazil", "Kathmandu",  "Tokyo"};
    String count[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String cabin[]={"ECONOMY","BUSINESS"};
    int id=1;
    Button button7;
    EditText editText12;
    String dep,loc,adults,children,classs;
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        final Context c = getActivity().getApplicationContext();
        final View view = inflater.inflate(R.layout.bookflight, container, false);
        autoCompleteTextView1 = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextView1);
        autoCompleteTextView2 = (AutoCompleteTextView)view.findViewById(R.id.autoCompleteTextView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(c, android.R.layout.simple_spinner_item, count);
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, str);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, strloc);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(c, android.R.layout.simple_spinner_item, cabin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        autoCompleteTextView1.setThreshold(1);
        autoCompleteTextView2.setThreshold(1);
        autoCompleteTextView1.setVisibility(view.VISIBLE);
        autoCompleteTextView2.setVisibility(view.VISIBLE);
        autoCompleteTextView1.setAdapter(adapter3);
        autoCompleteTextView2.setAdapter(adapter1);
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dep= (String) parent.getItemAtPosition(position);

            }
        });

        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                loc= (String) parent.getItemAtPosition(position);

            }
        });


        spinner1 = (Spinner) view.findViewById(R.id.Spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.Spinner2);
        spinner3 = (Spinner) view.findViewById(R.id.Spinner3);
        spinner1.setVisibility(view.VISIBLE);
        spinner2.setVisibility(view.VISIBLE);
        spinner3.setVisibility(view.VISIBLE);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter2);
        adults=spinner1.getSelectedItem().toString();
        children=spinner2.getSelectedItem().toString();
        classs=spinner3.getSelectedItem().toString();




        textView5 = (TextView) view.findViewById(R.id.textView5);
        textView6 = (TextView) view.findViewById(R.id.textView6);
        textView7 = (TextView) view.findViewById(R.id.textView7);
        textView100 = (TextView) view.findViewById(R.id.textView100);



        button6=(Button)view.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(c.getApplicationContext(), Booking2.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("departure", dep);
                    intent.putExtra("destination", loc);
                    intent.putExtra("depdate", editText12.getText().toString());
                    intent.putExtra("adults", adults);
                    intent.putExtra("children", children);
                    intent.putExtra("class", classs);


                    startActivity(intent);
                
           }
       });



        editText12=(EditText)view.findViewById(R.id.editText300);
//        editText13=(EditText)view.findViewById(R.id.editText13);
        button7=(Button)view.findViewById(R.id.Button7);


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                java.util.Calendar now = java.util.Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        Bookflights.this,
                        now.get(java.util.Calendar.YEAR),
                        now.get(java.util.Calendar.MONTH),
                        now.get(java.util.Calendar.DAY_OF_MONTH)
                );
                dpd.setVersion(DatePickerDialog.Version.VERSION_2);
                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");

            }
        });




        return view;

    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
        editText12.setText(date);

    }
}




