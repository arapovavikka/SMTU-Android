package com.dreamteamk4240.smtu.twoLevelList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamteamk4240.smtu.R;

import java.util.List;

public class FacultyAdapter extends ExpandableRecyclerAdapter<FacultyViewHolder, DepartmentViewHolder> {

    private LayoutInflater mInflator;

    public FacultyAdapter(Context context, List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        mInflator = LayoutInflater.from(context);
    }

    @Override
    public FacultyViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View movieCategoryView = mInflator.inflate(R.layout.faculty_item, parentViewGroup, false);
        return new FacultyViewHolder(movieCategoryView);
    }

    @Override
    public DepartmentViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View moviesView = mInflator.inflate(R.layout.department_item, childViewGroup, false);
        return new DepartmentViewHolder(moviesView);
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
    }
}
