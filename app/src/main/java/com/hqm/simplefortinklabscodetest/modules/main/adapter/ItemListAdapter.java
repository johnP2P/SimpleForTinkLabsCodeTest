package com.hqm.simplefortinklabscodetest.modules.main.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.hqm.simplefortinklabscodetest.common.Constants;
import com.hqm.simplefortinklabscodetest.common.PaLog;
import com.hqm.simplefortinklabscodetest.model.bean.ItemBean;
import com.hqm.simplefortinklabscodetest.views.adapter.BaseViewHolder;
import com.hqm.simplefortinklabscodetest.views.adapter.RecyclerAdapter;

public class ItemListAdapter extends RecyclerAdapter<ItemBean> {

    private static final String TAG = ItemListAdapter.class.getSimpleName();
    private final int TYPE_DESC = 1000; //详情
    private final int TYPE_IMAGE = 1001; //单张图片

    public ItemListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<ItemBean> onCreateBaseViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_IMAGE){
            return new ItemImageViewHolder(parent, getContext());
        }
        return new ItemDescViewHolder(parent, getContext());
    }

    @Override
    public int getItemViewType(int position) {
        int type = super.getItemViewType(position);

        if (type == 0){
            try {
                ItemBean bean = getData().get((position));
                if (bean != null) {
                    if (bean.getType().equals(Constants.ItemType.IMAGE_TYPE)) {
                        type = TYPE_IMAGE;
                    } else {
                        type = TYPE_DESC;
                    }
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        PaLog.e(TAG,  "getItemViewType position:" + position + "， type:" + type);
        return type;
    }
}
