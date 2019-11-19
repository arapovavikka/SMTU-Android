package com.dreamteamk4240.smtu.ui.contacts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class СontactsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public СontactsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Раздел Контакты");
    }

    public LiveData<String> getText() {
        return mText;
    }
}