package com.woc.jangarana.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail10Binding;
import com.woc.jangarana.databinding.FragmentFamilyDetail9Binding;
import com.woc.jangarana.models.House;
import com.woc.jangarana.viewmodels.FamilyDetailViewModel;
import com.woc.jangarana.viewmodels.PersonDetailViewModel;

public class familyDetail10Fragment extends Fragment {


    FragmentFamilyDetail10Binding binding;
    Context context;
    FamilyDetailViewModel familyDetailViewModel;
    House houseDetails;

    public familyDetail10Fragment(Context context, FamilyDetailViewModel familyDetailViewModel) {
        this.context = context;
        this.familyDetailViewModel = familyDetailViewModel;
    }

    public familyDetail10Fragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
        binding = FragmentFamilyDetail10Binding.inflate(inflater, container, false);
        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Data Uploaded", Toast.LENGTH_SHORT).show();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,
                                new AddFirstFragment(context, new PersonDetailViewModel()))
                        .commit();
            }
        });
        return binding.getRoot();
    }
}