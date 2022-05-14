package com.woc.jangarana.familyhead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.ActivityDashboardBinding;
import com.woc.jangarana.fragments.AddFirstFragment;
import com.woc.jangarana.fragments.UserProfileFragment;
import com.woc.jangarana.models.Person;
import com.woc.jangarana.viewmodels.PersonDetailViewModel;
import com.woc.jangarana.viewmodels.SignupViewModel;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;

    SignupViewModel signupViewModel;
    PersonDetailViewModel personDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        personDetailViewModel = new ViewModelProvider(this).get(PersonDetailViewModel.class);
        signupViewModel = new ViewModelProvider(this).get(SignupViewModel.class);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFragment,
                        new AddFirstFragment(DashboardActivity.this, personDetailViewModel))
                .commit();

        binding.bottomNavForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.bottomNavForm.setStrokeColor(getResources().getColor(R.color.color_primary));
                binding.bottomNavForm.setCardBackgroundColor(getResources().getColor(R.color.highlight_gray));
                binding.bottomNavProfile.setStrokeColor(getResources().getColor(R.color.white));
                binding.bottomNavProfile.setCardBackgroundColor(getResources().getColor(R.color.white));
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,
                                new AddFirstFragment(DashboardActivity.this, personDetailViewModel))
                        .commit();
            }
        });

        binding.bottomNavProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.bottomNavProfile.setStrokeColor(getResources().getColor(R.color.color_primary));
                binding.bottomNavProfile.setCardBackgroundColor(getResources().getColor(R.color.highlight_gray));
                binding.bottomNavForm.setStrokeColor(getResources().getColor(R.color.white));
                binding.bottomNavForm.setCardBackgroundColor(getResources().getColor(R.color.white));
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,
                                new UserProfileFragment())
                        .commit();
            }
        });





    }
}