package com.woc.jangarana.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail1Binding;
import com.woc.jangarana.databinding.FragmentUserDetail1Binding;
import com.woc.jangarana.models.Person;
import com.woc.jangarana.viewmodels.PersonDetailViewModel;


public class UserDetail1Fragment extends Fragment {


    FragmentUserDetail1Binding binding;
    Context context;
    PersonDetailViewModel personDetailViewModel;
    Person detailsModel;

    public UserDetail1Fragment(Context context, PersonDetailViewModel personDetailViewModel) {
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

        binding = FragmentUserDetail1Binding.inflate(inflater, container, false);
        binding.nextButtondeatil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                detailsModel.setName(binding.firstName.getText().toString()+" "+binding.lastname.getText().toString());
                detailsModel.setName("Tarun Shrivastava");
                detailsModel.setGender("male");
                detailsModel.setDob("01-08-2002");
//                detailsModel.setMohalla(binding.adressLine1.getText().toString()+","+binding.adressLine2.getText().toString());
                detailsModel.setMohalla("Holi Pura");
                detailsModel.setCity("Datia");
                detailsModel.setDistrict("Datia");
                detailsModel.setState("Madhya Pradesh");
                detailsModel.setCountry("india");
//                detailsModel.setZipcode(binding.zipCode.getText().toString());
                detailsModel.setZipcode("475661");
                personDetailViewModel.personDetails.postValue(detailsModel);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,
                                new UserDetail2Fragment(context, personDetailViewModel))
                        .commit();
            }
        });
        return binding.getRoot();
    }
}