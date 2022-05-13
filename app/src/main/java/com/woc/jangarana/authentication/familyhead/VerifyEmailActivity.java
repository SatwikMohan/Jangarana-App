package com.woc.jangarana.authentication.familyhead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.ActivityVerifyEmailBinding;
import com.woc.jangarana.models.FamilyHeadSignup;
import com.woc.jangarana.viewmodels.SignupViewModel;

public class VerifyEmailActivity extends AppCompatActivity {

    ActivityVerifyEmailBinding binding;
    SignupViewModel viewModel;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerifyEmailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViewModel();




    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        viewModel.getMessageObserver().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
            }
        });
        viewModel.getUserObserver().observe(this, new Observer<FamilyHeadSignup>() {
            @Override
            public void onChanged(FamilyHeadSignup s) {

            }
        });
        viewModel.getTokenUserObserver().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                token=s;
            }
        });
    }
}