package com.example.daihocproject.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.daihocproject.fragment.OptionFragment;
import com.example.daihocproject.fragment.PracticeFragment;

public class TabLayoutMainAdapter extends FragmentStatePagerAdapter {
    private String mNameTabAdmin[] = {"Luyện tập", "Cài đặt"};
    private PracticeFragment practiceFragment;
    private OptionFragment optionFragment;


    public TabLayoutMainAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        practiceFragment = new PracticeFragment();
        optionFragment = new OptionFragment();
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return practiceFragment;
            case 1:
                return optionFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mNameTabAdmin[position];
    }
}
