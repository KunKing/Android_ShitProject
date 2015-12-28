package com.edu.android_shitproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.android_shitproject.R;
public class ShitItemFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM = "title";

    public ShitItemFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ShitItemFragment newInstance(String title) {
        ShitItemFragment fragment = new ShitItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, title);
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
         TextView textView = (TextView) view.findViewById(R.id.textItem);
         String title = getArguments().getString(ARG_PARAM);
         textView.setText(title);
         super.onViewCreated(view, savedInstanceState);
     }
 }
