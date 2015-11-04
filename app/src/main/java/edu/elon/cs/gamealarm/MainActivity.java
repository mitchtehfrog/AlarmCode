package edu.elon.cs.gamealarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;
    protected static List<Alarm> alarmArrayList;
    protected static int relevantPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.alarmList);

        alarmArrayList = new ArrayList<Alarm>();

        //TODO: Remove - just for testing

        //alarmArrayList.add(new Alarm (2,30));

//        alarmArrayList.add(new Alarm(2, 4, 3, true));
//        alarmArrayList.add(new Alarm(6, 12, 16, true));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));
//        alarmArrayList.add(new Alarm(4, 3, 45, false));

        //TODO: code something that populates the array list with a file


        ArrayAdapter<Alarm> arrayAdapter = new ArrayAdapter<Alarm>(this,
                android.R.layout.simple_list_item_1,
                alarmArrayList);

        //runOnUiThread(new Runnable() {
           // public void run() {
              //  arrayAdapter.notifyDataSetChanged();
           // }
       // });                                                   This was here to try to debug



        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(itemClickListener);
        listView.setOnItemLongClickListener(itemLongClickListener);
        if(getIntent() != null){
            Intent intent = getIntent();
            int hours = intent.getIntExtra("hours", 0);
            int minutes = intent.getIntExtra("minutes", 0);
            Alarm alarm = new Alarm(hours, minutes);
            alarmArrayList.add(alarm);

                    //add logic for re-ordering the list
        }

    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Alarm current = alarmArrayList.get(position);
            if (current.isOn()) {
                current.setOn(false);
            }
            else
                current.setOn(true);
        }
    };

    AdapterView.OnItemLongClickListener itemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            relevantPosition = position;
            startEditOrDelete();
            System.out.println("in longclick");
            return true;
        }
    };

    private void startEditOrDelete(){
        Intent intent = new Intent (this, EditOrDeleteActivity.class);
        startActivity(intent);
        ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
    }

    public void onAddClick(View view){
        Intent intent = new Intent (this, AddAlarmActivity.class);
        startActivity(intent);
    }
}


