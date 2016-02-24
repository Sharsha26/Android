package com.example.harshavardhan.buttonspractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private final String TAG="tkt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButton1Clicked(View view){
        Toast.makeText(this, "Button 1 Clicked", Toast.LENGTH_LONG).show();

    }
    public void onButton2Clicked(View view){
        Toast.makeText(this, "Button 2 Clicked", Toast.LENGTH_LONG).show();
    }
    public void onButton3Clicked(View view){
        Toast.makeText(this,"Button 3 Clicked",Toast.LENGTH_LONG).show();
    }
    public void onButton4Clicked(View view){
        Toast.makeText(this,"Button 4 Clicked",Toast.LENGTH_LONG ).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
