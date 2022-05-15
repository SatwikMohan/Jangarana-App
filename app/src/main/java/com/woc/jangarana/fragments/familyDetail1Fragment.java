package com.woc.jangarana.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail1Binding;

public class familyDetail1Fragment extends Fragment {

    FragmentFamilyDetail1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentFamilyDetail1Binding.inflate(inflater, container, false);

        binding.checkNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                binding.checkYes.toggle();
            }
        });


        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.checkYes.isChecked()){
                    String lastCountry=binding.lastResidenceContry.getText().toString().trim();
                    if (lastCountry.isEmpty()){
                        binding.lastResidenceContry.setError("Required");
                        return;
                    }
                    String lastCity=binding.lastResidenceCity.getText().toString().trim();
                    if (lastCity.isEmpty()){
                        binding.lastResidenceCity.setError("");
                    }
                    String postalCode=binding.postalCodeLastResidence.getText().toString().trim();
                    if (postalCode.isEmpty()){
                        binding.postalCodeLastResidence.setError("Required");
                    }
                }
                else if (!binding.checkNo.isChecked()){
                    Toast.makeText(getContext(), "please check any one checkbox", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });

        binding.clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        return binding.getRoot();
    }


}