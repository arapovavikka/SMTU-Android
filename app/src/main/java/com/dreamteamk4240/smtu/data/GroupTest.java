package com.dreamteamk4240.smtu.data;

import java.util.UUID;

public class GroupTest  {
    private UUID id;

    public GroupTest( int courseLevel, String groupName) {
        this.id = UUID.randomUUID();
        this.courseLevel = courseLevel;
        this.groupName = groupName;
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    private int courseLevel;
    private String groupName;

    public int getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(int courseLevel) {
        if ((courseLevel >= 0) && (courseLevel <= 4)) {
            this.courseLevel = courseLevel;
        } else this.courseLevel = 1;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


}
