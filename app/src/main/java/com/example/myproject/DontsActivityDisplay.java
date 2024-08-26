package com.example.myproject;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class DontsActivityDisplay extends AppCompatActivity implements
        ViewPager.OnPageChangeListener {

    private int position;
    private ViewPager viewPage;
    private ViewPagerAdapterTips adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_tips);

        // Set up the action bar
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        String[] listofgeneralTips = new String[] {
                " Don’t smoke tobacco. Quitting is hard, ...",
                " Avoid exposure to toxic substances and ...",
                " Protect yourself and your baby from foodborne ...",
                " Don’t drink alcohol. There is no known ...",
                " Don’t use illegal drugs. Tell your doctor ...",
                " Don’t clean or change a cat’s litter ...",
                " Don’t eat swordfish, king mackerel, shark, ...",
                " Don’t take very hot baths or use hot ...",
                " Don’t use scented feminine hygiene ...",
                " Don’t douche. Douching can irritate the ...",
                " Avoid x-rays. If you must have dental ...",
                " DON’T indulge in alcohol, tobacco, and drugs ...",
                " DON’T get tattoos while you are pregnant. ...",
                " DON’T over eat during pregnancy. ...",
                " DON’T spend time with abusive people. ...",
                " DON’T miss out on all the fun and excitement ..."
        };

        viewPage = findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapterTips(this, listofgeneralTips);
        viewPage.setAdapter(adapter);
        viewPage.addOnPageChangeListener(this);

        int pos = getIntent().getIntExtra("key", 0);
        viewPage.setCurrentItem(pos);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        this.position = position;
        viewPage.setCurrentItem(position);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // app icon in action bar clicked; goto parent activity.
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
