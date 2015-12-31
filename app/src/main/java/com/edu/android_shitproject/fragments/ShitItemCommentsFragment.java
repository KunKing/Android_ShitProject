package com.edu.android_shitproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.edu.android_shitproject.R;
import com.edu.android_shitproject.adpters.ShitItemContentAdapter;
import com.edu.android_shitproject.entity.ShitCommentsEntity;
import com.edu.android_shitproject.tools.HttpUtils;
import com.edu.android_shitproject.widgets.MyListView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ShitItemCommentsFragment extends Fragment implements Callback<ShitCommentsEntity> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM = "userId";
    private static final String TAG = "ShitItemComments";

    private MyListView myListView;

    private ShitItemContentAdapter adapter;

    private Call<ShitCommentsEntity> call;
    private int page;

    public ShitItemCommentsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ShitItemCommentsFragment newInstance(String userId) {
        ShitItemCommentsFragment fragment = new ShitItemCommentsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, userId);
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
        return inflater.inflate(R.layout.fragment_shit_item_comments, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String userId = getArguments().getString(ARG_PARAM);
        page=1;
        myListView = (MyListView) view.findViewById(R.id.item_comments);
        adapter = new ShitItemContentAdapter(getContext());
        myListView.setAdapter(adapter);
        call =  HttpUtils.getService().getListItem(userId, page);
        call.enqueue(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResponse(Response<ShitCommentsEntity> response, Retrofit retrofit) {
        Log.d(TAG, "onResponse: "+response.body().getItems());
        adapter.addAll(response.body().getItems());
    }
    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(), "显示失败", Toast.LENGTH_SHORT).show();
    }
}
