package com.e.volley_recyclerview.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.e.volley_recyclerview.Mysingleton;
import com.e.volley_recyclerview.R;
import com.e.volley_recyclerview.adapter.RecyclerViewAdapter;
import com.e.volley_recyclerview.model.DataGet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataGet> data ;
    DataGet dataGet;
    RecyclerViewAdapter recyclerViewAdapter;
    private String url ="https://gist.githubusercontent.com/Ahmed-Basalib10/2a31961953d2887b5c6738f6fc72b232/raw/anime.json";
    JsonArrayRequest jsonArrayRequest;
   // RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();

        recyclerView= (RecyclerView) findViewById(R.id.recyclerviewid);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // better to use singleton class fot creating requestQueue
      //  requestQueue = Volley.newRequestQueue(MainActivity.this);
        paesjison();
    }

    private void paesjison() {
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                for(int i =0;i<response.length();i++){
                    try {
                        jsonObject=response.getJSONObject(i);
                        dataGet =new DataGet();
                        dataGet.setName(jsonObject.getString("name"));
                        dataGet.setCategorie(jsonObject.getString("categorie"));
                        dataGet.setRating(jsonObject.getString("Rating"));
                        dataGet.setStudio(jsonObject.getString("studio"));
                        dataGet.setImg(jsonObject.getString("img"));
                        data.add(dataGet);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

              recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });
    //    requestQueue.add(jsonArrayRequest);
        // or
        Mysingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
    }
}