package edu.elon.cs.gamealarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/**
 * Created by Michael on 10/22/2015.
 */
public class Alarm extends BroadcastReceiver{

    private int hours, minutes;
    private boolean isOn = false;

    public Alarm(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
    }

    public void onReceive(Context context, Intent intent){
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK ,"");
        wakeLock.acquire();
    }

    public void setAlarm(Context context, long timeFromNow){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager.AlarmClockInfo info = new AlarmManager.AlarmClockInfo(System.currentTimeMillis() + timeFromNow, pendingIntent);
        alarmManager.setAlarmClock(info, pendingIntent);
    }

    public void setOn(boolean isOn){
        this.isOn = isOn;
    }

    public boolean isOn(){
        return isOn;
    }


        @Override
        public String toString() {
            String alarm = hours + ":";

            if (minutes < 10){
                alarm += "0";
            }

            alarm += minutes + " ";
            return alarm;
    }

}
