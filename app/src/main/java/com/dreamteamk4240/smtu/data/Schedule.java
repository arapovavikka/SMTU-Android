package com.dreamteamk4240.smtu.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Schedule {
    private String subjectName;
    private String subjectType;
    private DayOfWeek dayOfWeekImage;
    private String time;
    private String teacherName;
    private String auditoryName;
}
