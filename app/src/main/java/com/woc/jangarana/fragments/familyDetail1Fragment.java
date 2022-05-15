package com.woc.jangarana.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail1Binding;
import com.woc.jangarana.models.House;
import com.woc.jangarana.models.Migration;
import com.woc.jangarana.models.Person;
import com.woc.jangarana.viewmodels.FamilyDetailViewModel;

public class familyDetail1Fragment extends Fragment {

    FragmentFamilyDetail1Binding binding;
    FamilyDetailViewModel familyDetailViewModel;
    Context context;
    Migration migrationDetails;

    public familyDetail1Fragment(FamilyDetailViewModel familyDetailViewModel, Context context) {
        this.familyDetailViewModel = familyDetailViewModel;
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        familyDetailViewModel.getMigrationDetailsObserver().observe(requireActivity(), new Observer<Migration>() {
            @Override
            public void onChanged(Migration migration) {
                migrationDetails = migration;
            }
        });
    }

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
        binding.checkYes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                binding.checkNo.toggle();
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

                    migrationDetails.setMigrated(true);
                    migrationDetails.setCountry(binding.lastResidenceContry.getText().toString().trim());
                    migrationDetails.setCity(binding.lastResidenceCity.getText().toString().trim());
                    migrationDetails.setDistrict(binding.lastResidenceCity.getText().toString().trim());
                    migrationDetails.setZipCode(binding.postalCodeLastResidence.getText().toString().trim());
//                    migrationDetails.setState(binding.lastResidenceState.getText().toString().trim());
                    migrationDetails.setState("Madhya Pradesh");

                }else if(binding.checkNo.isChecked()){
                    migrationDetails.setMigrated(true);
                    migrationDetails.setCountry("null");
                    migrationDetails.setCity("null");
                    migrationDetails.setDistrict("null");
                    migrationDetails.setZipCode("null");
                    migrationDetails.setState("null");


                }else {
                    Toast.makeText(getContext(), "please check any one checkbox", Toast.LENGTH_SHORT).show();
                    return;
                }

                familyDetailViewModel.migrationDetails.postValue(migrationDetails);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,
                                new familyDetail2Fragment(context, familyDetailViewModel))
                        .commit();


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