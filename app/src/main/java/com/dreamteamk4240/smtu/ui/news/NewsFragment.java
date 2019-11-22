package com.dreamteamk4240.smtu.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dreamteamk4240.smtu.R;



public class NewsFragment extends Fragment {

    private NewsViewModel newsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsViewModel =
                ViewModelProviders.of(this).get(NewsViewModel.class);

        View root = inflater.inflate(R.layout.news_view, container, false);
       // final TextView textView = root.findViewById(R.id.text_news);
       /* newsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        }); */
        LinearLayout newsList = root.findViewById(R.id.news_list);
        for (int i = 0; i <= 4; i++)
        {
            View view = inflater.inflate(R.layout.fragment_news, newsList, false);
            TextView textViewTitle = view.findViewById(R.id.title_news);
            textViewTitle.setText(newsViewModel.getTitleNews());
            TextView textViewDate = view.findViewById(R.id.date_news);
            textViewDate.setText(newsViewModel.getDateNews());
            ImageView imageView = view.findViewById(R.id.main_image_news);
            imageView.setImageResource(R.mipmap.image_news);
            newsList.addView(view);
        }
        return root;
    }

}