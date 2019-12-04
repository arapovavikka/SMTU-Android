package com.dreamteamk4240.smtu.data;

import android.graphics.drawable.Drawable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonImage {
    private String name;
    private int imageUrl;
    private String department_position;


}
