package com.hqm.simplefortinklabscodetest.modules.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hqm.simplefortinklabscodetest.R;
import com.hqm.simplefortinklabscodetest.base.BaseMvpFragment;
import com.hqm.simplefortinklabscodetest.common.PaLog;
import com.hqm.simplefortinklabscodetest.modules.main.contract.ItemListFragmentContract;
import com.hqm.simplefortinklabscodetest.modules.main.presenter.ItemListFragmentPresenter;
import com.hqm.simplefortinklabscodetest.views.RefreshRecyclerView;
import com.hqm.simplefortinklabscodetest.views.adapter.Action;

import butterknife.BindView;

public class ItemListFragment extends BaseMvpFragment<ItemListFragmentPresenter> implements ItemListFragmentContract.View {

    private static final String TAG = ItemListFragment.class.getSimpleName();

    public static final String TYPE_KEY = "type_key"; //当前显示的类别类型的key
    public static final String TYPE_CITY_GUIDE_LIST = "type_city_guide_list"; //city guide type
    public static final String TYPE_SHOP_LIST = "type_shop_list"; //shop type
    public static final String TYPE_EAT_LIST = "type_eat_list"; //eat type


    @BindView(R.id.rrv_list)
    RefreshRecyclerView mRefreshRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_item_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRefreshRecyclerView.setSwipeRefreshColors(getResources().getColor(R.color.color_swipe_refesh_color1),
                getResources().getColor(R.color.color_swipe_refesh_color2),
                getResources().getColor(R.color.color_swipe_refesh_color3));

        mRefreshRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                mRefreshRecyclerView.showSwipeRefresh();
                mPresenter.getData(true);
            }
        });
    }

    @Override
    public void showNoMore() {
        mRefreshRecyclerView.showNoMore();
    }

    @Override
    public void resetStatus() {
        mRefreshRecyclerView.dismissSwipeRefresh();
        //mRefreshRecyclerView.getRecyclerView().scrollToPosition(0);
    }

    @Override
    public void setNoDataStatus(boolean show) {

    }

    @Override
    public void showErrorState() {

    }

    @Override
    protected ItemListFragmentPresenter getPresenter() {
        //获取需要显示的列表类型
        String type = getArguments().getString(TYPE_KEY);
        PaLog.d(TAG, "arg:" + type);
        mPresenter = new ItemListFragmentPresenter(this, type);

        mRefreshRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRefreshRecyclerView.setAdapter(mPresenter.getAdapter());

        //上拉加载更多
        mRefreshRecyclerView.setLoadMoreAction(new Action() {
            @Override
            public void onAction() {
                PaLog.d(TAG, "--setLoadMoreAction---");
                mPresenter.getData(false);
            }
        });

        mRefreshRecyclerView.setRefreshAction(new Action() {
            @Override
            public void onAction() {
                mPresenter.getData(true);
            }
        });



        return mPresenter;
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        PaLog.e("------onFragmentFirstVisible-----");

    }
}
