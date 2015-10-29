package edu.elon.cs.gamealarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddAlarmActivity extends Activity {

    private Calendar calendar;
    private AlarmManager alarmManager;
    private Spinner hourSpinner;
    private Spinner minuteSpinner;
    private Integer[] hours;
    private Integer[] minutes;
   private ArrayAdapter<Integer> hourAdapter;
    private ArrayAdapter<Integer> minuteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        hours = new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        minutes = new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,
                18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,
                47,48,49,50,51,52,53,54,55,56,57,58,59};
       hourAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, hours);
        minuteAdapter  = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, minutes);
        calendar = Calendar.getInstance();
        hourSpinner = (Spinner) findViewById(R.id.hourspinner);
        minuteSpinner = (Spinner) findViewById(R.id.minutespinner);
        hourSpinner.setAdapter(hourAdapter);
        minuteSpinner.setAdapter(minuteAdapter);
        hourSpinner.setSelection(hours[calendar.get(Calendar.HOUR_OF_DAY)]);
        minuteSpinner.setSelection(minutes[calendar.get(Calendar.MINUTE)]);
        getIntent(); //not sure if this is needed..
    }

    public void onSaveClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        //TODO: Alternatively, we could put something here which appends to a file. not sure how yet
        intent.putExtra("hours", (Integer) hourSpinner.getSelectedItem());
        intent.putExtra("minutes", (Integer) minuteSpinner.getSelectedItem());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_alarm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
