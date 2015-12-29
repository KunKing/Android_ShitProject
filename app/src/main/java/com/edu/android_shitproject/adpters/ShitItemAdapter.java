package com.edu.android_shitproject.adpters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.android_shitproject.R;
import com.edu.android_shitproject.entity.ShitItem;
import com.edu.android_shitproject.tools.CircleTransformation;
import com.edu.android_shitproject.tools.ShitGetURL;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ming on 2015/12/29.
 */
public class ShitItemAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private Context context;
    private List<ShitItem.ItemsEntity> items;

    public ShitItemAdapter(Context context) {
        this.context = context;
        items = new ArrayList<>();
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (items != null) {
            ret = items.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.shit_item, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ShitItem.ItemsEntity item = items.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        if (item.getUser() != null) {
            holder.tvName.setText(item.getUser().getLogin());
            Picasso.with(context)
                    .load(ShitGetURL.getIconURL(item.getUser().getId(), item.getUser().getIcon()))
                    .transform(new CircleTransformation())
                    .into(holder.tvIcon);
        } else {
            holder.tvName.setText("匿名用户");
            holder.tvIcon.setImageResource(R.mipmap.ic_launcher);
        }

        if (item.getImage() == null) {
            holder.image.setVisibility(View.GONE);
        } else {
            holder.image.setVisibility(View.VISIBLE);
            // resize(宽,高) 不可以为负数，不可以全为0 一个为0 另一个不为0  为0 的失效
            // fit() 可以匹配 imageView 在 listView 中不好用
            // centerInside() 居中适应大小
            // centerCrop() 剪切
            Picasso.with(context)
                    .load(ShitGetURL.getImageURL((String) item.getImage()))
                    .resize(parent.getWidth(), 0)
                    .placeholder(R.mipmap.ic_launcher) // 下载中的图片 占位图片
                    .error(R.mipmap.ic_launcher) // 下载失败的图片
                    .into(holder.image);
        }
        holder.content.setText(item.getContent());
        return convertView;
    }

    public void addAll(Collection<? extends ShitItem.ItemsEntity> collection){
        items.addAll(collection);
        Log.d(TAG, "addAll: "+items);
        notifyDataSetChanged();
    }

    private static class ViewHolder {

        private final TextView tvName;
        private final ImageView tvIcon;
        private final TextView content;
        private final ImageView image;

        public ViewHolder(View itemView) {
            tvName = (TextView) itemView.findViewById(R.id.user_name);
            tvIcon = (ImageView) itemView.findViewById(R.id.user_icon);
            content = (TextView) itemView.findViewById(R.id.content);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
