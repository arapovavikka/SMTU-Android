package com.dreamteamk4240.smtu.data;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IdAndName {
    private UUID id;
    private String name;

}
