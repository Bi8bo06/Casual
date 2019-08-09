package com.mvp.common.adapter;

import android.view.ViewGroup;

import com.mvp.common.base.BaseFragment;
import com.mvp.common.bean.HorizontalTabTitle;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Describe：滑动Fragment适配器
 * 如果滑动Fragment是同一个 使用双参构造方法 覆写 getTabFragment 返回Fragment
 * 如果滑动Fragment是不同的Fragment 使用第三参构造方法 传入对应的Fragment集合
 * <p>
 */
public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<HorizontalTabTitle> titles;
    private List<BaseFragment> fragments;

    /**
     * 使用该构造方法 必须重写 getTabFragment 返回对应的Fragment
     */
    public FragmentPagerAdapter(FragmentManager fm, List<HorizontalTabTitle> titles) {
        this(fm, titles, null);
    }

    public FragmentPagerAdapter(FragmentManager fm, List<HorizontalTabTitle> titles, List<BaseFragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }


    @Override
    public int getCount() {
        return titles != null ? titles.size() : 0;
    }


    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment;
        if (fragments == null || fragments.isEmpty()) {
            fragment = getTabFragment();
        } else {
            fragment = fragments.get(position);
        }
        if (fragment == null) {
            throw new NullPointerException("Fragment is  null,please give me a fragment!");
        }
        fragment.setFragmentData(titles.get(position));
        return fragment;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position).getTitle();
    }

    /**
     * 使用两参构造方法 必须重写 该方法 返回对应的Fragment
     */
    public BaseFragment getTabFragment() {
        return null;
    }
}
