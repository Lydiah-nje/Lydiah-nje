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
public class SecondTrimister extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private Button btnImagePrevious, btnImageNext;
    private ViewPager viewPager;
    private int position = 0;
    private int totalImage;

    private ViewPagerWeek adapter;
    String[] list = new String[]{
            "What To Expect:\n\n\n" +
                    "Changes in Your Body:\n\n" +
                    "Pregnancy is different for every woman. Some women glow with good health and vitality " +
                    "during those first three months; others feel absolutely miserable. Here are some of the " +
                    "changes you might experience, what they mean, and which signs warrant a call to your doctor.\n\n\n",

            "Backache\n\n\n" +
                    "The extra weight you've gained in the last few months is starting to put pressure on your back, " +
                    "making it achy and sore. To ease the pressure, sit up straight and use a chair that provides " +
                    "good back support. Sleep on your side with a pillow tucked between your legs. Avoid picking up " +
                    "or carrying anything heavy. Wear low-heeled, comfortable shoes with good arch support. If the pain " +
                    "is really uncomfortable, ask your partner to rub the sore spots, or treat yourself to a pregnancy massage.\n\n\n",

            "Bleeding Gums\n\n\n" +
                    "About half of pregnant women develop swollen, tender gums. Hormone changes are sending more " +
                    "blood to your gums, making them more sensitive and causing them to bleed more easily. Your gums " +
                    "should go back to normal after your baby is born. In the meantime, use a softer toothbrush and be " +
                    "gentle when you floss, but don't skimp on dental hygiene. Studies show that pregnant women with gum " +
                    "disease (periodontal disease) may be more likely to go into premature labor and deliver a low-birthweight baby.\n\n\n",

            "Breast Enlargement\n\n\n" +
                    "Much of the breast tenderness you experienced during the first trimester should be wearing off, " +
                    "but your breasts are still growing as they prepare to feed your baby. Going up a bra size (or more) " +
                    "and wearing a good support bra can make you feel more comfortable.\n\n\n",

            "Frequent Urination\n\n\n" +
                    "Your uterus will rise away from the pelvic cavity during the second trimester, giving you a brief break " +
                    "from having to keep going to the bathroom. Don't get too comfortable, though. The urge to go will come " +
                    "back during the last trimester of your pregnancy.\n\n\n",

            "Hair Growth\n\n\n" +
                    "Pregnancy hormones can boost hair growth and not always where you want it. The hair on your head " +
                    "will become thicker. You may also be seeing hair in places you never had it before, including your " +
                    "face, arms, and back. Shaving and tweezing might not be the easiest options, but they're probably your " +
                    "safest bets right now. Many experts don't recommend laser hair removal, electrolysis, waxing, or " +
                    "depilatories during pregnancy, because research still hasn't proven that they are safe for the baby. " +
                    "Check to see what your doctor recommends.\n\n\n",

            "Headache\n\n\n" +
                    "Headaches are one of the most common pregnancy complaints. Try to get plenty of rest, and practice " +
                    "relaxation techniques, such as deep breathing. Aspirin and ibuprofen shouldn’t be taken during " +
                    "pregnancy, but your doctor may say it's OK for you to take acetaminophen if you're really uncomfortable.\n\n\n",

            "Hemorrhoids\n\n\n" +
                    "Hemorrhoids are actually varicose veins swollen blue or purple veins that form around the anus. " +
                    "These veins may enlarge during pregnancy, because extra blood is flowing through them and there is " +
                    "increased pressure on them from the growing uterus. Varicose veins can be itchy and uncomfortable. To " +
                    "relieve them, try sitting in a warm tub or sitz bath. Ask your doctor whether you can use an over-the-counter " +
                    "hemorrhoid ointment.\n\n\n",

            "Skin Changes\n\n\n" +
                    "Pregnant women often look as though they are glowing because changing hormone levels make " +
                    "the skin on the face appear flushed. An increase in the pigment melanin can also lead to brown marks " +
                    "on the face (often called the mask of pregnancy) and a dark line (linea nigra) down the middle of " +
                    "the abdomen. All of these skin changes should fade after the baby is born. In the meantime, " +
                    "you can use makeup to conceal them.\n\n\n"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_by__week__pregnancy);

        viewPager = findViewById(R.id.viewPager);
        btnImagePrevious = findViewById(R.id.btnImagePrevious);
        btnImageNext = findViewById(R.id.btnImageNext);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        adapter = new ViewPagerWeek(SecondTrimister.this, list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);

        btnImagePrevious.setOnClickListener(this);
        btnImageNext.setOnClickListener(this);

        int pos = getIntent().getIntExtra("key", 0);
        viewPager.setCurrentItem(pos);
        setPage(pos);
    }

    @Override
    public void onClick(View v) {
        if (v == btnImagePrevious) {
            if (position > 0) {
                position--;
                viewPager.setCurrentItem(position);
            }
        } else if (v == btnImageNext) {
            if (position < list.length - 1) {
                position++;
                viewPager.setCurrentItem(position);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        this.position = position;
        setPage(position);
    }

    private void setPage(int page) {
        totalImage = list.length;
        if (page == 0) {
            btnImageNext.setVisibility(View.VISIBLE);
            btnImagePrevious.setVisibility(View.INVISIBLE);
        } else if (page == totalImage - 1) {
            btnImageNext.setVisibility(View.INVISIBLE);
            btnImagePrevious.setVisibility(View.VISIBLE);
        } else {
            btnImageNext.setVisibility(View.VISIBLE);
            btnImagePrevious.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.maain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
