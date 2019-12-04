package com.dreamteamk4240.smtu.ui.schedule.adapters;

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
import com.dreamteamk4240.smtu.ui.schedule.ScheduleViewModel;

import java.util.ArrayList;

public class TextRecyclerViewAdapter extends RecyclerView.Adapter<TextRecyclerViewAdapter.TextRecyclerViewHolder> {
    private ArrayList<String> datas;
    private static final String TAG = TextRecyclerViewAdapter.class.getName();
    private Context context;
    private ScheduleViewModel scheduleViewModel;
    private boolean isFaculty;

    public TextRecyclerViewAdapter(ArrayList<String> faculties, Context context,ScheduleViewModel scheduleViewModel,boolean isFaculty) {
        this.datas = faculties;
        this.context = context;
        this.scheduleViewModel = scheduleViewModel;
        this.isFaculty = isFaculty;
    }


    @NonNull
    @Override
    public TextRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item, parent, false);
        TextRecyclerViewHolder TextRecyclerViewHolder = new TextRecyclerViewHolder(view);

        return TextRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TextRecyclerViewHolder holder, final int position) {

        holder.recyclerTextView.setText(datas.get(position));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Clicked on "+position+" position");
                if(isFaculty) {
                    scheduleViewModel.setmText(datas.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public class TextRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView recyclerTextView;
        private LinearLayout linearLayout;


        public TextRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerTextView = itemView.findViewById(R.id.recycler_item_textView);
            linearLayout = itemView.findViewById(R.id.recycler_item_text);
        }
    }


}
