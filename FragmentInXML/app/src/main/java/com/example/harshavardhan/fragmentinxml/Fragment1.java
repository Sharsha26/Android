package com.example.harshavardhan.fragmentinxml;

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

public class Fragment1 extends Fragment {
@Override
public void onAttach(Context context){
    super.onAttach(context);

}
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment1,container,true);

    }
@Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


}
