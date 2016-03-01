package com.example.harshavardhan.listview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by HARSHA VARDHAN on 2/28/2016.
 */
public class ListviewFragment extends Fragment{

String data[]={"abc","sdh","sdkvvb","sdcv sbdchsjd","dhvcshjv bhsd","dbnv sjdvnsdv","djvbsdhbdjk","wc jhwbcdjk","dvwhdjkcnkdj","hvbddf vjdf","mhvnbhjvhfd","dkjvhbhjfvbdfh","hvbhdbdhdf"};

    ListView listView;

ArrayAdapter<String> adapter;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }
    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
    }
    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup,Bundle savedInstanceState){
        super.onCreateView(inflater, viewGroup, savedInstanceState);

return inflater.inflate(R.layout.fragmentlayout,viewGroup,false);


    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        listView=(ListView) getView().findViewById(R.id.listView);
        adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,new ArrayList<String>());
        listView.setAdapter(adapter);
        super.onResume();



        new MyTask().execute();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    protected class MyTask extends AsyncTask<Void,String,Void>{
        int count=1;
        ProgressDialog progressDialog=new ProgressDialog(getContext());
        protected void onPreExecute(){
Log.d("TAG", "pre");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setIndeterminate(false);
progressDialog.show();

        }
        @Override
        protected Void doInBackground(Void... params) {



            Log.d("TAG","IN back");
for(String item:data){
    try {
        Thread.sleep(1000);

    }catch(Exception e){

    }
    publishProgress(item);


}

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values){
            Log.d("TAG1",""+((count / data.length) * progressDialog.getMax()));
            Log.d("count", "" + (int)(((double)count/(double)data.length)*100));


progressDialog.setProgress  ( (int)(((double)count/(double)data.length)*100));



            adapter.add(values[0]);
            count++;

        }
protected void onPostExecute(){
    progressDialog.dismiss();
}

    }


}
