package com.dreamteamk4240.smtu.ui.schedule;

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
import com.dreamteamk4240.smtu.service.DayOfWeekConverter;

import java.util.ArrayList;

public class ScheduleRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleRecyclerViewAdapter.ScheduleRecyclerViewHolder> {
    private ArrayList<Schedule> schedules;
    private static final String TAG = ScheduleRecyclerViewAdapter.class.getName();
    private Context context;
    private DayOfWeekConverter dayOfWeekConverter;

    public ScheduleRecyclerViewAdapter(ArrayList<Schedule> faculties, Context context) {
        dayOfWeekConverter = new DayOfWeekConverter(context.getResources().getStringArray(R.array.day_of_weeks));
        this.schedules = faculties;
        this.context = context;
    }


    @NonNull
    @Override
    public ScheduleRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule, parent, false);
        ScheduleRecyclerViewHolder ScheduleRecyclerViewHolder = new ScheduleRecyclerViewHolder(view);

        return ScheduleRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleRecyclerViewHolder holder, final int position) {

        holder.subjectName.setText(schedules.get(position).getSubjectName());
        holder.subjectType.setText(schedules.get(position).getSubjectType());
        holder.timeTable.setText(schedules.get(position).getTime());
        holder.teacherName.setText(schedules.get(position).getTeacherName());
        holder.auditoryName.setText(schedules.get(position).getAuditoryName());

        holder.dayOfWeekImage.setText(dayOfWeekConverter.getNameByDayOfWeek(schedules.get(position).getDayOfWeekImage()));

        holder.schedule_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked on " + position + " position");
            }
        });
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }


    public class ScheduleRecyclerViewHolder extends RecyclerView.ViewHolder {
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