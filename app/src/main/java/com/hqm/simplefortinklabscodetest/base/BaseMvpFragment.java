package com.hqm.simplefortinklabscodetest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;



/**
 * Created by john on 2017/7/25.
 */

public abstract class BaseMvpFragment <P extends BasePresenter> extends BaseFragment implements BaseView {


    protected P mPresenter;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter = getPresenter();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void showLoading(String tips) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showEmptyState() {

    }

    @Override
    public void showNoNetworkState() {

    }

    /**
     * 获取presenter
     * @return
     */
    protected abstract P getPresenter();

}
