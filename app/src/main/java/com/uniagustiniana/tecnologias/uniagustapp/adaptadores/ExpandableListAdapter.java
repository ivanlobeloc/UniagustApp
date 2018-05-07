package com.uniagustiniana.tecnologias.uniagustapp.adaptadores;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


//import com.uniagustiniana.tecnologias.R;
import com.uniagustiniana.tecnologias.uniagustapp.R;
import com.uniagustiniana.tecnologias.uniagustapp.objects.ElementoMenu;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ivan.lobelo on 10/24/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {


    private Context context;
    private List<String> listDataHeader;
    private HashMap<String,List<ElementoMenu>> listElementosMenu;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<ElementoMenu>> listElementosMenu) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listElementosMenu = listElementosMenu;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {

        return listElementosMenu.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listElementosMenu.get(listDataHeader.get(i)).get(i1);// i= Group item, i1 = childItem
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTittle = (String)getGroup(i);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_categoria,null);
        }
        TextView item_cate_name = (TextView)view.findViewById(R.id.list_item_cate_name);
        item_cate_name.setTypeface(null, Typeface.BOLD);
        item_cate_name.setText(headerTittle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        //Obtiene titulo.
        final String childText = listElementosMenu.get(listDataHeader.get(i)).get(i1).getTitulo();
        //Obtiene Imagen.
        final int childImg =  listElementosMenu.get(listDataHeader.get(i)).get(i1).getImagenResource();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_subcategoria,null);
        }
        TextView item_name = (TextView)view.findViewById(R.id.list_item_name);
        item_name.setText(childText);
        ImageView item_icon = (ImageView)view.findViewById(R.id.list_item_scate_icon);
        item_icon.setImageResource(childImg);



        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;//*
    }
}
