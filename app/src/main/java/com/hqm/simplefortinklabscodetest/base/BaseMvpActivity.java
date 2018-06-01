package com.hqm.simplefortinklabscodetest.base;




import android.widget.Toast;


/**
 * Created by john on 2017/7/25.
 * MVP activity 基类
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements BaseView {

    protected P mPresenter;


    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

    }



    /**
     * 网络状况方式变化
     * @param hasNetwork
     */
    protected void receiveNetStataus(boolean hasNetwork){

    }


    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
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


    @Override
    public void showErrorState() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        hideLoading();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        hideLoading();
    }

    /**
     * 获取presenter
     * @return
     */
    protected abstract P getPresenter();
}
