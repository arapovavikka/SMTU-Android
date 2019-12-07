package com.dreamteamk4240.smtu.ui.contacts;

import java.util.ArrayList;
import java.lang.String;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class СontactsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private String name;
    private String[] phones;
    private String[] emails;
    private String[] adresses;
    private String schedule;

    public СontactsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Раздел Контакты");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public String[] getPhones() {
        return phones;
    }
    public String[] getEmails() {
        return emails;
    }
    public String[] getAdresses() {
        return adresses;
    }
    public String getName() {
        return name;
    }
    public String getSchedule() {
        return schedule;
    }
    public ArrayList<СontactsViewModel> getContacts() {
        ArrayList<СontactsViewModel> contacts = new ArrayList<СontactsViewModel>();
        СontactsViewModel contact1 = new СontactsViewModel();
        contact1.name = "Подготовительные курсы";
        contact1.phones = new String[]{"+7 (937) 720-45-56","+7(999) 529-64-87","+7 (999) 123-65-44"};
        contacts.add(contact1);
        contact1 = new СontactsViewModel();
        contact1.name = "Приемная комиссия";
        contact1.phones = new String[]{"+7 (937) 564-12-32"};
        contact1.adresses = new String[]{"Санкт-Петербург, Ленинский пр., 101"};
        contact1.emails = new String[]{"priem@gmail.com", "priem@yandex.ru"};
        contacts.add(contact1);
        contact1 = new СontactsViewModel();
        contact1.name = "Отдел оплаты образовательных услуг";
        contact1.phones = new String[]{"+7 (927) 541-23-65","+7 (800) 525-35-35"};
        contact1.adresses = new String[]{"с 10:00 до 17:00 по рабочим дням"};
        contacts.add(contact1);
        return contacts;
    }
}