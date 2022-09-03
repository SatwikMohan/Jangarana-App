package com.woc.jangarana.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.FragmentFamilyDetail1Binding;
import com.woc.jangarana.databinding.FragmentUserDetail1Binding;
import com.woc.jangarana.databinding.FragmentUserDetail2Binding;
import com.woc.jangarana.models.Person;
import com.woc.jangarana.repositories.SpinnerData;
import com.woc.jangarana.viewmodels.PersonDetailViewModel;

import java.util.ArrayList;
import java.util.Arrays;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentUserDetail2Binding.inflate(inflater, container, false);

        final String[] married = {""};
        final String[] toung = {""};

        SpinnerData spinner_data = new SpinnerData();
        ArrayAdapter<String> marriedAdapter = getAdapter(new ArrayList<>(Arrays.asList(spinner_data.getMarital_st())));
        ArrayAdapter<String> toungAdapter = getAdapter(new ArrayList<>(Arrays.asList(spinner_data.getMotherToung())));
        ArrayAdapter<String> otherAdapter = getAdapter(new ArrayList<>(Arrays.asList(spinner_data.getMotherToung())));
        marriedAdapter.setDropDownViewResource(R.layout.spinner_items);
        otherAdapter.setDropDownViewResource(R.layout.spinner_items);
        toungAdapter.setDropDownViewResource(R.layout.spinner_items);
        binding.marritalStatus.setAdapter(marriedAdapter);
        binding.motherTounge.setAdapter(toungAdapter);
        binding.otherLanguage.setAdapter(toungAdapter);

        binding.marritalStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                if(position > 0){
                    married[0] = selectedItemText;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.otherLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                if(position > 0){
                    married[0] = selectedItemText;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.motherTounge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);

                if(position > 0){
                    // Notify the selected item text
                    toung[0] = selectedItemText;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsModel.setMaritalStatus(false);
//                detailsModel.setAgeMarried(Integer.parseInt(binding.ageOfMarrige.getText().toString()));
                detailsModel.setAgeMarried(26);
                detailsModel.setReligion("hindu");
                detailsModel.setMotherTongue("hindi");
                detailsModel.setOtherLanguage("english");
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

    public ArrayAdapter<String> getAdapter(ArrayList<String> data){

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                context,R.layout.spinner_items,data){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(getActivity().getResources().getColor(R.color.field_text));
                }
                else {
                    tv.setTextColor(getActivity().getResources().getColor(R.color.fill_text));
                }
                return view;
            }
        };

        return spinnerArrayAdapter;
    }
}