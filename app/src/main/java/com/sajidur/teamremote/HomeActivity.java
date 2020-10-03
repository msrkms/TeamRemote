package com.sajidur.teamremote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sajidur.teamremote.Adapter.RecyclerViewAllEventsAdapter;
import com.sajidur.teamremote.BackEnd.AllURLS;
import com.sajidur.teamremote.BackEnd.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<Event> events=new ArrayList<Event>();
    RecyclerView recyclerViewAllEvents;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerViewAllEvents=(RecyclerView) findViewById(R.id.recyclerViewAllEvents);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);

        getALLEventsFromAPI();

    }


    private void getALLEventsFromAPI(){
        String url = AllURLS.getALLEvents;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseEvents(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Volley Error",error.toString());
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void parseEvents(String response){
        System.out.println(response.toString());

        try{


            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArrayEvents=jsonObject.getJSONArray("events");

            events.clear();
            for(int i =0;i<jsonArrayEvents.length();i++){
                JSONObject jsonObjectevent = jsonArrayEvents.getJSONObject(i);
                Event event=new Event();
                event.setID(jsonObjectevent.getString("id"));
                event.setTitle(jsonObjectevent.getString("title"));

                JSONArray jsonArrayCategories=jsonObjectevent.getJSONArray("categories");
                for (int j=0;j<jsonArrayCategories.length();j++){
                    JSONObject objectCategory=jsonArrayCategories.getJSONObject(j);
                    event.setCategoryID(objectCategory.getString("id"));
                    event.setCategory(objectCategory.getString("title"));
                }
                events.add(event);

            }

            setValuesRecyclerViewAllEvents();
            } catch (JSONException ex) {
            ex.printStackTrace();
        }


    }

    private void setValuesRecyclerViewAllEvents(){
        RecyclerViewAllEventsAdapter recyclerViewAllEventsAdapter=new RecyclerViewAllEventsAdapter(this,events);
        recyclerViewAllEvents.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAllEvents.setAdapter(recyclerViewAllEventsAdapter);
        progressBar.setVisibility(View.INVISIBLE);
    }
}