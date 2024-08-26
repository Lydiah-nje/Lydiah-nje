package com.example.myproject.Pregnancy;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myproject.R;

/**
 * Created by Dev on 13-02-2017.
 */
public class Week_five_Pregnancy extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;


    private ViewPagerWeek adapter;
    String List[]=new String[]{"   Week 5\n" +
            "\n" +
            "\n"+

            "Baby: " +
            "\n"+
            "\n"+

            "Your baby is still tiny, but its heart," +
            "brain, spinal cord, muscle, and bones are " +
            "beginning to develop. The placenta, which " +
            "nourishes your baby, and the amniotic sac, " +
            "which provides a warm and safe environment " +
            "where your baby can move easily, are still " +
            "forming, too. The umbilical cord forms and " +
            "connects your baby to your blood supply." +
            "\n"+
            "\n"+
            "Mom-to-be: " +
            "\n"+
            "\n"+
            "You might suspect by now that you're pregnant." +
            " You may also notice some early symptoms of pregnancy:\n" +
            "\n" +
            "Feeling nauseous (called morning sickness, although it can happen at any time of day or night)\n" +
            "Tingling or soreness in your breasts and darkening of your nipples\n" +
            "Needing to pee more often\n" +
            "Feeling more tired than usual"+
            "\n"+
            "\n"+
            "Tip for the Week: " +
            "\n"+
            "\n"+

            "You'll want to schedule a visit to your " +
            "ob-gyn as soon as you suspect you're " +
            "pregnant. Starting prenatal care early" +
            " and keeping up with your appointments " +
            "is a large step toward having a healthy" +
            " pregnancy and a healthy baby."+
            "\n"+
            "\n"+
            "\n"+
            "\n",


            "Week 6"+
                    "\n"+
                    "\n" +
                    "\n"+

                    "Baby: " +
                    "\n"+
                    "\n"+
                    "Your baby is shaped like a tadpole, and it's " +
                    "about the size of a BB pellet. The eyes and limb " +
                    "buds are forming. During an ultrasound, your doctor" +
                    " may be able to hear a heartbeat. Between days 17 and" +
                    " 56 is a vulnerable time, because that's when the baby" +
                    " is most susceptible to anything that can affect normal" +
                    " growth."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "You may have gained a few pounds by now." +
                    " Or if you're having morning sickness" +
                    " you may have lost weight that's normal, " +
                    "too. You may start noticing some changes " +
                    "in your body: clothes getting a little " +
                    "tighter around your waist, " +
                    "fuller legs and breasts. With a pelvic exam, " +
                    "your doctor will notice a change in " +
                    "the size of your uterus."+
                    "\n"
                    +
                    "\n"+


                    "Tip for the Week: " +
                    "\n"+
                    "\n"+

                    "Follow good prenatal habits each day, " +
                    "like eating healthfully and taking prenatal vitamins. " +
                    "If you haven't already, stop smoking and drinking alcohol."+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n",

            "Week 7"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " Your baby is growing. Limb buds appear that" +
                    " will grow into hands and feet. Many parts " +
                    "continue to develop: heart, lungs, intestines" +
                    ", appendix, brain, spinal cord, nostrils, mouth, and eyes"+
                    "\n"+
                    "\n"+
                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "" +
                    "You're still not showing, but by now you're " +
                    "really feeling the changes in your body. " +
                    "You may still have morning sickness, and your" +
                    " breasts probably still feel tingly and tender."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    " Never let your stomach get completely empty " +
                    "that will help you from feeling queasy." +
                    " Keep snacks on hand around the clock, and eat " +
                    "lots of little meals rather than three big ones." +
                    " To prevent a drop in blood sugar, " +
                    "eat some protein, like adding cheese to crackers."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",


            "Week 8"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    "Your baby is now about in its sixth " +
                    "week of development. It's a big week " +
                    "for growth. Eyelid folds and ears are forming." +
                    " Your baby develops little webbed fingers " +
                    "and toes and can even swim around in your womb."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "" +
                    "Your blood volume is increasing, " +
                    "and your heart is pumping 50% more blood per minute " +
                    "for your baby. Common symptoms for this week are " +
                    "moodiness and queasiness from certain smells."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    " Wear a supportive bra. Good breast support " +
                    "during pregnancy will help you feel more " +
                    "comfortable and prevent future sagging. " +
                    "Exercises to keep your chest muscles " +
                    "toned can be useful, too."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",







    };










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_by__week__pregnancy);



        viewPage = (ViewPager) findViewById(R.id.viewPager);
        btnImagePrevious = (Button) findViewById(R.id.btnImagePrevious);
        btnImageNext = (Button) findViewById(R.id.btnImageNext);


        setPage(position);

        adapter = new ViewPagerWeek(Week_five_Pregnancy.this,List);
        viewPage.setAdapter(adapter);


        btnImagePrevious.setOnClickListener(this);
        btnImageNext.setOnClickListener(this);
        int pos = getIntent().getIntExtra("key", 0);
        viewPage.setCurrentItem(pos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View v) {
        if (v == btnImagePrevious) {
            position--;
            viewPage.setCurrentItem(position);
        } else if (v == btnImageNext) {
            position++;
            viewPage.setCurrentItem(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int position) {
        this.position = position;
        setPage(position);
    }

    private void setPage(int page) {
        if (page == 0 && totalImage > 0) {
            btnImageNext.setVisibility(View.VISIBLE);
            btnImagePrevious.setVisibility(View.INVISIBLE);
        } else if (page == totalImage - 1 && totalImage > 0) {
            btnImageNext.setVisibility(View.INVISIBLE);
            btnImagePrevious.setVisibility(View.VISIBLE);
        } else {
            btnImageNext.setVisibility(View.VISIBLE);
            btnImagePrevious.setVisibility(View.VISIBLE);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.maain, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (item.getItemId()) {
            case android.R.id.home:

                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:

                return super.onOptionsItemSelected(item);

        }
    }
}








