package com.dreamteamk4240.smtu.ui.schedule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dreamteamk4240.smtu.data.ScheduleJson;

public class ScheduleViewModel extends ViewModel {

    private final  MutableLiveData<String> mText =new MutableLiveData<String>();
    private final  MutableLiveData<String> faculty =new MutableLiveData<String>();
    private final  MutableLiveData<String> groupNumber =new MutableLiveData<String>();
    private final  MutableLiveData<ScheduleJson> scheduleJson =new MutableLiveData<ScheduleJson>();

    public ScheduleViewModel() {
    }

    public LiveData<String> getText() {
        return mText;
    }
    public void setmText(String type){
        mText.setValue(type);
    }

    public LiveData<ScheduleJson> getSchedule(){return scheduleJson;}
    public void setSchedule(ScheduleJson schedule){scheduleJson.setValue(schedule);}
}