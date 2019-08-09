package com.mvp.module.main.ui.control;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mvp.common.base.BaseMvpFragment;
import com.mvp.common.base.mvp.BasePresenter;
import com.mvp.common.constants.ARouterConfig;
import com.mvp.module.R;

/**
 * Describe：控件
 */
@Route(path = ARouterConfig.CONTROL_FRAGMENT)
public class ControlFragment extends BaseMvpFragment {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.control_fragment;
    }

    @Override
    protected void initView() {

    }
}
