package com.example.myproject.Pregnancy;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myproject.R;

public class FirstTrimister extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;
    private ViewPagerWeek adapter;
    private String[] list = new String[]{
            // Your list items here
            "   What To Expect:\n\n\nChanges in Your Body: \n\nPregnancy is different for every woman. Some women glow with good health and vitality during those first three months; others feel absolutely miserable. Here are some of the changes you might experience, what they mean, and which signs warrant a call to your doctor.\n\n\n",
            "Bleeding\n\n\n About 25% of pregnant women experience slight bleeding during their first trimester. Early in the pregnancy, light spotting may be a sign that the fertilized embryo has implanted in the uterus. However, if you have significant bleeding, cramping, or sharp pain in your abdomen, call your doctor. These could be signs of a miscarriage or ectopic pregnancy (a pregnancy in which the embryo implants outside of the uterus).\n\n\n",
            "Breast Tenderness\n\n\n  Sore breasts are one of the earliest signs of pregnancy. They're triggered by hormonal changes, which are preparing your milk ducts to feed your baby, and will probably last through the first trimester. Going up a bra size (or more) and wearing a support bra can make you feel more comfortable; you can go back to the lacy bras after your baby is finished nursing.\n\n\n",
            "Constipation\n\n\n  During pregnancy, the muscle contractions that normally move food through your intestines slow down because of higher levels of the hormone progesterone. Add to that the extra iron you're getting from your prenatal vitamin, and the result is uncomfortable constipation and gas that can keep you feeling bloated throughout your pregnancy. Increase your fiber intake and drink extra fluids to keep things moving more smoothly. Physical activity can also help.\nIf your constipation is really bothering you, talk to your doctor about what mild laxative or stool softeners are safe to use during pregnancy.\n\n\n",
            "Fatigue\n\n\n Your body is working hard to support a growing fetus, which can wear you out more easily than usual. Take naps or rest when you need to throughout the day. Also make sure you're getting enough iron (too little can lead to anemia, which can cause excess fatigue).\n\n\n",
            "Food Cravings\n\n\n Although you may not want a bowl of mint chip ice cream topped with dill pickles, as the old stereotype goes, your tastes can change while you're pregnant. More than 60% of pregnant women experience food cravings, and more than half have food aversions, according to research. Giving in to cravings from time to time is OK, provided you are generally eating healthy, low-calorie foods. The exception is pica a craving for non-foods like clay, dirt, and laundry starch, which can be dangerous for you and your baby. If you experience this kind of craving, report it to your doctor right away.\n\n\n",
            "Mood Swings\n\n\n Increased fatigue and changing hormones can put you on an emotional roller coaster that makes you feel alternately elated and miserable, cranky and terrified. It's OK to cry, but if you're feeling overwhelmed, try to find an understanding ear if not from your partner, then from a friend or family member.\n\n\n",
            "Weight Gain\n\n\n Pregnancy is one of the few times in a woman's life when weight gain is considered a good thing, but don't overdo it. During the first trimester, you should gain about 3 to 6 pounds (your doctor may recommend that you adjust your weight gain up or down if you started your pregnancy underweight or overweight). Although you're carrying an extra person, don't go by the adage of eating for two. You only need about an extra 150 calories a day during your first trimester. Get those calories the healthy way, by adding extra fruits and vegetables, milk, whole-grain bread, and lean meat to your diet.\n\n\n"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_by__week__pregnancy);

        viewPage = findViewById(R.id.viewPager);
        btnImagePrevious = findViewById(R.id.btnImagePrevious);
        btnImageNext = findViewById(R.id.btnImageNext);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setPage(position);

        adapter = new ViewPagerWeek(this, list);
        viewPage.setAdapter(adapter);
        viewPage.addOnPageChangeListener(this);

        btnImagePrevious.setOnClickListener(this);
        btnImageNext.setOnClickListener(this);

        int pos = getIntent().getIntExtra("key", 0);
        viewPage.setCurrentItem(pos);
        totalImage = list.length;
    }

    @Override
    public void onClick(View v) {
        if (v == btnImagePrevious) {
            position = Math.max(position - 1, 0);
            viewPage.setCurrentItem(position);
        } else if (v == btnImageNext) {
            position = Math.min(position + 1, totalImage - 1);
            viewPage.setCurrentItem(position);
        }
        setPage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        this.position = position;
        setPage(position);
    }

    private void setPage(int page) {
        if (page == 0) {
            btnImageNext.setVisibility(View.VISIBLE);
            btnImagePrevious.setVisibility(View.INVISIBLE);
        } else if (page == totalImage - 1) {
            btnImageNext.setVisibility(View.INVISIBLE);
            btnImagePrevious.setVisibility(View.VISIBLE);
        } else {
            btnImageNext.setVisibility(View.VISIBLE);
            btnImagePrevious.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.maain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
