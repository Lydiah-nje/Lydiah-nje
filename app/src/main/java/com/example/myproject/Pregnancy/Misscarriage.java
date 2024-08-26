package com.example.myproject.Pregnancy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myproject.R;
import com.example.myproject.ViewPagerAdapter;

public class Misscarriage extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private int position;

    private ViewPager viewPager;
    private PagerAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_healthlist);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String[] list = new String[]{
                "Causes Of Miscarriages\n\n\n" +
                        "Most miscarriages happen when the unborn baby has " +
                        "fatal genetic problems. Usually, these " +
                        "problems are unrelated to the mother.\n" +
                        "\n" +
                        "Other causes of miscarriage include:\n" +
                        "\n" +
                        "Infection\n" +
                        "Medical conditions in the mother, such as diabetes or thyroid disease\n" +
                        "Hormone problems\n" +
                        "Immune system responses\n" +
                        "Physical problems in the mother\n" +
                        "Uterine abnormalities\n" +
                        "A woman has a higher risk of miscarriage if she:\n" +
                        "\n" +
                        "Is over age 35\n" +
                        "Has certain diseases, such as diabetes or thyroid problems\n" +
                        "Has had three or more miscarriages\n\n\n\n",

                "Symptoms of a Miscarriage include:\n\n\n" +
                        "Bleeding which progresses from light to heavy\n" +
                        "Severe cramps\n" +
                        "Abdominal pain\n" +
                        "Fever\n" +
                        "Weakness\n" +
                        "Back pain\n" +
                        "If you experience the symptoms listed above, " +
                        "contact your obstetric health care provider " +
                        "right away. He or she will tell you to come " +
                        "in to the office or go to the emergency room.\n\n\n\n",

                "How Is a Miscarriage Treated?\n\n\n" +
                        "Your health care provider will perform " +
                        "a pelvic exam, an ultrasound test and bloodwork " +
                        "to confirm a miscarriage. If the miscarriage is " +
                        "complete and the uterus is empty, then no further " +
                        "treatment is usually required. Occasionally, " +
                        "the uterus is not completely emptied, so a dilation " +
                        "and curettage (D&C) procedure is performed. During " +
                        "this procedure, the cervix is dilated and any " +
                        "remaining fetal or placental tissue is gently " +
                        "removed from the uterus. As an alternative to " +
                        "a D&C, certain medications can be given to cause " +
                        "your body to expel the contents in the uterus. " +
                        "This option may be more ideal in someone who wants " +
                        "to avoid surgery and whose condition is otherwise stable.\n\n\n",

                "How Do I Know if I Had a Miscarriage?\n\n\n" +
                        "Bleeding and mild discomfort are common symptoms " +
                        "after a miscarriage. If you have heavy bleeding " +
                        "with fever, chills, or pain, contact your health " +
                        "care provider right away. These may be signs of an infection.\n\n\n\n"
        };

        viewPager = findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(this, list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);

        int pos = getIntent().getIntExtra("key", 0);
        viewPager.setCurrentItem(pos);
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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
