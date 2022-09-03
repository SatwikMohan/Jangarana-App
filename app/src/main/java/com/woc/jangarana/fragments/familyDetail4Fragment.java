package com.woc.jangarana.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail4Binding;


import com.woc.jangarana.models.Fertility;
import com.woc.jangarana.models.House;
import com.woc.jangarana.viewmodels.FamilyDetailViewModel;


public class familyDetail4Fragment extends Fragment {


    FragmentFamilyDetail4Binding binding;
    Context context;
    FamilyDetailViewModel familyDetailViewModel;
    House houseDetails;

    public familyDetail4Fragment() {
        // Required empty public constructor
    }

    public familyDetail4Fragment(Context context, FamilyDetailViewModel familyDetailViewModel) {
        this.context = context;
        this.familyDetailViewModel = familyDetailViewModel;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        familyDetailViewModel.getHouseDetailsObserver().observe(requireActivity(), new Observer<House>() {
            @Override
            public void onChanged(House house) {
                houseDetails = house;
            }
        });
    }


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

                houseDetails.setCensusHouseNo(houseNo);
                houseDetails.setBuildingNoMunicipal(buildingNo);
                houseDetails.setNoRooms(Integer.parseInt(noOfRoom));
                familyDetailViewModel.houseDetails.postValue(houseDetails);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,
                                new familyDetail5Fragment(context, familyDetailViewModel))
                        .commit();

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