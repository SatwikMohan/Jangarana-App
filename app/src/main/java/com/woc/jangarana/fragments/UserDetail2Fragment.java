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
import com.woc.jangarana.databinding.FragmentFamilyDetail1Binding;
import com.woc.jangarana.databinding.FragmentUserDetail1Binding;
import com.woc.jangarana.databinding.FragmentUserDetail2Binding;
import com.woc.jangarana.models.Person;
import com.woc.jangarana.viewmodels.PersonDetailViewModel;


public class UserDetail2Fragment extends Fragment {


    FragmentUserDetail2Binding binding;
    Context context;
    PersonDetailViewModel personDetailViewModel;
    Person detailsModel;

    public UserDetail2Fragment(Context context, PersonDetailViewModel personDetailViewModel) {
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

        binding = FragmentUserDetail2Binding.inflate(inflater, container, false);
        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsModel.setMaritalStatus(false);
//                detailsModel.setAgeMarried(Integer.parseInt(binding.ageOfMarrige.getText().toString()));
                detailsModel.setAgeMarried(26);
                detailsModel.setReligion(binding.religion.getText().toString());
                detailsModel.setMotherTongue("hindi");
                detailsModel.setOtherTongue("english");
                detailsModel.setDisabled(false);
                detailsModel.setDisableDOcLink("link");
                detailsModel.setLiterate(true);

                personDetailViewModel.personDetails.postValue(detailsModel);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,
                                new UserDetail3Fragment(context, personDetailViewModel))
                        .commit();
            }
        });
        return binding.getRoot();
    }
}