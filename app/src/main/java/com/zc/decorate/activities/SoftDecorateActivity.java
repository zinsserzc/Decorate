package com.zc.decorate.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.zc.decorate.R;
import com.zc.decorate.ui.TitleView;

public class SoftDecorateActivity extends AppCompatActivity {
    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_decorate);
        titleView = (TitleView)findViewById(R.id.title);
        titleView.setBackIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
