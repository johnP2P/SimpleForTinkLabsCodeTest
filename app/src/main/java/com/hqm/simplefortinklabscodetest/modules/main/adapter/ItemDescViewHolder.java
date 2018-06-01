package com.hqm.simplefortinklabscodetest.modules.main.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hqm.simplefortinklabscodetest.R;
import com.hqm.simplefortinklabscodetest.model.bean.ItemBean;
import com.hqm.simplefortinklabscodetest.views.adapter.BaseViewHolder;

public class ItemDescViewHolder  extends BaseViewHolder<ItemBean> {

    private ImageView mImageShow;
    private TextView mTvTitle;
    private TextView mTvDesc;

    public ItemDescViewHolder(ViewGroup itemView, Context context) {
        super(itemView, R.layout.item_description);
    }

    @Override
    public void onInitializeView() {
        super.onInitializeView();
        mImageShow = findViewById(R.id.iv_image);
        mTvTitle = findViewById(R.id.tv_title);
        mTvDesc = findViewById(R.id.tv_desc);
    }

    @Override
    public void setData(ItemBean data) {
        super.setData(data);
        mTvTitle.setText(data.getTitle());
        mTvDesc.setText(data.getDescription());
    }

    @Override
    public void onItemViewClick(ItemBean data) {
        super.onItemViewClick(data);
    }
}
