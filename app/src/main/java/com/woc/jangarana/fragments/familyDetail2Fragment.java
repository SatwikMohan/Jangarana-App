package com.woc.jangarana.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail2Binding;

public class familyDetail2Fragment extends Fragment {

    FragmentFamilyDetail2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentFamilyDetail2Binding.inflate(inflater, container, false);


        binding.migrationNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String duration=binding.durationInMonths.getText().toString().trim();
                if (duration.isEmpty()){
                    binding.durationInMonths.setError("Required");
                    return;
                }
                String reason=binding.reasonFormigration.getText().toString().trim();
                if (reason.isEmpty()){
                    binding.reasonFormigration.setError("Required");
                    return;
                }
            }
        });

        binding.clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.durationInMonths.setText("");
                binding.reasonFormigration.setText("");
            }
        });

        return binding.getRoot();
    }
}