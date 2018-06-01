package com.hqm.simplefortinklabscodetest.views.ListTemplet;

/**
 * Created by huangqianming on 17/3/30.
 */

public interface ILoadDataListTemplet {
    /**
     * 刷新
     */
    void refreshData();

    /**
     * 加载数据
     */
    void loadData();

    /**
     * 获取当前页码
     * @return
     */
    int getCurrentPage();

    /**
     * 总页数
     * @return
     */
    int getPageSize();

    /**
     * 判断是否还有更多数据
     * @return
     */
    boolean hasMoreData();
}
