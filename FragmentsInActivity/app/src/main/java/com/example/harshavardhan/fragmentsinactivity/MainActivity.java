package com.example.harshavardhan.fragmentsinactivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    Boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) (findViewById(R.id.button));
        button.setText("Load Fragment");
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {



            FragmentManager fm = getSupportFragmentManager();

            FragmentTransaction ft1 = fm.beginTransaction();
            FragmentTransaction ft2 = fm.beginTransaction();

            if (!status) {
Fragment1 fragment1=new Fragment1();
                Fragment2 fragment2=new Fragment2();
                ft1.replace(R.id.fragment_container1, fragment1);
                ft1.addToBackStack(null);
                ft1.commit();
                ft2.replace(R.id.fragment_container2, fragment2);
                ft2.addToBackStack(null);
                ft2.commit();
              //  fttrans2.commit();

                status = true;

            } else {
                Fragment1 fragment1=new Fragment1();
                Fragment2 fragment2=new Fragment2();
                ft1.replace(R.id.fragment_container1, fragment2);
                ft1.addToBackStack(null);
                ft1.commit();
                ft2.replace(R.id.fragment_container2, fragment1);
                ft2.addToBackStack(null);
                ft2.commit();
                status = false;
            }

            button.setText("Alter Fragement");

        }
    }
    );

    }



}

