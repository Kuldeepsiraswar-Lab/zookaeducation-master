package com.kuldeep.zooka_education;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.kuldeep.zooka_education.Fragment.Resultpage;
import com.kuldeep.zooka_education.Fragment.SchemePage;
import com.kuldeep.zooka_education.Fragment.StudyPage;
import com.kuldeep.zooka_education.Fragment.NewsPage;
import com.kuldeep.zooka_education.Fragment.TechPage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(new InternetDialog(this).getInternetStatus());
        viewPager = (NonSwipeableViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }
    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Zooka Study");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.ic_readingbook_selected, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Zooka Result");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.ic_result_selected, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Zooka Tech");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.ic_laptop_selected, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabfour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabfour.setText("Zooka News");
        tabfour.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.ic_newspaper_selected, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabfour);

        TextView tabfive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabfive.setText("Govt. Scheme");
        tabfive.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.ic_scheme_selected, 0, 0);
        tabLayout.getTabAt(4).setCustomView(tabfive);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Resultpage(), "Study");
        adapter.addFrag(new StudyPage(), "Result");
        adapter.addFrag(new TechPage(), "Tech");
        adapter.addFrag(new NewsPage(), "News");
        adapter.addFrag(new SchemePage(), "Scheme");
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

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}