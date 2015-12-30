package com.edu.android_shitproject.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.android_shitproject.R;
import com.edu.android_shitproject.adpters.ShitItemContentPagerAdapter;
import com.edu.android_shitproject.entity.CommentEntity;
import com.edu.android_shitproject.entity.ShitItemEntity;
import com.edu.android_shitproject.tools.CircleTransformation;
import com.edu.android_shitproject.tools.ShitGetURL;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ShitItemActivity extends AppCompatActivity {

    private static final String TAG = "ShitItemActivity";

    private  TextView tvName;
    private  ImageView tvIcon;
    private  TextView content;
    private  ImageView imageView;
    private  TextView type;
    private  ImageButton showPlayIcon;

    //------laugh
    private  TextView tvLaugh;
    private  TextView tvComment;
    private  TextView tvShare;
    private  TextView tvBorn;

    private  ImageButton ivMore;

    // 切换 fragment
    private TabLayout tabLayoutShit;
    private ViewPager viewPagerShit;

    private String[] items = {"全部","热门"};
    private ShitItemContentPagerAdapter adapter;
    private List<CommentEntity> commentEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_shit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init() {
        tvIcon = (ImageView) findViewById(R.id.user_item_icon);
        tvName = (TextView) findViewById(R.id.user_item_name);
        content = (TextView) findViewById(R.id.item_content);
        imageView = (ImageView) findViewById(R.id.item_imageView);
        showPlayIcon = (ImageButton) findViewById(R.id.item_showPlayIcon);
        type = (TextView) findViewById(R.id.item_type);
        tvLaugh = (TextView) findViewById(R.id.item_tvLaugh);
        tvComment = (TextView) findViewById(R.id.item_tvComment);
        tvShare = (TextView) findViewById(R.id.item_tvShare);
        tvBorn = (TextView) findViewById(R.id.item_tvBorn);
        ivMore = (ImageButton) findViewById(R.id.item_ivMore);

        commentEntities = new ArrayList<>();
        tabLayoutShit = (TabLayout) findViewById(R.id.item_tabLayout);
        viewPagerShit = (ViewPager) findViewById(R.id.item_viewPager);

        Intent intent = getIntent();
        ShitItemEntity.ItemsEntity item = (ShitItemEntity.ItemsEntity) intent.getSerializableExtra("item");
        Log.d(TAG, "onCreate: " + item.getId());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("糗事 " + item.getId());

        // 获取 屏幕宽高
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //拿到屏幕宽高
        int screenWidth =  displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        // 设定值
        if (item.getUser()!=null){
            tvName.setText(item.getUser().getLogin());
            Picasso.with(this)
                    .load(ShitGetURL.getIconURL(item.getUser().getId(), item.getUser().getIcon()))
                    .transform(new CircleTransformation())
                    .into(tvIcon);
        }else {
            tvName.setText("匿名用户");
            Picasso.with(this)
                    .load(R.mipmap.tuotuo_avatar)
                    .transform(new CircleTransformation())
                    .into(tvIcon);
        }

        if (item.getImage() == null) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setVisibility(View.VISIBLE);
            Picasso.with(this)
                    .load(ShitGetURL.getImageURL((String) item.getImage()))
                    .resize(screenWidth,0)
                    .placeholder(R.mipmap.ic_launcher) // 下载中的图片 占位图片
                    .error(R.mipmap.ic_launcher) // 下载失败的图片
                    .into(imageView);
        }

        // 设置 热门 还是 新鲜
        if (!"".equals(item.getType()) && item.getType() != null && !"null".equals(item.getType())) {
            Log.d(TAG, "getView: " + item.getType());
            if (item.getType().equals("hot")) {
                type.setText("热门");
                Drawable drawable = getResources().getDrawable(R.mipmap.ic_rss_hot);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                type.setCompoundDrawables(drawable, null, null, null);
            } else if (item.getType().equals("fresh")) {
                type.setText("新鲜");
                Drawable drawable = getResources().getDrawable(R.mipmap.im_ic_read);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                type.setCompoundDrawables(drawable, null, null, null);
            }
        } else {
            type.setText("");
            type.setCompoundDrawables(null, null, null, null);
        }

        // 是视频 显示 视频照片 和 播放按钮
        if (item.getFormat().equals("video")) {
            long times = item.getLoop();
            if (times > 10000) {
                times = times / 10000;
                tvBorn.setText(" · 再生 " + Long.toString(times) + "万");
            } else {
                tvBorn.setText(" · 再生 " + Long.toString(times));
            }
            imageView.setVisibility(View.VISIBLE);
            Picasso.with(this).load(item.getPic_url()).into(imageView);
            Log.d(TAG, "getView: " + item.getPic_url());
            showPlayIcon.setVisibility(View.VISIBLE);

        } else {
            tvBorn.setText("");
            showPlayIcon.setVisibility(View.GONE);
        }
        content.setText(item.getContent());
        tvLaugh.setText("好笑 " + "12");
        tvComment.setText(" · 评论 " + Integer.toString(item.getComments_count()));
        tvShare.setText(" · 分享 " + Integer.toString(item.getShare_count()));

        for (int i = 0; i < items.length; i++) {
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setTitle(items[i]);
            commentEntity.setUserId(Integer.toString(item.getId()));
            commentEntities.add(commentEntity);
        }

        FragmentManager fm = getSupportFragmentManager();
        adapter = new ShitItemContentPagerAdapter(fm,commentEntities);
        viewPagerShit.setAdapter(adapter);
        tabLayoutShit.setupWithViewPager(viewPagerShit);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch ( itemId) {
            // 返回键的点击
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
