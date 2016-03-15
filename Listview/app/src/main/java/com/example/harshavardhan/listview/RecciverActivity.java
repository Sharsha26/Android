package com.example.harshavardhan.listview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

/**
 * Created by HARSHA VARDHAN on 3/5/2016.
 */
public class RecciverActivity extends Activity {


    MapFragment mapsFragment;




    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ///
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
       GoogleMap map  =mapsFragment.getMap();
        map.


    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void onClick(View view){
        ContentValues values =  new ContentValues();
        values.put("Name","Rahul");
        values.put("Class","Android");
        Uri uri  = getContentResolver().insert(MyContentProvider.URI,values);
    }
}
