package com.example.harshavardhan.weatherbyzipcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by HARSHA VARDHAN on 2/29/2016.
 */
public class WeatherFragment extends Fragment {
    String code;
    String country;
    String city;
    TextView cityText;
    TextView countryText;
    TextView zipCodeText;
    RecyclerView recyclerView;
    recyclerviewAdapter adapter;
    ProgressDialog progressDialog;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        setRetainInstance(true);
View view=inflater.inflate(R.layout.fragment_weather,container,false);

        return view;


    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume(){
        super.onResume();

        new MyClass().execute();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cityText=(TextView)view.findViewById(R.id.city);
        countryText=(TextView)view.findViewById(R.id.country);
        zipCodeText=(TextView)view.findViewById(R.id.zipcode);
    }

    protected class MyClass extends AsyncTask<Void,Void,List<Weather>>{
        public void onPreExecute(){
            progressDialog=new ProgressDialog(getContext());
            progressDialog.setIndeterminate(true);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("Loading Weather data for next 10 days");
            progressDialog.show();
//            if(recyclerView.getAdapter()!=null) {
//                int count = recyclerView.getAdapter().getItemCount();
//                for (int i = 1; i <= count; i++) {
//                    recyclerView.getAdapter().notifyItemChanged(i);
//                    recyclerView.removeViewAt(i);
//
//                }
//            }
        }
        @Override
        protected List<Weather> doInBackground(Void... params) {
            double lat=0;
            double lon=0;
            Log.d("TAG","background");

            try {
                LocationManager locationManager=(LocationManager)getContext().getSystemService(Context.LOCATION_SERVICE);
                if ( Build.VERSION.SDK_INT >= 23 &&
                        ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        ContextCompat.checkSelfPermission( getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                }

                Location location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
               if(location==null){
                   return  null;
               }
                lat=location.getLatitude();
                lon=location.getLongitude();

                Geocoder geocoder;
                List<Address> addresses;
                geocoder = new Geocoder(getContext(), Locale.getDefault());
                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 5);
                Log.d("TAG1",""+addresses.size());
                code=addresses.get(0).getPostalCode();
                Log.d("TAG1",""+code);
            }catch(Exception e){
return null;
            }
            List<Weather> weatherList=new ArrayList<Weather>();
            String temp=null;
            HttpURLConnection connection=null;
            BufferedReader reader=null;

            try {

                URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?lat="+lat+"&lon="+lon+"&cnt=10&APPID=7b2366dd5335c041b021f482eb8fc9d2");


                connection=(HttpURLConnection)url.openConnection();

                connection.connect();
                Log.d("TAG", "finalJson is");
                InputStream stream=connection.getInputStream();
                reader=new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer=new StringBuffer();

                String line="";
                while((line=reader.readLine())!=null){
                    buffer.append(line);
                }
                String finalJson=buffer.toString();




                JSONObject jsonObject=new JSONObject(finalJson);
                JSONObject cityObject=jsonObject.getJSONObject("city");
                String city1=cityObject.getString("name");
                city=city1;

                String country1=cityObject.getString("country");
                country=country1;
for(int i=0;i<10;i++){
Weather weather=new Weather();
    JSONArray jsonArray=jsonObject.getJSONArray("list");
    JSONObject listObject=jsonArray.getJSONObject(i);
    String date=listObject.getString("dt");
    JSONObject tempJsonObject=listObject.getJSONObject("temp");
    String dayTemp=tempJsonObject.getString("day");
    String minTemp=tempJsonObject.getString("min");
    String maxTemp=tempJsonObject.getString("max");
    long date2=(Long.valueOf(date)).longValue();
    Date date1=new Date(date2*1000);
    Log.d("DATE",""+date1);
            weather.date=""+date1;
    weather.dayTemp=dayTemp;
    weather.maxTemp=maxTemp;
    weather.minTemp=minTemp;
    weatherList.add(weather);



}
Log.d("List",""+weatherList);

                //JSONObject countjson=jsonObject.getJSONObject("cnt");
                String count=jsonObject.getString("cnt");
                Log.d("TagCount",""+count);
               // JSONObject finalObject=jsonObject.getJSONObject("main");
               // temp=finalObject.getString("temp");
                //  JSONArray parentArray=jsonObject.getJSONArray()
            }catch(Exception e){
                Toast.makeText(getContext(),"Please check you internet connection",Toast.LENGTH_LONG).show();
                e.printStackTrace();

return null;


            }

            return weatherList;
        }

        @Override
        protected void onPostExecute(List<Weather> s) {
progressDialog.dismiss();
            if(s==null){
                Toast.makeText(getContext(),"Please check you internet connection",Toast.LENGTH_LONG).show();
                return;
            }
            cityText.setText(city);
            countryText.setText(country);
            zipCodeText.setText(code);
            recyclerView.setAdapter(new recyclerviewAdapter(getContext(), s));




            //adapter= (recyclerviewAdapter)recyclerView.getAdapter();


            Log.d("TAG", "temp is" + s);


        }
    }

}


