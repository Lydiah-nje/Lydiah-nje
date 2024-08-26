package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapterTips extends PagerAdapter {

    // Declare Variables
    Context context;
    String[] brainpuz;

    LayoutInflater inflater;

    public ViewPagerAdapterTips(Context context, String[] brainpuz) {
        this.context = context;
        this.brainpuz = brainpuz;
    }

    @Override
    public int getCount() {
        return brainpuz.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        // Declare Variables
        TextView txtCountry;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.tips_layout, container, false);

        // Locate the TextView in tips_layout.xml
        txtCountry = itemView.findViewById(R.id.textViewtipsdisplay);

        // Capture position and set to the TextView
        txtCountry.setText(brainpuz[position]);

        // Add tips_layout.xml to ViewPager
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
