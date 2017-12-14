package com.zc.decorate.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.zc.decorate.R;
import com.zc.decorate.activities.CheckActivity;
import com.zc.decorate.activities.FindDesignerActivity;
import com.zc.decorate.activities.FindWorkerActivity;
import com.zc.decorate.activities.MarketActivity;
import com.zc.decorate.activities.ProgressActivity;
import com.zc.decorate.activities.ServiceActivity;
import com.zc.decorate.activities.SoftDecorateActivity;
import com.zc.decorate.activities.StrategyActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment {

    private RelativeLayout strategyLayout;
    private RelativeLayout progressLayout;
    private RelativeLayout marketLayout;
    private RelativeLayout serviceLayout;
    private RelativeLayout softDecorateLayout;
    private RelativeLayout checkLayout;
    private RelativeLayout findDesignLayout;
    private RelativeLayout findDecorateLayout;

    private View rootView;


    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView == null) {
            rootView = View.inflate(IndexFragment.this.getActivity(), R.layout.fragment_index, null);
            initView(rootView);
            init();
            // Inflate the layout for this fragment
        }

        //用来避免fragment重复创建问题
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }

        return rootView;
    }

    private void init(){
        strategyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), StrategyActivity.class);
                startActivity(intent);
            }
        });

        progressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ProgressActivity.class);
                startActivity(intent);
            }
        });

        marketLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), MarketActivity.class);
                startActivity(intent);
            }
        });
        serviceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ServiceActivity.class);
                startActivity(intent);
            }
        });
        softDecorateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SoftDecorateActivity.class);
                startActivity(intent);
            }
        });
        checkLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), CheckActivity.class);
                startActivity(intent);
            }
        });
        findDesignLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), FindDesignerActivity.class);
                startActivity(intent);
            }
        });
        findDecorateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), FindWorkerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView(View view) {

        strategyLayout = (RelativeLayout) view.findViewById(R.id.layout_stragety);
        progressLayout = (RelativeLayout) view.findViewById(R.id.layout_progress);
        marketLayout = (RelativeLayout) view.findViewById(R.id.layout_market);
        serviceLayout = (RelativeLayout) view.findViewById(R.id.layout_service);
        softDecorateLayout = (RelativeLayout) view.findViewById(R.id.layout_soft_decorate);
        checkLayout = (RelativeLayout) view.findViewById(R.id.layout_check);
        findDecorateLayout = (RelativeLayout) view.findViewById(R.id.layout_find_decorate);
        findDesignLayout = (RelativeLayout) view.findViewById(R.id.layout_find_design);


    }

}
