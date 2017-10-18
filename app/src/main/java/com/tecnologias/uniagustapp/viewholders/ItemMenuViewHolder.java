package com.tecnologias.uniagustapp.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecnologias.uniagustapp.R;
import com.tecnologias.uniagustapp.adapters.MenuAdapter;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by Brad on 12/18/2016.
 */

public class ItemMenuViewHolder extends ChildViewHolder implements View.OnClickListener{ // *

    private TextView itemName;
    private ImageView icono;

    MenuAdapter.EventoOnItemClick listener; // *

    public ItemMenuViewHolder(View itemView, MenuAdapter.EventoOnItemClick listener) {
        super(itemView);
        itemName = (TextView)itemView.findViewById(R.id.list_item_name);
        icono = (ImageView)itemView.findViewById(R.id.list_item_scate_icon);

        this.listener = listener; // *
        itemView.setOnClickListener(this); // *
    }

    public void setItemName(String name){
        itemName.setText(name);
    }

    public void setIcono(int idResource){
        icono.setImageResource(idResource);
    }

    @Override // *
    public void onClick(View v) {listener.onItemClick(getAdapterPosition()); } // *
}
