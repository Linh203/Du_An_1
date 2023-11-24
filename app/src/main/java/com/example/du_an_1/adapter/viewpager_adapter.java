package com.example.du_an_1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.du_an_1.fragment.frg_banan;
import com.example.du_an_1.fragment.frg_caidat;
import com.example.du_an_1.fragment.frg_home;
import com.example.du_an_1.fragment.frg_thongke;

public class viewpager_adapter extends FragmentStatePagerAdapter {


    public viewpager_adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new frg_home();
            case 1:
                return new frg_banan();
            case 2:
                return new frg_thongke();
            case 3:
                return new frg_caidat();
            default:
                return new frg_home();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
