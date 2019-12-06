package com.dreamteamk4240.smtu.ui.faculty.recyclerView;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dreamteamk4240.smtu.R;
import com.dreamteamk4240.smtu.twoLevelList.FacultyItem;
import com.dreamteamk4240.smtu.twoLevelList.ParentViewHolder;

public class EducationTypeViewHolder extends ParentViewHolder {

    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;


    private TextView educationTypeTextView;
    private LinearLayout educationTypeLayout;

    public EducationTypeViewHolder(View itemView) {
        super(itemView);
        educationTypeTextView = itemView.findViewById(R.id.education_type);
        educationTypeLayout = itemView.findViewById(R.id.education_type_layout);

    }

    public void bind(FacultyItem facultyItem) {
        educationTypeTextView.setText(facultyItem.getName());
    }

    @Override
    public void setExpanded(boolean expanded) {
        super.setExpanded(expanded);


    }

    @Override
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);

        RotateAnimation rotateAnimation;
        if (expanded) { // rotate clockwise
            rotateAnimation = new RotateAnimation(ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        } else { // rotate counterclockwise
            rotateAnimation = new RotateAnimation(-1 * ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        }

        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);

    }
}
