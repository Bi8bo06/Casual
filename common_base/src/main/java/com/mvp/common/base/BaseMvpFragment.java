package com.mvp.common.base;

import android.os.Bundle;

import com.mvp.common.base.mvp.BasePresenter;
import com.mvp.common.base.mvp.IBaseView;

import androidx.annotation.Nullable;

/**
 * Describe：所有需要Mvp开发的Fragment的基类
 */
public abstract class BaseMvpFragment<P extends BasePresenter> extends BaseFragment implements IBaseView {
    protected P presenter;


    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建present
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }

    }


    //***************************************IBaseView方法实现*************************************
    @Override
    public void showLoading() {
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    @Override
    public void dismissLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void onEmpty(Object tag) {

    }

    @Override
    public void onError(Object tag, String errorMsg) {

    }
    //***************************************IBaseView方法实现*************************************

    /**
     * 创建Presenter
     */
    protected abstract P createPresenter();
}
