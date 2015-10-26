package edu.elon.cs.gamealarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;

public class EditOrDeleteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_or_delete);
    }

    public void onEditClick(){
        //Intent intent = new Intent(this, AddAlarmActivity.class);
        //startActivity(intent);
    }

    public void onDeleteClick(){
        MainActivity.alarmArrayList.remove(MainActivity.relevantPosition);
        finish();
    }

}
