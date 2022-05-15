package com.woc.jangarana.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail6Binding;

public class familyDetail6Fragment extends Fragment {

    FragmentFamilyDetail6Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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