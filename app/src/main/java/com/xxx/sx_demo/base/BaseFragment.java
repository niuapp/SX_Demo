package com.xxx.sx_demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xxx.sx_demo.utils.ViewUtils;

/**
 * Created by niuapp on 2016/8/22 10:30.
 * Project : XX_Project.
 * Email : *******
 * -->
 * 继承这个类通过pagerName创建
 */
public abstract class BaseFragment extends Fragment {

    private View fragmentContentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isCanLoad = false;
        //缓存View对象
        if (fragmentContentView == null) {
            fragmentContentView = initFragmentView(inflater, container, savedInstanceState);
        } else {
            //被ViewPager复用不能有父控件，移除
            ViewUtils.removeSelfFromParent(fragmentContentView);
        }

        return fragmentContentView;
    }

    /**
     * 初始化布局
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    protected abstract View initFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 是否可见
     */
    private boolean isCanLoad = false;
    private boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
            onVisible();
        } else {
            onInvisible();
        }
    }

    /**
     * 可见
     */
    protected void onVisible() {
        isVisible = true; //可见
        if (isCanLoad && isVisible) {
            initData();//在可见，并且执行到onActivityCreated后才进行加载
        }
    }

    /**
     * 不可见
     */
    protected void onInvisible() {
        isVisible = false;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isCanLoad = true; //可加载
        if (isCanLoad && isVisible) {
            initData();//在可见，并且执行到onActivityCreated后才进行加载
        }
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();
}
