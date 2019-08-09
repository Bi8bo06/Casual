package com.mvp.module.main.ui.main;

import android.text.TextUtils;
import android.widget.RadioGroup;

import com.mvp.common.base.ActionBarActivity;
import com.mvp.common.base.BaseFragment;
import com.mvp.common.bean.AppInfo;
import com.mvp.common.bean.Template;
import com.mvp.common.constants.ARouterConfig;
import com.mvp.common.utils.ARouterUtils;
import com.mvp.module.R;
import com.mvp.module.R2;
import com.mvp.module.main.ui.main.mvp.MainPresenter;
import com.mvp.module.main.ui.main.mvp.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;

/**
 * Describe：程序入口
 */
public class MainActivity extends ActionBarActivity<MainPresenter> implements MainContract.View {
    @BindView(R2.id.rg_main)
    RadioGroup mainTab;

    private List<Fragment> mFragmentList = new ArrayList<>();
    //首页模块Fragment
    private BaseFragment homeFragment = ARouterUtils.getFragment(ARouterConfig.HOME_FRAGMENT);
    //控件模块Fragment
    private BaseFragment controlFragment = ARouterUtils.getFragment(ARouterConfig.CONTROL_FRAGMENT);
    //我的模块Fragment
    private BaseFragment userFragment = ARouterUtils.getFragment(ARouterConfig.USER_FRAGMENT);

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_main;
    }

    @Override
    protected void initView() {
        actionBar.showBackImg(false);
        changeFragment(ARouterConfig.HOME_FRAGMENT);
        setTitleText(R.string.main_tab_home);
        mainTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb_main){
                    changeFragment(ARouterConfig.HOME_FRAGMENT);
                    setTitleText(R.string.main_tab_home);
                }else if(checkedId  == R.id.rb_center){
                    changeFragment(ARouterConfig.CONTROL_FRAGMENT);
                    setTitleText(R.string.main_tab_center);
                }else if (checkedId == R.id.rb_user){
                    changeFragment(ARouterConfig.USER_FRAGMENT);
                    setTitleText(R.string.main_tab_user);
                }else{
                    changeFragment(ARouterConfig.HOME_FRAGMENT);
                    setTitleText(R.string.main_tab_home);
                }
            }
        });
    }

    @Override
    public void needUpdate(AppInfo appInfo) {

    }

    @Override
    public void tabList(List<Template> blockList) {

    }

    /**
     * Fragment 发生改变
     *
     * @param tag Fragment 类名
     */
    public void changeFragment(String tag) {
        hideFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            transaction.show(fragment);
        } else {
            if (TextUtils.equals(tag, ARouterConfig.HOME_FRAGMENT)) {
                fragment = homeFragment;
            } else if (TextUtils.equals(tag, ARouterConfig.CONTROL_FRAGMENT)) {
                fragment = controlFragment;
            } else if (TextUtils.equals(tag, ARouterConfig.USER_FRAGMENT)) {
                fragment = userFragment;
            } else {
                fragment = homeFragment;
            }
            mFragmentList.add(fragment);
            transaction.add(R.id.fl_context, fragment, tag);
        }
        transaction.commitAllowingStateLoss();
    }


    /**
     * 隐藏所有Fragment
     */
    private void hideFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (Fragment f : mFragmentList) {
            transaction.hide(f);
        }
        transaction.commit();

    }
}
