package com.woc.jangarana.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.woc.jangarana.models.FamilyHeadSignup;
import com.woc.jangarana.repositories.SignupRepo;

public class SignupViewModel extends ViewModel {
    public MutableLiveData<String> message;
    public MutableLiveData<String> token;
    private MutableLiveData<FamilyHeadSignup> user;
    public SignupRepo repo;

    public SignupViewModel() {
        super();
        repo = SignupRepo.getInstance();
        message = new MutableLiveData<>();
        token = new MutableLiveData<>();
        user = new MutableLiveData<>();
    }

    public MutableLiveData<String> getMessageUserObserver() {
        message = repo.getMessage();
        return message;
    }

    public MutableLiveData<String> getTokenUserObserver() {
        token = repo.getToken();
        return token;
    }

    public void createNewUser(FamilyHeadSignup user, Context context) {
        repo.createUser(user, context);
    }

    public MutableLiveData<String> getMessageObserver() {
        message = repo.getMessage();
        return message;
    }

    public MutableLiveData<FamilyHeadSignup> getUserObserver() {
        user = repo.getUser();
        return user;
    }

    public void verifyUser(FamilyHeadSignup otpObject, Context context) {
        repo.VerifyUser(otpObject, context);
    }

}
