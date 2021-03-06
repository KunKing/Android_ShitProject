package com.edu.android_shitproject;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.edu.android_shitproject.adpters.CommonPagerAdapter;
import com.edu.android_shitproject.fragments.CircleShitFragment;
import com.edu.android_shitproject.fragments.MessageFragment;
import com.edu.android_shitproject.fragments.SelectFragment;
import com.edu.android_shitproject.fragments.ShitFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private static final String TAG = "MainActivity";
    private DrawerLayout drawer;
    private NavigationView menu;
    private ActionBarDrawerToggle toggle;
    private List<Fragment> fragments;
    private CommonPagerAdapter adapter;
    private ViewPager viewPager;

    private int currentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionIcon(R.string.app_name);
        init();
    }

    private void initActionIcon(int title){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_ab_qiushi);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(title);
    }

    private void init() {
        setContentView(R.layout.activity_main);
        drawer = (DrawerLayout) findViewById(R.id.drawLayout);
        menu = (NavigationView) findViewById(R.id.menu);
        viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        // 初始化 fragments 集合
        fragments = new ArrayList<>();
        // 添加 fragment
        Fragment fragment = new ShitFragment();
        fragments.add(fragment);
        fragment = new CircleShitFragment();
        fragments.add(fragment);
        fragment = new SelectFragment();
        fragments.add(fragment);
        fragment = new MessageFragment();
        fragments.add(fragment);
        FragmentManager fm = getSupportFragmentManager();
        adapter = new CommonPagerAdapter(fm,fragments);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        menu.setNavigationItemSelectedListener(this);
        // 显示 home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, drawer, 0, 0);
        toggle.syncState();
        drawer.setDrawerListener(toggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 对于菜单 actionBar 的点击事件 控制 drawer
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        int count;
        switch (itemId) {
            case R.id.itemShit:
                count = 0;
                currentCount = count;
                item.setChecked(true);
                viewPager.setCurrentItem(count, false);
                // 重新创建 menu
                invalidateOptionsMenu();
                break;
            case R.id.itemCircle:
                count = 1;
                item.setChecked(true);
                currentCount = count;
                viewPager.setCurrentItem(count, false);
                invalidateOptionsMenu();
                break;
            case R.id.itemSelect:
                count = 2;
                item.setChecked(true);
                currentCount = count;
                viewPager.setCurrentItem(count, false);
                invalidateOptionsMenu();
                break;
            case R.id.itemMessage:
                count = 3;
                item.setChecked(true);
                currentCount = count;
                viewPager.setCurrentItem(count, false);
                invalidateOptionsMenu();
                break;
            case R.id.mineCollect:
                Toast.makeText(this, "我的收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.systemSetting:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quit:
                ActivityCompat.finishAffinity(this);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    // 切换 navigation item
    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                menu.setCheckedItem(R.id.itemShit);
                currentCount = 0;
                invalidateOptionsMenu();
                break;
            case 1:
                menu.setCheckedItem(R.id.itemCircle);
                currentCount = 1;
                invalidateOptionsMenu();
                break;
            case 2:
                menu.setCheckedItem(R.id.itemSelect);
                currentCount = 2;
                invalidateOptionsMenu();
                break;
            case 3:
                menu.setCheckedItem(R.id.itemMessage);
                currentCount = 3;
                invalidateOptionsMenu();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    // 设置 actionBar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_shit,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d(TAG, "当前 的 type 是 "+currentCount);
        menu.clear();
        MenuInflater inflater = this.getMenuInflater();
        switch (currentCount) {
            case 0:
                inflater.inflate(R.menu.menu_shit,menu);
                initActionIcon(R.string.app_name);
                break;
            case 1:
                inflater.inflate(R.menu.menu_circle_shit,menu);
                initActionIcon(R.string.app_name_circle);
                break;

            case 2:
                inflater.inflate(R.menu.menu_select,menu);
                initActionIcon(R.string.app_name_select);
                break;
            case 3:
                inflater.inflate(R.menu.menu_message,menu);
                initActionIcon(R.string.app_name_message);
                break;
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
