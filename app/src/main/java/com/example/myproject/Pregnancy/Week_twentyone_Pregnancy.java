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
public class Week_twentyone_Pregnancy extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;


    private ViewPagerWeek adapter;
    String List[]=new String[]{"   Week 21" +
            "\n"+
            "\n"+
            "\n" +

            "Baby: " +
            "\n"+
            "\n"+
            "Your baby is steadily gaining fat to keep warm. " +
            "Growth rate is slowing down, but its organs are " +
            "still maturing. Your baby's oil glands are making" +
            " a waxy film, called the vernix caseosa, that " +
            "covers the skin to keep it supple in the amniotic " +
            "fluid. Buds for permanent teeth are beginning to form." +
            "\n"+
            "\n"+
            "Mom-To-Be: " +
            "\n"+
            "\n"+
            "You're starting to show! Your uterus is starting to " +
            "extend above your navel. You've probably " +
            "gained 10-14 pounds by now."+
            "\n"+
            "\n"+
            "Tip for the Week: " +
            "\n"+
            "\n"+

            "If you're interested in childbirth classes," +
            " now's a good time to start looking for one."+
            "\n"+
            "\n"+
            "\n"+
            "\n",


            "Week 22"+
                    "\n"+
                    "\n" +
                    "\n"+

                    "Baby: " +
                    "\n"+
                    "\n"+
                    "Your baby's muscles are getting stronger every " +
                    "week now, and the eyelids and eyebrows are developed. " +
                    "Your baby moves a lot and responds to sound, rhythm, " +
                    "and melody. If you sing and talk to your baby now, " +
                    "those sounds may later soothe your newborn."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "Your uterus is still growing, and you're probably " +
                    "feeling pretty good no more morning sickness. " +
                    "You may still be getting leg and foot cramps, " +
                    "though, and mild swelling of your ankles and feet."+
                    "\n"
                    +
                    "\n"+


                    "Tip for the Week: " +
                    "\n"+
                    "\n"+

                    "To curb cramping, eat more calcium and potassium." +
                    " Have a glass of milk before bedtime or snack " +
                    "on potassium-rich foods, such as grapefruits, " +
                    "oranges, and bananas. If you do get a leg cramp, " +
                    "try flexing your toes back toward your face " +
                    "and keeping your leg straight.\n" +
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n",

            "Week 23"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " Your baby's skin is still wrinkled because your" +
                    " baby still has more weight to gain. Fine hair, " +
                    "called lanugo, on the body sometimes turns darker."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "You've probably gained about 12-15 pounds." +
                    " While pregnant, you may notice an increase in" +
                    " vaginal secretions that are typically clear-to-yellowish " +
                    "with a faint smell. If the color or odor changes significantly, " +
                    "check in with your health care provider to see if you have an infection." +
                    " Does the small of your back ache? Lying down," +
                    " getting massages, and applying a heating pad " +
                    "or hot water bottle to the area can help."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "As your skin stretches, it may become dry and itchy." +
                    " Keeping it moist with lotions or creams can help."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",



            "Week 24"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " Your baby is starting to make white blood cells," +
                    " which will help it fight off disease and infection," +
                    " and may respond to your touch or sounds. If you haven't" +
                    " felt the baby hiccup yet, you might now."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "Expect to gain about a pound per week this month." +
                    " Your health care provider may test you for " +
                    "gestational diabetes between this week and 28 weeks."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "Your partner might be able to hear the baby's " +
                    "heartbeat by putting an ear to your abdomen."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",


            "Week 25"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " Your baby's skin now becomes opaque instead " +
                    "of transparent. The baby's body is still covered " +
                    "with folds, as it needs to grow into its skin. " +
                    "Heartbeat can be heard through a stethoscope or," +
                    " depending on the position of the baby, by " +
                    "others putting an ear against your belly."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "Besides your uterus growing upward, it may be " +
                    "getting bigger on your abdomen's sides. You may have" +
                    " hemorrhoids, caused by increased blood flow, constipation, " +
                    "indigestion, and heartburn."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "To soothe hemorrhoids, apply an ice pack or witch hazel," +
                    " or try a sitz bath (soaking your bottom in shallow warm water)." +
                    " Over-the-counter suppositories and/or medicated wipes may also help. " +
                    "Don't take laxatives or mineral oil."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n"





    };










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_by__week__pregnancy);



        viewPage = (ViewPager) findViewById(R.id.viewPager);
        btnImagePrevious = (Button) findViewById(R.id.btnImagePrevious);
        btnImageNext = (Button) findViewById(R.id.btnImageNext);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setPage(position);

        adapter = new ViewPagerWeek(Week_twentyone_Pregnancy.this,List);
        viewPage.setAdapter(adapter);


        btnImagePrevious.setOnClickListener(this);
        btnImageNext.setOnClickListener(this);
        int pos = getIntent().getIntExtra("key", 0);
        viewPage.setCurrentItem(pos);


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



