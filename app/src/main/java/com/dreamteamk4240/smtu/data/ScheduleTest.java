package com.dreamteamk4240.smtu.data;

import com.dreamteamk4240.smtu.ui.schedule.ScheduleViewModel;

import java.util.UUID;

import lombok.Data;

@Data
public class ScheduleTest {
    private UUID id;
    private ScheduleViewModel.WeekType weekType;
    private String time;
    private String teacherName;
    private DayOfWeek dayOfWeek;
    private GroupTest groupTest;
    private String placeName;
    private SubjectTest subjectTest;

    public ScheduleTest( ScheduleViewModel.WeekType weekType, String time, String teacherName, DayOfWeek dayOfWeek,
                         String placeName, SubjectTest subjectTest,GroupTest groupTest) {
        this.id = UUID.randomUUID();
        this.weekType = weekType;
        this.time = time;
        this.groupTest = groupTest;
        this.teacherName = teacherName;
        this.dayOfWeek = dayOfWeek;
        this.placeName = placeName;
        this.subjectTest = subjectTest;
    }
}
