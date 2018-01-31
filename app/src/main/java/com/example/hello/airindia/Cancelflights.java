package com.example.hello.airindia;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by hp on 6/17/2017.
 */

public class Cancelflights extends Fragment implements DatePickerDialog.OnDateSetListener{
    TextView textView8, textView200, textView10, textView11, textView12;
    EditText editText300, editText200, editText14;
    AutoCompleteTextView autoCompleteTextView3, autoCompleteTextView4;
    String strloc[] = {"New Delhi", "Bombay", "Calcutta", "chennai"};
    String str[] = {"New Delhi", "Bombay", "Calcutta", "chennai", "London", "Canada", "Brazil", "Kathmandu", "Tokyo"};
    Button button4, button200;
    String email,flight,deploc,destloc;
    String del;
    public static final String TAG = "CancelFlights";
    private DatabaseHandler myDb;
    ArrayList<Contact> allEmployees;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        View view = inflater.inflate(R.layout.cancelflight, container, false);
        textView8 = (TextView) view.findViewById(R.id.textView8);
        textView200 = (TextView) view.findViewById(R.id.textView201);
        textView10 = (TextView) view.findViewById(R.id.textView10);
        textView11 = (TextView) view.findViewById(R.id.textView11);
        textView12 = (TextView) view.findViewById(R.id.textView12);
        editText300 = (EditText) view.findViewById(R.id.editText300);
        editText200 = (EditText) view.findViewById(R.id.editText200);
        editText14 = (EditText) view.findViewById(R.id.editText14);
        button4 = (Button) view.findViewById(R.id.button4);
        final Context c = getActivity().getApplicationContext();

        autoCompleteTextView3 = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextView3);
        autoCompleteTextView4 = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextView4);
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, str);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, strloc);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        autoCompleteTextView3.setThreshold(1);
        autoCompleteTextView4.setThreshold(1);
        autoCompleteTextView3.setVisibility(view.VISIBLE);
        autoCompleteTextView4.setVisibility(view.VISIBLE);
        autoCompleteTextView3.setAdapter(adapter3);
        autoCompleteTextView4.setAdapter(adapter1);


        button200 = (Button) view.findViewById(R.id.button300);


        button200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                java.util.Calendar now = java.util.Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        Cancelflights.this,
                        now.get(java.util.Calendar.YEAR),
                        now.get(java.util.Calendar.MONTH),
                        now.get(java.util.Calendar.DAY_OF_MONTH)
                );
                dpd.setVersion(DatePickerDialog.Version.VERSION_2);
                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");

            }
        });
        myDb = new DatabaseHandler(view.getContext());

        allEmployees = myDb.getAllContact(null,null,null);

        email=editText14.getText().toString();
        flight=editText200.getText().toString();
final String        date=editText300.getText().toString();


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email == null || flight == null||date==null) {
                    Toast.makeText(c.getApplicationContext(), "ENTER THE DATA CORRECTLY", Toast.LENGTH_SHORT).show();
                } else {
                    String searchemail = editText14.getText().toString().trim();
                    String searchflight = editText200.getText().toString().trim();
                    String searchdate=editText300.getText().toString().trim();
                     autoCompleteTextView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                             deploc= (String) parent.getItemAtPosition(position);
                        }
                     });

                            autoCompleteTextView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                              destloc= (String) parent.getItemAtPosition(position);
                                }
                            });

                    allEmployees = myDb.getAllContact(searchemail,searchflight,searchdate);
                    Log.i(TAG, "Searched Size : " + allEmployees.size());
                    if (allEmployees.size() == 0) {
                        Toast.makeText(c.getApplicationContext(), "NO RESULTS", Toast.LENGTH_SHORT).show();
                    } else {
                        del= searchemail;
                        Toast.makeText(c.getApplicationContext(), "DATA FOUND", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(c.getApplicationContext(), Confirmcancel.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent3.putExtra("delete",del);
                        startActivity(intent3);
                    }
                }
            }
        });

        return view;
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
        editText300.setText(date);

    }




    void showToastMessage(String message) {
        Toast.makeText(getView().getContext(), message, Toast.LENGTH_LONG).show();
    }
}