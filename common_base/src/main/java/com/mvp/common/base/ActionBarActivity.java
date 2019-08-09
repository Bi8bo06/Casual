package com.mvp.common.base;

import android.os.Bundle;

import com.mvp.common.base.mvp.BasePresenter;
import com.mvp.common.widget.ActionBar;

import androidx.annotation.Nullable;

/**
 * Describe：所有带actionBar的Activity基类
 */
public abstract class ActionBarActivity<P extends BasePresenter> extends BaseMvpActivity<P> {
    //    @BindView(R2.id.actionbar)
    protected ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        actionBar = findViewById(R.id.actionbar);
    }

    protected void setTitleText(String title) {
        if (actionBar != null) {
            actionBar.setCenterText(title);
        }
    }

    protected void setTitleText(int title) {
        if (actionBar != null) {
            actionBar.setCenterText(getString(title));
        }
    }

    @Override
    protected boolean isActionBar() {
        return true;
    }
}
