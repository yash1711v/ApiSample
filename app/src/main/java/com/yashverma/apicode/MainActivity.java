package com.yashverma.apicode;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
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
    String type="Allopath";
String api= "https://beta.myupchar.com/api/medicine/search?api_key=dcd5391705e71bbb87ffaf683b0b8f44&type=";
ArrayList<model> allUSer=new ArrayList<model>();
TextView lm;
String name2;
    public MainActivity() throws MalformedURLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            getData();
    }

    private void getData() {
        lm=findViewById(R.id.textView);
        RequestQueue queue = Volley.newRequestQueue(this);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, api+type,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            JSONArray array=jsonObject.getJSONArray("data");
                            Log.e("api","data "+array.length());
//                            Log.e("api","data "+array.toString());
                            ArrayList<String> medicennames=new ArrayList<>();
                            ArrayList<String> manufcature= new ArrayList<>();
//                            for(int i=0;i<array.length();i++){
//                                Log.e("api","new i"+i);
//                                JSONObject singleObject=array.getJSONObject(i);
//                                Log.e("api","name "+ singleObject.getString("name"));
//                                medicennames.add(singleObject.getString("name"));
//
//                                for(int j=0;j<singleObject.getJSONObject("manufacturer").length();j++){
//                                    Log.e("api","name "+ j);
////                                    manufcature.add(singleObject.getJSONArray("manufacturer").getJSONObject(j).getString("name"));
////                                    Log.e("api","name "+ singleObject.getJSONArray("manufacturer").getJSONObject(j).getString("name"));
//                                }
//
//                            }
                            for(int i=0;i<4;i++){
                                JSONObject singleObject=array.getJSONObject(i);
                                model user_model=new model();
                                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
//                                Log.e("api","i "+i);
//                                Log.e("api","i "+singleObject.getString("name"));
                                Toast.makeText(MainActivity.this, ""+singleObject.getString("name"), Toast.LENGTH_SHORT).show();
                                user_model.setProduct_id(singleObject.getInt("product_id"));
                                user_model.setName(singleObject.getString("name"));
                                user_model.setIn_stock(singleObject.getBoolean("in_stock"));
                                user_model.setProduct_url(singleObject.getString("product_url"));
                                user_model.setImage(singleObject.getString("image"));
                                ArrayList<model.manufacturer> mf = new ArrayList<>();
                                for(int j=0;j<singleObject.getJSONObject("manufacturer").length();j++){
                                    model.manufacturer mfc=new model.manufacturer();
                                    mfc.setName(singleObject.getJSONObject("manufacturer").getString("name"));
                                    mfc.setUrl(singleObject.getJSONObject("manufacturer").getString("url"));
                                    mf.add(mfc);
                                }
                                user_model.setMf(mf);
                                ArrayList<model.price> pr = new ArrayList<>();
                                for(int k=0;k<singleObject.getJSONObject("price").length();k++){
                                    model.price price=new model.price();
                                  // price.setFinal_price(singleObject.getJSONObject("price").getInt("Final_price"));
                                   price.setMrp(singleObject.getJSONObject("price").getInt("mrp"));
                                   price.setDiscount_perc(singleObject.getJSONObject("price").getInt("discount_perc"));
                                   pr.add(price);
                                }
                                user_model.setPr(pr);
                                allUSer.add(user_model);
                                //Log.e("api","data "+allUSer.size());
                                Log.e("api","data "+response.toString());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                       Log.e("api","allusersize "+allUSer.size());
                        for(int j=0;j<allUSer.size();j++)
                        {
                            Log.e("api","allusersize "+allUSer.get(j).name);
                            Log.e("api","allManufacture "+allUSer.get(j).getMf().get(0).name);
                        }


                       // Toast.makeText(MainActivity.this, ""+response.toString(), Toast.LENGTH_SHORT).show();
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