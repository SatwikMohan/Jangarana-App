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
import com.woc.jangarana.databinding.FragmentFamilyDetail2Binding;
import com.woc.jangarana.models.Fertility;
import com.woc.jangarana.models.Migration;
import com.woc.jangarana.viewmodels.FamilyDetailViewModel;

public class familyDetail2Fragment extends Fragment {

    FragmentFamilyDetail2Binding binding;

    Context context;
    FamilyDetailViewModel familyDetailViewModel;
    Migration migrationDetails;

    public familyDetail2Fragment(Context context, FamilyDetailViewModel familyDetailViewModel) {
        this.context = context;
        this.familyDetailViewModel = familyDetailViewModel;
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

        binding=FragmentFamilyDetail2Binding.inflate(inflater, container, false);


        binding.migrationNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String duration=binding.durationInMonths.getText().toString().trim();
                if (duration.isEmpty()){
                    binding.durationInMonths.setError("Required");
                    return;
                }
                String reason=binding.reasonFormigration.getText().toString().trim();
                if (reason.isEmpty()){
                    binding.reasonFormigration.setError("Required");
                    return;
                }
                migrationDetails.setReasonMigration(binding.reasonFormigration.getText().toString());
                migrationDetails.setDuration(Integer.parseInt(binding.durationInMonths.getText().toString()));

                familyDetailViewModel.addMigrationDetails(migrationDetails,context);
                familyDetailViewModel.getMessageUserObserver().observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
                        Fertility fertility = new Fertility();
                        fertility.setId(migrationDetails.getId());
                        familyDetailViewModel.fertilityDetails.postValue(fertility);
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flFragment, new familyDetail3Fragment(context, familyDetailViewModel))
                        .commit();
                    }
                });
            }
        });

        binding.clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.durationInMonths.setText("");
                binding.reasonFormigration.setText("");
            }
        });

        return binding.getRoot();
    }
}