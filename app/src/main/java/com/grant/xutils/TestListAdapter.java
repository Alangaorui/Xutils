package com.grant.xutils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.utils.L;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by grant on 2018/4/24 0024.
 * list适配器
 */

public class TestListAdapter extends BaseAdapter {
    private Context mContext;
    private List<ListEntity> mList;
    public TestListAdapter(Context context, List<ListEntity> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        ListEntity listEntity = mList.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView =inflater.inflate(R.layout.test_adapter,null,false);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.list_image);
            holder.mTextName = (TextView) convertView.findViewById(R.id.name);
            holder.mTextMoney = (TextView) convertView.findViewById(R.id.name_money);
            convertView.setTag(holder);//一定要复用
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(mContext).load(listEntity.getBankLogo()).resize(110, 110).into(holder.mImageView);
        holder.mTextName.setText(listEntity.getBankName());
        holder.mTextMoney.setText(listEntity.getBankCode());
        return convertView;
    }

    class ViewHolder{
        private ImageView mImageView;
        private TextView mTextName;
        private TextView mTextMoney;

    }
}
