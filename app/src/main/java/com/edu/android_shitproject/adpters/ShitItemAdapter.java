package com.edu.android_shitproject.adpters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.android_shitproject.R;
import com.edu.android_shitproject.entity.ShitItemEntity;
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

    private static final String TAG = "ShitItemAdapter";
    private Context context;
    private List<ShitItemEntity.ItemsEntity> items;
    // 评论的监听事件
    private View.OnClickListener onClickListener;

    public ShitItemAdapter(Context context) {
        this.context = context;
        items = new ArrayList<>();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
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
        ShitItemEntity.ItemsEntity item = items.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        if (item.getUser() != null) {
            holder.tvName.setText(item.getUser().getLogin());
            Picasso.with(context)
                    .load(ShitGetURL.getIconURL(item.getUser().getId(), item.getUser().getIcon()))
                    .transform(new CircleTransformation())
                    .into(holder.tvIcon);
        } else {
            holder.tvName.setText("匿名用户");
            Picasso.with(context)
                    .load(R.mipmap.tuotuo_avatar)
                    .transform(new CircleTransformation())
                    .into(holder.tvIcon);
        }

        if (item.getImage() == null) {
            holder.imageView.setVisibility(View.GONE);
        } else {
            holder.imageView.setVisibility(View.VISIBLE);

            Picasso.with(context)
                    .load(ShitGetURL.getImageURL((String) item.getImage()))
                    .resize(parent.getWidth(), 0)
                    .placeholder(R.mipmap.ic_launcher) // 下载中的图片 占位图片
                    .error(R.mipmap.ic_launcher) // 下载失败的图片
                    .into(holder.imageView);
        }

        // 设置 热门 还是 新鲜
        if (!"".equals(item.getType()) && item.getType() != null && !"null".equals(item.getType())) {
            Log.d(TAG, "getView: " + item.getType());
            if (item.getType().equals("hot")) {
                holder.type.setText("热门");
                Drawable drawable = context.getResources().getDrawable(R.mipmap.ic_rss_hot);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                holder.type.setCompoundDrawables(drawable, null, null, null);
            } else if (item.getType().equals("fresh")) {
                holder.type.setText("新鲜");
                Drawable drawable = context.getResources().getDrawable(R.mipmap.im_ic_read);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                holder.type.setCompoundDrawables(drawable, null, null, null);
            }
        } else {
            holder.type.setText("");
            holder.type.setCompoundDrawables(null, null, null, null);
        }

        // 是视频 显示 视频照片 和 播放按钮
        if (item.getFormat().equals("video")) {
            long times = item.getLoop();
            if (times > 10000) {
                times = times / 10000;
                holder.tvBorn.setText(" · 再生 " + Long.toString(times) + "万");
            } else {
                holder.tvBorn.setText(" · 再生 " + Long.toString(times));
            }
            holder.imageView.setVisibility(View.VISIBLE);
            Picasso.with(context).load(item.getPic_url()).into(holder.imageView);
            Log.d(TAG, "getView: " + item.getPic_url());
            holder.showPlayIcon.setVisibility(View.VISIBLE);

        } else {
            holder.tvBorn.setText("");
            holder.showPlayIcon.setVisibility(View.GONE);
        }
        holder.content.setText(item.getContent());
        holder.tvLaugh.setText("好笑 " + "12");
        holder.tvComment.setText(" · 评论 " + Integer.toString(item.getComments_count()));
        holder.tvShare.setText(" · 分享 " + Integer.toString(item.getShare_count()));
        holder.ivComments.setTag(position);
        holder.ivMore.setTag(position);

        return convertView;
    }

    public void addAll(Collection<? extends ShitItemEntity.ItemsEntity> collection) {
        items.addAll(collection);
        Log.d(TAG, "addAll: " + items);
        notifyDataSetChanged();
    }

    // ------------------刷新的方法
    public void clear(){
        items.clear();
        notifyDataSetChanged();
    }

    private class ViewHolder {

        private final TextView tvName;
        private final ImageView tvIcon;
        private final TextView content;
        private final ImageView imageView;
        private final TextView type;
        private final ImageButton showPlayIcon;

        //------laugh
        private final TextView tvLaugh;
        private final TextView tvComment;
        private final TextView tvShare;
        private final TextView tvBorn;

        //----- btn comment
        private final ImageButton ivComments;
        private final ImageButton ivMore;


        public ViewHolder(View itemView) {
            tvName = (TextView) itemView.findViewById(R.id.user_name);
            tvIcon = (ImageView) itemView.findViewById(R.id.user_icon);
            content = (TextView) itemView.findViewById(R.id.content);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            showPlayIcon = (ImageButton) itemView.findViewById(R.id.showPlayIcon);

            type = (TextView) itemView.findViewById(R.id.type);
            tvLaugh = (TextView) itemView.findViewById(R.id.tvLaugh);
            tvComment = (TextView) itemView.findViewById(R.id.tvComment);
            tvShare = (TextView) itemView.findViewById(R.id.tvShare);
            tvBorn = (TextView) itemView.findViewById(R.id.tvBorn);

            ivComments = (ImageButton) itemView.findViewById(R.id.ivComments);
            ivMore = (ImageButton) itemView.findViewById(R.id.ivMore);
            ivComments.setOnClickListener(onClickListener);
        }
    }
}
