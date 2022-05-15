package com.woc.jangarana.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail5Binding;

public class familyDetail5Fragment extends Fragment {

    FragmentFamilyDetail5Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding=FragmentFamilyDetail5Binding.inflate(inflater, container, false);

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useofcensus=binding.useOfcenses.getText().toString().trim();
                if (useofcensus.isEmpty()){
                    binding.useOfcenses.setError("Required");
                    return;
                }
                String conditionOfHousehold=binding.conditionOfcenses.getText().toString().trim();
                if (conditionOfHousehold.isEmpty()){
                    binding.conditionOfcenses.setError("Required");
                    return;
                }
                String personCensesHousehold=binding.personsResidingcensus.getText().toString().trim();
                if (personCensesHousehold.isEmpty()){
                    binding.personsResidingcensus.setError("Required");
                    return;
                }
            }
        });

        binding.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.useOfcenses.setText("");
                binding.conditionOfcenses.setText("");
                binding.personsResidingcensus.setText("");
            }
        });



        return binding.getRoot();
    }
}