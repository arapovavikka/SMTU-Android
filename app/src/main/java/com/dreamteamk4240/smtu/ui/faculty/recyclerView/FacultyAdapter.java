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
import com.dreamteamk4240.smtu.ui.schedule.ScheduleViewModel;

import java.util.List;

public class FacultyAdapter extends ExpandableRecyclerAdapter<FacultyViewHolder, DepartmentViewHolder> {

    private LayoutInflater mInflator;
    private FacultyViewModel facultyViewModel;

    public FacultyAdapter(Context context, List<? extends ParentListItem> parentItemList,FacultyViewModel facultyViewModel) {
        super(parentItemList);
        mInflator = LayoutInflater.from(context);
        this.facultyViewModel = facultyViewModel;
        facultyViewModel.setScreen(FacultyViewModel.Screen.FACULTY_DEPARTMENT_SCREEN);
        facultyViewModel.setSwitchType(ScheduleViewModel.SwitchType.DIRECTLY);
        facultyViewModel.setIsChangeScreen(false);
    }

    @Override
    public FacultyViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View facultyCategoryView = mInflator.inflate(R.layout.faculty_item, parentViewGroup, false);
        return new FacultyViewHolder(facultyCategoryView);
    }

    @Override
    public void setExpandCollapseListener(ExpandCollapseListener expandCollapseListener) {
        super.setExpandCollapseListener(expandCollapseListener);
    }

    @Override
    public DepartmentViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View facultysView = mInflator.inflate(R.layout.department_item, childViewGroup, false);
        return new DepartmentViewHolder(facultysView);
    }

    @Override
    public void onBindParentViewHolder(FacultyViewHolder facultyViewHolder, int position, ParentListItem parentListItem) {
        FacultyItem facultyItem = (FacultyItem) parentListItem;
        facultyViewHolder.bind(facultyItem);
    }

    @Override
    public void onBindChildViewHolder(DepartmentViewHolder departmentViewHolder, int position, Object childListItem) {
        Department department = (Department) childListItem;
        departmentViewHolder.bind(department);
        departmentViewHolder.getItemLayout().setOnClickListener(v->{
            facultyViewModel.setDepartment(department.getName());
            facultyViewModel.setIsChangeScreen(true);
        });
    }
}
