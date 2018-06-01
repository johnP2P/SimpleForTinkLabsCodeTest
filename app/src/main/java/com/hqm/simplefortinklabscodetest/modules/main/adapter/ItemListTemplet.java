package com.hqm.simplefortinklabscodetest.modules.main.adapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hqm.simplefortinklabscodetest.model.bean.ItemBean;
import com.hqm.simplefortinklabscodetest.views.ListTemplet.ALoadDataListAdapterTemplet;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ItemListTemplet extends ALoadDataListAdapterTemplet<ItemListAdapter> {
    private Gson mGson = new Gson();

    public ItemListTemplet(ItemListAdapter mAdapter, RxFragment fragment) {
        super(mAdapter, fragment);
        mTotalPage = 3; //写死3页，测试
    }

    @Override
    protected void getData() {
        mAdapter.addAll(getVirtualData());
        onReceiveData(true);
    }

    private List<ItemBean> getVirtualData() {
        List<ItemBean> result = new ArrayList<ItemBean>();
        Type type = new TypeToken<ArrayList<ItemBean>>() {}.getType();
        result = mGson.fromJson(getPage1JsonStr(), type);

        return result;
    }

    private String getPage1JsonStr(){
        return "[{\"id\":\"1001\",\"type\":\"2\",\"title\":\"title1\",\"description\":\"不容错过的好玩资讯1\",\"img_url\":\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527771873551&di=e457c0e83dc3eb342e77521bef9644e7&imgtype=0&src=http://pic1.win4000.com/wallpaper/5/532931489604e.jpg\"},{\"id\":\"1001\",\"type\":\"2\",\"title\":\"title2\",\"description\":\"不容错过的好玩资讯2\",\"img_url\":\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527792703770&di=e08b69376c8d9631048cac0bef4fe454&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F3801213fb80e7beca9004ec5252eb9389b506b38.jpg\"},{\"id\":\"1001\",\"type\":\"1\",\"title\":\"title3\",\"description\":\"不容错过的好玩资讯3\",\"img_url\":\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527771873551&di=e457c0e83dc3eb342e77521bef9644e7&imgtype=0&src=http://pic1.win4000.com/wallpaper/5/532931489604e.jpg\"},{\"id\":\"1001\",\"type\":\"2\",\"title\":\"title4\",\"description\":\"不容错过的好玩资讯4\",\"img_url\":\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527771873551&di=e457c0e83dc3eb342e77521bef9644e7&imgtype=0&src=http://pic1.win4000.com/wallpaper/5/532931489604e.jpg\"},{\"id\":\"1001\",\"type\":\"1\",\"title\":\"title5\",\"description\":\"不容错过的好玩资讯5\",\"img_url\":\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527771873551&di=e457c0e83dc3eb342e77521bef9644e7&imgtype=0&src=http://pic1.win4000.com/wallpaper/5/532931489604e.jpg\"}]";
    }
}
