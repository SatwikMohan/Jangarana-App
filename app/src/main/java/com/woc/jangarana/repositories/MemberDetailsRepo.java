package com.woc.jangarana.repositories;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.woc.jangarana.models.Person;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MemberDetailsRepo {

    private static final MemberDetailsRepo instance = new MemberDetailsRepo();
    private final MutableLiveData<String> message = new MutableLiveData<>();
    RequestQueue requestQueue;
    RequestQueue requestQueue2;
    ProgressDialog progressDialog;

    public static MemberDetailsRepo getInstance() {
        return instance;
    }

    public void detailscreate(Person model, Context context) {
        progressDialog=new ProgressDialog(context);
        progressDialog.setMessage("Updating Your Profile . Please Wait");
        progressDialog.show();

        Map<String, String> params = new HashMap<>();


        Log.d("params", String.valueOf(params));

        String url = "https://jangarana.herokuapp.com/api/form/create";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,
                new JSONObject(params), new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("response", response.toString());
                try {
//                    Toast.makeText(context, response.get("message").toString(), Toast.LENGTH_SHORT).show();
                    message.postValue(response.get("message").toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences= context.getSharedPreferences("All Details",Context.MODE_PRIVATE);
                String tomken=sharedPreferences.getString("token","");
//                Log.d("token",tomken);
                Map<String, String> map = new HashMap<>();
                map.put("Authorization", "Bearer "+tomken);
                return map;
            }
        };
        requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonObjectRequest);
    }

    public MutableLiveData<String> getMessage() {
        return message;
    }
    
}
