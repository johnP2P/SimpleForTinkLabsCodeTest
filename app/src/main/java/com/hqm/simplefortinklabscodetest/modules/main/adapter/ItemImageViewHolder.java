package com.hqm.simplefortinklabscodetest.modules.main.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hqm.simplefortinklabscodetest.R;
import com.hqm.simplefortinklabscodetest.model.bean.ItemBean;
import com.hqm.simplefortinklabscodetest.views.adapter.BaseViewHolder;

public class ItemImageViewHolder extends BaseViewHolder<ItemBean> {
    private ImageView mImageShow;

    public ItemImageViewHolder(ViewGroup itemView, Context context) {
        super(itemView, R.layout.item_image);
    }

    @Override
    public void onInitializeView() {
        super.onInitializeView();
        mImageShow = findViewById(R.id.img_show);
    }

    @Override
    public void setData(ItemBean data) {
        super.setData(data);
    }

    @Override
    public void onItemViewClick(ItemBean data) {
        super.onItemViewClick(data);
    }
}
