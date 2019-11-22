package com.dreamteamk4240.smtu.ui.news;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private String titleNews;
    private Calendar dateNews;


    public NewsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Раздел Новости");
        titleNews = "Заголовок новости";
        dateNews = new GregorianCalendar();
        dateNews = Calendar.getInstance();

    }

    public LiveData<String> getText() {
        return mText;
    }
    public String getTitleNews() {
        return titleNews;
    }
    public String getDateNews() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy");
        return dateFormat.format(dateNews.getTime());
    }
}