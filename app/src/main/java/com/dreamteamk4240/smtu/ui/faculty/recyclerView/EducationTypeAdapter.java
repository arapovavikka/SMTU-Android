package com.dreamteamk4240.smtu.ui.faculty.recyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamteamk4240.smtu.R;
import com.dreamteamk4240.smtu.twoLevelList.Department;
import com.dreamteamk4240.smtu.twoLevelList.ExpandableRecyclerAdapter;
import com.dreamteamk4240.smtu.twoLevelList.FacultyItem;
import com.dreamteamk4240.smtu.twoLevelList.ParentListItem;
import com.dreamteamk4240.smtu.ui.faculty.FacultyViewModel;

import java.util.List;

public class EducationTypeAdapter extends ExpandableRecyclerAdapter<EducationTypeViewHolder, ProgramViewHolder> {
    private LayoutInflater educationInflator;
    private FacultyViewModel facultyViewModel;

    public EducationTypeAdapter(Context context, List<? extends ParentListItem> parentItemList,FacultyViewModel facultyViewModel) {
        super(parentItemList);
        educationInflator = LayoutInflater.from(context);
        this.facultyViewModel = facultyViewModel;
        facultyViewModel.setScreen(FacultyViewModel.Screen.SPECIAL_LIST_SCREEN);
        facultyViewModel.setIsChangeScreen(false);
    }

    @Override
    public EducationTypeViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View educationTypeView = educationInflator.inflate(R.layout.types_of_education, parentViewGroup, false);
        return new EducationTypeViewHolder(educationTypeView);
    }

    @Override
    public ProgramViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View programView = educationInflator.inflate(R.layout.program_item, childViewGroup, false);
        return new ProgramViewHolder(programView);
    }

    @Override
    public void onBindParentViewHolder(EducationTypeViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        FacultyItem facultyItem = (FacultyItem) parentListItem;
        parentViewHolder.bind(facultyItem);
    }

    @Override
    public void onBindChildViewHolder(ProgramViewHolder childViewHolder, int position, Object childListItem) {
        Department department = (Department) childListItem;
        childViewHolder.bind(department);
//        childViewHolder.getItemLayout().setOnClickListener(v -> {
//            facultyViewModel.setIsChangeScreen(true);
//        });
    }
}
