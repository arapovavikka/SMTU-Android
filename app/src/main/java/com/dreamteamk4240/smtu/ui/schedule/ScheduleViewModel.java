package com.dreamteamk4240.smtu.ui.schedule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dreamteamk4240.smtu.data.EducationTypeTest;
import com.dreamteamk4240.smtu.data.ScheduleJson;

import java.util.Objects;
import java.util.UUID;

public class ScheduleViewModel extends ViewModel {

    private final  MutableLiveData<String> mText = new MutableLiveData<>();
    private final  MutableLiveData<UUID> faculty = new MutableLiveData<>();
    private final  MutableLiveData<UUID> groupNumber = new MutableLiveData<>();
    private final  MutableLiveData<ScheduleJson> scheduleJson = new MutableLiveData<>();
    private final  MutableLiveData<Screen> screen = new MutableLiveData<>();
    private final  MutableLiveData<Boolean> isChangeScreen = new MutableLiveData<>();
    private final  MutableLiveData<SwitchType> switchType = new MutableLiveData<>();
    private final  MutableLiveData<Integer> courseNumber = new MutableLiveData<>();
    private final  MutableLiveData<WeekType> weekType = new MutableLiveData<>();
    private final  MutableLiveData<EducationTypeTest> educationType = new MutableLiveData<>();

    public MutableLiveData<EducationTypeTest> getEducationType() {
        return educationType;
    }

    public void setEducationType(EducationTypeTest educationType) {
         this.educationType.setValue(educationType);
    }

    public MutableLiveData<WeekType> getWeekType() {
        return weekType;
    }
    public void setWeekType(WeekType weekType) {
         this.weekType.setValue(weekType);
    }


    public LiveData<Integer> getCourseNumber() {
        return courseNumber;
    }
    public ScheduleViewModel() {
    }

    public void setCourseNumber(int courseNumber){
        this.courseNumber.setValue(courseNumber);
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<UUID> getFaculty() {
        return faculty;
    }
    public void setFaculty(UUID faculty){
        this.faculty.setValue(faculty);
    }
    public LiveData<UUID> getGroupNumber() {
        return groupNumber;
    }
    public void setGroupNumber(UUID groupNumber){
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
        FACULTY_LIST_SCREEN,
        GROUP_LIST_SCREEN,
        SCHEDULE_LIST_SCREEN
    }
    public enum SwitchType{
        DIRECTLY,
        REVERSE
    }
    public enum WeekType{
        UP,
        DOWN
    }


}