package com.dreamteamk4240.smtu.twoLevelList;

import android.view.View;
import android.widget.TextView;

import com.dreamteamk4240.smtu.R;

public class DepartmentViewHolder extends ChildViewHolder {

    private TextView departmentTextView;

    public DepartmentViewHolder(View itemView) {
        super(itemView);
        departmentTextView = (TextView) itemView.findViewById(R.id.tv_movies);
    }

    public void bind(Department department) {
        departmentTextView.setText(department.getName());
    }
}
