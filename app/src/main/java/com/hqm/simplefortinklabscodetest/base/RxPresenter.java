package com.hqm.simplefortinklabscodetest.base;



import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by john on 2017/7/25.
 *  基于Rx的Presenter封装,控制订阅的生命周期
 */

public class RxPresenter<V extends BaseView> implements BasePresenter<V>{
    //UI 视图
    protected V mView;

    protected CompositeDisposable mCompositeDisposable;

    protected RxAppCompatActivity mActivity;

    protected RxFragment mFragment;



    //取消订阅
    protected void unSubscribe(){
        if (mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    //添加订阅
    protected void addSubscribe(Disposable subscription){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }


    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        this.mActivity = null;
        this.mFragment = null;
        unSubscribe();
    }
}
