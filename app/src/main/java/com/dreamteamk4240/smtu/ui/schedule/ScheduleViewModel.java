package com.dreamteamk4240.smtu.ui.schedule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dreamteamk4240.smtu.data.ScheduleJson;

import java.util.Objects;

public class ScheduleViewModel extends ViewModel {

    private final  MutableLiveData<String> mText = new MutableLiveData<>();
    private final  MutableLiveData<String> faculty = new MutableLiveData<>();
    private final  MutableLiveData<String> groupNumber = new MutableLiveData<>();
    private final  MutableLiveData<ScheduleJson> scheduleJson = new MutableLiveData<>();
    private final  MutableLiveData<Screen> screen = new MutableLiveData<>();
    private final  MutableLiveData<Boolean> isChangeScreen = new MutableLiveData<>();
    private final  MutableLiveData<SwitchType> switchType = new MutableLiveData<>();



    public ScheduleViewModel() {
    }

    public LiveData<String> getText() {
        return mText;
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

    public  boolean isEmpty(){
        return screen.getValue()==  null;
    }
    public LiveData<Boolean> getIsChangeScreen(){
        return isChangeScreen;
    }
    public void setIsChangeScreen(Boolean changeScreen){
        isChangeScreen.setValue(changeScreen);
    }
    public LiveData<SwitchType>  getSwitchType(){
        return switchType;
    }

    public boolean isReverse(){
        return  Objects.requireNonNull(switchType.getValue()).equals(SwitchType.REVERSE);
    }
    public void setSwitchType(SwitchType switchType){
        this.switchType.setValue(switchType);
    }


    public enum  Screen{
        EMPTY_SCREEN,
        FACULTY_LIST_SCREEN,
        GROUP_LIST_SCREEN,
        SCHEDULE_LIST_SCREEN
    }
    public enum SwitchType{
        DIRECTLY,
        REVERSE
    }


}