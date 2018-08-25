package com.hqm.simplefortinklabscodetest.modules.main.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.hqm.simplefortinklabscodetest.base.RxPresenter;
import com.hqm.simplefortinklabscodetest.common.Constants;
import com.hqm.simplefortinklabscodetest.modules.main.contract.MainContract;
import com.hqm.simplefortinklabscodetest.modules.main.fragment.ItemListFragment;
import com.hqm.simplefortinklabscodetest.views.adapter.CommonFragmentAdapter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    private CommonFragmentAdapter mTabAdapter;

    public MainPresenter(RxAppCompatActivity appCompatActivity){
        mActivity = appCompatActivity;
    }



    @Override
    public CommonFragmentAdapter getTabAdapter() {
        return mTabAdapter;
    }

    @Override
    public void initTitles(FragmentManager fragmentManager) {
        List<String> titles = new ArrayList<>();
        titles.add("CITY GUIDE");
        titles.add("SHOP");
        titles.add("EAT");
        mTabAdapter = new CommonFragmentAdapter(fragmentManager, getFragments(), titles);
        SharedPreferences sharedPreferences = mActivity.getSharedPreferences("test_sp", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("settings", 2).commit();
        sharedPreferences.edit().clear();
        sharedPreferences.edit().commit();
        Log.e("test", "sp value:" + sharedPreferences.getInt("settings", 0));

    }

    synchronized void find(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<Fragment>();

        ItemListFragment cityGuideFragment = new ItemListFragment();
        Bundle data = new Bundle();
        data.putString(Constants.IntentKey.LIST_TYPE, ItemListFragment.TYPE_CITY_GUIDE_LIST);
        cityGuideFragment.setArguments(data);

        ItemListFragment eatFragment = new ItemListFragment();
        Bundle idata = new Bundle();
        idata.putString(Constants.IntentKey.LIST_TYPE, ItemListFragment.TYPE_EAT_LIST);
        eatFragment.setArguments(idata);

        ItemListFragment shopFragment = new ItemListFragment();
        Bundle sdata = new Bundle();
        sdata.putString(Constants.IntentKey.LIST_TYPE, ItemListFragment.TYPE_SHOP_LIST);
        shopFragment.setArguments(sdata);

        fragments.add(cityGuideFragment);
        fragments.add(shopFragment);
        fragments.add(eatFragment);

        return fragments;
    }
}
