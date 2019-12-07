package com.dreamteamk4240.smtu.data;

import java.util.ArrayList;
import java.util.UUID;

import lombok.Data;

@Data
public class FacultyTest {
    private UUID facultyId;
    private String name;
    private ArrayList<GroupTest> groups;
    private EducationTypeTest educationType;

    public FacultyTest(String name, ArrayList<GroupTest> groups, EducationTypeTest educationType) {
        this.facultyId = UUID.randomUUID();
        this.name = name;
        this.groups = groups;
        this.educationType = educationType;
    }

    public void setFacultyId() {
        this.facultyId = UUID.randomUUID();
    }


}
