package com.example.harshavardhan.locationdisplay;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HARSHA VARDHAN on 2/27/2016.
 */
public class FragmentLocation extends Fragment {
    Button button;
    TextView latValue;
    TextView lonValue;
    LocationManager locationManager;
    ProgressDialog progressDialog;

double lat;
    double lon;



    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.location_fragment,container,true);
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        button=(Button )view.findViewById(R.id.button);
        latValue=(TextView)view.findViewById(R.id.LatitudeValue);
        lonValue=(TextView)view.findViewById((R.id.LongitudeValue));

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onResume(){
        super.onResume();
        locationManager=(LocationManager)getContext().getSystemService(Context.LOCATION_SERVICE);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                latValue.setText("");
                lonValue.setText("");
                new MyClass().execute();


            }
        });
    }


    class MyClass extends AsyncTask<Void,Void, Location> {
        @Override
        protected void onPreExecute(){
progressDialog=new ProgressDialog(getContext());
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Getting location");
            if(!progressDialog.isShowing())
            progressDialog.show();
        }

        @Override
        protected Location doInBackground(Void... params){
            Location location=null;
            try {
                Thread.sleep(3000);
                if ( Build.VERSION.SDK_INT >= 23 &&
                        ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        ContextCompat.checkSelfPermission( getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                }

                 location= locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);


            }catch(Exception e){

            }
            return location;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(Location location) {
            lat= location.getLatitude();
            lon=location.getLongitude();

            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
            latValue.setText(""+lat);
            lonValue.setText(""+lon);
        }

    }
}
