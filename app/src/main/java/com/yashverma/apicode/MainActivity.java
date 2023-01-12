package com.yashverma.apicode;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
//https://beta.myupchar.com/api/medicine/search?api_key=dcd5391705e71bbb87ffaf683b0b8f44&name=MEDICINE_NAME&type=MEDICINE_TYPE&manufacturer=MANUFACTURER_NAME
    String name="crocine";
String api= "https://beta.myupchar.com/api/medicine/search?api_key=dcd5391705e71bbb87ffaf683b0b8f44&name=";
ArrayList<user_model> allUSer=new ArrayList<user_model>();
ListView lm;

    public MainActivity() throws MalformedURLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lm=findViewById(R.id.Listview);
            getData();
    }

    private void getData() {

        RequestQueue queue = Volley.newRequestQueue(this);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, api+name,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array=new JSONArray(response);
                            for(int i=0;i<array.length();i++){
                                JSONObject singleObject=array.getJSONObject(i);
                                user_model user_model=new user_model(
                                       singleObject.getString("status"),
                                       singleObject.getString("message"),
                                        singleObject.getJSONArray("data")
                                );
                                allUSer.add(user_model);
                               // Log.e("api","data "+allUSer.size());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Log.e("api","data "+response.toString());
                        Toast.makeText(MainActivity.this, ""+response.toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, ""+allUSer.size(), Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            Log.e("api","Error:- "+error.getLocalizedMessage());
                Toast.makeText(MainActivity.this, ""+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}