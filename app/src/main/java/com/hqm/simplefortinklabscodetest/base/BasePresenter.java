package com.hqm.simplefortinklabscodetest.base;

/**
 * Created by john on 2017/7/25.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
