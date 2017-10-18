package com.tecnologias.uniagustapp.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecnologias.uniagustapp.EventoOnItemClick;
import com.tecnologias.uniagustapp.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by Brad on 12/18/2016.
 */

public class ItemMenuViewHolder extends ChildViewHolder  implements View.OnClickListener{

    EventoOnItemClick listener; // Recibe la interfaz enviada desde el adaptador
    int posicion; // Recibe la posicion enviada desde le adaptador


    private TextView itemName;
    private ImageView icono;

    public ItemMenuViewHolder(View itemView, EventoOnItemClick listener) {
        super(itemView);
        itemName = (TextView)itemView.findViewById(R.id.list_item_name);
        icono = (ImageView)itemView.findViewById(R.id.list_item_scate_icon);

        // Apuntas el evento onClick del item al metodo onClick
        // de la interfaz OnClickListener.
        itemView.setOnClickListener(this);

        // Inicializas el listener
        this.listener = this.listener;
    }

    public void setItemName(String name){
        itemName.setText(name);
    }

    public void setIcono(int idResource){
        icono.setImageResource(idResource);
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion; // Inicializa la posicion
    }

    @Override
    public void onClick(View view) {
        listener.onItemClick(posicion);
    }
}