package com.example.harshavardhan.listview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;

/**
 * Created by HARSHA VARDHAN on 3/5/2016.
 */
public class RecciverActivity extends Activity {

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ///
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver,new IntentFilter("com.example.harshavardhan.listview.MyReciever"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void onClick(View view){
        Intent intent = new Intent(this,FetchDataService.class);
        intent.putExtra("filename","regrgegr");
        intent.putExtra("url","www.google.cpm");
        startService(intent);
    }
}
