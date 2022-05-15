package com.woc.jangarana.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.databinding.FragmentUserDetail4Binding;
import com.woc.jangarana.models.Person;
import com.woc.jangarana.viewmodels.PersonDetailViewModel;


public class UserDetail4Fragment extends Fragment {


    FragmentUserDetail4Binding binding;
    Context context;
    PersonDetailViewModel personDetailViewModel;
    private Person detailsModel;

    public UserDetail4Fragment(Context context, PersonDetailViewModel personDetailViewModel) {
        this.context = context;
        this.personDetailViewModel = personDetailViewModel;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        personDetailViewModel.getPersonDetailsObserver().observe(requireActivity(), new Observer<Person>() {
            @Override
            public void onChanged(Person person) {
                detailsModel = person;
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserDetail4Binding.inflate(inflater, container, false);
        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsModel.setWorkedLastYear(true);
                detailsModel.setLookingForWork(true);
                detailsModel.setOneWayDisToWork(20);
                detailsModel.setModeOfTravel("bike");

                personDetailViewModel.createdetails(detailsModel, context);
            }
        });
        return binding.getRoot();
    }
}