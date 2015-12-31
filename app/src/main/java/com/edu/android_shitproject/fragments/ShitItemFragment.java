package com.edu.android_shitproject.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.edu.android_shitproject.R;
import com.edu.android_shitproject.activities.ShitItemActivity;
import com.edu.android_shitproject.adpters.ShitItemAdapter;
import com.edu.android_shitproject.dao.ShitService;
import com.edu.android_shitproject.entity.ShitItemEntity;
import com.edu.android_shitproject.tools.HttpUtils;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ShitItemFragment extends Fragment implements Callback<ShitItemEntity>, View.OnClickListener, AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM = "type";
    private static final String TAG = "ShitItemFragment";

    private ListView listView;
    private ShitItemAdapter adapter;
    private Call<ShitItemEntity> call;
    private SwipeRefreshLayout refreshLayout;
    private int page;
    private String type;

    public ShitItemFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ShitItemFragment newInstance(String type) {
        ShitItemFragment fragment = new ShitItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shit_item, container, false);
    }

     @Override
     public void onViewCreated(View view, Bundle savedInstanceState) {
         type = getArguments().getString(ARG_PARAM);
         listView = (ListView) view.findViewById(R.id.shitListView);
         adapter = new ShitItemAdapter(getContext());
         adapter.setOnClickListener(this);
         listView.setAdapter(adapter);
         page = 1;

         //------------------------- 下拉刷新
         refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
         // 设置图标的性状
         refreshLayout.setSize(SwipeRefreshLayout.LARGE);
         refreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
         refreshLayout.setOnRefreshListener(this);
         //---------

         // 设置 listView 的 监听事件
         listView.setOnItemClickListener(this);
         call = HttpUtils.getService().getList(type,page);
         call.enqueue(this);
         super.onViewCreated(view, savedInstanceState);
     }

    @Override
    public void onResponse(Response<ShitItemEntity> response, Retrofit retrofit) {
        // 清空数据 需要判断 上拉加载还是下拉刷新 用page 判断
        if (page==1){
            adapter.clear();
        }
        adapter.addAll(response.body().getItems());
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(), "显示失败", Toast.LENGTH_SHORT).show();
        // 设置是否在刷新状态
        refreshLayout.setRefreshing(false);
    }

    // imageButton click 事件
    @Override
    public void onClick(View v) {
        int id = v.getId();
        Object tag = v.getTag();
        int position = -1;
        if (tag != null && tag instanceof Integer) {
            position = (int) tag;
        }
        switch (id) {
            case R.id.ivComments:
                if (position > -1) {
                    ShitItemEntity.ItemsEntity item = (ShitItemEntity.ItemsEntity) adapter.getItem(position);
                    Intent intent = new Intent(getContext(),ShitItemActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("item", item);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
        }

    }

    /**
     * 选中事件 处理 点击事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemSelected: "+id+"-***************-"+adapter.getItem(position));
        ShitItemEntity.ItemsEntity item = (ShitItemEntity.ItemsEntity) adapter.getItem(position);
        Intent intent = new Intent(getContext(),ShitItemActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", item);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
            // TODO: 2015/12/31  进行下拉刷新 取第一页的数据 得清空数据
            page = 1;
            // 一般放在成功拿到数据之后 这边是测试
            // adapter.clear();
            HttpUtils.getService().getList(type,page).enqueue(this);
    }
}
