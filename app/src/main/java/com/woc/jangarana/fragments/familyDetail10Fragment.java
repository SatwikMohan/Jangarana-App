package com.woc.jangarana.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.models.House;
import com.woc.jangarana.viewmodels.FamilyDetailViewModel;

public class familyDetail10Fragment extends Fragment {


    Context context;
    FamilyDetailViewModel familyDetailViewModel;
    House houseDetails;

    public familyDetail10Fragment(Context context, FamilyDetailViewModel familyDetailViewModel) {
        this.context = context;
        this.familyDetailViewModel = familyDetailViewModel;
    }

    public familyDetail10Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        familyDetailViewModel.getHouseDetailsObserver().observe(requireActivity(), new Observer<House>() {
            @Override
            public void onChanged(House house) {
                houseDetails = house;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_family_detail10, container, false);
    }
}