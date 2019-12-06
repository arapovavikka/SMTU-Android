package com.dreamteamk4240.smtu.ui.faculty.recyclerView;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dreamteamk4240.smtu.R;
import com.dreamteamk4240.smtu.twoLevelList.ChildViewHolder;
import com.dreamteamk4240.smtu.twoLevelList.Department;

public class DepartmentViewHolder extends ChildViewHolder {

    private TextView departmentTextView;
    private LinearLayout departmentView;

    public DepartmentViewHolder(View itemView) {
        super(itemView);
        departmentTextView = (TextView) itemView.findViewById(R.id.department_text_view);
        departmentView = itemView.findViewById(R.id.department_item_view);
    }

    public LinearLayout getItemLayout() {
        return departmentView;
    }

    public TextView getDepartmentTextView() {
        return departmentTextView;
    }

    public void setDepartmentTextView(TextView departmentTextView) {
        this.departmentTextView = departmentTextView;
    }

    public void setDepartmentView(LinearLayout departmentView) {
        this.departmentView = departmentView;
    }

    public void bind(Department department) {
        departmentTextView.setText(department.getName());
    }
}
