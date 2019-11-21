package com.dreamteamk4240.smtu.ui.schedule;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamteamk4240.smtu.R;

import java.util.ArrayList;

public class ScheduleRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleRecyclerViewAdapter.ScheduleRecyclerViewHolder> {
    private ArrayList<String> faculties;
    private static final String TAG = ScheduleRecyclerViewAdapter.class.getName();
    private Context context;

    public ScheduleRecyclerViewAdapter(ArrayList<String> faculties, Context context) {
        this.faculties = faculties;
        this.context = context;
    }


    @NonNull
    @Override
    public ScheduleRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faculty, parent, false);
        ScheduleRecyclerViewHolder scheduleRecyclerViewHolder = new ScheduleRecyclerViewHolder(view);

        return scheduleRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleRecyclerViewHolder holder, final int position) {

        holder.facultyTextView.setText(faculties.get(position));
        holder.facultyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Clicked on "+position+" position");
            }
        });
    }

    @Override
    public int getItemCount() {
        return faculties.size();
    }


    public class ScheduleRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView facultyTextView;
        private LinearLayout facultyLayout;


        public ScheduleRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            facultyTextView = itemView.findViewById(R.id.faculty_text_view);
            facultyLayout = itemView.findViewById(R.id.faculty_item_id);
        }
    }


}
