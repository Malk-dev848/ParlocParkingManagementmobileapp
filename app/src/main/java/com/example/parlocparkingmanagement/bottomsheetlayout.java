package com.example.parlocparkingmanagement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.badge.BadgeDrawable;

import java.util.ArrayList;
import java.util.List;

public class bottomsheetlayout extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager2;
    private TabLayout tabLayout;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_layout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager2 = findViewById(R.id.view_pager2);
        tabLayout = findViewById(R.id.tab_layout);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();

        tabLayout.setupWithViewPager(viewPager2);

        viewPagerAdapter viewPagerAdapter = new viewPagerAdapter(getSupportFragmentManager(),0);
        viewPagerAdapter.addFragment(firstFragment,"Reserve Spot" );
        viewPagerAdapter.addFragment(secondFragment,"Start" );
        viewPagerAdapter.addFragment(thirdFragment,"Over View" );

        viewPager2.setAdapter(viewPagerAdapter);

    }


    static class viewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public viewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment,String title) {
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
        public CharSequence getPageTitle(int position){
            return fragmentTitle.get(position);
        }
    }
}
