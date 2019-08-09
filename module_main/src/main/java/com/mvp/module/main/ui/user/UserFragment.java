package com.mvp.module.main.ui.user;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mvp.common.base.BaseMvpFragment;
import com.mvp.common.base.mvp.BasePresenter;
import com.mvp.common.constants.ARouterConfig;
import com.mvp.module.R;

/**
 * Describe：我的
 */
@Route(path = ARouterConfig.USER_FRAGMENT)
public class UserFragment extends BaseMvpFragment {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_fragment;
    }

    @Override
    protected void initView() {

    }
}
