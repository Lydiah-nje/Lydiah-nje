package com.example.myproject.Pregnancy;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myproject.R;

public class Week_by_Week_Pregnancy extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;


    private ViewPagerWeek adapter;
    String List[]=new String[]{"   Weeks 1 and 2" +
            "\n"+
            "\n" +
            "\n" +
            "Baby: " +
            "\n"+
            "\n"+
            "Your baby is still just a glimmer in your eye." +
            " It’s difficult to know exactly when conception occurred," +
            " so doctors calculate your due date from the beginning " +
            "of your last menstrual cycle. That’s right -- for calculation" +
            "purposes, you’re “pregnant” before you even conceive!" +
            "\n"+
            "\n"+
            "Mom-to-be: " +
            "\n"+
            "\n"+
            "At the beginning of your period, about 20 eggs " +
            "called ova occupy fluid-filled sacs called follicles. " +
            "If you typically have your period every 28 days, then" +
            " about 14 days later, you ovulate: One of these follicles" +
            " releases an egg, and it travels down your fallopian tube" +
            " where it awaits fertilization. This time 14 days after" +
            " your period started and a day or so longer is when you're " +
            "the most fertile. If you want to get pregnant, this is the" +
            " best time to try. Once the egg is fertilized, it moves into the uterus."+
            "\n"+
                    "\n"+
            "Tip for the Week: " +
            "\n"+
            "\n"+

            "Make sure you've scheduled a preconception visit with " +
            "your ob-gyn to determine risks of genetic diseases and " +
            "environmental hazards as well as learn about necessary " +
            "lifestyle changes to ensure a healthy pregnancy and baby." +
            " Most important, make sure you've started taking 0.4 milligrams," +
            " or 400 micrograms, of folic acid a day. Folic acid taken " +
            "a few months before conception has been shown to dramatically " +
            "reduce such neural tube defects as spina bifida."+
            "\n"+
                    "\n"+
                    "\n"+
                    "\n",


            "Week 3"+
                    "\n"+
                    "\n" +
                    "\n" +

            "Baby: " +
                    "\n"+
                    "\n"+
                    "Congratulations! If your egg and your partner's " +
                            "sperm have joined successfully, your embryo" +
                            " is really there, although it's very small about " +
                            "the size of the head of a pin. It doesn't look like" +
                    " a fetus or baby; it's just a group of about 100 cells" +
                    " multiplying and growing rapidly. The outer layer " +
                    "of cells will become the placenta, and the" +
                    "inner layer will become the embryo."+
                    "\n"+
                    "\n"+

    "Mom-to-be: " +
                    "\n"+
                    "\n"+

                    "You won't notice any changes in your " +
                    "body at this point. Remember, you haven't " +
                    "even missed your period yet."+
                    "\n"
            +
                    "\n"+


    "Tip for the Week: " +
                    "\n"+
                    "\n"+

                    "Can't wait to find out? Take a home pregnancy test." +
                    " They're about as reliable as a urine test or blood" +
                    " test done in the doctor's office and you get " +
                    "results immediately. To ensure accuracy, read the " +
                    "directions carefully and make sure all the " +
                    "supplies you use are clean."+
            "\n"+
            "\n"+
                    "\n"+
            "\n",

            "Week 4"+
                    "\n"+
                    "\n" +

                    "\n" +
                    "Baby:" +
                    "\n"+
                    "\n"+
                    " Now that your egg is fertilized, it burrows " +
                    "into the lining of your uterus. This is called implantation."+
                    "\n"+
                    "\n"+

   "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "You're probably expecting your period this week, " +
                    "and if it doesn't occur, it might be one of the" +
                    " first signs that you're pregnant. You may also" +
                    " notice light spotting as the embryo implants itself" +
                    " in your uterus. You might not feel any different yet, " +
                    "but the amniotic cavity, which will be filled with fluid, " +
                    "and the placenta, which will bring oxygen and nutrients to" +
                    " nourish your baby, are forming in your uterus."+
                    "\n"+
                    "\n"+

    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "Try to eat healthfully, which means choosing a " +
                    "variety of foods from recommended food groups " +
                    "and drinking at least six to eight 8-ounce glasses " +
                    "of water a day. But you don't really need to "+
                    "eat for two you only need an extra" +
                    " 300 calories per day while you're pregnant. " +
                    "And don't worry if your food intake drops in " +
                    "the beginning because of morning sickness. " +
                    "If you've been eating right already, your baby will " +
                    "get what it needs."+
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

       adapter = new ViewPagerWeek(Week_by_Week_Pregnancy.this,List);
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



