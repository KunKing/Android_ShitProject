package com.edu.android_shitproject.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.android_shitproject.R;
import com.edu.android_shitproject.entity.CommentEntity;
import com.edu.android_shitproject.entity.ShitCommentsEntity;
import com.edu.android_shitproject.entity.ShitItemEntity;
import com.edu.android_shitproject.tools.CircleTransformation;
import com.edu.android_shitproject.tools.ShitGetURL;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ming on 2015/12/30.
 */
public class ShitItemContentAdapter extends BaseAdapter {

    private Context context;
    private List<ShitCommentsEntity.ItemsEntity> items;

    public ShitItemContentAdapter(Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.shit_item_coments, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }

        ShitCommentsEntity.ItemsEntity item = items.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.tvUserName.setText(item.getUser().getLogin());
        Picasso.with(context)
                .load(ShitGetURL.getIconURL(item.getUser().getId(), item.getUser().getIcon()))
                .transform(new CircleTransformation())
                .into(holder.tvUserIcon);
        holder.tvContent.setText(item.getContent());
        holder.tvTime.setText(Integer.toString(item.getCreated_at()));
        holder.tvReplayCount.setText("2");
        holder.tvLikeCount.setText(Integer.toString(item.getLike_count()));
        return convertView;
    }

    public void addAll(Collection<? extends ShitCommentsEntity.ItemsEntity> collection) {
        items.addAll(collection);
        notifyDataSetChanged();
    }

    private static class ViewHolder {

        private final ImageView tvUserIcon;
        private final TextView tvUserName;
        private final TextView tvContent;
        private final TextView tvTime;
        private final TextView tvReplayCount;
        private final TextView tvLikeCount;

        public ViewHolder(View itemView) {
            tvUserIcon = (ImageView) itemView.findViewById(R.id.user_icon_comment);
            tvUserName = (TextView) itemView.findViewById(R.id.user_name_comment);
            tvContent = (TextView) itemView.findViewById(R.id.content_comment);
            tvTime = (TextView) itemView.findViewById(R.id.item_comment_time);
            tvReplayCount = (TextView) itemView.findViewById(R.id.tv_replayCount);
            tvLikeCount = (TextView) itemView.findViewById(R.id.tv_likeCount);
        }
    }


}
