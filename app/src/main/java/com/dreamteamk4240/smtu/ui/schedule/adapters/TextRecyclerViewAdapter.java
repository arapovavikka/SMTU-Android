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
import com.dreamteamk4240.smtu.data.IdAndName;
import com.dreamteamk4240.smtu.ui.schedule.ScheduleViewModel;

import java.util.ArrayList;

public abstract class  TextRecyclerViewAdapter extends RecyclerView.Adapter<TextRecyclerViewAdapter.TextRecyclerViewHolder> {
    protected ArrayList<IdAndName> datas;
    protected static final String TAG = TextRecyclerViewAdapter.class.getName();
    protected Context context;
    protected ScheduleViewModel scheduleViewModel;

    public TextRecyclerViewAdapter(ArrayList<IdAndName> datas, Context context,ScheduleViewModel scheduleViewModel) {
        this.datas = datas;
        this.context = context;
        this.scheduleViewModel = scheduleViewModel;
        scheduleViewModel.setSwitchType(ScheduleViewModel.SwitchType.DIRECTLY);
        scheduleViewModel.setIsChangeScreen(false);
    }
    abstract void onClickAction(View v,final int position);


    @NonNull
    @Override
    public TextRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item, parent, false);
        TextRecyclerViewHolder TextRecyclerViewHolder = new TextRecyclerViewHolder(view);

        return TextRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TextRecyclerViewHolder holder, final int position) {

        holder.recyclerTextView.setText(datas.get(position).getName());
        holder.linearLayout.setOnClickListener(v -> onClickAction(v,position));
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
