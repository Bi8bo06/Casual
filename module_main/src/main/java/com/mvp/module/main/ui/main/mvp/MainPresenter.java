package com.mvp.module.main.ui.main.mvp;

import com.mvp.common.base.mvp.BasePresenter;
import com.mvp.common.bean.AppInfo;
import com.mvp.common.net.callback.OnResultCallBack;
import com.mvp.module.main.ui.main.mvp.contract.MainContract;
import com.orhanobut.logger.Logger;

/**
 * Describe：首页Presenter
 */
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> implements MainContract.Presenter {

    @Override
    protected MainContract.Model createModule() {
        return new MainModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void checkUpdate() {
        if (isViewAttached()) {
            getModule().checkUpdate(new OnResultCallBack<AppInfo>() {
                @Override
                public void onSuccess(boolean success, int code, String msg, Object tag, AppInfo response) {
                    //需要更新
                    getView().needUpdate(response);
                }

                @Override
                public void onFailure(Object tag, Exception e) {
                    Logger.e(e.getMessage());
                }

                @Override
                public void onCompleted() {

                }
            });
        }
    }

    @Override
    public void getTabList() {

    }
}
