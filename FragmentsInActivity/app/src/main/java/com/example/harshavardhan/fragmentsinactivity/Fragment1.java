package com.example.harshavardhan.fragmentsinactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HARSHA VARDHAN on 2/23/2016.
 */
public class Fragment1 extends Fragment{
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }
    @Override
    public void onStart(){
        super.onStart();
    }

    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment1,container,false);
    }
    @Override
    public void onCreate( Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
@Override
    public void onActivityCreated(Bundle savedInstanceState){
    super.onActivityCreated(savedInstanceState);
}
@Override
    public void onViewCreated(View view,Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);
}
    @Override
    public void onPause(){
        super.onPause();
    }
    @Override
    public void onStop(){
        super.onStop();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }


}
