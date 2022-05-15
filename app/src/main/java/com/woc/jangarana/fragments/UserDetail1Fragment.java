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
import com.woc.jangarana.models.Person;
import com.woc.jangarana.repositories.SpinnerData;
import com.woc.jangarana.viewmodels.PersonDetailViewModel;

import java.util.ArrayList;
import java.util.Arrays;


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

        final String[] gender = {""};
        final String[] state = {""};



        SpinnerData spinner_data = new SpinnerData();
        ArrayAdapter<String> genderAdapter = getAdapter(new ArrayList<>(Arrays.asList(spinner_data.getGender())));
        ArrayAdapter<String> stateAdapter = getAdapter(new ArrayList<>(Arrays.asList(spinner_data.getStates_ut())));
        genderAdapter.setDropDownViewResource(R.layout.spinner_items);
        stateAdapter.setDropDownViewResource(R.layout.spinner_items);
        binding.genderSpinner.setAdapter(genderAdapter);
        binding.spinner2.setAdapter(stateAdapter);

        binding.genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
                    gender[0] = selectedItemText;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
                    state[0] = selectedItemText;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



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

    public ArrayAdapter<String> getAdapter(ArrayList<String> data){

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                context,R.layout.spinner_items,data){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
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