package com.woc.jangarana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.woc.jangarana.databinding.ActivityHouseholdWiseDataBinding;

import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HouseholdWiseData extends AppCompatActivity {

    private ActivityHouseholdWiseDataBinding binding ;
    private final String URL = "https://jangarana.herokuapp.com/api/householdcount/get" ;
    private RequestQueue requestQueue ;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHouseholdWiseDataBinding.inflate(getLayoutInflater());
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
                Toast.makeText(HouseholdWiseData.this, error.getMessage()+"",  Toast.LENGTH_SHORT).show();
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

        binding.woodenroof.setText(String.valueOf(object.getInt("woodenRoofCount")));
        binding.mudroof.setText(String.valueOf(object.getInt("mudRoofCount")));
        binding.cementroof.setText(String.valueOf(object.getInt("cementRoofCount")));
        binding.mudfloor.setText(String.valueOf(object.getInt("mudFloorCount")));
        binding.cementfloor.setText(String.valueOf(object.getInt("cementFloorCount")));
        binding.marblefloor.setText(String.valueOf(object.getInt("marbleFloorCount")));
        binding.mudwall.setText(String.valueOf(object.getInt("mudWallCount")));
        binding.cementwall.setText(String.valueOf(object.getInt("cementWallCount")));
        binding.woodenwall.setText(String.valueOf(object.getInt("wookenWallCount")));

        binding.piechart2.clearChart();
        binding.piechart3.clearChart();
        binding.piechart4.clearChart();



        binding.piechart2.addPieSlice(
                new PieModel(
                        "Mud Floor",
                        Integer.parseInt(binding.mudfloor.getText().toString()),
                        Color.parseColor("#FFA726")));
        binding.piechart2.addPieSlice(
                new PieModel(
                        "Cement Floor",
                        Integer.parseInt(binding.cementfloor.getText().toString()),
                        Color.parseColor("#66BB6A")));
        binding.piechart2.addPieSlice(
                new PieModel(
                        "Marble Floor",
                        Integer.parseInt(binding.marblefloor.getText().toString()),
                        Color.parseColor("#EF5350")));




        binding.piechart3.addPieSlice(
                new PieModel(
                        "Mud Roof",
                        Integer.parseInt(binding.mudroof.getText().toString()),
                        Color.parseColor("#FFA726")));
        binding.piechart3.addPieSlice(
                new PieModel(
                        "Wooden Roof",
                        Integer.parseInt(binding.woodenroof.getText().toString()),
                        Color.parseColor("#66BB6A")));
        binding.piechart3.addPieSlice(
                new PieModel(
                        "Cement Roof",
                        Integer.parseInt(binding.cementroof.getText().toString()),
                        Color.parseColor("#EF5350")));




        binding.piechart4.addPieSlice(
                new PieModel(
                        "Mud Walls",
                        Integer.parseInt(binding.mudwall.getText().toString()),
                        Color.parseColor("#FFA726")));
        binding.piechart4.addPieSlice(
                new PieModel(
                        "Cement Walls",
                        Integer.parseInt(binding.cementwall.getText().toString()),
                        Color.parseColor("#66BB6A")));
        binding.piechart4.addPieSlice(
                new PieModel(
                        "Wooden Walls",
                        Integer.parseInt(binding.woodenwall.getText().toString()),
                        Color.parseColor("#EF5350")));




        binding.piechart2.startAnimation();
        binding.piechart3.startAnimation();
        binding.piechart4.startAnimation();
    }

}