package com.dreamteamk4240.smtu.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamteamk4240.smtu.R;
import com.dreamteamk4240.smtu.data.PersonImage;
import com.dreamteamk4240.smtu.interfaces.BackButtonClick;
import com.dreamteamk4240.smtu.twoLevelList.Department;
import com.dreamteamk4240.smtu.twoLevelList.ExpandableRecyclerAdapter;
import com.dreamteamk4240.smtu.twoLevelList.FacultyItem;
import com.dreamteamk4240.smtu.ui.faculty.recyclerView.EducationTypeAdapter;
import com.dreamteamk4240.smtu.ui.faculty.recyclerView.FacultyAdapter;
import com.dreamteamk4240.smtu.ui.faculty.recyclerView.ImageRecyclerViewAdapter;
import com.dreamteamk4240.smtu.ui.schedule.ScheduleViewModel;

import java.util.ArrayList;
import java.util.Objects;

public class FacultyFragment extends Fragment implements BackButtonClick {

    private FacultyViewModel facultyViewModel;
    private ExpandableRecyclerAdapter mAdapter;
    private LayoutInflater inflater;
    private ViewGroup container;
    private View root;
    private View mainDepartmentView;
    private FrameLayout frameDepartment;
    private FrameLayout frameFaculty;

    private final String TAG = FacultyFragment.class.getName();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        facultyViewModel =
                ViewModelProviders.of(this).get(FacultyViewModel.class);
        this.inflater = inflater;
        this.container = container;
        root = inflater.inflate(R.layout.fragment_faculty, container, false);
        frameFaculty = root.findViewById(R.id.faculty_frame);
        mainDepartmentView = inflateMainDepartmentView();
        frameDepartment = mainDepartmentView.findViewById(R.id.frame_department);
        checkViewModel();

//        getViewAboutDepartment( FacultyViewModel.Screen.DEPARTMENT_HISTORY_SCREEN);
//        initFrameLayout(frameFaculty, mainDepartmentView);
        // checkViewModel(root, frameFaculty);
        // LinearLayout progressBar = loadingView.findViewById(R.id.progress_bar);
        //downloadData(progressBar, frameFaculty, root);
        // frameFaculty.removeAllViews();
        // frameLayout.addView(initRecyclerTextView(root));
        // frameFaculty.addView(getViewDepartmentDescription( ));
        // View loadingView = inflater.inflate(R.layout.loading, container, false);

