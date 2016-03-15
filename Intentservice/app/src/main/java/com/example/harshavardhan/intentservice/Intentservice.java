package com.example.harshavardhan.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by HARSHA VARDHAN on 3/15/2016.
 */
public class Intentservice extends IntentService {
    String key;
public Intentservice(){
    super("name");


}


    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this) {
            Bundle bundle = intent.getExtras();
            key = bundle.getString("key");
           // Toast.makeText(getBaseContext(), "Recieved " + key, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Recieved key "+key+" and Service Destroyed",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
