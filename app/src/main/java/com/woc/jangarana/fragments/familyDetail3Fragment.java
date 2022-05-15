package com.woc.jangarana.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail3Binding;

import java.util.function.BiConsumer;

public class familyDetail3Fragment extends Fragment {

    FragmentFamilyDetail3Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentFamilyDetail3Binding.inflate(inflater, container, false);

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String daughter=binding.noOfDaughter.getText().toString().trim();
                if (daughter.isEmpty()){
                    binding.noOfDaughter.setError("Required");
                    return;
                }
                String sons=binding.noOfsons.getText().toString().trim();
                if (sons.isEmpty()){
                    binding.noOfsons.setError("Required");
                    return;
                }
                String daughterborn=binding.noOfDaughtersborn.getText().toString().trim();
                if (daughterborn.isEmpty()){
                    binding.noOfDaughtersborn.setError("Required");
                    return;
                }
                String sonsborn=binding.noOfsonsborn.getText().toString().trim();
                if (sonsborn.isEmpty()){
                    binding.noOfsonsborn.setError("Required");
                    return;
                }
                String daughterbornLastYear=binding.noOfDaughtersbornlastYear.getText().toString().trim();
                if(daughterbornLastYear.isEmpty()){
                    binding.noOfDaughtersbornlastYear.setError("Required");
                }
                String sonbornLastYear=binding.noOfsonsbornlastYear.getText().toString().trim();
                if(sonbornLastYear.isEmpty()){
                    binding.noOfsonsbornlastYear.setError("Required");
                }

            }
        });

        binding.clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.noOfDaughter.setText("");
                binding.noOfDaughtersborn.setText("");
                binding.noOfDaughtersbornlastYear.setText("");
                binding.noOfsons.setText("");
                binding.noOfsonsborn.setText("");
                binding.noOfsonsbornlastYear.setText("");
            }
        });






        return binding.getRoot();
    }
}