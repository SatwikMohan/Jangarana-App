package com.woc.jangarana.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.woc.jangarana.models.Fertility;
import com.woc.jangarana.models.House;
import com.woc.jangarana.models.Migration;
import com.woc.jangarana.models.Person;
import com.woc.jangarana.repositories.FamilyDetailRepo;
import com.woc.jangarana.repositories.MemberDetailsRepo;

public class FamilyDetailViewModel extends ViewModel {

    public MutableLiveData<String> message;
    public FamilyDetailRepo repo;
    public MutableLiveData<House> houseDetails;
    public MutableLiveData<House> houseDetailsResponse;
    public MutableLiveData<Migration> migrationDetails;
    public MutableLiveData<Fertility> fertilityDetails;


    public FamilyDetailViewModel() {
        super();
        repo= FamilyDetailRepo.getInstance();
        message=new MutableLiveData<>();
        houseDetails=new MutableLiveData<>();
        migrationDetails=new MutableLiveData<>();
        fertilityDetails=new MutableLiveData<>();
        houseDetails.postValue(new House());
        migrationDetails.postValue(new Migration());
        fertilityDetails.postValue(new Fertility());
    }
    public MutableLiveData<String> getMessageUserObserver(){
        message=repo.getMessage();
        return message;
    }

    public MutableLiveData<House> getHouseDetailsObserver(){
        return houseDetails;
    }


    public void addHouseDetails(House model, Context context){
        repo.houseDetails(model,context);
    }

    public MutableLiveData<Migration> getMigrationDetailsObserver(){
        return migrationDetails;
    }

    public void addMigrationDetails(Migration model, Context context){
        repo.migrationDetails(model,context);
    }

    public MutableLiveData<Fertility> getFertilityDetailsObserver(){
        return fertilityDetails;
    }

    public void addFertilityDetails(Fertility model, Context context){
        repo.fertilityDetails(model,context);
    }


}
