package com.hqm.simplefortinklabscodetest.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by john on 2017/7/25.
 * activity的基类
 */

public abstract class BaseActivity extends RxAppCompatActivity{
    protected Activity mContext;
    private Unbinder mUnBinder;
    protected CompositeDisposable mCompositeDisposable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnBinder = ButterKnife.bind(this);
        mContext = this;

        onViewCreated();
        initEventAndData();
    }

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
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
        unSubscribe();
    }

    /**
     * view 创建完成
     */
    protected void onViewCreated() {

    }

    /**
     * 子类设置layoutResID
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据和事件绑定
     */
    protected abstract void initEventAndData();

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();

    }





}
