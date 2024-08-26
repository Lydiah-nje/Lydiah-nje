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
public class Week_thirtyone_Pregnancy extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;


    private ViewPagerWeek adapter;
    String List[]=new String[]{"   Week 31" +
            "\n"+
            "\n"+
            "\n" +

            "Baby: " +
            "\n"+
            "\n"+
            "Your baby can hear distinct sounds," +
            " including familiar voices and music." +
            "\n"+
            "\n"+
            "Mom-To-Be: " +
            "\n"+
            "\n"+
            "Your uterus now fills a large part of your abdomen, " +
            "and you've probably gained 21-27 pounds. You're probably anticipating the birth -- it won't be long now."+
            "\n"+
            "\n"+
            "Tip for the Week: " +
            "\n"+
            "\n"+

            "Practice your breathing and relaxation exercises."+
            "\n"+
            "\n"+
            "\n"+
            "\n",


            "Week 32"+
                    "\n"+
                    "\n" +
                    "\n"+

                    "Baby: " +
                    "\n"+
                    "\n"+
                    "Your baby measures about 18.9 inches long from" +
                    " head to toe and weighs almost 4 pounds." +
                    "Baby fills almost all the space in your uterus now," +
                    " but may still have enough room to do somersaults." +
                    " A layer of fat is forming under your baby's skin. " +
                    "The baby is practicing opening his eyes and breathing."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n\n"+
                    "You'll probably start seeing your practitioner" +
                    " every two weeks until the last month, when you'll" +
                    " likely switch to weekly visits. You may continue" +
                    " to get backaches and leg cramps. You may also" +
                    " notice a yellowish fluid, called colostrum, " +
                    "leaking from your breasts it comes before milk production."+
                    "\n"
                    +
                    "\n"+


                    "Tip for the Week: " +
                    "\n"+
                    "\n"+

                    "You might be carrying differently from others " +
                    "at the same stage of pregnancy. Whether you're " +
                    "carrying higher or lower, bigger or smaller, wider" +
                    " or more compact depends on the size and position " +
                    "of the baby, your body type, and how much weight " +
                    "you've gained. For more comfort, drink plenty " +
                    "of fluids, elevate your legs when sitting, " +
                    "lie on your left side, and wear support stockings."+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n",

            "Week 33"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " The next few weeks will mark lots of growth in the baby. " +
                    "The baby will gain more than half its birth" +
                    " weight in the next seven weeks. Your baby begins " +
                    "to move less now as it runs out of room and curls" +
                    " up with knees bent, chin resting on chest, and arms and legs crossed.\n" +
                    "\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "You've gained 22-28 pounds by now. Of the pound" +
                    " a week you're gaining now, roughly half is going to your baby."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "It's safe to keep having sex with your partner, " +
                    "though you may be too uncomfortable. Talk with " +
                    "your partner about other ways to remain intimate," +
                    " including back rubs and foot massages."+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n",

            "Week 34"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " Your baby measures about 19.8 inches from head " +
                    "to toe and weighs about 5 pounds. The baby is" +
                    " probably settling into the head-down position," +
                    " although it might not be final. Organs are now " +
                    "almost fully mature, except for lungs, and the " +
                    "skin is pink instead of red. Fingernails reach " +
                    "the ends of fingers, but toenails are not yet " +
                    "fully grown. The baby might have lots of hair " +
                    "and may not move as often, due to the tight fit."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    " Your uterus hardens and contracts as practice " +
                    "for labor, known as Braxton Hicks contractions," +
                    " but you may not feel them yet. Your pelvis has " +
                    "expanded and may ache, especially at the back. " +
                    "The uterus is pushed hard against your lower" +
                    " ribs and your rib cage may be sore, and your " +
                    "navel is probably pushing out as a result " +
                    "of your abdomen being stretched."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "  Start thinking about whether you want to try " +
                    "breastfeeding. You may want to consult a lactation" +
                    " expert or simply talk with friends or relatives" +
                    " who can share their experiences."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",


            "Week 35"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    "Your baby's lungs are almost fully developed. " +
                    "It's still building fat deposits beneath its skin " +
                    "to keep warm after it leaves your womb."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "Your uterus is about 6 inches above your navel." +
                    " By now, you've probably gained 24-29 pounds." +
                    " Your doctor will test you for Group B" +
                    " streptococcus bacteria between now and 37 weeks."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    " Are you ready for the baby? Be sure you've" +
                    " collected the necessary baby clothes, equipment " +
                    "especially a car seat and furniture to get you through " +
                    "the first few weeks, at least, after your baby is born."+
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

        adapter = new ViewPagerWeek(Week_thirtyone_Pregnancy.this,List);
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



