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
public class Week_twentysix_Pregnancy extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPage;
    private int position = 0, totalImage;


    private ViewPagerWeek adapter;
    String List[]=new String[]{"Week 26" +
            "\n"+
            "\n"+
            "\n" +

            "Baby: " +
            "\n"+
            "\n"+
            "Your baby's hearing is fully developed. As the baby " +
            "reacts to sounds, its pulse increases.Your baby will " +
            "even move in rhythm to music. Lungs are still growing " +
            "but are not yet mature. Patterns of your baby's brain " +
            "waves appear like a full-term newborn. He or she also " +
            "has patterns of sleeping and waking." +
            "\n"+
            "\n"+
            "Mom-To-Be: " +
            "\n"+
            "\n"+
            " The baby's constant movements should be reassuring. " +
            "You'll be putting on weight at the rate of about " +
            "1 pound per week now. You may be feeling some " +
            "rib pain as your baby grows and pushes upward " +
            "on your rib cage. The pressure may also be causing " +
            "indigestion and heartburn. You may also feel " +
            "stitch-like pains down the sides of your abdomen " +
            "as your uterine muscle stretches."+
            "\n"+
            "\n"+
            "Tip for the Week: " +
            "\n"+
            "\n"+

            "If you're planning to return to work, you might want " +
            "to begin checking out child care in your area." +
            " Nannies cost about $250 to $600 per week, group day " +
            "care typically ranges from $125 to $200 per week, " +
            "and home day care runs from about $75 to $125 per week. " +
            "Stay open-minded about various child care arrangements."+
            "\n"+
            "\n"+
            "\n"+
            "\n",


            "Week 27"+
                    "\n"+
                    "\n" +
                    "\n"+

                    "Baby: " +
                    "\n"+
                    "\n"+
                    "Your baby's hands are active. Thumb-sucking calms the" +
                    " baby and strengthens cheek and jaw muscles." +
                    " Your baby can cry now."+
                    "\n"+
                    "\n"+

                    "Mom-to-be: " +
                    "\n\n"+
                    "You may see stretch marks as your uterus " +
                    "continues to expand. Most women have gained about " +
                    "16 to 22 pounds by now. Your balance and" +
                    "mobility also may be changing as you grow larger."+
                    "\n"
                    +
                    "\n"+


                    "Tip for the Week: " +
                    "\n"+
                    "\n"+

                    "During your last trimester, you should talk to" +
                    " your doctor or midwife about the delivery. " +
                    "They can let you know about signs to predict" +
                    " labor and how far apart the contractions " +
                    "should be before going to the hospital or birth center. " +
                    "It's also the time to begin interviewing pediatricians " +
                    "and to take care of other logistics, like pre-registration" +
                    " at the place where you'll give birth and a birthing plan" +
                    ", which is what you envision your labor and delivery " +
                    "will be like, if you plan to do one. This plan should" +
                    " be written in your patient record or attached " +
                    "to it in the form of a birth plan."+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n",

            "Week 28"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " Your baby measures about 10 inches from " +
                    "crown to rump, or a total length of about 15.75 " +
                    "inches from head to toe, and weighs about 2.4 pounds." +
                    " Brain waves show rapid eye movement (REM) sleep, " +
                    "which means your baby may be dreaming. Eyelids" +
                    "are opening. Branches of lungs are developing."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "Your uterus extends well above your navel. " +
                    "As the baby gets bigger and stronger this month, " +
                    "you may be experiencing leg cramps and mild" +
                    " swelling of ankles and feet, difficulty sleeping, " +
                    "shortness of breath, lower abdominal achiness, " +
                    "clumsiness, or scattered Braxton Hicks " +
                    "contractions (hardening and relaxing of the uterus," +
                    " like a rehearsal for labor). You may also be" +
                    " urinating more frequently again as the uterus " +
                    "continues to push on your bladder."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    " Even if your partner is planning on being" +
                    " with you in the delivery room, you might" +
                    " want to consider hiring a doula " +
                    "a professional labor assistant who provides " +
                    "support, but not medical aid, for the mother" +
                    " and her partner. Studies show that doulas " +
                    "can shorten a woman's labor and reduce the " +
                    "likelihood of needing pain medication, " +
                    "forceps or vacuum deliveries, " +
                    "or a cesarean section."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",

            "Week 29"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    " Your baby's eyes are almost always blue " +
                    "and can distinguish bright sunlight or artificial " +
                    "light through the uterine wall. The baby is" +
                    " performing fewer acrobatics as conditions" +
                    " in the womb become more cramped, but he's " +
                    "still doing a lot of kicking and stretching.."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "You've probably gained 19-25 pounds." +
                    " You still have some time to go, so you may want " +
                    "to remind yourself of signs of premature labor, " +
                    "including menstrual-like cramps or lower back pain, " +
                    "a trickle of amniotic fluid, or a watery pinkish or" +
                    " brownish discharge preceded sometimes by the passage" +
                    " of a thick, gelatinous mucus plug. Tell your health " +
                    "care provider ASAP if that happens they can " +
                    "sometimes stop labor from progressing " +
                    "with bed rest, medications, and possibly also hospitalization."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    " Your blood pressure typically may rise " +
                    "a little around the seventh month. Tell your " +
                    "health care provider if you get severe headaches; " +
                    "blurred vision; severe swelling of hands, feet, " +
                    "or ankles; or if you gain a lot of weight. " +
                    "These symptoms could signal the beginning " +
                    "of preeclampsia, a dangerous condition " +
                    "marked by high blood pressure and high " +
                    "levels of protein in the urine during pregnancy."+
                    "\n"+
                    "\n"+

                    "\n"+
                    "\n",


            "Week 30"+
                    "\n"+
                    "\n" +
                    "\n"+


                    "Baby:" +
                    "\n"+
                    "\n"+
                    "Your baby measures about 17 inches from head to" +
                    " toe and weighs about 3 pounds. Baby is growing " +
                    "plumper and beginning to control its own body " +
                    "temperature. Eyebrows and eyelashes are fully" +
                    " developed, and hair on the head is getting thicker." +
                    " Head and body are now proportioned like a newborn's." +
                    " Hands are now fully formed and fingernails are growing."+
                    "\n\n"+

                    "Mom-to-be: " +
                    "\n"+
                    "\n"+
                    "Your uterus is about 4 inches above your navel, " +
                    "and it may be hard to believe you still have " +
                    "about 10 weeks to go as the baby continues to" +
                    " push on your ribs. You may be feeling more " +
                    "discomfort in your pelvis and abdomen. " +
                    "You'll probably be gaining about a pound a week."+
                    "\n"+
                    "\n"+

                    "Tip for the Week: " +

                    "\n"+
                    "\n"+
                    "  The membranes around the baby that contain the amniotic " +
                    "fluid are called the bag of water. They usually do not " +
                    "break until just before the onset of labor, but if they " +
                    "break prematurely, an infection becomes more likely, " +
                    "so call your health care provider immediately."+
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

        adapter = new ViewPagerWeek(Week_twentysix_Pregnancy.this,List);
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



