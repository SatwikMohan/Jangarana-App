package com.woc.jangarana.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.authentication.familyhead.FamilyHeadSignUpActivity;


public class StaffDashboardFragment extends Fragment {

    private Context context ;

    public StaffDashboardFragment() {
        // Required empty public constructor
    }

    public StaffDashboardFragment( Context context ) {
        // Required empty public constructor
        this.context = context ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_staff_dashboard, container, false);
        AppCompatButton button = view.findViewById(R.id.familyHeadCensusButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , FamilyHeadSignUpActivity.class);
                startActivity(intent);
            }
        });

        return view ;
    }
}