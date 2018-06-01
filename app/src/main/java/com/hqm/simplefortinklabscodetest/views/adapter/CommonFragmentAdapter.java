package com.hqm.simplefortinklabscodetest.views.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 通用的FragmentPagerAdapter
 * Created by huangqianming on 17/3/27.
 */

public class CommonFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public CommonFragmentAdapter(FragmentManager manager, List<Fragment> list) {
        super(manager);
        mFragments = list;
    }


    public CommonFragmentAdapter(FragmentManager manager, List<Fragment> list, List<String>
            titles) {
        super(manager);
        mFragments = list;
        mTitles = titles;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null) {
            return mTitles.get(position);
        }
        return super.getPageTitle(position);
    }

}
