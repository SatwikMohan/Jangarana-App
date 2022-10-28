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
import com.woc.jangarana.databinding.FragmentFamilyDetail3Binding;
import com.woc.jangarana.models.Fertility;
import com.woc.jangarana.models.House;
import com.woc.jangarana.models.Migration;
import com.woc.jangarana.viewmodels.FamilyDetailViewModel;

import java.util.function.BiConsumer;

public class familyDetail3Fragment extends Fragment {

    FragmentFamilyDetail3Binding binding;

    Context context;
    FamilyDetailViewModel familyDetailViewModel;
    Fertility fertilityDetails;

    public familyDetail3Fragment(Context context, FamilyDetailViewModel familyDetailViewModel) {
        this.context = context;
        this.familyDetailViewModel = familyDetailViewModel;
    }

    public familyDetail3Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        familyDetailViewModel.getFertilityDetailsObserver().observe(requireActivity(), new Observer<Fertility>() {
            @Override
            public void onChanged(Fertility fertility) {
                fertilityDetails = fertility;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentFamilyDetail3Binding.inflate(inflater, container, false);

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String daughter=binding.noOfDaughter.getText().toString().trim();
                if (daughter.isEmpty()){
                    binding.noOfDaughter.setError("Required");
                    return;
                }
                String sons=binding.noOfsons.getText().toString().trim();
                if (sons.isEmpty()){
                    binding.noOfsons.setError("Required");
                    return;
                }
                String daughterborn=binding.noOfDaughtersborn.getText().toString().trim();
                if (daughterborn.isEmpty()){
                    binding.noOfDaughtersborn.setError("Required");
                    return;
                }
                String sonsborn=binding.noOfsonsborn.getText().toString().trim();
                if (sonsborn.isEmpty()){
                    binding.noOfsonsborn.setError("Required");
                    return;
                }
                String daughterbornLastYear=binding.noOfDaughtersbornlastYear.getText().toString().trim();
                if (daughterbornLastYear.isEmpty()){
                    binding.noOfDaughtersbornlastYear.setError("Required");
                    return;
                }
                String sonsbornLastYear=binding.noOfsonsbornlastYear.getText().toString().trim();
                if (sonsbornLastYear.isEmpty()){
                    binding.noOfsonsbornlastYear.setError("Required");
                    return;
                }

                fertilityDetails.setNoBornAliveDaughterLastYear(Integer.parseInt(daughterbornLastYear));
                fertilityDetails.setNoBornAliveSonLastYear(Integer.parseInt(sonsbornLastYear));
                fertilityDetails.setNoBornDaughter(Integer.parseInt(daughter));
                fertilityDetails.setNoBornSon(Integer.parseInt(sons));
                fertilityDetails.setNoLivingDaughter(Integer.parseInt(daughterborn));
                fertilityDetails.setNoLivingSon(Integer.parseInt(sonsborn));

                familyDetailViewModel.addFertilityDetails(fertilityDetails, context);

                familyDetailViewModel.getMessageUserObserver().observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
                        House house = new House();
                        house.setId(fertilityDetails.getId());
                        familyDetailViewModel.houseDetails.postValue(house);
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flFragment, new familyDetail4Fragment(context, familyDetailViewModel))
                        .commit();
                    }
                });

            }
        });

        binding.clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.noOfDaughter.setText("");
                binding.noOfDaughtersborn.setText("");
                binding.noOfDaughtersbornlastYear.setText("");
                binding.noOfsons.setText("");
                binding.noOfsonsborn.setText("");
                binding.noOfsonsbornlastYear.setText("");
            }
        });







        return binding.getRoot();
    }
}