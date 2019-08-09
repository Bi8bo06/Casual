package com.mvp.module.main.ui.main.mvp;

import com.mvp.common.net.Api;
import com.mvp.common.net.HttpUtils;
import com.mvp.common.net.NetConfig;
import com.mvp.common.net.RequestParam;
import com.mvp.common.net.callback.OnResultCallBack;
import com.mvp.common.utils.Utils;
import com.mvp.module.main.ui.main.mvp.contract.MainContract;

/**
 * Describe：首页Module
 */

public class MainModel implements MainContract.Model {

    @Override
    public void checkUpdate(OnResultCallBack callback) {
        RequestParam param = new RequestParam();
        param.addParameter("versionCode", Utils.getVersionCode());
        HttpUtils.getInstance()
                .setBaseUrl(NetConfig.Url.MY_SERVICE_URL)
                .getRequest(Api.CHECK_UPDATE, param, callback);
    }
}
