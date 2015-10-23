package edu.elon.cs.gamealarm;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.alarmList);

        List<Alarm> alarmArrayList = new ArrayList<Alarm>();

        //TODO: Remove - just for testing
        alarmArrayList.add(new Alarm(2, 4, 3, true));
        alarmArrayList.add(new Alarm(6, 12, 16, true));
        alarmArrayList.add(new Alarm(4, 3, 45, false));

        ArrayAdapter<Alarm> arrayAdapter = new ArrayAdapter<Alarm>(this,
                android.R.layout.simple_list_item_1,
                alarmArrayList);

        listView.setAdapter(arrayAdapter);


    }

}
