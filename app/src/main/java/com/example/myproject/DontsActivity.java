package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



/**
 * Created by Supriya on 14-02-2017.
 */

public class DontsActivity extends Fragment {

    ListView doslist;
    ArrayAdapter<String> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dos, container, false);
        doslist=(ListView)view.findViewById(R.id.dosPregnancy);
        String[] values = new String[] {


                "• Don’t smoke tobacco. Quitting is hard," +
                        "but you can do it! Ask your doctor for" +
                        "help. Smoking during pregnancy passes" +
                        "nicotine and cancer-causing drugs to your" +
                        "baby. Smoking also keeps your baby from" +
                        "getting needed nourishment and raises" +
                        "the risk of miscarriage, preterm birth, and" +
                        "infant death." ,

                "• Avoid exposure to toxic substances and" +
                        "chemicals, such as cleaning solvents, lead" +
                        "and mercury, some insecticides, and paint." +
                        "Pregnant women should avoid exposure" +
                        "to paint fumes." ,

                "• Protect yourself and your baby from foodborne" +
                        "illness, which can cause serious" +
                        "health problems and even death. Handle," +
                        "clean, cook, eat, and store food properly." ,

                "• Don’t drink alcohol. There is no known" +
                        "safe amount of alcohol a woman can drink" +
                        "while pregnant. Both drinking every day" +
                        "and drinking a lot of alcohol once in a" +
                        "while during pregnancy can harm the" +
                        "baby." ,

                "• Don’t use illegal drugs. Tell your doctor" +
                        "if you are using drugs. Marijuana," +
                        "cocaine, heroin, speed (amphetamines)," +
                        "barbiturates, and LSD are very dangerous" +
                        "for you and your baby." ,

                "• Don’t clean or change a cat’s litter" +
                        "box. This could put you at risk for" +
                        "toxoplasmosis, an infection that can be" +
                        "very harmful to the fetus." ,

                "• Don’t eat swordfish, king mackerel, shark," +
                        "and tilefish, which are high in mercury." +

                        "• Avoid contact with rodents and with their" +
                        "urine, droppings, or nesting material. This" +
                        "includes household pests and pet rodents," +
                        "such as guinea pigs and hamsters. Rodents" +
                        "can carry a virus that can be harmful or" +
                        "even deadly to your unborn baby." ,

                "• Don’t take very hot baths or use hot" +
                        "tubs or saunas. High temperatures can be" +
                        "harmful to the fetus, or cause you to faint." ,

                "• Don’t use scented feminine hygiene" +
                        "products. Pregnant women should" +
                        "avoid scented sprays, sanitary napkins," +
                        "and bubble bath. These products might" +
                        "irritate your vaginal area, and increase" +
                        "your risk of a urinary tract infection or" +
                        "yeast infection." ,

                "• Don’t\tdouche.\tDouching\tcan\tirritate\tthe" +
                        "vagina, force air into the birth canal and" +
                        "increase the risk of infection." ,

                "• Avoid x-rays. If you must have dental" +
                        "work or diagnostic tests, tell your dentist" +
                        "or physician that you are pregnant so that" +
                        "extra care can be taken.",

                "• DON’T indulge in alcohol, tobacco, and drugs during your pregnancy.  If you are a smoker try to reduce your smoking or stop all together.  We really don’t know of safe alcohol levels during pregnancy, so avoid drinking.   Of course, drugs are not safe for you or baby." ,

                "• DON’T get tattoos while you are pregnant.  You wouldn’t want any type of infection or complication to deal with while you are pregnant." ,

                "• DON’T over eat during pregnancy.  You may find that you have a “big appetite” but try to choose healthy snacking foods without a lot of caffeine and sugar.  Your doctor will be monitoring your weight and provide healthful suggestions. " ,

                "• DON’T spend time with abusive people.  Your focus should be on being healthy for both yourself and your baby.  Mental and physical abuse is harmful and damaging. " ,

                "• DON’T miss out on all the fun and excitement there is to have while you are expecting!  Read about helpful hints on parenting, and baby development .  Find a friend or friends that are pregnant and share the journey.  "

        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_dos, R.id.textViewdosdonts, values);
        doslist.setAdapter(adapter);

        doslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getContext(),DontsActivityDisplay.class);
                i.putExtra("key", position);
                startActivity(i);
            }
        });
        return view;
    }



}
