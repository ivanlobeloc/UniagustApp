package com.tecnologias.uniagustapp.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecnologias.uniagustapp.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by Brad on 12/18/2016.
 */

public class ItemMenuViewHolder extends ChildViewHolder {

    private TextView itemName;
    private ImageView icono;

    public ItemMenuViewHolder(View itemView) {
        super(itemView);
        itemName = (TextView)itemView.findViewById(R.id.list_item_name);
        icono = (ImageView)itemView.findViewById(R.id.list_item_scate_icon);
    }

    public void setItemName(String name){
        itemName.setText(name);
    }

    public void setIcono(int idResource){
        icono.setImageResource(idResource);
    }
}
