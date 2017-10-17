package com.tecnologias.uniagustapp.models;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Brad on 12/18/2016.
 */

public class MenuCategoria extends ExpandableGroup {
    public MenuCategoria(String title, List items) {
        super(title, items);
    }
}
