package com.xxx.sx_demo.activity;

import android.view.View;

import com.xxx.sx_demo.R;
import com.xxx.sx_demo.base.BaseActivity;
import com.xxx.sx_demo.utils.UIUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void init() {
        isFullScreen = true; //全屏
    }

    @Override
    protected View getContentView() {
        return UIUtils.inflate(R.layout.activity_main);
    }

    @Override
    protected void initView() {

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIUtils.showToastSafe("哈哈哈哈哈哈哈哈哈哈哈哈和哈哈哈哈");
            }
        });
    }
}
