package com.example.myproject;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myproject.R;


public class DosActivity extends Fragment {

    ListView doslist;
    ArrayAdapter<String> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dos, container, false);
        doslist=(ListView)view.findViewById(R.id.dosPregnancy);
        String[] values = new String[] {

                "•\tSee your doctor regularly. Prenatal care" +
                        "can help keep you and your baby healthy" +
                        "and spot problems if they occur." ,

                "•\tContinue taking folic acid throughout" +
                        "your pregnancy. All women capable" +
                        "of pregnancy should get 400 to 800" +
                        "micrograms (400 to 800 mcg or 0.4 to" +
                        "0.8 mg) of folic acid every day. Getting" +
                        "enough folic acid lowers the risk of some" +
                        "birth defects. Taking a vitamin with folic" +
                        "acid will help you to be sure you are" +
                        "getting enough." ,

                "•\tEat a variety of healthy foods. Include" +
                        "fruits, vegetables, whole grains, calciumrich" +
                        "foods, lean meats, and a variety of" +
                        "cooked seafood." ,

                "•\tGet all essential nutrients, including iron," +
                        "every day. Getting enough iron prevents" +
                        "anemia, which is linked to preterm birth" +
                        "and low-birth weight babies. Ask your" +
                        "doctor about taking a daily prenatal" +
                        "vitamin or iron supplement." ,

                "•\tDrink extra fluids, especially water." ,

                "•\tGet moving! Unless your doctor tells you" +
                        "otherwise, physical activity is good for" +
                        "you and your baby." ,

                "•\tGain a healthy amount of weight. Gaining" +
                        "more than the recommended amount" +
                        "during pregnancy increases a woman’s" +
                        "risk for pregnancy complications. It also" +
                        "makes it harder to lose the extra pounds" +
                        "after childbirth. Check with your doctor" +
                        "to find out how much weight you should" +
                        "gain during pregnancy." ,

                "•\tWash hands, especially after handling raw" +
                        "meat or using the bathroom." ,

                "•\tGet enough sleep. Aim for 7 to 9 hours" +
                        "every night. Resting on your left side" +
                        "helps blood flow to you and your baby" +
                        "and prevents swelling. Using pillows" +
                        "between your legs and under your belly" +
                        "will help you get comfortable." ,

                "•\tSet limits. If you can, control the stress" +
                        "in your life and set limits. Don’t be afraid" +
                        "to say “no” to requests for your time and" +
                        "energy. Ask for help from others." ,

                "•\tMake sure health problems are treated and" +
                        "kept under control. If you have diabetes," +
                        "control your blood sugar levels. If you" +
                        "have high blood pressure, monitor it" +
                        "closely." ,

                "•\tAsk your doctor before stopping any" +
                        "medicines you take or taking any new" +
                        "medicines. Prescription, over-thecounter," +
                        "and herbal medicine all can harm" +
                        "your baby." ,

                "•\tGet a flu shot. Pregnant women can" +
                        "get very sick from the flu and may need" +
                        "hospital care. Ask your doctor about the" +
                        "flu vaccine." ,

                "•\tAlways wear a seatbelt. The lap strap" +
                        "should go under your belly, across your" +
                        "hips. The shoulder strap should go" +
                        "between your breasts and to the side of" +
                        "your belly. Make sure it fits snuggly." ,

                "•\tJoin a childbirth or parenting class." +
                        "page 2" +
                        "H e a lt h y P r e g n a n c y" +
                        "Steer clear of these pregnancy no-nos" +
                        "to help keep you and your baby safe and" +
                        "healthy. ",

                "•\tDO take your prenatal vitamin every day, particularly in the first trimester.  A lot of baby development is going on during that time." ,

                "•\tDO exercise during your pregnancy unless it is contraindicated by disability or your physician.  Even walking for a few minutes a day can improve your health." ,

                "•\tDO eat a variety of foods including fruits, vegetables, grains, lean protein, and dairy." ,

                "•\tDO follow your doctor’s advice.  He/She evaluates many things about the progression of your pregnancy and your health status." ,

                "•\tDO enjoy the companionship of friends and family members that will be supportive and encouraging to you during your pregnancy."
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_dos, R.id.textViewdosdonts, values);
        doslist.setAdapter(adapter);

        doslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getContext(),DosActivityDisplay.class);
                i.putExtra("key", position);
                startActivity(i);
            }
        });
        return view;
    }



}
