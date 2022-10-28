package com.woc.jangarana.authentication.familyhead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.woc.jangarana.R;
import com.woc.jangarana.databinding.ActivityFamilyHeadSignUpBinding;
import com.woc.jangarana.models.FamilyHeadSignup;
import com.woc.jangarana.viewmodels.SignupViewModel;

public class FamilyHeadSignUpActivity extends AppCompatActivity {

    ActivityFamilyHeadSignUpBinding binding;
    SignupViewModel viewModel;
    FamilyHeadSignup userSignupModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFamilyHeadSignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViewModel();

        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupUser();
            }
        });
    }

    private void signupUser() {
        if(TextUtils.isEmpty(binding.familyHeadName.getText().toString()) && binding.familyHeadName.getText().toString().length() < 4){
            binding.familyHeadName.setError("Enter name more than 3 characters");
            return;
        }
        if(TextUtils.isEmpty(binding.familyHeadEmail.getText().toString()) && ! Patterns.EMAIL_ADDRESS.matcher(binding.familyHeadEmail.getText().toString()).matches()){
            binding.familyHeadEmail.setError("Enter valid email");
            return;
        }
        if(TextUtils.isEmpty(binding.password.getText().toString()) && binding.password.getText().toString().length()<6){
            binding.password.setError("Enter password min 6 characters");
            return;
        }
        binding.progressBar2.setVisibility(View.VISIBLE);
        userSignupModel = new FamilyHeadSignup(binding.familyHeadName.getText().toString(), binding.familyHeadEmail.getText().toString(),binding.password.getText().toString());

        viewModel.createNewUser(userSignupModel, FamilyHeadSignUpActivity.this);
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        viewModel.getMessageUserObserver().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
        viewModel.getTokenUserObserver().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.progressBar2.setVisibility(View.GONE);
                startActivity(new Intent(FamilyHeadSignUpActivity.this, VerifyEmailActivity.class));
            }
        });
    }


}