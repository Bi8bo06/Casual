package com.mvp.module.main.ui.home;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mvp.common.base.BaseMvpFragment;
import com.mvp.common.base.mvp.BasePresenter;
import com.mvp.common.constants.ARouterConfig;
import com.mvp.module.R;

/**
 * Describe：首页
 */
@Route(path = ARouterConfig.HOME_FRAGMENT)
public class HomeFragment extends BaseMvpFragment {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView() {

    }
}
