package com.hqm.simplefortinklabscodetest.modules.main.presenter;

import com.hqm.simplefortinklabscodetest.base.RxPresenter;
import com.hqm.simplefortinklabscodetest.common.PaLog;
import com.hqm.simplefortinklabscodetest.modules.main.adapter.ItemListAdapter;
import com.hqm.simplefortinklabscodetest.modules.main.adapter.ItemListTemplet;
import com.hqm.simplefortinklabscodetest.modules.main.contract.ItemListFragmentContract;
import com.hqm.simplefortinklabscodetest.views.ListTemplet.ALoadDataListAdapterTemplet;
import com.hqm.simplefortinklabscodetest.views.adapter.RecyclerAdapter;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class ItemListFragmentPresenter extends RxPresenter<ItemListFragmentContract.View> implements ItemListFragmentContract.Presenter {

    private static final String TAG = ItemListFragmentPresenter.class.getSimpleName();
    private String mListType; //当前显示的列表类型

    private ALoadDataListAdapterTemplet mDataListAdapterTemplet;

    private ALoadDataListAdapterTemplet.IOnReceiveDataListener receiveDataListener = new ALoadDataListAdapterTemplet.IOnReceiveDataListener() {
        @Override
        public void onReceiveData(boolean success) {
            if (mIsRefash){
                mView.resetStatus();
            }

            if (success){
                PaLog.d(TAG, "onReceiveData()  load data success!");
            }else {
                PaLog.d(TAG, "onReceiveData()  load data error!");
            }

            if (!mDataListAdapterTemplet.hasMoreData()) {
                mView.showNoMore();
            }
            //控制无数据的视图
            if (mDataListAdapterTemplet.getAdapter().getData().size() > 0){
                mView.setNoDataStatus(false);
            }else {
                mView.setNoDataStatus(true);
            }
        }
    };

    private boolean mIsRefash = true; //true：刷新， false：加载更多


    public ItemListFragmentPresenter(RxFragment fragment, String listType){
        mFragment = fragment;
        mListType = listType;
        mDataListAdapterTemplet = new ItemListTemplet(new ItemListAdapter(mFragment.getContext()), mFragment);
        mDataListAdapterTemplet.setOnReceiveDataListener(receiveDataListener);
    }

    @Override
    public RecyclerAdapter getAdapter() {
        return mDataListAdapterTemplet.getAdapter();
    }

    @Override
    public void getData(final boolean isRefesh) {
        addSubscribe( io.reactivex.Observable.timer(2, TimeUnit.SECONDS).compose(mFragment.bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                PaLog.d("---getData()------isRefesh:" + isRefesh);
                if (isRefesh) {
                    mDataListAdapterTemplet.refreshData();
                }else {
                    mDataListAdapterTemplet.loadData();
                }
            }
        }));
    }



}
