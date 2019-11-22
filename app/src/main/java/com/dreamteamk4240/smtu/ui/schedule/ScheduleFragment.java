package com.dreamteamk4240.smtu.ui.schedule;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamteamk4240.smtu.R;
import com.dreamteamk4240.smtu.data.DayOfWeek;
import com.dreamteamk4240.smtu.data.Schedule;

import java.util.ArrayList;

public class ScheduleFragment extends Fragment {
    private static final String TAG = ScheduleFragment.class.getName();

    private ScheduleViewModel scheduleViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scheduleViewModel =
                ViewModelProviders.of(this).get(ScheduleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_schedule, container, false);
        initRecyclerTextView(root);
//        final TextView textView = root.findViewById(R.id.text_schedule);
//        scheduleViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    private ArrayList<String> getTestDataForRecyclerView() {
        return new ArrayList<String>() {{
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");
            add("Communication");
            add("Computer");
            add("Engineer");
            add("Economy");

        }};

    }

    private ArrayList<Schedule> getTestDataForSchRecyclerView() {
        ArrayList<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        schedules.add(new Schedule("Математика",
                "Лекция", DayOfWeek.Mon, "14:30", "Никаноров П.П.", "Б-414"));
        return schedules;


    }

    private void initRecyclerTextView(View root) {
        Log.d(TAG, "Initialise RecyclerView");
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView_list);
        TextRecyclerViewAdapter scheduleAdapter = new TextRecyclerViewAdapter(getTestDataForRecyclerView(), root.getContext());
        recyclerView.setAdapter(scheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
    }

    private void initSchedulerTextView(View root) {
        Log.d(TAG, "Initialise RecyclerView");
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView_list);
        ScheduleRecyclerViewAdapter scheduleAdapter = new ScheduleRecyclerViewAdapter(getTestDataForSchRecyclerView(), root.getContext());
        recyclerView.setAdapter(scheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
    }

}