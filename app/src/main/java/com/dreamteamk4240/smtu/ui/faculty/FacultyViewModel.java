package com.dreamteamk4240.smtu.ui.faculty;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FacultyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FacultyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Раздел Факультеты и кафедры");
    }

    public LiveData<String> getText() {
        return mText;
    }
}