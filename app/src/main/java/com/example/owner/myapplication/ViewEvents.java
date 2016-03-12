package com.example.owner.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);
        Intent intentExtras = getIntent();
        final int year = intentExtras.getIntExtra("Year", 2016);
        final int month = intentExtras.getIntExtra("Month", 3);
        final int day = intentExtras.getIntExtra("Day", 11);
//        final String des = intentExtras.getStringExtra("EventDescription");
//        final String time = intentExtras.getStringExtra("EventTime");
//        final int id = intentExtras.getIntExtra("ID", 1);

        final ArrayList<String> events = Events.getEvents();

        ArrayAdapter<String> myAdapter=new
                ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                events);

        ListView myList=
                (ListView) findViewById(R.id.listView);

        myList.setAdapter(myAdapter);

        Button add = (Button) findViewById(R.id.button);
        Button delete = (Button) findViewById(R.id.button2);
        Button back = (Button) findViewById(R.id.button5);

        add.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        Intent intentBundle = new Intent(ViewEvents.this, MakeEvent.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("Year", year);
                        bundle.putInt("Month", month);
                        bundle.putInt("Day", day);
                        intentBundle.putExtras(bundle);
                        startActivity(intentBundle);
                    }
                }
        );

        delete.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intentBundle = new Intent(ViewEvents.this, DeleteEvent.class);
                        startActivity(intentBundle);
                        events.remove(DeleteEvent.idNumber);
                    }
                }
        );

        back.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        finish();
                    }
                }
        );
    }


}
