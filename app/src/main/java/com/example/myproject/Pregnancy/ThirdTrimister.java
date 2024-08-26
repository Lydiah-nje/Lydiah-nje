package com.example.myproject.Pregnancy;

/**
 * Created by Dev on 13-02-2017.
 */

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
public class ThirdTrimister extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;


    private ViewPagerWeek adapter;
    String List[]=new String[]{"   What To Expect:" +
            "\n" +
            "\n"+
            "\n" +

            "Changes in Your Body: " +
            "\n"+
            "\n"+
            "Pregnancy is different for every woman. " +
            "Some women glow with good health and vitality " +
            "during those first three months; others feel " +
            "absolutely miserable. Here are some of the " +
            "changes you might experience, what they mean," +
            " and which signs warrant a call to your doctor.!" +
            "\n"+
            "\n"+
            "\n",

            "Backache" +
                    "\n" +
                    "\n"+
                    "\n" +

                    "The extra weight you've gained in the last few " +
                    "months is starting to put pressure on your back," +
                    " making it achy and sore. To ease the pressure, " +
                    "sit up straight and use a chair that provides " +
                    "good back support. Sleep on your side with a " +
                    "pillow tucked between your legs. Avoid picking up" +
                    " or carrying anything heavy. Wear low-heeled, " +
                    "comfortable shoes with good arch support. If " +
                    "the pain is really uncomfortable, ask your " +
                    "partner to rub the sore spots, or treat yourself" +
                    "to a pregnancy massage."+
                    "\n" +
                    "\n"+
                    "\n" ,

            "Bleeding Gums " +
                    "\n" +
                    "\n"+
                    "\n" +

                    "About half of pregnant women develop swollen, " +
                    "tender gums. Hormone changes are sending more " +
                    "blood to your gums, making them more sensitive " +
                    "and causing them to bleed more easily. Your gums " +
                    "should go back to normal after your baby is born." +
                    " In the meantime, use a softer toothbrush and be " +
                    "gentle when you floss, but don't skimp on dental " +
                    "hygiene. Studies show that pregnant women with gum" +
                    " disease (periodontal disease) may be more likely " +
                    "to go into premature labor and deliver a low-birth" +
                    "weight baby."+
                    "\n" +
                    "\n"+
                    "\n" ,

            "Breast Enlargement " +
                    "\n" +
                    "\n"+
                    "\n" +

                    "Much of the breast tenderness you experienced " +
                    "during the first trimester should be wearing off," +
                    " but your breasts are still growing as they prepare" +
                    " to feed your baby. Going up a bra size (or more)" +
                    " and wearing a good support bra can make you feel " +
                    "more comfortable."+
                    "\n" +
                    "\n"+
                    "\n" ,

            "Frequent Urination " +
                    "\n" +
                    "\n"+
                    "\n" +

                    "Your uterus will rise away from the pelvic cavity " +
                    "during the second trimester, giving you a brief break" +
                    " from having to keep going to the bathroom. Don't get" +
                    " too comfortable, though. The urge to go will come " +
                    "back during the last trimester of your pregnancy."+
                    "\n" +
                    "\n"+
                    "\n" ,



            "Swelling" +
                    "\n" +
                    "\n"+
                    "\n" +

                    "Your rings might be feeling tighter these days, " +
                    "and you may also notice that your ankles and face " +
                    "are looking bloated. Mild swelling is the result " +
                    "of excess fluid retention ( edema ). To reduce " +
                    "swelling, put your feet up on a stool or box " +
                    "whenever you sit for any length of time, and " +
                    "elevate your feet while you sleep. If you have " +
                    "sudden onset of swelling though, seek medical " +
                    "attention immediately as it may be a sign of " +
                    "preeclampsia, a dangerous pregnancy complication."+
                    "\n" +
                    "\n"+
                    "\n" ,


            "Shortness Of Breath" +
                    "\n" +
                    "\n"+
                    "\n" +

                    "As your uterus expands, it rises up until it sits just " +
                    "under your rib cage, leaving less room for your " +
                    "lungs to expand. That added pressure on your lungs" +
                    " can make it more difficult to breathe. Exercising " +
                    "can help with shortness of breath. You can also " +
                    "try propping up your head and shoulders with " +
                    "pillows while you sleep"+
                    "\n" +
                    "\n"+
                    "\n" ,



            "Hemorrhoids" +
                    "\n" +
                    "\n"+
                    "\n" +

                    "Hemorrhoids are actually varicose veins swollen " +
                    "blue or purple veins that form around the anus." +
                    " These veins may enlarge during pregnancy, because " +
                    "extra blood is flowing through them and there is " +
                    "increased pressure on them from the growing uterus." +
                    " Varicose veins can be itchy and uncomfortable. To " +
                    "relieve them, try sitting in a warm tub or sitz bath." +
                    " Ask your doctor whether you can use an over-the-counter" +
                    " hemorrhoid ointment."+
                    "\n" +
                    "\n"+
                    "\n" +
                    "\n",




            "Braxton Hicks Contractions" +
                    "\n" +
                    "\n"+
                    "\n" +

                    "You might start to feel mild contractions, " +
                    "which are warm-ups to prepare your uterus for " +
                    "the real labor to come. Braxton Hicks contractions" +
                    " often aren't as intense as real labor contractions," +
                    " but they may feel a lot like labor and can " +
                    "eventually progress to it. One main difference " +
                    "is that real contractions gradually get closer " +
                    "and closer together and more intense. If you're" +
                    " red in the face and out of breath after your " +
                    "contractions, or they're coming regularly, " +
                    "call your doctor. "+
                    "\n" +
                    "\n"+
                    "\n" +
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

        adapter = new ViewPagerWeek(ThirdTrimister.this,List);
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
