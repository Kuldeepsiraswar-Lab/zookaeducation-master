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
import com.kuldeep.zooka_education.R;
import com.kuldeep.zooka_education.SchemePageTab.Bihar;
import com.kuldeep.zooka_education.SchemePageTab.Chhattisgarh;
import com.kuldeep.zooka_education.SchemePageTab.Delhi;
import com.kuldeep.zooka_education.SchemePageTab.Gujarat;
import com.kuldeep.zooka_education.SchemePageTab.Haryana;
import com.kuldeep.zooka_education.SchemePageTab.HimachalPradesh;
import com.kuldeep.zooka_education.SchemePageTab.Home;
import com.kuldeep.zooka_education.SchemePageTab.Jharkhand;
import com.kuldeep.zooka_education.SchemePageTab.Karnataka;
import com.kuldeep.zooka_education.SchemePageTab.Kerala;
import com.kuldeep.zooka_education.SchemePageTab.MadhyaPradesh;
import com.kuldeep.zooka_education.SchemePageTab.Maharashtra;
import com.kuldeep.zooka_education.SchemePageTab.Manipur;
import com.kuldeep.zooka_education.SchemePageTab.Meghalaya;
import com.kuldeep.zooka_education.SchemePageTab.Odisha;
import com.kuldeep.zooka_education.SchemePageTab.Punjab;
import com.kuldeep.zooka_education.SchemePageTab.Rajasthan;
import com.kuldeep.zooka_education.SchemePageTab.Sikkim;
import com.kuldeep.zooka_education.SchemePageTab.TamilNadu;
import com.kuldeep.zooka_education.SchemePageTab.UttarPradesh;
import com.kuldeep.zooka_education.SchemePageTab.Uttarakhand;
import com.kuldeep.zooka_education.SchemePageTab.WestBengal;

import java.util.ArrayList;
import java.util.List;

public class SchemePage extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentActivity myContext;
    public SchemePage() {
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
        View v= inflater.inflate(R.layout.storepage, container, false);
        viewPager = (ViewPager)v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        return v;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Home(), "Home");
        adapter.addFragment(new Rajasthan(), "Rajasthan");
        adapter.addFragment(new UttarPradesh(), "Uttar-Pradesh");
        adapter.addFragment(new Delhi(), "New Delhi");
        adapter.addFragment(new Gujarat(), "Gujarat");
        adapter.addFragment(new Haryana(), "Haryana");
        adapter.addFragment(new Bihar(), "Bihar");
        adapter.addFragment(new Chhattisgarh(), "Chhattisgarh");
        adapter.addFragment(new HimachalPradesh(), "Himachal-Pradesh");
        adapter.addFragment(new Jharkhand(), "Jharkhand");
        adapter.addFragment(new Karnataka(), "Karnataka");
        adapter.addFragment(new Kerala(), "Kerala");
        adapter.addFragment(new MadhyaPradesh(), "Madhya-Pradesh");
        adapter.addFragment(new Maharashtra(), "Maharashtra");
        adapter.addFragment(new Manipur(), "Manipur");
        adapter.addFragment(new Meghalaya(), "Meghalaya");
        adapter.addFragment(new Odisha(), "Odisha");
        adapter.addFragment(new Punjab(), "Punjab");
        adapter.addFragment(new Sikkim(), "Sikkim");
        adapter.addFragment(new TamilNadu(), "TamilNadu");
        adapter.addFragment(new Uttarakhand(), "Uttarakhand");
        adapter.addFragment(new WestBengal(), "West-Bengal");


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