package com.example.harshavardhan.actnadfraglc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
private String TAG="tkt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            Log.d(TAG,"Activity OnCreateCalled");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
        @Override
        public void onStart(){
                Log.d(TAG,"Activity OnStartCalled");
                super.onStart();

        }


        @Override
        public void onRestart(){
                Log.d(TAG,"Activity OnRestartCalled");
                super.onRestart();
        }

   @Override
        public void onResume(){
           Log.d(TAG,"Activity OnResumeCalled");
           super.onResume();;
   }
        @Override
        public void onPause(){
                Log.d(TAG,"Activity OnPauseCalled");
                super.onPause();

        }
        @Override
        public void onStop(){
                Log.d(TAG,"Activity OnStopCalled");
                super.onStop();
        }
@Override
public void onDestroy(){
        Log.d(TAG,"Activity OnDestroyCalled");
super.onDestroy();
}


}
