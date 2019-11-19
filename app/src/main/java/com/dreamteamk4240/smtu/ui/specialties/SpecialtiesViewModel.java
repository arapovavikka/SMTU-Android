package com.dreamteamk4240.smtu.ui.specialties;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SpecialtiesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SpecialtiesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Раздел Направления подготовки");
    }

    public LiveData<String> getText() {
        return mText;
    }
}