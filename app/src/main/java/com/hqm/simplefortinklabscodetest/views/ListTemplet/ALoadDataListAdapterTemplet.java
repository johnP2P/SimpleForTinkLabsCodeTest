package com.hqm.simplefortinklabscodetest.views.ListTemplet;


import com.hqm.simplefortinklabscodetest.views.adapter.RecyclerAdapter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.Map;


/**
 * Created by huangqianming on 17/3/30.
 */

public abstract class ALoadDataListAdapterTemplet<T extends RecyclerAdapter> implements ILoadDataListTemplet {
    protected int mCurrentPage = 1;
    protected int mPageSize = 5; //页的大小
    protected int mTotalPage = 0; //总页数
    protected int mCurrentSize = 0; //当前数据的个数
    protected T mAdapter;
    protected String mKeyWord = ""; //关键字
    protected Map<String, String> mParams; //请求参数
    protected IOnReceiveDataListener mOnReceiveDataListener;
    protected RxFragment mRxFragment;
    protected RxAppCompatActivity mRxActivity;

    public ALoadDataListAdapterTemplet(T mAdapter, RxFragment fragment) {
        this.mAdapter = mAdapter;
        this.mRxFragment = fragment;
    }

    public ALoadDataListAdapterTemplet(T mAdapter, RxAppCompatActivity mRxActivity) {
        this.mAdapter = mAdapter;
        this.mRxActivity = mRxActivity;
    }

    @Override
    public int getCurrentPage() {
        return mCurrentPage;
    }

    @Override
    public int getPageSize() {
        return mPageSize;
    }

    public T getAdapter() {
        return mAdapter;
    }

    @Override
    public void refreshData() {
        mCurrentPage = 1;
        mAdapter.clear();
        getData();
    }

    /**
     * 请求网络，获取到数据放到mAdapter 里面
     */
    protected abstract void getData();

    @Override
    public void loadData() {
        mCurrentPage++;
        getData();
    }

    public void setKeyword(String searchkey) {
        mKeyWord = searchkey;
    }

    @Override
    public boolean hasMoreData() {
        return mCurrentPage < mTotalPage ? true : false;
    }

    /**
     * 设置数据到达的通知 监听
     *
     * @param listener
     */
    public void setOnReceiveDataListener(IOnReceiveDataListener listener) {
        mOnReceiveDataListener = listener;
    }

    /**
     * 设置参数
     * @param params
     */
    public void setParams(Map<String, String> params){
        mParams = params;
    }

    /**
     * 数据到达的通知
     *
     * @param success true:数据成功， false：数据失败
     */
    protected void onReceiveData(boolean success) {
        if (mOnReceiveDataListener != null) {
            mOnReceiveDataListener.onReceiveData(success);
        }
    }

    public interface IOnReceiveDataListener {
        /**
         * 数据到达的通知
         *
         * @param success
         */
        void onReceiveData(boolean success);
    }
}
