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
public class Week_thirtysix_Pregnancy extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;


    private ViewPagerWeek adapter;
    String List[]=new String[]{"Week 36" +
            "\n"+
            "\n"+
            "\n" +

            "Baby: " +
            "\n"+
            "\n"+
            " Your baby measures about 20.7 inches from " +
            "head to toe and weighs about 6 pounds. " +
            "The baby may drop lower in your abdomen, " +
            "usually assuming the head-down position to" +
            " prepare for birth. The brain has been developing " +
            "rapidly, and your baby is practicing blinking." +
            "\n"+
            "\n"+
            "Mom-to-be: " +
            "\n"+
            "\n"+
            " Your uterus has grown bigger these last " +
            "few weeks and is probably up under your ribs." +
            " But you're in the home stretch! After this week, " +
            "you'll see your doctor weekly. You may switch " +
            "between fatigue and extra bursts of energy. " +
            "You may also have an achier back and feel" +
            " heaviness and discomfort in your " +
            "buttocks and pelvis."+
            "\n"+
            "\n"+
            "Tip for the Week: " +
            "\n"+
            "\n"+

            "Start stocking your freezer with foods that " +
            "can be easily popped into the oven or microwave " +
            "after you bring your baby home. Chili, casseroles," +
            " and other simple dishes can be prepared and frozen " +
            "ahead of time for use later."+
            "\n"+
            "\n"+
            "\n"+
            "\n",


            "Week 37"+
                    "\n"+
                    "\n" +
                    "\n"+

                    "Baby: " +
                    "\n"+
                    "\n"+
                    "Your baby is about 21 inches from head to toe " +
                    "and weighs almost 6.5 pounds. The baby is getting" +
                    " rounder every day, and skin is getting pinker " +
                    "and losing its wrinkly appearance. Your baby's " +
                    "head is usually positioned down into the pelvis by now."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n\n"+
                    "Your uterus may stay the same size as it was" +
                    " for the last week or two. Your weight gain should " +
                    "be about as high as it will go, about 25 to 35 pounds." +
                    " About this time, your doctor might perform a pelvic " +
                    "exam to check on the progress of your pregnancy."+
                    "\n"
                    +
                    "\n"+


                    "Tip for the Week: " +
                    "\n"+
                    "\n"+

                    "Just in case you deliver early, consider packing " +
                    "two bags for the hospital. Pack one bag for you," +
                    " with warm socks, a robe, lip balm, and everything " +
                    "you'll want during labor. Pack the other bag with " +
                    "the items you'll want for your newborn."+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n",

            "Week 38"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    "Most of your baby's downy hair, lanugo, " +
                    "and whitish coating, vernix, are disappearing. " +
                    "Your baby is getting its antibodies from you to " +
                    "protect against illness. The baby's growth is slowing," +
                    " but fat cells under skin get plumper for life outside" +
                    " the womb. Your baby is almost ready for birth.\n" +
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "You're probably not getting any bigger, " +
                    "but you may be feeling more uncomfortable. " +
                    "Make sure you have a bag packed for when " +
                    "you deliver. It won't be long now 95% of all" +
                    " babies are born within two weeks of their mother's due date."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "You may want to consider whether you'll circumcise " +
                    "your baby if it's a boy. Circumcision isn't as much " +
                    "a medical issue as a cultural or religious one."+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n",

            "Week 39"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " Your baby's arm and leg muscles are strong, " +
                    "and toenails and fingernails are in place. The baby's" +
                    " head has dropped into the mother's pelvis a head-down " +
                    "position lets you breathe a little easier."+
                    "\n"+
                    "\n"+
                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    " You're probably feeling quite large and uncomfortable." +
                    " Your uterus has filled your pelvis and most of your abdomen," +
                    " pushing everything else out of the way. Your center of " +
                    "gravity has shifted, so you may feel clumsier than usual."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "  Watch for signs of labor, but don't get too " +
                    "obsessed. It could happen soon or still be a " +
                    "week away. Some differences between false " +
                    "labor and contractions: False labor pains " +
                    "usually concentrate in the lower abdomen and groin, " +
                    "while true labor pains may start in the lower back " +
                    "and may spread through the entire abdomen. " +
                    "Real labor also becomes stronger and more " +
                    "powerful as time passes and will not go " +
                    "away with eating, drinking water, or lying down.."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",


            "Week 40"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " Boys often tend to weigh a little more " +
                    "than girls. More lanugo falls out, but some " +
                    "may remain at birth on the baby's shoulders, " +
                    "folds of skin, and backs of ears."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "It's almost time! Birth should happen soon now, " +
                    "but don't worry if your due date comes and goes. " +
                    "Only 5% of all babies are born exactly on the " +
                    "predicted due date. It may be more difficult " +
                    "for you to get a good night's sleep, because " +
                    "it's hard to find a comfortable position. Still, " +
                    "try to rest as much as possible, with your feet up if you can."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "  If you think you're in labor, don't eat. " +
                    "Even something light in your stomach can cause nausea."+
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

        adapter = new ViewPagerWeek(Week_thirtysix_Pregnancy.this,List);
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


