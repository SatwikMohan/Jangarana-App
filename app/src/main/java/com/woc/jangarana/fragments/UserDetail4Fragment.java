package com.woc.jangarana.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentUserDetail4Binding;
import com.woc.jangarana.models.House;
import com.woc.jangarana.models.Migration;
import com.woc.jangarana.models.Person;
import com.woc.jangarana.models.PersonResponse;
import com.woc.jangarana.viewmodels.FamilyDetailViewModel;
import com.woc.jangarana.viewmodels.PersonDetailViewModel;


public class UserDetail4Fragment extends Fragment {


    FragmentUserDetail4Binding binding;
    Context context;
    PersonDetailViewModel personDetailViewModel;
    FamilyDetailViewModel familyDetailViewModel;
    private Person detailsModel;

    public UserDetail4Fragment(Context context, PersonDetailViewModel personDetailViewModel) {
        this.context = context;
        this.personDetailViewModel = personDetailViewModel;
        this.familyDetailViewModel = new FamilyDetailViewModel();
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

                personDetailViewModel.getPersonDetailsResponseObserver().observe(requireActivity(), new Observer<PersonResponse>() {
                    @Override
                    public void onChanged(PersonResponse personResponse) {
                        Migration migration = new Migration();
                        migration.setId(personResponse.getId());
                        familyDetailViewModel.migrationDetails.postValue(migration);
                        SharedPreferences sharedPreferences= context.getSharedPreferences("Head SignUp",Context.MODE_PRIVATE);
                        String tomken=sharedPreferences.getString("family_head_token","");
                        if(personResponse.getId().equals(tomken)){
                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.flFragment, new familyDetail1Fragment(familyDetailViewModel, context))
                                    .commit();
                        }else{
                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.flFragment, new AddFirstFragment())
                                    .commit();
                        }
                    }
                });
            }
        });
        return binding.getRoot();
    }
}