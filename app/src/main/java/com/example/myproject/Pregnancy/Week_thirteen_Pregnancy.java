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
public class Week_thirteen_Pregnancy extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;


    private ViewPagerWeek adapter;
    String List[]=new String[]{"Week 13" +
            "\n"+
            "\n" +
            "\n"+


            "Baby: " +
            "\n"+
            "\n"+

            "Your baby is growing quickly! Eyes are moving " +
            "into position, the ankles and wrists have formed," +
            " and though the head is still disproportionately " +
            "big, the rest of the body is starting to catch up." +
            "\n"+
            "\n"+
            "Mom-to-be: " +
            "\n"+
            "\n"+
            "Your uterus has grown a lot. It's filling " +
            "your pelvis now and starting to grow upward" +
            " into your abdomen. It probably feels like a " +
            "soft, smooth ball. If you haven't gained any " +
            "weight yet because of morning sickness, " +
            "you'll begin to now as you start to feel better." +
            "\n" +
            "\n"+

            "Tip for the Week: " +
            "\n"+
            "\n"+

            "Suggest that your partner go with" +
            " you to a check-up. They might love " +
            "the chance to hear the baby's heartbeat."+
            "\n"+
            "\n"+
            "\n"+
            "\n",


            "Week 14"+
                    "\n"+
                    "\n" +
                    "\n"+

                    "Baby: " +
                    "\n"+
                    "\n"+
                    "Your baby's ears are shifting from the neck " +
                    "to the sides of the head, and the neck is " +
                    "getting longer and the chin more prominent." +
                    " Facial features and unique fingerprints are " +
                    "all there. Your baby is beginning to respond " +
                    "to outside stimuli. If your abdomen is poked, " +
                    "the baby will try to wriggle away."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "You're probably wearing maternity clothes now. " +
                    "Your skin and muscles are starting to stretch " +
                    "to accommodate your growing baby. You may notice " +
                    "some constipation, because pregnancy hormones " +
                    "relax the bowel."+
                    "\n"
                    +
                    "\n"+


                    "Tip for the Week: " +
                    "\n"+
                    "\n"+

                    "Try to ease constipation by getting moderate exercise," +
                    " drinking plenty of fluids, and eating lots " +
                    "of fruit and vegetables."+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n",

            "Week 15"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    "  Your baby's body is covered by very fine hair," +
                    " called lanugo, which is usually shed by birth." +
                    " Eyebrows and hair on the top of the head are" +
                    " beginning to grow, bones are getting harder, " +
                    "and the baby may even be sucking his thumb."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "" +
                    "Your uterus can probably be felt about 3 to 4" +
                    " inches below your navel. Sometime in the next" +
                    " five weeks you'll be offered a blood test " +
                    "called the quadruple marker screening test " +
                    "to help screen for Down syndrome. You might " +
                    "also be offered amniocentesis, which tests a" +
                    " small sample of amniotic fluid withdrawn by" +
                    " an ultrasound-guided needle, between now and 18" +
                    " weeks. You can talk with your doctor about " +
                    "what prenatal tests you may want."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "Start learning to sleep on your left side your " +
                    "circulation is better that way. You can try " +
                    "tucking pillows behind you and between your" +
                    " legs. Some pregnancy pillows support your entire body."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",


            "Week 16"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    "You may be able to hear the baby's heartbeat in " +
                    "the doctor's office. Fine hair, lanugo," +
                    " may be growing on the head. Arms and legs " +
                    "are moving, and the nervous system is working."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "" +
                    "Within the next few weeks, you may start to " +
                    "feel your baby move, called \"quickening.\" " +
                    "It often feels like a gas bubble or subtle " +
                    "fluttering movement. As it happens more regularly," +
                    " you'll know it's your baby. Your body is changing " +
                    "in many other ways. Increased blood volume to support" +
                    " your growing baby may produce nosebleeds, and you may " +
                    "notice your leg veins are becoming more apparent. " +
                    "Good news: Because your uterus is shifting, " +
                    "you may not have to urinate so much."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "If your leg veins bulge, you may want to " +
                    "wear support stockings, put your feet " +
                    "up when you can, and exercise to improve blood flow.\n" +
                    "\n"+
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

        adapter = new ViewPagerWeek(Week_thirteen_Pregnancy.this,List);
        viewPage.setAdapter(adapter);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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





