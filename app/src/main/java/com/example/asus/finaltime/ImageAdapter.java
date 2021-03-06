package com.example.asus.finaltime;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public Integer[] images={
            R.drawable.a,R.drawable.b,
            R.drawable.c,R.drawable.d,
            R.drawable.e,R.drawable.f,
            R.drawable.g,R.drawable.thh,
            R.drawable.i,R.drawable.j,
            R.drawable.k,R.drawable.l,
            R.drawable.m,R.drawable.n,
            R.drawable.o,R.drawable.p,
            R.drawable.q,R.drawable.r,
            R.drawable.s,R.drawable.t,
    };
    public ImageAdapter(Context c){
        context=c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(240, 240));
        return imageView;
    }
}
