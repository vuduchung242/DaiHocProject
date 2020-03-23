package com.example.daihocproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.daihocproject.adapter.TabLayoutMainAdapter;
import com.example.daihocproject.base.BaseActivity;
import com.example.daihocproject.base.BaseViewPager;
import com.example.daihocproject.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private ViewPager mMainViewPager;
    private TabLayout mTabLayout;
    private View mTabView;
    private LinearLayout mLayoutTabOne;
    private LinearLayout mLayoutTabTwo;
    private ImageView mImageTabOne;
    private ImageView mImageTabTwo;
    private TextView mTitleTabOne;
    private TextView mTitleTabTwo;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = getViewBinding();
        binding.setMain(this);
        mMainViewPager = binding.mainViewpager;
        ((BaseViewPager) mMainViewPager).setPagingEnabled(false);
        mMainViewPager.setAdapter(new TabLayoutMainAdapter(getSupportFragmentManager()));
        mTabLayout = binding.tabLayout;
        mTabLayout.setupWithViewPager(mMainViewPager);
        mTabView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.tab_view, null, false);
        mLayoutTabOne = mTabView.findViewById(R.id.ll1);
        mLayoutTabTwo = mTabView.findViewById(R.id.ll2);
        mImageTabOne = mLayoutTabOne.findViewById(R.id.icon1);
        mImageTabTwo = mLayoutTabTwo.findViewById(R.id.icon2);
        mTitleTabOne = mLayoutTabOne.findViewById(R.id.tvtab1);
        mTitleTabTwo = mLayoutTabTwo.findViewById(R.id.tvtab2);
        initIcon();
        mMainViewPager.setOffscreenPageLimit(2);
    }

    private void initIcon() {
        mTitleTabOne.setText("Luyện tập");
        mTitleTabTwo.setText("Tùy chọn");
        mTitleTabTwo.setTextColor(getResources().getColor(R.color.gray_tab_view));

        mImageTabOne.setImageResource(R.drawable.ic_homework);
        mImageTabTwo.setImageResource(R.drawable.ic_setting_gray);

        mTabLayout.getTabAt(0).setCustomView(mLayoutTabOne);
        mTabLayout.getTabAt(1).setCustomView(mLayoutTabTwo);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        mImageTabOne.setImageResource(R.drawable.ic_homework);
                        mTitleTabOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case 1:
                        mImageTabTwo.setImageResource(R.drawable.ic_setting);
                        mTitleTabTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        mImageTabOne.setImageResource(R.drawable.ic_homework_gray);
                        mTitleTabOne.setTextColor(getResources().getColor(R.color.gray_tab_view));
                        break;
                    case 1:
                        mImageTabTwo.setImageResource(R.drawable.ic_setting_gray);
                        mTitleTabTwo.setTextColor(getResources().getColor(R.color.gray_tab_view));
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
