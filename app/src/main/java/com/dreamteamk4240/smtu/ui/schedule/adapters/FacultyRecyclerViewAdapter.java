package com.dreamteamk4240.smtu.ui.schedule.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.dreamteamk4240.smtu.ui.schedule.ScheduleViewModel;

import java.util.ArrayList;

public class FacultyRecyclerViewAdapter extends TextRecyclerViewAdapter  {


    public FacultyRecyclerViewAdapter(ArrayList<String> datas, Context context, ScheduleViewModel scheduleViewModel) {
        super(datas, context, scheduleViewModel);
        scheduleViewModel.setScreen(ScheduleViewModel.Screen.FACULTY_LIST_SCREEN);
    }

    @Override
    void onClickAction(View v,final int position) {
        Log.d(TAG,"Clicked on "+position+" position");

        scheduleViewModel.setFaculty(datas.get(position));
        scheduleViewModel.setIsChangeScreen(true);

    }
}
