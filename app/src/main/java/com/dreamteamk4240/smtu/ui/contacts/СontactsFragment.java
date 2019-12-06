package com.dreamteamk4240.smtu.ui.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.dreamteamk4240.smtu.R;

public class СontactsFragment extends Fragment {

    private СontactsViewModel сontactsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        сontactsViewModel =
                ViewModelProviders.of(this).get(СontactsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contacts, container, false);
        
        Button mapButton = root.findViewById(R.id.map_open);
        mapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NavDirections action = РЎontactsFragmentDirections.actionNavContactsToNavContactsMap();
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
            }
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}