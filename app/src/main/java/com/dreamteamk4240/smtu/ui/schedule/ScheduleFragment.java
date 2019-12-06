package com.dreamteamk4240.smtu.ui.schedule;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
import com.dreamteamk4240.smtu.interfaces.BackButtonClick;
import com.dreamteamk4240.smtu.ui.schedule.adapters.FacultyRecyclerViewAdapter;
import com.dreamteamk4240.smtu.ui.schedule.adapters.GroupNumberRecyclerViewAdapter;
import com.dreamteamk4240.smtu.ui.schedule.adapters.ScheduleRecyclerViewAdapter;
import com.dreamteamk4240.smtu.ui.schedule.adapters.TextRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class ScheduleFragment extends Fragment implements BackButtonClick {
    private static final String TAG = ScheduleFragment.class.getName();

    private ScheduleViewModel scheduleViewModel;
    private HashMap<String, Collection<String>> map;
    private View root ;
    private  HorizontalScrollView scroll ;
    private  LayoutInflater inflater ;
    private  ViewGroup container ;
    private View upperButtonsView;
    private LinearLayout upper_button_include;
    private View two_button;
    private View four_button;
    private View three_button;
    private FrameLayout frameSchedule;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scheduleViewModel =
                ViewModelProviders.of(this).get(ScheduleViewModel.class);
        map = getTestDataForRecyclerView();
        this.inflater = inflater;
        this.container = container;

         root = inflater.inflate(R.layout.fragment_schedule, container, false);
        View loadingView = inflater.inflate(R.layout.loading, container, false);
         frameSchedule = root.findViewById(R.id.frame_schedule);
        upper_button_include= root.findViewById(R.id.upper_button_include);
        two_button = inflater.inflate(R.layout.navigation_item, container, false);
        four_button = inflater.inflate(R.layout.four_buttons, container, false);
        three_button = inflater.inflate(R.layout.three_buttons, container, false);
        //upperButtonsView = getUpperButtonsView();
       // initUpperButtons("","");
        //frameSchedule.addView(scroll);
        //LinearLayout progressBar = loadingView.findViewById(R.id.progress_bar);
        initThreeUpperButtons(new ArrayList<>(Arrays.asList("Бакалавриат","Специалитет","Магистратура")));
       checkViewModel();

        return root;
    }
    private View getUpperButtonsView() {
        return   root.findViewById(R.id.upper_button_include);
    }

    private HashMap<String, Collection<String>> getTestDataForRecyclerView() {
        HashMap<String, Collection<String>> map = new HashMap<>();
        map.put("Факультет кораблестроения и океанографии", new ArrayList<String>() {{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("12360");
            add("12340");
        }});
        map.put("Факультет кораблестроения ", new ArrayList<String>() {{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("1280");
            add("12340");
        }});
        map.put("Факультет океанографии и океанографии", new ArrayList<String>() {{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("12399");
            add("12340");
        }});
        map.put("Факультет кораблестроения и строениякорабле", new ArrayList<String>() {{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("1239");
            add("12340");
            add("8888");
        }});
        map.put("Факультет кораблестроения и самолетостроения", new ArrayList<String>() {{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("12349");
            add("12310");
        }});
        map.put("Факультет кораблестроения и машиностроения", new ArrayList<String>() {{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("12349");
            add("12320");
        }});
        map.put("Факультет кораблестроения и шатлостроения", new ArrayList<String>() {{
            add("11234");
            add("12345");
            add("12347");
            add("12348");
            add("12399");
            add("12340");
        }});
        map.put("Факультет кораблестроения и подлодкостроения", new ArrayList<String>() {{
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

    private View initFacultyRecyclerTextView(View root, ScheduleViewModel scheduleViewModel) {
        Log.d(TAG, "Initialise RecyclerView");
        RecyclerView recyclerView = new RecyclerView(root.getContext());
        TextRecyclerViewAdapter scheduleAdapter = new FacultyRecyclerViewAdapter(getArrayList(), root.getContext(), scheduleViewModel);
        recyclerView.setAdapter(scheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        return recyclerView;
    }


    private View initGroupTextView(View root, ScheduleViewModel scheduleViewModel) {
        int courseNumber = scheduleViewModel.getCourseNumber().getValue();
        Log.d(TAG, "Initialise RecyclerView");
        scheduleViewModel.setWeekType(ScheduleViewModel.WeekType.UP);
        RecyclerView recyclerView = new RecyclerView(root.getContext());
        TextRecyclerViewAdapter scheduleAdapter = new GroupNumberRecyclerViewAdapter((ArrayList<String>) map.get(scheduleViewModel.getFaculty().getValue()), root.getContext(), scheduleViewModel);
        recyclerView.setAdapter(scheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        return recyclerView;
    }

    private View initSchedulerTextView(View root, ScheduleViewModel scheduleViewModel) {
        Log.d(TAG, "Initialise RecyclerView");
        ScheduleViewModel.WeekType weekType = scheduleViewModel.getWeekType().getValue();
        //RecyclerView recyclerView = root.findViewById(R.id.recyclerView_list);
        RecyclerView recyclerView = new RecyclerView(root.getContext());
        ScheduleRecyclerViewAdapter scheduleAdapter = new ScheduleRecyclerViewAdapter(getTestDataForSchRecyclerView(), root.getContext(), scheduleViewModel, scheduleViewModel.getGroupNumber().getValue());
        recyclerView.setAdapter(scheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        return recyclerView;
    }


    private void downloadData(View progressBarView, FrameLayout frameLayout, View root, ScheduleViewModel scheduleViewModel) {

//        frameLayout.addView(progressBarView);
        frameLayout.removeAllViews();
        frameLayout.addView(initFacultyRecyclerTextView(root, scheduleViewModel));
        // frameLayout.addView(initRecyclerTextView(root));
    }

    private void initFrameLayout(FrameLayout frameLayout, View view) {

//        frameLayout.addView(progressBarView);
        frameLayout.removeAllViews();
        frameLayout.addView(view);
        // frameLayout.addView(initRecyclerTextView(root));
    }

    private ArrayList<String> getArrayList() {
        return new ArrayList<>(map.keySet());
    }


    private ArrayList<ScheduleJson> getScheduleJsonList() {
        ArrayList<ScheduleJson> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ScheduleBean bean = new ScheduleBean();
            bean.setSubject("Math");
            bean.setDayOfWeek(DayOfWeek.Mon);
            bean.setSubjectType("лекция");
            bean.setRoomNumber("Б453");
            bean.setTeacher("Петров Игорь Петрович");
            bean.setTimeFrom("10:30");
            bean.setTimeTo("11:15");
            ScheduleJson scheduleJson = new ScheduleJson();
            scheduleJson.setFaculty(new Faculty(String.valueOf(i), "Факультет" + i));
            scheduleJson.setEducationGroup(new EducationGroup(String.valueOf(i), "K4567"));
            scheduleJson.setScheduleBean(bean);
            list.add(scheduleJson);
        }
        return list;
    }

    private void checkViewModel() {
        if (scheduleViewModel.isEmpty()) {
            initThreeUpperButtons(new ArrayList<>(Arrays.asList("Бакалавриат","Специалитет","Магистратура")));
            initFrameLayout(frameSchedule, initFacultyRecyclerTextView(root, scheduleViewModel));

        }
        scheduleViewModel.getIsChangeScreen().observe(this, item -> {
           if (item) {
                switch (Objects.requireNonNull(scheduleViewModel.getScreen().getValue())) {
                    case FACULTY_LIST_SCREEN: {
                       // Toast.makeText(root.getContext(), "faculty_list_screen", Toast.LENGTH_SHORT).show();
                        if(scheduleViewModel.isReverse()){
                          throw new IllegalArgumentException("Type cannot reverse with FACULTY_LIST_SCREEN");
                        }else {
                            initFourUpperButtons(new ArrayList<>(Arrays.asList("1 курс","2 курс","3 курс","4 курс")));
                            initFrameLayout(frameSchedule, initGroupTextView(root, scheduleViewModel));

                        }
                        break;
                    }
                    case GROUP_LIST_SCREEN: {
                       // Toast.makeText(root.getContext(), "group_list_screen", Toast.LENGTH_SHORT).show();
                        if(scheduleViewModel.isReverse()) {
                            initThreeUpperButtons(new ArrayList<>(Arrays.asList("Бакалавриат","Специалитет","Магистратура")));
                            initFrameLayout(frameSchedule, initFacultyRecyclerTextView(root, scheduleViewModel));
                        }else {
                            initTwoUpperButtons(new ArrayList<>(Arrays.asList("Верхняя","Нижняя")));
                            initFrameLayout(frameSchedule, initSchedulerTextView(root, scheduleViewModel));

                        }
                        break;
                    }

                    case SCHEDULE_LIST_SCREEN: {
                       // Toast.makeText(root.getContext(), "schedule_list_screen", Toast.LENGTH_SHORT).show();
                        if(scheduleViewModel.isReverse()) {
                            initFourUpperButtons(new ArrayList<>(Arrays.asList("1 курс","2 курс","3 курс","4 курс")));
                            initFrameLayout(frameSchedule, initGroupTextView(root, scheduleViewModel));
                        }else {
                           // initFrameLayout(frameSchedule, initFacultyRecyclerTextView(root, scheduleViewModel));
                        }
                        break;
                    }
                    default:
                      //  Toast.makeText(root.getContext(), "ERROR", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void initThreeUpperButtons(ArrayList<String> buttonsText) {
        if(buttonsText.size()==3) {
            Button button1 = three_button.findViewById(R.id.button_nav_1);
            Button button2 = three_button.findViewById(R.id.button_nav_2);
            Button button3 = three_button.findViewById(R.id.button_nav_3);

            button1.setText(buttonsText.get(0));
            button2.setText(buttonsText.get(1));
            button3.setText(buttonsText.get(2));
            button1.setSelected(true);
            button2.setFocusable(false);
            button3.setFocusable(false);
//            button1.setOnClickListener(v->{
//                Toast.makeText(root.getContext(),"pressed 1", Toast.LENGTH_SHORT).show();
//            });
//            button2.setOnClickListener(v->{
//                Toast.makeText(root.getContext(),"pressed 2", Toast.LENGTH_SHORT).show();
//            });
//            button3.setOnClickListener(v->{
//                Toast.makeText(root.getContext(),"pressed 3", Toast.LENGTH_SHORT).show();
//            });
            upper_button_include.removeAllViews();
            upper_button_include.addView(three_button);
        }
    }

    private void initTwoUpperButtons(ArrayList<String> buttonsText) {
        if(buttonsText.size()==2) {
            Button button1 = two_button.findViewById(R.id.navigation_button_1);
            Button button2 = two_button.findViewById(R.id.navigation_button_2);

            button1.setText(buttonsText.get(0));
            button2.setText(buttonsText.get(1));
            scheduleViewModel.setWeekType(ScheduleViewModel.WeekType.UP);
            button1.setOnClickListener(v->{
                if(scheduleViewModel.getWeekType().getValue().equals(ScheduleViewModel.WeekType.DOWN)) {
                    scheduleViewModel.setWeekType(ScheduleViewModel.WeekType.UP);
                    initFrameLayout(frameSchedule, initSchedulerTextView(root, scheduleViewModel));
                    Toast.makeText(root.getContext(), "pressed UP", Toast.LENGTH_SHORT).show();
                }
            });
            button2.setOnClickListener(v-> {
                if (scheduleViewModel.getWeekType().getValue().equals(ScheduleViewModel.WeekType.UP)) {
                    scheduleViewModel.setWeekType(ScheduleViewModel.WeekType.DOWN);
                    initFrameLayout(frameSchedule, initSchedulerTextView(root, scheduleViewModel));
                    Toast.makeText(root.getContext(), "pressed DOWN", Toast.LENGTH_SHORT).show();
                }
            });
            upper_button_include.removeAllViews();
            upper_button_include.addView(two_button);
        }
    }
    private void initFourUpperButtons(ArrayList<String> buttonsText) {
        if(buttonsText.size()==4) {
            Button button1 = four_button.findViewById(R.id.nav_1);
            Button button2 = four_button.findViewById(R.id.nav_2);
            Button button3 = four_button.findViewById(R.id.nav_3);
            Button button4 = four_button.findViewById(R.id.nav_4);

                    button1.setText(buttonsText.get(0));
                    button2.setText(buttonsText.get(1));
                    button3.setText(buttonsText.get(2));
                    button4.setText(buttonsText.get(3));
                   scheduleViewModel.setCourseNumber(1);
                    button1.setOnClickListener(v->{
                        if(scheduleViewModel.getCourseNumber().getValue()!=1) {
                            Toast.makeText(root.getContext(), "prev courseNumber" +
                                    scheduleViewModel.getCourseNumber().getValue(), Toast.LENGTH_SHORT).show();
                            scheduleViewModel.setCourseNumber(1);
                            initFrameLayout(frameSchedule, initGroupTextView(root, scheduleViewModel));
                        }});
            button2.setOnClickListener(v->{
                if(scheduleViewModel.getCourseNumber().getValue()!=2) {
                Toast.makeText(root.getContext(),"prev courseNumber" +
                                scheduleViewModel.getCourseNumber().getValue(), Toast.LENGTH_SHORT).show();
                scheduleViewModel.setCourseNumber(2);
                initFrameLayout(frameSchedule, initGroupTextView(root, scheduleViewModel));
            }});
            button3.setOnClickListener(v->{
                if(scheduleViewModel.getCourseNumber().getValue()!=3) {
                Toast.makeText(root.getContext(),"prev courseNumber" +
                        scheduleViewModel.getCourseNumber().getValue(), Toast.LENGTH_SHORT).show();
                scheduleViewModel.setCourseNumber(3);
                initFrameLayout(frameSchedule, initGroupTextView(root, scheduleViewModel));
            }});
            button4.setOnClickListener(v->{
                if(scheduleViewModel.getCourseNumber().getValue()!=4) {
                    Toast.makeText(root.getContext(), "prev courseNumber" +
                            scheduleViewModel.getCourseNumber().getValue(), Toast.LENGTH_SHORT).show();
                    scheduleViewModel.setCourseNumber(4);
                    initFrameLayout(frameSchedule, initGroupTextView(root, scheduleViewModel));
                }});
            upper_button_include.removeAllViews();
            upper_button_include.addView(four_button);
        }
    }


    @Override
    public boolean onBackPressed() {
        ScheduleViewModel.Screen screen = scheduleViewModel.getScreen().getValue();
        Log.d(TAG, "backPressed in ScheduleFragment");
        scheduleViewModel.setSwitchType(ScheduleViewModel.SwitchType.REVERSE);
        switch (Objects.requireNonNull(screen)) {
            case SCHEDULE_LIST_SCREEN: {
                scheduleViewModel.setSchedule(null);
                Log.d(TAG, Objects.requireNonNull(scheduleViewModel.getGroupNumber().getValue()));
                scheduleViewModel.setIsChangeScreen(true);
                return false;

            }
            case FACULTY_LIST_SCREEN: {
                scheduleViewModel.setFaculty("");

                return true;
            }
            case GROUP_LIST_SCREEN: {
                scheduleViewModel.setGroupNumber("");
                Log.d(TAG, Objects.requireNonNull(scheduleViewModel.getFaculty().getValue()));
                scheduleViewModel.setIsChangeScreen(true);
                return false;
            }
            default:return false;

        }

    }
}