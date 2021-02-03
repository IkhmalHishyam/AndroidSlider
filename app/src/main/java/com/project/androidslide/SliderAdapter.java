package com.project.androidslide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter  extends PagerAdapter
{
    Context mContext;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context mContext)
    {
        this.mContext = mContext;
    }

    //Arrays
    public int[] slide_images = {R.drawable.one, R.drawable.peace, R.drawable.three};

    public String[] slide_heading = {"One", "Two", "Three"};

    @Override
    public int getCount()
    {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
    {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        layoutInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView img = (ImageView) view.findViewById(R.id.img);
        TextView heading = (TextView) view.findViewById(R.id.heading);

        img.setImageResource(slide_images[position]);
        heading.setText(slide_heading[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        container.removeView((RelativeLayout)object) ;
    }
}
