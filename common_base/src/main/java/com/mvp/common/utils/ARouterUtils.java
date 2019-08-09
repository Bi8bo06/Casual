package com.mvp.common.utils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mvp.common.base.BaseActivity;
import com.mvp.common.base.BaseFragment;

public class ARouterUtils {
    /**
     * 根据path返回Fragment
     *
     * @param path path
     * @return fragment
     */
    public static BaseFragment getFragment(String path) {
        return (BaseFragment) ARouter.getInstance()
                .build(path)
                .navigation();
    }

    /**
     * 根据path返回Activity
     *
     * @param path path
     * @return Activity
     */
    public static BaseActivity getActivity(String path) {
        return (BaseActivity) ARouter.getInstance()
                .build(path)
                .navigation();
    }
}
