package com.woc.jangarana.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail8Binding;

import java.util.Locale;

public class familyDetail8Fragment extends Fragment {

    FragmentFamilyDetail8Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentFamilyDetail8Binding.inflate(inflater, container, false);

        binding.kitchenYES.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) binding.kitchenNO.setChecked(false);
                else binding.kitchenNO.setChecked(true);
            }
        });

        binding.kitchenNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) binding.kitchenYES.setChecked(false);
                else binding.kitchenYES.setChecked(true);
            }
        });

        binding.lpgYES.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) binding.lpgNO.setChecked(false);
                else binding.lpgNO.setChecked(true);
            }
        });

        binding.lpgYES.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) binding.lpgNO.setChecked(false);
                else binding.lpgNO.setChecked(true);
            }
        });

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mainFuel=binding.mainFuel.getText().toString().trim();
                if (mainFuel.isEmpty()){
                    binding.mainFuel.setError("Required");
                    return;
                }
                String mainceral=binding.mailcereal.getText().toString().trim();
                if (mainFuel.isEmpty()){
                    binding.mailcereal.setError("Required");
                    return;
                }

            }
        });





        binding.clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.kitchenYES.setChecked(false);
                binding.kitchenNO.setChecked(false);
                binding.lpgYES.setChecked(false);
                binding.lpgNO.setChecked(false);
            }
        });

        return binding.getRoot();
    }
}