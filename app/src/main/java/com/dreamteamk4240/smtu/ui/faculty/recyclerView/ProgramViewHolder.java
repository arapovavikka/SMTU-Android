package com.dreamteamk4240.smtu.ui.faculty.recyclerView;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dreamteamk4240.smtu.R;
import com.dreamteamk4240.smtu.twoLevelList.ChildViewHolder;
import com.dreamteamk4240.smtu.twoLevelList.Department;

public class ProgramViewHolder extends ChildViewHolder {

    private TextView programTextView;
    private LinearLayout programLayout;

    public ProgramViewHolder(View itemView) {
        super(itemView);

        programTextView = (TextView) itemView.findViewById(R.id.recycler_item_textView);
        programLayout = itemView.findViewById(R.id.program_layout);
    }

    public LinearLayout getItemLayout() {
        return programLayout;
    }

    public TextView getDepartmentTextView() {
        return programTextView;
    }

    public void setDepartmentTextView(TextView departmentTextView) {
        this.programTextView = departmentTextView;
    }

    public void setDepartmentView(LinearLayout departmentView) {
        this.programLayout = departmentView;
    }

    public void bind(Department department) {
        programTextView.setText(department.getName());
    }
}
