package com.dreamteamk4240.smtu.twoLevelList;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FacultyItem implements ParentListItem {
    private String name;
    private List<Department> departments;


    @Override
    public List<?> getChildItemList() {
        return departments;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
