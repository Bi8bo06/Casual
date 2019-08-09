package com.mvp.module.main.ui.main.mvp.contract;

import com.mvp.common.base.mvp.IBaseModel;
import com.mvp.common.base.mvp.IBaseView;
import com.mvp.common.bean.AppInfo;
import com.mvp.common.bean.Template;
import com.mvp.common.net.callback.OnResultCallBack;

import java.util.List;

/**
 * Describe：契约类
 */
public interface MainContract {
    interface Model extends IBaseModel {

        /**
         * 检查更新
         *
         * @param callback 回调函数
         */
        void checkUpdate(OnResultCallBack callback);
    }

    interface View extends IBaseView {

        /**
         * 需要更新
         *
         * @param appInfo appInfo
         */
        void needUpdate(AppInfo appInfo);

        /**
         * 控件tab数据列表
         *
         * @param blockList blockList
         */
        void tabList(List<Template> blockList);
    }

    interface Presenter {
        /**
         * 检查更新
         */
        void checkUpdate();

        /**
         * 获取控件tab数据
         */
        void getTabList();
    }
}
