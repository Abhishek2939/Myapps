package com.example.hello.airindia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.hello.airindia.constants.FIFTH_COLUMN;
import static com.example.hello.airindia.constants.FIRST_COLUMN;
import static com.example.hello.airindia.constants.FOURTH_COLUMN;
import static com.example.hello.airindia.constants.SECOND_COLUMN;
import static com.example.hello.airindia.constants.THIRD_COLUMN;

/**
 * Created by hp on 7/7/2017.
 */

public class listviewadaptor extends BaseAdapter {

    public ArrayList<HashMap<String, String>> list;
    Activity activity;
    TextView txtFirst;
    TextView txtSecond;
    TextView txtThird;
    TextView txtFourth;
    TextView txtFifth;
    public listviewadaptor(Activity activity,ArrayList<HashMap<String, String>> list){
        super();
        this.activity=activity;
        this.list=list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub



        LayoutInflater inflater=activity.getLayoutInflater();

        if(convertView == null){

            convertView=inflater.inflate(R.layout.column, null);

            txtFirst=(TextView) convertView.findViewById(R.id.Flightno);
            txtSecond=(TextView) convertView.findViewById(R.id.departure);
            txtThird=(TextView) convertView.findViewById(R.id.destination);
            txtFourth=(TextView) convertView.findViewById(R.id.flighttime);
            txtFifth=(TextView) convertView.findViewById(R.id.amount);

        }

        HashMap<String, String> map=list.get(position);
        txtFirst.setText(map.get(FIRST_COLUMN));
        txtSecond.setText(map.get(SECOND_COLUMN));
        txtThird.setText(map.get(THIRD_COLUMN));
        txtFourth.setText(map.get(FOURTH_COLUMN));
        txtFifth.setText(map.get(FIFTH_COLUMN));

        return convertView;
    }

}
