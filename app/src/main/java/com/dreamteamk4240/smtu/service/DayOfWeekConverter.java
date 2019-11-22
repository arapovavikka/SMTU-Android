package com.dreamteamk4240.smtu.service;

import com.dreamteamk4240.smtu.data.DayOfWeek;

import lombok.Data;

@Data
public class DayOfWeekConverter {
    private String[] dayOfWeeks;

    public DayOfWeekConverter(String[] dayOfWeeks) {
        if (dayOfWeeks.length == 7)
            this.dayOfWeeks = dayOfWeeks;
        else throw new IllegalArgumentException("Day of weeks array hasn't 7 length");
    }

    public String getNameByDayOfWeek(DayOfWeek dayOfWeek) {
        if (DayOfWeek.values().length == 7) {
            return dayOfWeeks[dayOfWeek.ordinal()];
        } else throw new IllegalArgumentException("DayOfWeek enum hasn't 7 length");
    }

}
