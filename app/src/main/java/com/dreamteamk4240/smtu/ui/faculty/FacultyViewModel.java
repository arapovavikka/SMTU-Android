package com.dreamteamk4240.smtu.ui.faculty;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dreamteamk4240.smtu.ui.schedule.ScheduleViewModel;

import java.util.Objects;

public class FacultyViewModel extends ViewModel {

    private final MutableLiveData<String> mText = new MutableLiveData<>();
    private final MutableLiveData<String> department = new MutableLiveData<>();
    private final MutableLiveData<Screen> screen = new MutableLiveData<>();
    private final  MutableLiveData<Boolean> isChangeScreen = new MutableLiveData<>();
    private final  MutableLiveData<ScheduleViewModel.SwitchType> switchType = new MutableLiveData<>();

    public MutableLiveData<Screen> getScreen() {
        return screen;
    }

    public void setScreen(Screen screen){
        this.screen.setValue(screen);
    }

    public FacultyViewModel() {
    }
    public MutableLiveData<String> getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText.setValue(mText);
    }

    public LiveData<String> getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department.setValue(department);
    }

    public LiveData<String> getText() {
        return mText;
    }
    public boolean isEmpty(){
        return screen.getValue()==  null;
    }

    public LiveData<Boolean> getIsChangeScreen(){
        return isChangeScreen;
    }
    public void setIsChangeScreen(Boolean changeScreen){
        isChangeScreen.setValue(changeScreen);
    }
    public LiveData<ScheduleViewModel.SwitchType>  getSwitchType(){
        return switchType;
    }

    public boolean isReverse(){
        return  Objects.requireNonNull(switchType.getValue()).equals(ScheduleViewModel.SwitchType.REVERSE);
    }
    public void setSwitchType(ScheduleViewModel.SwitchType switchType){
        this.switchType.setValue(switchType);
    }


    public enum  Screen{
        FACULTY_DEPARTMENT_SCREEN,
        DEPARTMENT_DESCRIPTION_SCREEN,
        SPECIAL_LIST_SCREEN,
        DEPARTMENT_HISTORY_SCREEN,
        IMAGE_PERSON_SCREEN
    }
    public enum SwitchType{
        DIRECTLY,
        REVERSE
    }
}