package com.xxx.sx_demo.fragment.mainfragment;

import com.xxx.sx_demo.base.BaseApplication;
import com.xxx.sx_demo.base.BaseFragment;

/**
 * Created by niuapp on 2016/8/22 11:03.
 * Project : XX_Project.
 * Email : *******
 * --> 首页Fragment集合
 */
public class MainFragmentFactory {

    private static final String PAGER_HOME = "PAGER_HOME";
    private static final String PAGER_SEARCH = "PAGER_SEARCH";
    private static final String PAGER_APPRAISEMENT = "PAGER_APPRAISEMENT";

    /**
     * 通过页名 得到Fragment
     * @param pagerName
     * @return
     */
    public static BaseFragment createFragment(String pagerName) {

        // 从缓存中取出
        BaseFragment fragment = BaseApplication.getmMainFragments().get(pagerName);
        if (null == fragment) {
            switch (pagerName) {
                case PAGER_HOME:
                    fragment = new HomeFragment();
                    break;
                case PAGER_SEARCH:
                    fragment = new SearchFragment();
                    break;
                case PAGER_APPRAISEMENT:
                    fragment = new AppraisementFragment();
                    break;
                default:
                    break;
            }
            // 把frament加入到缓存中
            BaseApplication.getmMainFragments().put(pagerName, fragment);
        }
        return fragment;
    }
}
