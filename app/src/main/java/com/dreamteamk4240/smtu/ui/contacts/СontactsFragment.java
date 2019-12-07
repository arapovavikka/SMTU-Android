package com.dreamteamk4240.smtu.ui.contacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dreamteamk4240.smtu.R;

import java.util.ArrayList;

public class СontactsFragment extends Fragment {

    private СontactsViewModel сontactsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        сontactsViewModel =
                ViewModelProviders.of(this).get(СontactsViewModel.class);
        View root = inflater.inflate(R.layout.contacts, container, false);
       /* final TextView textView = root.findViewById(R.id.text_contacts);
        сontactsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        }); */
        ArrayList<СontactsViewModel> contactsList = сontactsViewModel.getContacts();
        for(СontactsViewModel item : contactsList) {
            if (item.getName() == "Подготовительные курсы") {
                CreateModelView(root, R.id.training_courses_list, item, inflater);
            } else if (item.getName() == "Приемная комиссия") {
                CreateModelView(root, R.id.selection_committee_list, item, inflater);
            } else {
                CreateModelView(root, R.id.department_of_payment_list, item, inflater);
            }
        }
        return root;
    }

    public void CreateFragments(LayoutInflater inflater, LinearLayout layout, String[] array, int imageId) {
        int visible = 0;
        if (array.length > 1) {visible = 1;}
        for(String i : array) {
            View view = inflater.inflate(R.layout.fragment_contacts, layout, false);
            TextView textViewNumber = view.findViewById(R.id.text_contact);
            textViewNumber.setText(i);
            ImageView imageView = view.findViewById(R.id.image_contact);
            imageView.setImageResource(imageId);
            View delimeterView = view.findViewById(R.id.delimeter_view);
            delimeterView.setVisibility(visible);
            layout.addView(view);
        }
    }

    public void CreateFragments(LayoutInflater inflater, LinearLayout layout, String[] array, int imageId, boolean isPhoneNumber) {
        int visible = 0;
        if (array.length > 1) {visible = 1;}
        for(String i : array) {
            View view = inflater.inflate(R.layout.fragment_contacts, layout, false);
            TextView textViewNumber = view.findViewById(R.id.text_contact);
            textViewNumber.setText(i);
            if (isPhoneNumber)
                textViewNumber.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OpenPhone(((TextView)v).getText().toString());
                    }
                });
            ImageView imageView = view.findViewById(R.id.image_contact);
            imageView.setImageResource(imageId);
            View delimeterView = view.findViewById(R.id.delimeter_view);
            delimeterView.setVisibility(visible);
            layout.addView(view);
        }
    }

    public void OpenPhone(String phone)
    {
        // Create the intent and set the data for the
        // intent as the phone number.
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + phone));

        try
        {
            // Launch the Phone app's dialer with a phone
            // number to dial a call.
            startActivity(i);
        }
        catch (SecurityException s)
        {
            // show() method display the toast with
            // exception message.
            Toast.makeText(getActivity(),"Error", Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void CreateModelView (View root, int layoutId, СontactsViewModel item, LayoutInflater inflater){
        LinearLayout contactList = root.findViewById(layoutId);
        String[] phones = item.getPhones();
        String[] emails = item.getEmails();
        String[] adresses = item.getAdresses();
        String schedule = item.getSchedule();
        if (phones != null) {
            CreateFragments(inflater, contactList,phones,R.mipmap.phone, true);
        }
        if (emails != null) {
            CreateFragments(inflater, contactList,emails,R.mipmap.email, false);
        }
        if (adresses != null) {
            CreateFragments(inflater, contactList,adresses,R.mipmap.adress, false);
        }
        if (schedule != null) {
            View view = inflater.inflate(R.layout.fragment_contacts, contactList, false);
            TextView textView = view.findViewById(R.id.text_contact);
            textView.setText(schedule);
            ImageView imageView = view.findViewById(R.id.image_contact);
            imageView.setImageResource(R.mipmap.schedule);
            contactList.addView(view);
        }
    }
}
