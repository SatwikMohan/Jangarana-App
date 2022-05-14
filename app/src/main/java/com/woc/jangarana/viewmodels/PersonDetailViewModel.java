package com.woc.jangarana.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.woc.jangarana.models.Person;
import com.woc.jangarana.repositories.MemberDetailsRepo;

public class PersonDetailViewModel extends ViewModel {

    public MutableLiveData<String> message;
    public MemberDetailsRepo repo;
    public MutableLiveData<Person> personDetails;


    public PersonDetailViewModel() {
        super();
        repo= MemberDetailsRepo.getInstance();
        message=new MutableLiveData<>();
        personDetails=new MutableLiveData<>();
    }
    public MutableLiveData<String> getMessageUserObserver(){
        message=repo.getMessage();
        return message;
    }

    public MutableLiveData<Person> getPersonDetailsObserver(){
        return personDetails;
    }
    public void createdetails(Person model, Context context){
        repo.detailscreate(model,context);
    }

}
