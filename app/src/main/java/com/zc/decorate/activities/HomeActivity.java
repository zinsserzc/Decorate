package com.zc.decorate.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.zc.decorate.R;
import com.zc.decorate.fragments.CalculateFragment;
import com.zc.decorate.fragments.IndexFragment;
import com.zc.decorate.fragments.MyFragment;
import com.zc.decorate.fragments.PictureFragment;
import com.zc.decorate.ui.TabIndicatorView;


public class HomeActivity extends AppCompatActivity {

    //定义FragmentTabHost对象
    private FragmentTabHost mTabHost;
    //定义数组来存放Fragment界面
    private Class fragmentArray[] = {IndexFragment.class, PictureFragment.class, CalculateFragment.class, MyFragment.class};
    //定义数组来存放按钮图片
    private int mImageViewArrayNomal[] = {R.drawable.icon_index, R.drawable.icon_picture, R.drawable.icon_calculate, R.drawable.icon_my};
    private int mImageViewArrayFocus[] = {R.drawable.icon_index_pressed, R.drawable.icon_picture_pressed, R.drawable.icon_calculate_pressed, R.drawable.icon_my_pressed};
    //Tab选项卡的文字
    private String mTextviewArray[] = {"首页", "图库", "计算器", "我的"};
    private TabIndicatorView[] mTabIndicatorView = new TabIndicatorView[4];

    private boolean isFirstPress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        init();


    }

    private void init() {

        //得到fragment的个数
        int count = fragmentArray.length;
        for (int i = 0; i < count; i++) {
            mTabIndicatorView[i] = new TabIndicatorView(this);
            mTabIndicatorView[i].setDesc(mTextviewArray[i]);
            mTabIndicatorView[i].setIconId(mImageViewArrayFocus[i], mImageViewArrayNomal[i]);
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(mTabIndicatorView[i]);
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
        }



        mTabHost.getTabWidget().setDividerDrawable(android.R.color.white);//设置分割线
        mTabIndicatorView[3].setTabSelected(false);
        mTabIndicatorView[2].setTabSelected(false);
        mTabIndicatorView[1].setTabSelected(false);
        mTabIndicatorView[0].setTabSelected(true);
        mTabHost.setCurrentTab(0);

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                //int count = 0;
                isFirstPress = false;
                mTabIndicatorView[0].setTabSelected(false);
                mTabIndicatorView[1].setTabSelected(false);
                mTabIndicatorView[2].setTabSelected(false);
                mTabIndicatorView[3].setTabSelected(false);
                if (tabId.equals(mTextviewArray[0])) {
                    mTabIndicatorView[0].setTabSelected(true);
                    //count = 0;
                } else if (tabId.equals(mTextviewArray[1])) {
                    mTabIndicatorView[1].setTabSelected(true);
                    //count = 1;
                } else if (tabId.equals(mTextviewArray[2])) {
                    mTabIndicatorView[2].setTabSelected(true);
                    //count = 2;
                }else if(tabId.equals(mTextviewArray[3])){
                    mTabIndicatorView[3].setTabSelected(true);
                    //count = 3;
                }

            }
        });



    }

    private void initView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        /**
         * 在setup()里边，其才去获取到TabWidget，所以在此之前，不能直接调用getTabWidget()方法；
         */
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

    }

    @Override
    public void onBackPressed() {
        if (!isFirstPress) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            isFirstPress = true;
        } else {

        }

        //super.onBackPressed();
    }

    //测试用
    @Override
    public void onStart() {
        super.onStart();
        //List<Node> jbs=ServerUtil.getNodeInfos();
        //Toast.makeText(this,ServerUtil.getIP(),Toast.LENGTH_LONG).show();
    }


}
