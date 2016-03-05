package com.example.harshavardhan.listview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by HARSHA VARDHAN on 3/3/2016.
 */
public class DataActivity extends Activity {

    private FetchDataService service;


    @Override
    protected void onResume() {
        super.onResume();
        Intent i = new Intent(this,FetchDataService.class);
        bindService(i,connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(connection);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            FetchDataService.DataBinder b  = (FetchDataService.DataBinder) binder;
            service = b.getService();
            Toast.makeText(DataActivity.this,"Connection Succesful",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            service = null;
        }
    };
}
