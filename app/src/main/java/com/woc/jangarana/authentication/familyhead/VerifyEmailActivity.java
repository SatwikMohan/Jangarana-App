package com.woc.jangarana.authentication.familyhead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mukesh.OnOtpCompletionListener;
import com.woc.jangarana.R;
import com.woc.jangarana.databinding.ActivityVerifyEmailBinding;
import com.woc.jangarana.familyhead.DashboardActivity;
import com.woc.jangarana.models.FamilyHeadSignup;
import com.woc.jangarana.viewmodels.SignupViewModel;

import org.json.JSONObject;

public class VerifyEmailActivity extends AppCompatActivity {

    ActivityVerifyEmailBinding binding;
    SignupViewModel viewModel;
    String token;
    String OTP = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerifyEmailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViewModel();


        binding.otpViewText.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String otp) {
                OTP = otp;
            }
        });

        binding.verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(OTP.equals("")){
                    Toast.makeText(VerifyEmailActivity.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                    return;
                }

                FamilyHeadSignup otpObject = new FamilyHeadSignup(token, OTP);
                viewModel.verifyUser(otpObject, VerifyEmailActivity.this);
            }
        });

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
                SharedPreferences sharedPreferences= getSharedPreferences("Head SignUp", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("family_head","signUp");
                editor.commit();

                startActivity(new Intent(VerifyEmailActivity.this, DashboardActivity.class));
                finish();

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