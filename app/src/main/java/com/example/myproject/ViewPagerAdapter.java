package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myproject.R;

public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    private Context context;
    private String[] brainpuz;
    private LayoutInflater inflater;

    public ViewPagerAdapter(Context context, String[] brainpuz) {
        this.context = context;
        this.brainpuz = brainpuz;
    }

    @Override
    public int getCount() {
        return brainpuz.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Declare Variables
        TextView txtBrainPuz;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.activity_pager, container, false);

        // Locate the TextView in activity_pager.xml
        txtBrainPuz = itemView.findViewById(R.id.brainpuz);

        // Capture position and set to the TextView
        txtBrainPuz.setText(brainpuz[position]);

        // Add activity_pager.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove activity_pager.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}
