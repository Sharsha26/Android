package com.example.harshavardhan.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by HARSHA VARDHAN on 3/15/2016.
 */
public class BoundService extends Service {
    private final IBinder ibinder=new localService();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return ibinder;
    }
    class localService extends Binder{

        BoundService getService(){
            return BoundService.this;
        }
    }
public void callFirst(){
    Toast.makeText(this,"First Message called",Toast.LENGTH_SHORT).show();
}
    public void callSecond(){
        Toast.makeText(this,"Second Message called",Toast.LENGTH_SHORT).show();
    }
}
