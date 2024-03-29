package com.dreamteamk4240.smtu.ui.schedule.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamteamk4240.smtu.R;
import com.dreamteamk4240.smtu.data.Schedule;
import com.dreamteamk4240.smtu.data.ScheduleTest;
import com.dreamteamk4240.smtu.service.DayOfWeekConverter;
import com.dreamteamk4240.smtu.ui.schedule.ScheduleViewModel;

import java.util.ArrayList;
import java.util.UUID;

public class ScheduleRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleRecyclerViewAdapter.ScheduleRecyclerViewHolder> {
    private ArrayList<ScheduleTest> schedules;
    private static final String TAG = ScheduleRecyclerViewAdapter.class.getName();
    private Context context;
    private DayOfWeekConverter dayOfWeekConverter;
    private ScheduleViewModel scheduleViewModel;
    private UUID groupNumber;

    public ScheduleRecyclerViewAdapter(ArrayList<ScheduleTest> scheduleTests, Context context, ScheduleViewModel scheduleViewModel, UUID groupNumber) {
        dayOfWeekConverter = new DayOfWeekConverter(context.getResources().getStringArray(R.array.day_of_weeks));
        this.schedules = scheduleTests;
        this.context = context;
        this.scheduleViewModel = scheduleViewModel;
        this.groupNumber = groupNumber;
        scheduleViewModel.setScreen(ScheduleViewModel.Screen.SCHEDULE_LIST_SCREEN);
        scheduleViewModel.setSwitchType(ScheduleViewModel.SwitchType.DIRECTLY);
        scheduleViewModel.setIsChangeScreen(false);

    }


    @NonNull
    @Override
    public ScheduleRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule, parent, false);

        return new ScheduleRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleRecyclerViewHolder holder, final int position) {

        holder.subjectName.setText(schedules.get(position).getSubjectTest().getName());
        holder.subjectType.setText(schedules.get(position).getSubjectTest().getSubjType());
        holder.timeTable.setText(schedules.get(position).getTime());
        holder.teacherName.setText(schedules.get(position).getTeacherName());
        holder.auditoryName.setText(schedules.get(position).getPlaceName());

        holder.dayOfWeekImage.setText(dayOfWeekConverter.getNameByDayOfWeek(schedules.get(position).getDayOfWeek()));

        holder.schedule_item.setOnClickListener(v -> {
            Log.d(TAG, "Clicked on " + position + " position");
            scheduleViewModel.setSchedule(null);
            //scheduleViewModel.setScreen(ScheduleViewModel.Screen.SCHEDULE_LIST_SCREEN);
        });
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }


    protected class ScheduleRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView subjectName;
        private TextView subjectType;
        private TextView timeTable;
        private TextView teacherName;
        private TextView auditoryName;


        private Button dayOfWeekImage;

        private ConstraintLayout schedule_item;


        public ScheduleRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.subject_name);
            subjectType = itemView.findViewById(R.id.subject_type);
            timeTable = itemView.findViewById(R.id.time_table);
            teacherName = itemView.findViewById(R.id.teacher_name);
            auditoryName = itemView.findViewById(R.id.auditory_name);

            dayOfWeekImage = itemView.findViewById(R.id.day_of_week_image);
            schedule_item = itemView.findViewById(R.id.schedule_item);
        }
    }


}