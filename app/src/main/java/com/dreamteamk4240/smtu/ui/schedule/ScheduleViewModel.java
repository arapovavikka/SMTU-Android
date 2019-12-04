package com.dreamteamk4240.smtu.ui.schedule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dreamteamk4240.smtu.data.ScheduleJson;

public class ScheduleViewModel extends ViewModel {

    private final  MutableLiveData<String> mText = new MutableLiveData<>();
    private final  MutableLiveData<String> faculty = new MutableLiveData<>();
    private final  MutableLiveData<String> groupNumber = new MutableLiveData<>();
    private final  MutableLiveData<ScheduleJson> scheduleJson = new MutableLiveData<>();
    private final  MutableLiveData<Screen> screen = new MutableLiveData<>();


    public ScheduleViewModel() {
    }

    public LiveData<String> getText() {
        return mText;
    }
    public void setmText(String type){
        mText.setValue(type);
    }
    public LiveData<String> getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty){
        this.faculty.setValue(faculty);
    }
    public LiveData<String> getGroupNumber() {
        return groupNumber;
    }
    public void setGroupNumber(String groupNumber){
        this.groupNumber.setValue(groupNumber);
    }
    public LiveData<ScheduleJson> getSchedule(){return scheduleJson;}
    public void setSchedule(ScheduleJson schedule){scheduleJson.setValue(schedule);}

    public void setScreen(Screen screen ){
        this.screen.setValue(screen);
    }
    public LiveData<Screen> getScreen(){
       return screen;
    }


    public enum  Screen{
        FACULTY_LIST_SCREEN,
        GROUP_LIST_SCREEN,
        SCHEDULE_LIST_SCREEN
    }


}