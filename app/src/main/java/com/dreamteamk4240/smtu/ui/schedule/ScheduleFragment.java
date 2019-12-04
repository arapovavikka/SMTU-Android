package com.dreamteamk4240.smtu.ui.schedule;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamteamk4240.smtu.R;
import com.dreamteamk4240.smtu.data.DayOfWeek;
import com.dreamteamk4240.smtu.data.EducationGroup;
import com.dreamteamk4240.smtu.data.Faculty;
import com.dreamteamk4240.smtu.data.Schedule;
import com.dreamteamk4240.smtu.data.ScheduleBean;
import com.dreamteamk4240.smtu.data.ScheduleJson;
import com.dreamteamk4240.smtu.twoLevelList.FacultyAdapter;
import com.dreamteamk4240.smtu.ui.schedule.adapters.ScheduleRecyclerViewAdapter;
import com.dreamteamk4240.smtu.ui.schedule.adapters.TextRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ScheduleFragment extends Fragment {
    private static final String TAG = ScheduleFragment.class.getName();

    private ScheduleViewModel scheduleViewModel;
    private FacultyAdapter mAdapter;
    private HashMap<String, Collection<String>> map;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scheduleViewModel =
                ViewModelProviders.of(this).get(ScheduleViewModel.class);
         map=getTestDataForRecyclerView();

        View root = inflater.inflate(R.layout.fragment_schedule, container, false);
        View loadingView = inflater.inflate(R.layout.loading, container, false);
        FrameLayout frameSchedule = root.findViewById(R.id.frame_schedule);
        LinearLayout progressBar = loadingView.findViewById(R.id.progress_bar);

        //downloadData(progressBar, frameSchedule, root, scheduleViewModel);
        initFrameLayout(frameSchedule,initRecyclerTextView(root,scheduleViewModel));

        scheduleViewModel.getText().observe(this, item -> {
            Log.d(TAG, "Я получил сообщение:" + item);
            initFrameLayout(frameSchedule,initGroupTextView(root,scheduleViewModel,item));
        });
        return root;
    }

    private HashMap<String, Collection<String>> getTestDataForRecyclerView() {
        HashMap<String, Collection<String>> map = new HashMap<>();
        map.put("Факультет кораблестроения и океанографии",new ArrayList<String>(){{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("12360");
            add("12340");
        }});
        map.put("Факультет кораблестроения ",new ArrayList<String>(){{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("1280");
            add("12340");
        }});
        map.put("Факультет океанографии и дельфинов",new ArrayList<String>(){{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("12399");
            add("12340");
        }});
        map.put("Факультет кораблестроения и мореокеанов",new ArrayList<String>(){{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("1239");
            add("12340");
            add("8888");
        }});
        map.put("Факультет кораблестроения и парапланов",new ArrayList<String>(){{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("12349");
            add("12310");
        }});
        map.put("Факультет кораблестроения и машиностроения",new ArrayList<String>(){{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("12349");
            add("12320");
        }});
        map.put("Факультет кораблестроения и птицефабрики",new ArrayList<String>(){{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("12399");
            add("12340");
        }});
        map.put("Факультет кораблестроения и мореграфии",new ArrayList<String>(){{
            add("11234");
            add("12345");
            add("12347");
            add("1234128");
            add("12349");
            add("12340");
        }});
        return map;

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

    private View initRecyclerTextView(View root, ScheduleViewModel scheduleViewModel) {
        Log.d(TAG, "Initialise RecyclerView");
        RecyclerView recyclerView = new RecyclerView(root.getContext());
        TextRecyclerViewAdapter scheduleAdapter = new TextRecyclerViewAdapter(getArrayList(), root.getContext(), scheduleViewModel,true);
        recyclerView.setAdapter(scheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        return recyclerView;
    }


    private View initGroupTextView(View root, ScheduleViewModel scheduleViewModel,String key) {
        Log.d(TAG, "Initialise RecyclerView");
        RecyclerView recyclerView = new RecyclerView(root.getContext());
        TextRecyclerViewAdapter scheduleAdapter = new TextRecyclerViewAdapter((ArrayList<String>) map.get(key), root.getContext(), scheduleViewModel,false);
        recyclerView.setAdapter(scheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        return recyclerView;
    }

    private View initSchedulerTextView(View root) {
        Log.d(TAG, "Initialise RecyclerView");
        //RecyclerView recyclerView = root.findViewById(R.id.recyclerView_list);
        RecyclerView recyclerView = new RecyclerView(root.getContext());
        ScheduleRecyclerViewAdapter scheduleAdapter = new ScheduleRecyclerViewAdapter(getTestDataForSchRecyclerView(), root.getContext());
        recyclerView.setAdapter(scheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        return recyclerView;
    }


    private void downloadData(View progressBarView, FrameLayout frameLayout, View root, ScheduleViewModel scheduleViewModel) {

//        frameLayout.addView(progressBarView);
        frameLayout.removeAllViews();
        frameLayout.addView(initRecyclerTextView(root, scheduleViewModel));
        // frameLayout.addView(initRecyclerTextView(root));
    }

    private void initFrameLayout( FrameLayout frameLayout, View view) {

//        frameLayout.addView(progressBarView);
        frameLayout.removeAllViews();
        frameLayout.addView(view);
        // frameLayout.addView(initRecyclerTextView(root));
    }

    private ArrayList<String> getArrayList(){
        ArrayList<String> st = new ArrayList<>(map.keySet());
        return st;
    }


    private ArrayList<ScheduleJson> getScheduleJsonList(){
        ArrayList<ScheduleJson>  list = new ArrayList<>();
        for(int i=0;i<20;i++) {
            ScheduleBean bean = new ScheduleBean();
            bean.setSubject("Math");
            bean.setDayOfWeek(DayOfWeek.Mon);
            bean.setSubjectType("лекция");
            bean.setRoomNumber("Б453");
            bean.setTeacher("Петров Игорь Петрович");
            bean.setTimeFrom("10:30");
            bean.setTimeTo("11:15");
            ScheduleJson scheduleJson = new ScheduleJson();
            scheduleJson.setFaculty(new Faculty(String.valueOf(i),"Факультет"+i));
            scheduleJson.setEducationGroup(new EducationGroup(String.valueOf(i),"K4567"));
            scheduleJson.setScheduleBean(bean);
            list.add(scheduleJson);
        }
        return list;
    }

}