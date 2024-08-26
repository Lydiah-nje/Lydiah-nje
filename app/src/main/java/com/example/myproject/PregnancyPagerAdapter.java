package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PregnancyPagerAdapter extends FragmentStateAdapter {
    public PregnancyPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Implement the logic to create and return the appropriate Fragment
        // based on the position
        switch (position) {
            case 0:
                return new DashboardFragment();
            case 1:
                return new ResourcesFragment();
            default:
                return new DashboardFragment();
        }
    }

    @Override
    public int getItemCount() {
        // Return the number of Fragments/tabs
        return 4;
    }
}