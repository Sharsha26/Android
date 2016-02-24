package com.example.harshavardhan.fragmentinxml;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

/**
 * Created by HARSHA VARDHAN on 2/23/2016.
 */
public class Fragment2 extends Fragment {
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

    }
   @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);
        return inflater.inflate(R.layout.fragment2,container,true);

    }
}
