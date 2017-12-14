package com.zc.decorate.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zc.decorate.R;
import com.zc.decorate.ui.TitleView;

public class ProgressActivity extends AppCompatActivity {

    TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        titleView = (TitleView)findViewById(R.id.title);
        titleView.setBackIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
