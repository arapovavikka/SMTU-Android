package com.dreamteamk4240.smtu.ui.persons;

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

public class PersonsFragment extends Fragment {

    private PersonsViewModel personsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personsViewModel =
                ViewModelProviders.of(this).get(PersonsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_persons, container, false);
        final TextView textView = root.findViewById(R.id.text_persons);
        personsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}