package com.woc.jangarana.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail6Binding;
import com.woc.jangarana.models.House;
import com.woc.jangarana.viewmodels.FamilyDetailViewModel;

public class familyDetail6Fragment extends Fragment {

    FragmentFamilyDetail6Binding binding;
    Context context;
    FamilyDetailViewModel familyDetailViewModel;
    House houseDetails;

    public familyDetail6Fragment(Context context, FamilyDetailViewModel familyDetailViewModel) {
        this.context = context;
        this.familyDetailViewModel = familyDetailViewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        familyDetailViewModel.getHouseDetailsObserver().observe(requireActivity(), new Observer<House>() {
            @Override
            public void onChanged(House house) {
                houseDetails = house;
            }
        });

        binding=FragmentFamilyDetail6Binding.inflate(inflater, container, false);

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marriedCouples=binding.marridCouples.getText().toString().trim();
                if (marriedCouples.isEmpty()){
                    binding.marridCouples.setError("Required");
                    return;
                }
                String sourceofwater=binding.sourceOfWater.getText().toString().trim();
                if (sourceofwater.isEmpty()){
                    binding.sourceOfWater.setError("Required");
                    return;
                }
                String sourceOfLight=binding.sourceOfLight.getText().toString().trim();
                if (sourceOfLight.isEmpty()){
                    binding.sourceOfLight.setError("Required");
                    return;
                }
            }
        });

        binding.clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.marridCouples.setText("");
                binding.sourceOfWater.setText("");
                binding.sourceOfLight.setText("");
            }
        });


        return binding.getRoot();
    }
}