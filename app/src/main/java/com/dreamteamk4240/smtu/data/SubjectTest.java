package com.dreamteamk4240.smtu.data;

import java.util.UUID;

import lombok.Data;

@Data
public class SubjectTest {
    private UUID id;
    private String name;
    private String subjType;

    public SubjectTest( String name, String subjType) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.subjType = subjType;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

}
