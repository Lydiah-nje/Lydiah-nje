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
public class Week_nine_Pregnancy extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;


    private ViewPagerWeek adapter;
    String List[]=new String[]{"   Week 9\n" +
            "\n" +
            "\n"+


            "Baby: " +
            "\n"+
            "\n"+

            "Your baby is about the size of a peanut." +
            "The head is more erect, and the neck is more " +
            "developed. During an ultrasound, you might" +
            " see how your baby moves, even though " +
            "you can't feel it yet" +
            "\n"+
            "\n"+
            "Mom-to-be: " +
            "\n"+
            "\n"+
            "Your uterus is continuing to grow, and you " +
            "may notice your waistline thickening." +
            " Unless you tell people your special news," +
            " however, your pregnancy still won't be noticeable " +
            "to others. You shouldn't have gained much weight yet," +
            " especially if you're having food aversions, cravings," +
            " heartburn, indigestion, nausea, or bloating." +
            "\n" +
            "\n"+

            "Tip for the Week: " +
            "\n"+
            "\n"+

            "Eat plenty of foods that contain calcium, " +
            "such as cheeses, sardines, and broccoli." +
            " Your baby needs it, and so do you."+
            "\n"+
            "\n"+
            "\n"+
            "\n",


            "Week 10"+
                    "\n"+
                    "\n" +
                    "\n"+

                    "Baby: " +
                    "\n"+
                    "\n"+
                    "Your baby is still small but looks and " +
                    "acts like a baby. Arms and legs are " +
                    "longer and can bend at the elbows and knees."+
                    "\n"+
                    "\n"+

                    "Mom-to-be:" +
                    "\n"+
                    "\n"+
                    "Once the size of your fist, your uterus is " +
                    "now the size of a grapefruit. You still " +
                    "probably don't show much, but you may feel " +
                    "more comfortable in looser clothes. You may " +
                    "continue to feel tired and moody, " +
                    "but take heart: These symptoms shouldn't last too much longer."+
                    "\n"
                    +
                    "\n"+


                    "Tip for the Week: " +
                    "\n"+
                    "\n"+

                    "Start shopping for maternity bras. " +
                    "You'll need one pretty soon. You can " +
                    "go ahead and get nursing bras if you're " +
                    "planning to breastfeed."+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n",

            "Week 11"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " It's another big growth week. When your " +
                    "doctor uses a Doppler stethoscope now, she can hear" +
                    " the rapid \"swooshing\" noises of the heartbeat." +
                    " Your baby's genitals are developing, but the sex" +
                    " can't be determined yet by ultrasound."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "" +
                    "Pregnancy hormones show their good and bad effects." +
                    "You may notice that your hair, fingernails, " +
                    "and toenails are growing faster. But you may " +
                    "also notice oily skin and acne."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "Schedule a dentist appointment. See your dentist " +
                    "at least once in these nine months. Brush and floss daily," +
                    " and take your prenatal vitamin for calcium to keep your" +
                    " teeth strong. Your gums may bleed more because" +
                    " of pregnancy hormones and increased blood volume. " +
                    "If they do, use a soft toothbrush."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",


            "Week 12"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    "All parts of your baby are developing, " +
                    "from tooth buds to toenails. Your baby will " +
                    "keep developing and getting larger and stronger" +
                    " for the rest of your pregnancy. By the end of " +
                    "this week, the chance of miscarriage drops considerably."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "" +
                    "You'll feel more energetic for the next few weeks. " +
                    "The typical weight gain by now is from 1.5 to 5 pounds." +
                    " Fathers-to-be might also experience pregnancy symptoms," +
                    " called couvade, or \"hatching,\" during the third month" +
                    " and at delivery, including nausea, abdominal pain, " +
                    "appetite changes, and weight gain."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "Try not to fret about stretch marks. " +
                    "Most women get them on the breasts, abdomen," +
                    " hips, or buttocks sometime during pregnancy. " +
                    "They won't go away, but they usually fade after" +
                    " pregnancy. Despite claims from manufacturers, " +
                    "creams and oils don't minimize them. How much " +
                    "they show depends on your skin's natural elasticity."+
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

        adapter = new ViewPagerWeek(Week_nine_Pregnancy.this,List);
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





