package com.example.regischarles.fitheart;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.regischarles.fitheart.fragment.heartmeasure;
import com.example.regischarles.fitheart.fragment.heartreport;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {
    private ViewPager mViewPager;
    public ViewPagerAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tablayout);
        setSupportActionBar(toolbar);
        mViewPager = findViewById(R.id.container);


        setupViewPager(mViewPager);

        tabLayout.setupWithViewPager(mViewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new heartmeasure(this), "Heart Rate ");
        adapter.addFragment(new heartreport(this), "Display Results");

        viewPager.setAdapter(adapter);
    }
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
