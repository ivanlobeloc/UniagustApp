package com.tecnologias.uniagustapp.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecnologias.uniagustapp.R;
import com.tecnologias.uniagustapp.adapters.MenuAdapter;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by Brad on 12/18/2016.
 */

public class MenuCategoriaViewHolder extends GroupViewHolder {

    private TextView categoriaTitle;


    public MenuCategoriaViewHolder(View itemView) {
        super(itemView);
        categoriaTitle = (TextView)itemView.findViewById(R.id.list_item_cate_name);
    }

    public void setCategoriaName(String name){
        categoriaTitle.setText(name);
    }

}
