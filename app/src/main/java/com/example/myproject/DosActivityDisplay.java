package com.example.myproject;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class DosActivityDisplay extends AppCompatActivity implements ViewPager.OnPageChangeListener {

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

        String[] listofgeneralTips = new String[]{
                "See your doctor regularly. Prenatal care can help keep you and your baby healthy and spot problems if they occur.",
                "Continue taking folic acid throughout your pregnancy. All women capable of pregnancy should get 400 to 800 micrograms (400 to 800 mcg or 0.4 to 0.8 mg) of folic acid every day. Getting enough folic acid lowers the risk of some birth defects. Taking a vitamin with folic acid will help you to be sure you are getting enough.",
                "Eat a variety of healthy foods. Include fruits, vegetables, whole grains, calcium-rich foods, lean meats, and a variety of cooked seafood.",
                "Get all essential nutrients, including iron, every day. Getting enough iron prevents anemia, which is linked to preterm birth and low-birth weight babies. Ask your doctor about taking a daily prenatal vitamin or iron supplement.",
                "Drink extra fluids, especially water.",
                "Get moving! Unless your doctor tells you otherwise, physical activity is good for you and your baby.",
                "Gain a healthy amount of weight. Gaining more than the recommended amount during pregnancy increases a woman’s risk for pregnancy complications. It also makes it harder to lose the extra pounds after childbirth. Check with your doctor to find out how much weight you should gain during pregnancy.",
                "Wash hands, especially after handling raw meat or using the bathroom.",
                "Get enough sleep. Aim for 7 to 9 hours every night. Resting on your left side helps blood flow to you and your baby and prevents swelling. Using pillows between your legs and under your belly will help you get comfortable.",
                "Set limits. If you can, control the stress in your life and set limits. Don’t be afraid to say “no” to requests for your time and energy. Ask for help from others.",
                "Make sure health problems are treated and kept under control. If you have diabetes, control your blood sugar levels. If you have high blood pressure, monitor it closely.",
                "Ask your doctor before stopping any medicines you take or taking any new medicines. Prescription, over-the-counter, and herbal medicine all can harm your baby.",
                "Get a flu shot. Pregnant women can get very sick from the flu and may need hospital care. Ask your doctor about the flu vaccine.",
                "Always wear a seatbelt. The lap strap should go under your belly, across your hips. The shoulder strap should go between your breasts and to the side of your belly. Make sure it fits snugly.",
                "Join a childbirth or parenting class.",
                "DO take your prenatal vitamin every day, particularly in the first trimester. A lot of baby development is going on during that time.",
                "DO exercise during your pregnancy unless it is contraindicated by disability or your physician. Even walking for a few minutes a day can improve your health.",
                "DO eat a variety of foods including fruits, vegetables, grains, lean protein, and dairy.",
                "DO follow your doctor’s advice. He/She evaluates many things about the progression of your pregnancy and your health status.",
                "DO enjoy the companionship of friends and family members that will be supportive and encouraging to you during your pregnancy."
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
            // app icon in action bar clicked; go to parent activity
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
