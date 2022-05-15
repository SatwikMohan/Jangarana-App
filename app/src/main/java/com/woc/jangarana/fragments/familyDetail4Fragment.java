package com.woc.jangarana.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail4Binding;

public class familyDetail4Fragment extends Fragment {

    FragmentFamilyDetail4Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentFamilyDetail4Binding.inflate(inflater, container, false);

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buildingNo=binding.buildingNumber.getText().toString().trim();
                if (buildingNo.isEmpty()){
                    binding.buildingNumber.setError("");
                    return;
                }
                String houseNo=binding.cencusHouseNo.getText().toString().trim();
                if (houseNo.isEmpty()){
                    binding.cencusHouseNo.setError("");
                    return;
                }
                String noOfRoom=binding.noOfRooms.getText().toString().trim();
                if (noOfRoom.isEmpty()){
                    binding.noOfRooms.setError("");
                    return;
                }
            }
        });

        binding.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.buildingNumber.setText("");
                binding.cencusHouseNo.setText("");
                binding.noOfRooms.setText("");
            }
        });

        return binding.getRoot();
    }
}