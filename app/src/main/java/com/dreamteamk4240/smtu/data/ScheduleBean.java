package com.dreamteamk4240.smtu.data;

import lombok.Data;

@Data
public class ScheduleBean {
    private String subject;
    private DayOfWeek dayOfWeek;
    private String subjectType;
    private String timeFrom;
    private String timeTo;
    private String teacher;
    private String roomNumber;
}
