package com.hqm.simplefortinklabscodetest.base;

/**
 * Created by john on 2017/7/25.
 */

public interface BaseView {
    /**
     * 显示错误信息
     * @param msg
     */
    void showErrorMsg(String msg);

    /**
     * 显示进行中
     * @param tips 提示文字
     */
    void showLoading(String tips);

    void hideLoading();

    /**
     * 显示无状态
     */
    void showEmptyState();

    /**
     * 显示错误状态
     */
    void showErrorState();

    /**
     * 显示没网的状态
     */
    void showNoNetworkState();
}
