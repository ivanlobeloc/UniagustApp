package com.tecnologias.uniagustapp.models;

/**
 * Created by Brad on 12/18/2016.
 */

public class ItemMenu {
    private String name;
    private int imagenId;

    public ItemMenu(String name, int imagenId) {
        this.name = name;
        this.imagenId = imagenId;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

}