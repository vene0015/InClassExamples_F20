package com.example.inclassexamples_f20;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHTTPRequest req = new MyHTTPRequest();
        req.execute("https://torunski.ca/","CST2335_XML.xml");  //Type 1
    }


                                                 //Type1     Type2   Type3
    private class MyHTTPRequest extends AsyncTask< String, Integer, String>
    {
        //Type3                      Type1
        public String doInBackground(String ... args)
        {
            try {
                String encoded = args[0] + URLEncoder.encode(args[1], "UTF-8");

                //create a URL object of what server to contact:
                URL url = new URL(encoded);

                //open the connection
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                //wait for data:
                InputStream response = urlConnection.getInputStream();

            }
            catch (Exception e)
            {

            }

            return "Done";
        }

                                        //Type 2
        public void onProgressUpdate(Integer ... args)
        {

        }
                                //Type3
        public void onPostExecute(String fromDoInBackground)
        {
            Log.i("HTTP", fromDoInBackground);
        }
    }
}
