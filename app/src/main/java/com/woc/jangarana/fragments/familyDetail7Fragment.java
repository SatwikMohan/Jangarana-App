package com.woc.jangarana.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail7Binding;


public class familyDetail7Fragment extends Fragment {

    FragmentFamilyDetail7Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentFamilyDetail7Binding.inflate(inflater, container, false);

        binding.latrineYES.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) binding.latrineNO.setChecked(false);
                else binding.latrineNO.setChecked(true);
            }
        });

        binding.latrineNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) binding.latrineYES.setChecked(false);
                else binding.latrineYES.setChecked(true);
            }
        });

        binding.bathingYES.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) binding.bathingNO.setChecked(false);
                else binding.bathingNO.setChecked(true);
            }
        });

        binding.bathingNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) binding.bathingYES.setChecked(false);
                else binding.bathingYES.setChecked(true);
            }
        });




        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bl1=binding.latrineYES.isChecked();
                boolean bl2=binding.latrineNO.isChecked();
                boolean bb1=binding.bathingYES.isChecked();
                boolean bb2=binding.bathingNO.isChecked();
                if (!bl1 && !bl2){
                    Toast.makeText(getContext(), "Please mark the boxes", Toast.LENGTH_SHORT).show();
                }
                if (!bb1 && !bb2){
                    Toast.makeText(getContext(), "Please mark the boxes", Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.latrineYES.setChecked(false);
                binding.latrineNO.setChecked(false);
                binding.bathingYES.setChecked(false);
                binding.bathingNO.setChecked(false);
            }
        });

        return binding.getRoot();
    }

}