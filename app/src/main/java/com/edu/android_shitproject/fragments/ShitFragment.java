package com.edu.android_shitproject.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.android_shitproject.R;
import com.edu.android_shitproject.adpters.ShitPagerAdapter;
import com.edu.android_shitproject.base.Constants;
import com.edu.android_shitproject.entity.ShitEntity;

import java.util.ArrayList;
import java.util.List;

public class ShitFragment extends Fragment {
    private static final String TAG = "ShitFragment";
    private List<ShitEntity> shitEntities;

    private ViewPager viewPager;
    private ShitPagerAdapter adapter;
    private TabLayout tabLayout;
    private String[] items = {"专享", "视频", "纯文", "纯图", "精华"};
    private String[] types = {Constants.SHIT_ITEM_EXCLUSIVE,
            Constants.SHIT_ITEM_VIDEO,
            Constants.SHIT_ITEM_TEXT,
            Constants.SHIT_ITEM_IMAGE,
            Constants.SHIT_ITEM_LATEST
    };


    public ShitFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        shitEntities = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            ShitEntity shitEntity = new ShitEntity();
            shitEntity.setTitle(items[i]);
            shitEntity.setType(types[i]);
            shitEntities.add(shitEntity);
        }
        Log.d(TAG, "onCreateView: "+shitEntities.toString());
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shit, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        // 添加 fragment
        FragmentManager fm = getChildFragmentManager();
        adapter = new ShitPagerAdapter(fm, shitEntities);
        // 设置 viewPager
        viewPager.setAdapter(adapter);
        // 关联 tabLayout
        tabLayout.setupWithViewPager(viewPager);
    }
}
