package com.hqm.simplefortinklabscodetest.modules.main.contract;

import android.support.v4.app.FragmentManager;

import com.hqm.simplefortinklabscodetest.base.BasePresenter;
import com.hqm.simplefortinklabscodetest.base.BaseView;
import com.hqm.simplefortinklabscodetest.views.adapter.CommonFragmentAdapter;

public class MainContract {
    public interface View extends BaseView {


    }

    public interface Presenter extends BasePresenter<View> {

        CommonFragmentAdapter getTabAdapter();

        /**
         * 设置titles
         * @param fragmentManager
         */
        void initTitles( FragmentManager fragmentManager);
    }
}
