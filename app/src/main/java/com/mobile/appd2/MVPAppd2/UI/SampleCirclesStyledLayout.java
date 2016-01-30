package com.mobile.appd2.MVPAppd2.UI;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.mobile.appd2.MVPAppd2.Fragment.BaseSampleActivity;
import com.mobile.appd2.MVPAppd2.Fragment.TestFragmentAdapter;
import com.mobile.appd2.MVPAppd2.R;
import com.viewpagerindicator.CirclePageIndicator;

public class SampleCirclesStyledLayout extends BaseSampleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themed_circles);

        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
}