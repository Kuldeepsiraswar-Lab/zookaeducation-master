package com.kuldeep.zooka_education.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;


import com.google.android.material.tabs.TabLayout;
import com.kuldeep.zooka_education.ResultPageTab.Admission;
import com.kuldeep.zooka_education.ResultPageTab.AdmitCard;
import com.kuldeep.zooka_education.ResultPageTab.Answerkey;
import com.kuldeep.zooka_education.ResultPageTab.Certificate;
import com.kuldeep.zooka_education.ResultPageTab.Cutoff;
import com.kuldeep.zooka_education.ResultPageTab.Jobs;
import com.kuldeep.zooka_education.ResultPageTab.Notification;
import com.kuldeep.zooka_education.ResultPageTab.Result;
import com.kuldeep.zooka_education.ResultPageTab.Schoolarship;
import com.kuldeep.zooka_education.ResultPageTab.Syllabus;
import com.kuldeep.zooka_education.R;
import com.kuldeep.zooka_education.ResultPageTab.University;

public class Resultpage extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentActivity myContext;

    public Resultpage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.resultpage, null);

        viewPager = (ViewPager)v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        return v;


    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Jobs(), "Latest Jobs");
        adapter.addFragment(new Result(), "Result");
        adapter.addFragment(new AdmitCard(), "Admit-Card");
        adapter.addFragment(new University(),"University Update");
        adapter.addFragment(new Notification(), "Notification");
        adapter.addFragment(new Answerkey(), "Answer-Key");
        adapter.addFragment(new Cutoff(), "Cut-Off");
        adapter.addFragment(new Admission(), "Admission");
        adapter.addFragment(new Schoolarship(), "Schoolarship");
        adapter.addFragment(new Certificate(), "Online Services");
        adapter.addFragment(new Syllabus(), "Syllabus");


        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
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