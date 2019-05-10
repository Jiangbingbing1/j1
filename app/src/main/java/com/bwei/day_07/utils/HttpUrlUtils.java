package com.bwei.day_07.utils;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUrlUtils {
    private Callback callback;
    private static final HttpUrlUtils ourInstance = new HttpUrlUtils();

    public static HttpUrlUtils getInstance() {
        return ourInstance;
    }

    private HttpUrlUtils() {
    }

    public void getAs(String path){
        AsyncTask<String,Void,String> asyncTask=new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {

                try {
                    URL url=new URL(strings[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("GET");
                    int responseCode = connection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = connection.getInputStream();

                        String s = SystemToFrom(inputStream);
                        return s;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callback.getdata(s);
            }
        }.execute(path);
    }

    public interface Callback{
         void getdata(String s);
    }
    public void MyBack(Callback callback){
         this.callback=callback;
    }


    public String SystemToFrom(InputStream inputStream) throws IOException {
        int len=-1;
        byte[] bytes=new byte[1024];
        StringBuffer stringBuffer=new StringBuffer();
        while ((len=inputStream.read(bytes))!=-1){
              String s=new String(bytes,0,len);
              stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

}
