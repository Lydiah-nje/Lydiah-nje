package com.example.myproject.Pregnancy;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myproject.R;

public class ViewPagerWeek extends PagerAdapter {
    // Declare Variables
    Context context;
    String[] textViewweek;
    LayoutInflater inflater;

    public ViewPagerWeek(Context context, String[] textViewweek) {
        this.context = context;
        this.textViewweek = textViewweek;
    }

    @Override
    public int getCount() {
        return textViewweek.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Declare Variables
        TextView txtCountry;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.activity_pager, container, false);

        // Locate the TextView in activity_pager.xml
        txtCountry = itemView.findViewById(R.id.brainpuz);

        // Capture position and set to the TextView
        txtCountry.setText(textViewweek[position]);

        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}
