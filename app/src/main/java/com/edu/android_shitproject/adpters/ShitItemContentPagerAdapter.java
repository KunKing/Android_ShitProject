package com.edu.android_shitproject.adpters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.edu.android_shitproject.dao.LoadDatasCallBack;
import com.edu.android_shitproject.entity.CommentEntity;
import com.edu.android_shitproject.fragments.ShitItemCommentsFragment;

import java.util.List;

/**
 * Created by Ming on 2015/12/30.
 */
public class ShitItemContentPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "ShitItemContentPager";
    private List<CommentEntity> commentEntities;
    private LoadDatasCallBack LoadDatasCallBack;

    public ShitItemContentPagerAdapter(FragmentManager fm, List<CommentEntity> commentEntities,LoadDatasCallBack loadDatasCallBack) {
        super(fm);
        this.commentEntities = commentEntities;
        this.LoadDatasCallBack = loadDatasCallBack;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem: "+commentEntities.get(position).getUserId());
        return ShitItemCommentsFragment.newInstance(commentEntities.get(position).getUserId(), LoadDatasCallBack);
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
        Log.d(TAG, "getPageTitle() returned: " + commentEntities.get(position).getTitle());
        return commentEntities.get(position).getTitle();
    }


}
