package com.example.harshavardhan.listview;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by HARSHA VARDHAN on 3/3/2016.
 */
public class CustomBroadcastReciever extends BroadcastReceiver {


    private static final long REPEAT_TIME = 1000*30;
    @Override
    public void onReceive(Context context, Intent intent) {
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context,FetchDataService.class);
        PendingIntent pending = PendingIntent.getBroadcast(context,0,i,PendingIntent.FLAG_CANCEL_CURRENT);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND,30);
        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),REPEAT_TIME,pending);
    }
}
