package com.example.harshavardhan.actnadfraglc;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HARSHA VARDHAN on 2/26/2016.
 */
public class Fragment1 extends Fragment {
private final String TAG="tkt";

    @Override
    public void onAttach(Context context){
        Log.d(TAG,"Fragment OnAttach called");
        super.onAttach(context);


    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        Log.d(TAG,"Fragment OnCreateView called");
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment1,container,true);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        Log.d(TAG,"Fragment OnActivityCreated called");
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        Log.d(TAG,"Fragment OnCreatecalled");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart(){
        Log.d(TAG,"Fragment OnStart called");
        super.onStart();
    }
    @Override
    public void onResume(){
        Log.d(TAG,"Fragment OnResume called");
    super.onResume();
    }
@Override
    public void onPause(){
    Log.d(TAG,"Fragment OnPause called");
    super.onResume();
}
@Override
    public void onStop(){
    Log.d(TAG,"Fragment OnStop called");
    super.onStop();
}
    @Override
    public void onDestroyView(){
        Log.d(TAG,"Fragment OnDestroyView called");
        super.onDestroyView();;
    }
    @Override
    public void onDestroy(){
        Log.d(TAG,"Fragment OnDestroy called");
        super.onDestroy();
    }


    @Override
    public void onDetach(){
        Log.d(TAG,"Fragment OnDetach called");
        super.onDetach();
    }
}

