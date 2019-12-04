package com.dreamteamk4240.smtu.ui.faculty.recyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamteamk4240.smtu.R;
import com.dreamteamk4240.smtu.data.PersonImage;

import java.util.ArrayList;

public class ImageRecyclerViewAdapter extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageRecyclerViewHolder> {
    private ArrayList<PersonImage> departmentEmployees;
    private Context context;
    private static final String TAG = ImageRecyclerViewAdapter.class.getName();

    public ImageRecyclerViewAdapter(ArrayList<PersonImage> departmentEmployees, Context context) {
        this.departmentEmployees = departmentEmployees;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        ImageRecyclerViewHolder imageRecyclerViewHolder = new ImageRecyclerViewHolder(view);
        return imageRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageRecyclerViewHolder holder, final int position) {
        holder.personPhoto.setImageResource(departmentEmployees.get(position).getImageUrl());
        holder.departmentPositionView.setText(departmentEmployees.get(position).getDepartment_position());
        holder.nameView.setText(departmentEmployees.get(position).getName());
        holder.departmentPositionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked on " + position + " position");
            }
        });
    }

    @Override
    public int getItemCount() {
        return departmentEmployees.size();
    }

    protected class ImageRecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView personPhoto;
        private TextView nameView;
        private TextView departmentPositionView;
        private LinearLayout departmentPersonItem;

        public ImageRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            personPhoto = itemView.findViewById(R.id.department_person_image);
            nameView = itemView.findViewById(R.id.person_name_tv);
            departmentPositionView = itemView.findViewById(R.id.person_position);
            departmentPersonItem = itemView.findViewById(R.id.department_person_item);

        }
    }
}
