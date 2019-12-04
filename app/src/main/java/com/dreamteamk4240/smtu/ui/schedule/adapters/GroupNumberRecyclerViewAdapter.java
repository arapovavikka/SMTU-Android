package com.dreamteamk4240.smtu.ui.schedule.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.dreamteamk4240.smtu.ui.schedule.ScheduleViewModel;

import java.util.ArrayList;

public class GroupNumberRecyclerViewAdapter extends TextRecyclerViewAdapter {
    public GroupNumberRecyclerViewAdapter(ArrayList<String> datas, Context context, ScheduleViewModel scheduleViewModel) {
        super(datas, context, scheduleViewModel);
    }

    @Override
    void onClickAction(View v, int position) {
        Log.d(TAG,"Clicked on "+position+" position");
        scheduleViewModel.setGroupNumber(datas.get(position));
        scheduleViewModel.setScreen(ScheduleViewModel.Screen.GROUP_LIST_SCREEN);
    }
}
