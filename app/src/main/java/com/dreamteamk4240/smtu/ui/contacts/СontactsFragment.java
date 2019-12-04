package com.dreamteamk4240.smtu.ui.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dreamteamk4240.smtu.R;

public class СontactsFragment extends Fragment {

    private СontactsViewModel сontactsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        сontactsViewModel =
                ViewModelProviders.of(this).get(СontactsViewModel.class);
        //View root = inflater.inflate(R.layout.fragment_contacts, container, false);
        /* textView = root.findViewById(R.id.text_contacts);
        сontactsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        // получаем экземпляр FragmentTransaction



        Intent firstpage= new Intent(getActivity(), MapFragment.class);
        getActivity().startActivity(firstpage);
        return new View(getActivity());
    }
}