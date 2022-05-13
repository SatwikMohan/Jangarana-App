package com.woc.jangarana.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.woc.jangarana.R;
import com.woc.jangarana.authentication.familyhead.FamilyHeadSignUpActivity;
import com.woc.jangarana.authentication.staff.StaffLoginActivity;
import com.woc.jangarana.databinding.ActivityLoginOptionsBinding;

public class LoginOptionsActivity extends AppCompatActivity {

    ActivityLoginOptionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginOptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.familyHeadSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginOptionsActivity.this, FamilyHeadSignUpActivity.class));
            }
        });

        binding.governmentStaffLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginOptionsActivity.this, StaffLoginActivity.class));
            }
        });

    }
}