        return root;
    }

    private void checkViewModel() {
        if (facultyViewModel.isEmpty()) {
            initFrameLayout(frameFaculty, getFacultyAndDepartmentView(root.getContext()));
        }
        facultyViewModel.getIsChangeScreen().observe(this, item -> {
            if (item) {
                switch (Objects.requireNonNull(facultyViewModel.getScreen().getValue())) {
                    case FACULTY_DEPARTMENT_SCREEN: {
                        // Toast.makeText(root.getContext(), "faculty_department_screen", Toast.LENGTH_SHORT).show();
                        if (facultyViewModel.isReverse()) {
                            throw new IllegalArgumentException("Type cannot reverse with FACULTY_LIST_SCREEN");
                        } else {
                            getViewDepartmentDescription(FacultyViewModel.Screen.DEPARTMENT_DESCRIPTION_SCREEN);
                            initFrameLayout(frameFaculty, mainDepartmentView);

                        }
                        break;
                    }
                    case DEPARTMENT_DESCRIPTION_SCREEN: {
                        //Toast.makeText(root.getContext(), "DEPARTMENT_DESCRIPTION_SCREEN", Toast.LENGTH_SHORT).show();
                        if (facultyViewModel.isReverse()) {
                            initFrameLayout(frameFaculty, getFacultyAndDepartmentView(root.getContext()));
                        } else {
                            getSpecialiseListScreen(root.getContext(), FacultyViewModel.Screen.SPECIAL_LIST_SCREEN);
                            initFrameLayout(frameFaculty, mainDepartmentView);
                        }
                        break;
                    }

                    case SPECIAL_LIST_SCREEN: {
                        // Toast.makeText(root.getContext(), "schedule_list_screen", Toast.LENGTH_SHORT).show();
                        if (facultyViewModel.isReverse()) {
                            getViewDepartmentDescription(FacultyViewModel.Screen.DEPARTMENT_DESCRIPTION_SCREEN);
                        } else {
                            getViewAboutDepartment(FacultyViewModel.Screen.DEPARTMENT_HISTORY_SCREEN);

                        }
                        initFrameLayout(frameFaculty, mainDepartmentView);
                        break;
                    }
                    case DEPARTMENT_HISTORY_SCREEN: {
                        // Toast.makeText(root.getContext(), "schedule_list_screen", Toast.LENGTH_SHORT).show();
                        if (facultyViewModel.isReverse()) {
                            getSpecialiseListScreen(root.getContext(), FacultyViewModel.Screen.SPECIAL_LIST_SCREEN);

                        } else {
                            getImageRecyclerView(root.getContext(), FacultyViewModel.Screen.IMAGE_PERSON_SCREEN);
                        }
                        initFrameLayout(frameFaculty, mainDepartmentView);
                        break;
                    }
                    case IMAGE_PERSON_SCREEN: {
                        // Toast.makeText(root.getContext(), "schedule_list_screen", Toast.LENGTH_SHORT).show();
                        if (facultyViewModel.isReverse()) {
                            getViewAboutDepartment(FacultyViewModel.Screen.DEPARTMENT_HISTORY_SCREEN);
                        } else {
                            // initFrameLayout(frameSchedule, initFacultyRecyclerTextView(root, scheduleViewModel));
                        }
                        initFrameLayout(frameFaculty, mainDepartmentView);
                        break;
                    }
                    default:
                        //  Toast.makeText(root.getContext(), "ERROR", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void initFrameLayout(FrameLayout frameLayout, View view) {

//        frameLayout.addView(progressBarView);
        frameLayout.removeAllViews();
        frameLayout.addView(view);
        // frameLayout.addView(initRecyclerTextView(root));
    }

    private View getFacultyAndDepartmentView(final Context context) {
        ArrayList<Department> departmentList = new ArrayList<>();
        ArrayList<FacultyItem> facultyList = new ArrayList<>();
        departmentList.add(new Department("Кафедра 1"));
        departmentList.add(new Department("Кафедра 2"));
        departmentList.add(new Department("Кафедра 3"));
        departmentList.add(new Department("Кафедра 4"));
        departmentList.add(new Department("Кафедра 5"));

        facultyList.add(new FacultyItem("Факультет1", departmentList));
        facultyList.add(new FacultyItem("Факультет2", departmentList));
        facultyList.add(new FacultyItem("Факультет3", departmentList));
        facultyList.add(new FacultyItem("Факультет4", departmentList));
        facultyList.add(new FacultyItem("Факультет5", departmentList));
        facultyList.add(new FacultyItem("Факультет6", departmentList));

        RecyclerView recyclerView = new RecyclerView(context);
        mAdapter = new FacultyAdapter(context, facultyList, facultyViewModel);
        mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {
                FacultyItem expandedFacultyItem = facultyList.get(position);

                String toastMsg = getResources().getString(R.string.expanded, expandedFacultyItem.getName());
//                Toast.makeText(context,
//                        toastMsg,
//                        Toast.LENGTH_SHORT)
//                        .show();
            }

            @Override
            public void onListItemCollapsed(int position) {
                FacultyItem collapsedFacultyItem = facultyList.get(position);

                String toastMsg = getResources().getString(R.string.collapsed, collapsedFacultyItem.getName());
//                Toast.makeText(context,
//                        toastMsg,
//                        Toast.LENGTH_SHORT)
//                        .show();
            }
        });

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        return recyclerView;
    }

    private void getViewDepartmentDescription(FacultyViewModel.Screen screen) {
        initFrameDepartmentContainer(screen);
        Intent intent;
        View departmentLayout = inflater.inflate(R.layout.department_description, container, false);
        initUpperButton("О кафедре", "Образовательные прог..");
        TextView name = departmentLayout.findViewById(R.id.name);
        TextView telephone = departmentLayout.findViewById(R.id.telephone);
        TextView mail = departmentLayout.findViewById(R.id.mail);
        TextView address = departmentLayout.findViewById(R.id.address);
        TextView departmentTextDescription = departmentLayout.findViewById(R.id.department_text_description);
        ImageView photo = departmentLayout.findViewById(R.id.department_person_photo);
        name.setText("Согонов Сергей Александрович и Григорий Петрович");
        telephone.setText("+7 (812) 494-0980");
        mail.setText("mds-sogonov@yandex.ru");
        address.setText("190121, Санкт-Петербург, ул. Лоцманская 3, ауд. А-429 дом 5, квартира 23.");
        departmentTextDescription.
                setText("   Подготовка и выпуск специалистов, бакалавров и магистров по основным образовательным" +
                        " программам высшего профессионального образования (ООП ВПО): 180201.65 «Системы" +
                        " электроэнергетики и автоматизации судов», срок обучения - 5 лет, квалификация" +
                        " – морской инженер (последний выпуск - 2015 г.) 180202.65 «Системотехника" +
                        " объектов морской инфраструктуры», срок обучения - 5 лет, квалификация –" +
                        " морской инженер (последний выпуск - 2015 г.) 090103.65 «Организация и технология" +
                        " защиты информации», срок обучения - 5 лет, квалификация – специалист по защите" +
                        " информации (последний выпуск - 2015 г.");
        photo.setImageResource(R.drawable.p100629);
        implicitIntent(telephone, mail, address);
        frameDepartment.addView(departmentLayout);

    }

    private void getSpecialiseListScreen(final Context context, FacultyViewModel.Screen screen) {
        initFrameDepartmentContainer(screen);
        initUpperButton("Образовательные программы", "История");
        ArrayList<Department> departmentList = new ArrayList<>();
        ArrayList<FacultyItem> facultyList = new ArrayList<>();
        departmentList.add(new Department("26.03.02.09 Системы электроэнергетики и автоматизации судов"));
        departmentList.add(new Department("26.03.02.09 Системы электроэнергетики и автоматизации судов"));
        departmentList.add(new Department("26.03.02.09 Системы электроэнергетики и автоматизации судов"));
        departmentList.add(new Department("26.03.02.09 Системы электроэнергетики и автоматизации судов"));
        departmentList.add(new Department("26.03.02.09 Системы электроэнергетики и автоматизации судов"));
        facultyList.add(new FacultyItem("Бакалавриат", departmentList));
        facultyList.add(new FacultyItem("Специалист", departmentList));
        facultyList.add(new FacultyItem("Магистратура", departmentList));

        RecyclerView recyclerView = new RecyclerView(context);
        mAdapter = new EducationTypeAdapter(context, facultyList, facultyViewModel);
        mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {
                FacultyItem expandedFacultyItem = facultyList.get(position);

                String toastMsg = getResources().getString(R.string.expanded, expandedFacultyItem.getName());
//                Toast.makeText(context,
//                        toastMsg,
//                        Toast.LENGTH_SHORT)
//                        .show();
            }

            @Override
            public void onListItemCollapsed(int position) {
                FacultyItem collapsedFacultyItem = facultyList.get(position);

                String toastMsg = getResources().getString(R.string.collapsed, collapsedFacultyItem.getName());
//                Toast.makeText(context,
//                        toastMsg,
//                        Toast.LENGTH_SHORT)
//                        .show();
            }
        });

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        frameDepartment.addView(recyclerView);
    }

    private void getViewAboutDepartment(FacultyViewModel.Screen screen) {
        initFrameDepartmentContainer(screen);
        initUpperButton("История", "Сотрудники");
        View aboutDepartment = inflater.inflate(R.layout.about_department, container, false);
        TextView aboutDepartmentTextView = aboutDepartment.findViewById(R.id.about_department);
        aboutDepartmentTextView.setText("Кафедра Судовой автоматики и измерений сравнительно молодая" +
                " она создана как самостоятельная в декабре 1957 года." +
                " Однако подготовка студентов по автоматике началась задолго до этого." +
                " Уже с 1946 года в учебные планы энергетических специальностей машиностроительного" +
                " факультета (ныне ФКЭ и А ГМТУ )была включена учебная дисциплина" +
                " “Теория автоматического регулирования”. Тогда же в институте был организован семинар," +
                " руководил которым член-корреспондент АН СССР Иван Николаевич Вознесенский," +
                " крупный ученый, автор теории автономного регулирования, Бурное развитие автоматики" +
                " потребовало и улучшения качества подготовки молодых специалистов, В связи с этим" +
                " с 1950 года на кафедре Судовых силовых установок начинается широкая подготовка" +
                " Первая группа для обучения по новой специальности была сфомирована из студентов 5-го курса." +
                " Целевое их обучение с продлением срока окончания института на полгода позволило обеспечить первый" +
                " выпуск по новой специальности уже в том же 50-м году (среди выпускников 50-го года был и Б.В.Ракицкий," +
                " в настоящее время - д.т.н., проф.,), В дальнейшем срок обучения по нов месяцев)."
        );
        frameDepartment.addView(aboutDepartment);
    }

    private ArrayList<PersonImage> getPersonsImageList(Context context) {
        ArrayList<PersonImage> personImages = new ArrayList<>();
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677, "заведующий лабораторией, Старший преподаватель"));
        return personImages;
    }

    private void getImageRecyclerView(Context context, FacultyViewModel.Screen screen) {
        initFrameDepartmentContainer(screen);
        initUpperButton("Cотрудники", "");
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setBackgroundColor(context.getResources().getColor(R.color.main_items_background));
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        ImageRecyclerViewAdapter adapter = new ImageRecyclerViewAdapter(getPersonsImageList(context)
                , context);
        recyclerView.setAdapter(adapter);
        frameDepartment.addView(recyclerView);

    }


    private View inflateMainDepartmentView() {

        return inflater.inflate(R.layout.department_main, container, false);
    }

    private void initFrameDepartmentContainer(FacultyViewModel.Screen screen) {

        frameDepartment.removeAllViews();
        facultyViewModel.setScreen(screen);
        facultyViewModel.setIsChangeScreen(false);
        facultyViewModel.setSwitchType(ScheduleViewModel.SwitchType.DIRECTLY);
    }

    private void initUpperButton(String button1Text, String button2Text) {
        Button button1 = mainDepartmentView.findViewById(R.id.round_button1);
        Button button2 = mainDepartmentView.findViewById(R.id.round_button2);
        button1.setText(button1Text);
        if (button2Text.isEmpty()) {
            button2.setVisibility(View.INVISIBLE);
        } else {
            button2.setText(button2Text);
            button2.setOnClickListener(v -> facultyViewModel.setIsChangeScreen(true));
        }
    }

    private void implicitIntent(TextView phone, TextView email, TextView position) {

        phone.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone.getText().toString()));
            startActivity(intent);
        });
        email.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email.getText().toString()));
            startActivity(intent);
        });
        position.setOnClickListener(v -> {
            String geoUrl = String.format("geo:0,0?q=%s", position.getText().toString());
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUrl));
            startActivity(intent);
        });
    }

    @Override
    public boolean onBackPressed() {
        FacultyViewModel.Screen screen = facultyViewModel.getScreen().getValue();
        Log.d(TAG, "backPressed in FacultyFragment");
        facultyViewModel.setSwitchType(ScheduleViewModel.SwitchType.REVERSE);
        switch (Objects.requireNonNull(screen)) {
            case FACULTY_DEPARTMENT_SCREEN: {
                return true;

            }
            case DEPARTMENT_DESCRIPTION_SCREEN: {

                facultyViewModel.setIsChangeScreen(true);
                facultyViewModel.setDepartment("");
                return false;
            }
            case SPECIAL_LIST_SCREEN: {
                facultyViewModel.setDepartment("");
                Log.d(TAG, Objects.requireNonNull(facultyViewModel.getDepartment().getValue()));
                facultyViewModel.setIsChangeScreen(true);
                return false;
            }
            case DEPARTMENT_HISTORY_SCREEN: {
                facultyViewModel.setDepartment("");
                Log.d(TAG, Objects.requireNonNull(facultyViewModel.getDepartment().getValue()));
                facultyViewModel.setIsChangeScreen(true);
                return false;
            }
            case IMAGE_PERSON_SCREEN: {
                facultyViewModel.setDepartment("");
                Log.d(TAG, Objects.requireNonNull(facultyViewModel.getDepartment().getValue()));
                facultyViewModel.setIsChangeScreen(true);
                return false;
            }
            default:
                return false;

        }
    }

}