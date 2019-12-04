package com.dreamteamk4240.smtu.ui.specialties;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dreamteamk4240.smtu.R;

public class SpecialtiesFragment extends Fragment {

    private SpecialtiesViewModel specialtiesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        specialtiesViewModel =
                ViewModelProviders.of(this).get(SpecialtiesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_specialties, container, false);
//       // final TextView textView = root.findViewById(R.id.text_specialties);
//        specialtiesViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}