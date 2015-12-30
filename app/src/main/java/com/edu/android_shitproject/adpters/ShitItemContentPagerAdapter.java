package com.edu.android_shitproject.adpters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.edu.android_shitproject.entity.CommentEntity;
import com.edu.android_shitproject.entity.ShitEntity;
import com.edu.android_shitproject.fragments.ShitItemCommentsFragment;

import java.util.List;

/**
 * Created by Ming on 2015/12/30.
 */
public class ShitItemContentPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "ShitItemContentPager";
    private List<CommentEntity> commentEntities;

    public ShitItemContentPagerAdapter(FragmentManager fm, List<CommentEntity> commentEntities) {
        super(fm);
        this.commentEntities = commentEntities;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem: "+commentEntities.get(position).getUserId());
        return ShitItemCommentsFragment.newInstance(commentEntities.get(position).getUserId());
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (commentEntities != null) {
            ret = commentEntities.size();
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return commentEntities.get(position).getTitle();
    }
}
