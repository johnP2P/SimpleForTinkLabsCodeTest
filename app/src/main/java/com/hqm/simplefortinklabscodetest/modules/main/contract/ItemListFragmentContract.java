package com.hqm.simplefortinklabscodetest.modules.main.contract;

import com.hqm.simplefortinklabscodetest.base.BasePresenter;
import com.hqm.simplefortinklabscodetest.base.BaseView;
import com.hqm.simplefortinklabscodetest.views.adapter.RecyclerAdapter;

public class ItemListFragmentContract {

    public interface View extends BaseView {
        /**
         * 显示无更多数据
         */
        void showNoMore();

        /**
         * 恢复列表状态
         */
        void resetStatus();

        /**
         * 显示无数据视图
         */
        void setNoDataStatus(boolean show);
    }

    public interface Presenter extends BasePresenter<View> {

        /**
         * 获取设备adapter
         * @return
         */
        RecyclerAdapter getAdapter();

        /**
         * 请求数据
         * @param isRefesh true：刷新数据；false：加载下一页内容
         */
        void getData(boolean isRefesh);


    }
}
