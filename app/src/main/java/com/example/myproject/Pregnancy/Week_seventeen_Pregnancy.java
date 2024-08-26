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
public class Week_seventeen_Pregnancy extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;


    private ViewPagerWeek adapter;
    String List[]=new String[]{"Week 17" +
            "\n"+
            "\n" +
            "\n"+


            "Baby: " +
            "\n"+
            "\n"+

            "Your baby now has doubled in weight in the " +
            "last two weeks. Fat begins to form, helping " +
            "your baby's heat production and metabolism. " +
            "The lungs are beginning to exhale amniotic fluid," +
            " and the circulatory and urinary systems are working." +
            " Hair on the head, eyebrows, and eyelashes is filling in." +
            "\n"+
            "\n"+
            "Mom-to-be: " +
            "\n"+
            "\n"+
            "You're showing more now, with a typical weight " +
            "gain of 5-10 pounds. You may also be noticing " +
            "that your appetite has grown." +
            "\n" +
            "\n"+

            "Tip for the Week: " +
            "\n"+
            "\n"+

            "To avoid feeling dizzy or faint, change positions slowly," +
            " especially when you move from a lying down position" +
            " to sitting or from a sitting position to standing." +
            "If you feel lightheaded, sit down and lower your head, " +
            "or lie down for a moment."+
            "\n"+
            "\n"+
            "\n"+
            "\n",


            "Week 18"+
                    "\n"+
                    "\n" +
                    "\n"+

                    "Baby: " +
                    "\n"+
                    "\n"+
                    "Your baby's rapid growth spurt is tapering off, " +
                    "but reflexes are kicking in. The baby can yawn, " +
                    "stretch, and make facial expressions, even frown. " +
                    "Taste buds are beginning to develop and can distinguish " +
                    "sweet from bitter. The baby will suck if its lips " +
                    "are stroked, and it can swallow and even get the hiccups. " +
                    "The retinas have become sensitive to light, " +
                    "so if a bright light is shined on your abdomen, " +
                    "baby will probably move to shield its eyes."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "Your uterus, about the size of a cantaloupe," +
                    " can probably be felt just below your navel. " +
                    "You're most likely feeling the baby move by now. " +
                    "A mid-pregnancy ultrasound may be performed " +
                    "between now and 22 weeks to assess the baby's" +
                    " growth and development and to verify the due date." +
                    " If the baby is in the right position, " +
                    "the ultrasound may show whether it's a" +
                    " boy or a girl. Your heart has to work 40% " +
                    "to 50% harder now to support your pregnancy."+
                    "\n"
                    +
                    "\n"+


                    "Tip for the Week: " +
                    "\n"+
                    "\n"+

                    "Could your partner go with you for the ultrasound? It's a " +
                    "chance to catch the first glimpse of your baby together."+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n",

            "Week 19"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    "Your baby's skin is developing and transparent, " +
                    "appearing red because blood vessels are visible through" +
                    " it. A creamy white protective coating, called vernix," +
                    " begins to develop on the baby's skin."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "" +
                    "As your baby continues to grow, you may be " +
                    "feeling some mid-pregnancy aches and pains by" +
                    " now lower abdominal achiness, dizziness, heartburn, " +
                    "constipation, leg cramps, mild swelling of ankles" +
                    " and feet, and a backache. Dilated blood vessels" +
                    " might cause tiny, temporary red marks (called spider nevi) " +
                    "on your face, shoulders, and arms."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "Take care of yourself! Try not to get " +
                    "overtired while the baby is growing so quickly."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",


            "Week 20"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    "Your baby can hear sounds by now your voice, heart," +
                    " and your stomach growling, as well as sounds " +
                    "outside your body. The baby will cover its ears " +
                    "with its hands if a loud sound is made near you, " +
                    "and it may even become startled and jump. " +
                    "The baby is moving often, too twisting, turning," +
                    " wiggling, punching and kicking."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "" +
                    "Congratulations! You're near the midpoint" +
                    " of your pregnancy. Your uterus is just about " +
                    "even with your navel. Your waistline has pretty" +
                    " much disappeared. Bladder infections are more " +
                    "likely, because certain muscles in the urinary " +
                    "tract relax. Your breathing will deepen and you " +
                    "may sweat more than usual because your " +
                    "thyroid gland is more active"+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "Backache? Watch your posture. Sit with a footstool " +
                    "or use an ergonomic chair, avoid standing for too " +
                    "long, sleep with a small pillow under your side" +
                    "at the waist, and lift things with your legs " +
                    "instead of your back.\n" +
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


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPage = (ViewPager) findViewById(R.id.viewPager);
        btnImagePrevious = (Button) findViewById(R.id.btnImagePrevious);
        btnImageNext = (Button) findViewById(R.id.btnImageNext);


        setPage(position);

        adapter = new ViewPagerWeek(Week_seventeen_Pregnancy.this,List);
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





