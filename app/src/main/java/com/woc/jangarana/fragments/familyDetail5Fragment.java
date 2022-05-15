package com.woc.jangarana.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail5Binding;
import com.woc.jangarana.models.House;
import com.woc.jangarana.viewmodels.FamilyDetailViewModel;

public class familyDetail5Fragment extends Fragment {

    FragmentFamilyDetail5Binding binding;
    Context context;
    FamilyDetailViewModel familyDetailViewModel;
    House houseDetails;

    public familyDetail5Fragment(Context context, FamilyDetailViewModel familyDetailViewModel) {
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