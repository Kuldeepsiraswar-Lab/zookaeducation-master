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

import com.google.android.material.tabs.TabLayout;
import com.kuldeep.zooka_education.NewsPageTab.BharatpurNews;
import com.kuldeep.zooka_education.NewsPageTab.BusinessNews;
import com.kuldeep.zooka_education.NewsPageTab.EducationalNews;
import com.kuldeep.zooka_education.NewsPageTab.EntertainmentNews;
import com.kuldeep.zooka_education.NewsPageTab.FashionNews;
import com.kuldeep.zooka_education.NewsPageTab.FoodNews;
import com.kuldeep.zooka_education.NewsPageTab.HealthNews;
import com.kuldeep.zooka_education.NewsPageTab.JobsNews;
import com.kuldeep.zooka_education.NewsPageTab.LatestNews;
import com.kuldeep.zooka_education.NewsPageTab.NationalNews;
import com.kuldeep.zooka_education.NewsPageTab.PoliticsNews;
import com.kuldeep.zooka_education.NewsPageTab.ScienceNews;
import com.kuldeep.zooka_education.NewsPageTab.TechNews;
import com.kuldeep.zooka_education.R;

import java.util.ArrayList;
import java.util.List;

public class NewsPage extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentActivity myContext;
    public NewsPage() {
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
        View v= inflater.inflate(R.layout.newspage, container, false);
        viewPager = (ViewPager)v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        return v;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new LatestNews(), "Latest News");
        adapter.addFragment(new BharatpurNews(), "Bharatpur");
        adapter.addFragment(new EducationalNews(), "Educational");
        adapter.addFragment(new JobsNews(), "Jobs-News");
        adapter.addFragment(new ScienceNews(), "Science-News");
        adapter.addFragment(new TechNews(), "Tech News");
        adapter.addFragment(new NationalNews(), "National");
        adapter.addFragment(new PoliticsNews(), "Politics");
        adapter.addFragment(new BusinessNews(), "Business");
        adapter.addFragment(new EntertainmentNews(), "Entertainment");
        adapter.addFragment(new FashionNews(), "Fashion");
        adapter.addFragment(new FoodNews(), "Food");
        adapter.addFragment(new HealthNews(), "Health");


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