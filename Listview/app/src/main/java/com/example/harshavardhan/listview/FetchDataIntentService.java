package com.example.harshavardhan.listview;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by HARSHA VARDHAN on 3/5/2016.
 */
public class FetchDataIntentService  extends IntentService {



    private static  int RESULT = -2;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public FetchDataIntentService(String name) {
        super("FetchDataIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String path = intent.getStringExtra("urlpath");
        String fileName = intent.getStringExtra("fileName");
        File outPut = new File(Environment.getExternalStorageDirectory(), fileName);
        if (outPut.exists()) {
            outPut.delete();

            InputStream is = null;
            FileOutputStream fs = null;

            try {
                URL url = new URL(path);
                is = url.openConnection().getInputStream();
                InputStreamReader re = new InputStreamReader(is);
                fs = new FileOutputStream(outPut.getPath());
                int next = -1;
                while ((next = re.read()) != -1) {
                    fs.write(next);
                }
                RESULT = Activity.RESULT_OK;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (is != null) {

                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (fs != null) {
                    try {
                        fs.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }

        publishResults(outPut.getAbsolutePath(),RESULT);
    }

        protected void publishResults(String outPath,int result){
            Intent i = new Intent("com.example.harshavardhan.listview.MyReciever");
            i.putExtra("OutPutFilePath",outPath);
            i.putExtra("result",result);
            sendBroadcast(i);

    }
}
