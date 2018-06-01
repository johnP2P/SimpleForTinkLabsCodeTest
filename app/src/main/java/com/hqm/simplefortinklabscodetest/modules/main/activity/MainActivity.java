package com.hqm.simplefortinklabscodetest.modules.main.activity;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.hqm.simplefortinklabscodetest.R;
import com.hqm.simplefortinklabscodetest.base.BaseMvpActivity;
import com.hqm.simplefortinklabscodetest.modules.main.contract.MainContract;
import com.hqm.simplefortinklabscodetest.modules.main.presenter.MainPresenter;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View{

    @BindView(R.id.slid_tab_layout_community)
    SlidingTabLayout mSlidingTabLayoutCommunity;

    @BindView(R.id.vp_community)
    ViewPager mVpCommunity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        //初始化tab
        mPresenter.initTitles(getSupportFragmentManager());
        mVpCommunity.setAdapter(mPresenter.getTabAdapter());
        mVpCommunity.setOffscreenPageLimit(3);
        mSlidingTabLayoutCommunity.setViewPager(mVpCommunity);
        mSlidingTabLayoutCommunity.setCurrentTab(0);
    }


    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }


}
