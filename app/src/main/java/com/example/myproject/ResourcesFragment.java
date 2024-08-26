package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myproject.Chat.ChatActivity;

public class ResourcesFragment extends Fragment {

    private LinearLayout dosAndDontsCard, dueDateCalcCard, enterSymptomsCard, bookAppointmentCard, chatActivityCard,  predictRiskCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resources, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dosAndDontsCard = view.findViewById(R.id.dos_and_donts_card);
        dueDateCalcCard = view.findViewById(R.id.due_date_calc_card);
        enterSymptomsCard = view.findViewById(R.id.enter_symptoms_card);
        bookAppointmentCard = view.findViewById(R.id.book_appointment_card);
        chatActivityCard = view.findViewById(R.id.chat_activity_card);
        predictRiskCard = view.findViewById(R.id.predict_risk_card);



        // Set click listeners for each card
        dosAndDontsCard.setOnClickListener(v -> startActivity(new Intent(getActivity(), DosandDonts.class)));
        dueDateCalcCard.setOnClickListener(v -> startActivity(new Intent(getActivity(), PregnancyDueDate.class)));
        enterSymptomsCard.setOnClickListener(v -> startActivity(new Intent(getActivity(), PregnancyTrackerActivity.class)));
        bookAppointmentCard.setOnClickListener(v -> startActivity(new Intent(getActivity(), PatientAppointmentActivity.class)));
        chatActivityCard.setOnClickListener(v -> startActivity(new Intent(getActivity(), ChatActivity.class)));
        predictRiskCard.setOnClickListener(v -> startActivity(new Intent(getActivity(), ExplanationActivity.class)));


    }
}
