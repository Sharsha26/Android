package com.example.harshavardhan.fragmentsinactivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) (findViewById(R.id.button));
        button.setText("Get Fragments");
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fttrans = fm.beginTransaction();

            if (status) {

                fttrans.add(R.id.firstfragment, new Fragment1());
              //  fttrans.add(R.id.secondfragment, new Fragment2());
                fttrans.commit();


            } else {
               // fttrans.add(R.id.firstfragment, new Fragment2());
                  fttrans.add(R.id.secondfragment, new Fragment1());
                fttrans.commit();
            }

            status = !status;
            button.setText("Alter Fragments");
        }
    }
    );

    }



}

