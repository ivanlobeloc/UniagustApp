package com.tecnologias.uniagustapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecnologias.uniagustapp.R;
import com.tecnologias.uniagustapp.models.ItemMenu;
import com.tecnologias.uniagustapp.viewholders.ItemMenuViewHolder;
import com.tecnologias.uniagustapp.viewholders.MenuCategoriaViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Brad on 12/18/2016.
 */

public class MenuAdapter extends ExpandableRecyclerViewAdapter<MenuCategoriaViewHolder, ItemMenuViewHolder> implements View.OnClickListener {

    private View.OnClickListener listener;

        public MenuAdapter(List<? extends ExpandableGroup> groups) {
            super(groups);
        }

        @Override
        public MenuCategoriaViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_categoria, parent, false);
            return new MenuCategoriaViewHolder(view);
        }

        @Override
        public ItemMenuViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_subcategoria, parent, false);

            view.setOnClickListener(this);

            return new ItemMenuViewHolder(view);
        }

        @Override
        public void onBindChildViewHolder(ItemMenuViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
            ItemMenu itemMenu = (ItemMenu) group.getItems().get(childIndex);

            holder.setItemName(itemMenu.getItemName());
            holder.setIcono(itemMenu.getImagenId());
        }

        @Override
        public void onBindGroupViewHolder(MenuCategoriaViewHolder holder, int flatPosition, ExpandableGroup group) {
            holder.setCategoriaName(group.getTitle());
        }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }
}
