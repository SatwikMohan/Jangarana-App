package com.woc.jangarana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.woc.jangarana.databinding.ActivityStatusBinding;

import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PersonWiseData extends AppCompatActivity {

    private ActivityStatusBinding binding ;
    private final String URL = "https://jangarana.herokuapp.com/api/census/get" ;
    private RequestQueue requestQueue ;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        requestQueue = Volley.newRequestQueue(this);

        get_data();
    }

    private void get_data ()
    {
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        JSONObject json = new JSONObject();
        try {
            json.put("censusId" , "bahadur nagarlakhimpur kherikheri262701Uttar Pradesh");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL,
                json, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("response", response.toString());

                progressDialog.dismiss();
                try {
                    JSONObject obj = response.getJSONObject("count");
                    set_data(obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(PersonWiseData.this, error.getMessage()+"",  Toast.LENGTH_SHORT).show();
                Log.d("error", error.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String tomken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjdkZjNjZTRhMzNkZDAwMjNmOGM3ZDYiLCJpYXQiOjE2NTI0MjE2OTB9.SeKJy-tU8Ob2mas4uI4SQHdLfmcJSiVL9s0zi4HfQO8";
                Map<String, String> map = new HashMap<>();
                map.put("Authorization", "Bearer "+tomken);
                return map;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }

    private void set_data (JSONObject object) throws JSONException {

        binding.moreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PersonWiseData.this, HouseholdWiseData.class));
            }
        });

        binding.maleCount.setText(String.valueOf(object.getInt("maleCount")));
        binding.femaleCount.setText(String.valueOf(object.getInt("femaleCount")));
        binding.marriedafter18.setText(String.valueOf(object.getInt("marriedAfter18")));
        binding.marriedbefore18.setText(String.valueOf(object.getInt("marriedBefore18")));
        binding.notmarried.setText(String.valueOf(object.getInt("unmarriedCount")));
        binding.hindu.setText(String.valueOf(object.getInt("hinduCount")));
        binding.muslim.setText(String.valueOf(object.getInt("muslimCount")));
        binding.sikh.setText(String.valueOf(object.getInt("sikhCount")));
        binding.christian.setText(String.valueOf(object.getInt("christianCount")));
        binding.hindi.setText(String.valueOf(object.getInt("hindiCount")));
        binding.english.setText(String.valueOf(object.getInt("englishCount")));
        binding.marathi.setText(String.valueOf(object.getInt("marathiCount")));
        binding.punjabi.setText(String.valueOf(object.getInt("punjabiCount")));
        binding.lieratecount.setText(String.valueOf(object.getInt("literateCount")));
        binding.illiterateCount.setText(String.valueOf(object.getInt("illiterateCount")));

        binding.piechart1.clearChart();
        binding.piechart2.clearChart();
        binding.piechart3.clearChart();
        binding.piechart4.clearChart();
        binding.piechart5.clearChart();

        binding.piechart1.addPieSlice(
                new PieModel(
                        "Male",
                        Integer.parseInt(binding.maleCount.getText().toString()),
                        Color.parseColor("#FFA726")));
        binding.piechart1.addPieSlice(
                new PieModel(
                        "Female",
                        Integer.parseInt(binding.femaleCount.getText().toString()),
                        Color.parseColor("#66BB6A")));



        binding.piechart2.addPieSlice(
                new PieModel(
                        "Married Before 18",
                        Integer.parseInt(binding.marriedbefore18.getText().toString()),
                        Color.parseColor("#FFA726")));
        binding.piechart2.addPieSlice(
                new PieModel(
                        "Married After 18",
                        Integer.parseInt(binding.marriedafter18.getText().toString()),
                        Color.parseColor("#66BB6A")));
        binding.piechart2.addPieSlice(
                new PieModel(
                        "Not Married",
                        Integer.parseInt(binding.notmarried.getText().toString()),
                        Color.parseColor("#EF5350")));




        binding.piechart3.addPieSlice(
                new PieModel(
                        "Hindu",
                        Integer.parseInt(binding.hindu.getText().toString()),
                        Color.parseColor("#FFA726")));
        binding.piechart3.addPieSlice(
                new PieModel(
                        "Muslim",
                        Integer.parseInt(binding.muslim.getText().toString()),
                        Color.parseColor("#66BB6A")));
        binding.piechart3.addPieSlice(
                new PieModel(
                        "Sikh",
                        Integer.parseInt(binding.sikh.getText().toString()),
                        Color.parseColor("#EF5350")));
        binding.piechart3.addPieSlice(
                new PieModel(
                        "Christian",
                        Integer.parseInt(binding.christian.getText().toString()),
                        Color.parseColor("#29B6F6")));




        binding.piechart4.addPieSlice(
                new PieModel(
                        "Hindi",
                        Integer.parseInt(binding.hindi.getText().toString()),
                        Color.parseColor("#FFA726")));
        binding.piechart4.addPieSlice(
                new PieModel(
                        "English",
                        Integer.parseInt(binding.english.getText().toString()),
                        Color.parseColor("#66BB6A")));
        binding.piechart4.addPieSlice(
                new PieModel(
                        "Marathi",
                        Integer.parseInt(binding.marathi.getText().toString()),
                        Color.parseColor("#EF5350")));
        binding.piechart4.addPieSlice(
                new PieModel(
                        "Punjabi",
                        Integer.parseInt(binding.punjabi.getText().toString()),
                        Color.parseColor("#29B6F6")));



        binding.piechart5.addPieSlice(
                new PieModel(
                        "Literate",
                        Integer.parseInt(binding.lieratecount.getText().toString()),
                        Color.parseColor("#FFA726")));
        binding.piechart5.addPieSlice(
                new PieModel(
                        "Illiterate",
                        Integer.parseInt(binding.illiterateCount.getText().toString()),
                        Color.parseColor("#66BB6A")));


        binding.piechart1.startAnimation();
        binding.piechart2.startAnimation();
        binding.piechart3.startAnimation();
        binding.piechart4.startAnimation();
        binding.piechart5.startAnimation();
    }

}