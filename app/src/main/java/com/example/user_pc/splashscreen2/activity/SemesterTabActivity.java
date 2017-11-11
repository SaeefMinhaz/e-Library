package com.example.user_pc.splashscreen2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.user_pc.splashscreen2.R;
import com.example.user_pc.splashscreen2.adapter.SectionPageAdapter;
import com.example.user_pc.splashscreen2.fragment.Tab1Fragment;
import com.example.user_pc.splashscreen2.fragment.Tab2Fragment;
import com.example.user_pc.splashscreen2.fragment.Tab3Fragment;
import com.example.user_pc.splashscreen2.fragment.Tab4Fragment;

public class SemesterTabActivity extends AppCompatActivity {

    private static final String TAG = "Mainactivity";
    private SectionPageAdapter mSectionPageAdapter;

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        setContentView(R.layout.activity_semester_tab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(TAG, "onCreate: Starting.");

        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "1ST SEMESTER");
        adapter.addFragment(new Tab2Fragment(), "2ND SEMESTER");
        adapter.addFragment(new Tab3Fragment(), "3RD SEMESTER");
        adapter.addFragment(new Tab4Fragment(), "4TH SEMESTER");
        viewPager.setAdapter(adapter);
    }
}
