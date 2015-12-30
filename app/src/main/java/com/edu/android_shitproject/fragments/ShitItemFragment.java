package com.edu.android_shitproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.edu.android_shitproject.R;
import com.edu.android_shitproject.activities.ShitItemActivity;
import com.edu.android_shitproject.adpters.ShitItemAdapter;
import com.edu.android_shitproject.dao.ShitService;
import com.edu.android_shitproject.entity.ShitItemEntity;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ShitItemFragment extends Fragment implements Callback<ShitItemEntity>, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM = "type";

    private ListView listView;
    private ShitItemAdapter adapter;
    private Call<ShitItemEntity> call;

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
         String type = getArguments().getString(ARG_PARAM);
         listView = (ListView) view.findViewById(R.id.shitListView);
         adapter = new ShitItemAdapter(getContext());
         adapter.setOnClickListener(this);
         listView.setAdapter(adapter);
         Retrofit build = new Retrofit.Builder()
                 .baseUrl("http://m2.qiushibaike.com")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
         ShitService service = build.create(ShitService.class);
         call = service.getList(type, 1);
         call.enqueue(this);
         super.onViewCreated(view, savedInstanceState);
     }

    @Override
    public void onResponse(Response<ShitItemEntity> response, Retrofit retrofit) {
        adapter.addAll(response.body().getItems());
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(), "显示失败", Toast.LENGTH_SHORT).show();
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
}
