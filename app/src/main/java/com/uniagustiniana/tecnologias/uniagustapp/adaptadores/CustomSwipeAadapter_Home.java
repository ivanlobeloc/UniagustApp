package com.uniagustiniana.tecnologias.uniagustapp.adaptadores;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.uniagustiniana.tecnologias.uniagustapp.R;

/**
 * Created by ivan.lobelo on 11/9/2017.
 */

public class CustomSwipeAadapter_Home extends PagerAdapter {

    private int[] image_resource = {R.drawable.slide_01,R.drawable.slide_02,R.drawable.slide_03};
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomSwipeAadapter_Home(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view == (LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);

        imageView.setImageResource(image_resource[position]);
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
