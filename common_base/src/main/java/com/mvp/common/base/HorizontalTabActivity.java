package com.mvp.common.base;

import com.mvp.common.adapter.FragmentPagerAdapter;
import com.mvp.common.base.mvp.BasePresenter;
import com.mvp.common.bean.HorizontalTabTitle;
import com.mvp.common.widget.PagerSlidingTabStrip;

import java.util.List;

import androidx.annotation.CallSuper;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Describe：带水平选项卡的Activity
 */
public abstract class HorizontalTabActivity<P extends BasePresenter> extends ActionBarActivity<P> {
    @BindView(R2.id.pst_tab)
    PagerSlidingTabStrip tabStrip;

    @BindView(R2.id.vp_list)
    ViewPager viewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_horizontal_tab;
    }

    @CallSuper
    @Override
    protected void initView() {
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), getTabTitles()) {
            @Override
            public BaseFragment getTabFragment() {
                return HorizontalTabActivity.this.getTabFragment();
            }
        });
        tabStrip.setViewPager(viewPager);
    }

    protected abstract List<HorizontalTabTitle> getTabTitles();

    protected abstract BaseFragment getTabFragment();
}
