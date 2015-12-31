package com.edu.android_shitproject.adpters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.edu.android_shitproject.entity.ShitEntity;
import com.edu.android_shitproject.fragments.ShitFriendsItemFragment;

import java.util.List;

/**
 * Created by Ming on 2015/12/28.
 */
public class ShitFriendPagerAdapter extends FragmentPagerAdapter {
    private List<ShitEntity> shitEntities;

    public ShitFriendPagerAdapter(FragmentManager fm, List<ShitEntity> shitEntities) {
        super(fm);
        this.shitEntities = shitEntities;
    }


    @Override
    public Fragment getItem(int position) {
        // 判断传入的 fragment 是哪一个 类型的
        return ShitFriendsItemFragment.newInstance(shitEntities.get(position).getType());
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (shitEntities != null) {
            ret = shitEntities.size();
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return shitEntities.get(position).getTitle();
    }
}
