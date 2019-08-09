package com.mvp.common.base;

import com.mvp.common.base.mvp.BasePresenter;
import com.mvp.common.listener.OnListItemClickListener;
import com.mvp.common.widget.pulltorefresh.OnPullRefreshListener;
import com.mvp.common.widget.pulltorefresh.PullToRefreshLayout;

import androidx.annotation.CallSuper;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Describe：带下拉刷新 上拉加载更多的Fragment
 * 内部实现为刷新控件 PullToRefreshLayout + 列表控件 RecyclerView
 */
public abstract class RefreshListFragment<P extends BasePresenter> extends BaseMvpFragment<P> implements OnPullRefreshListener, OnListItemClickListener {
    @BindView(R2.id.ptrl_list)
    PullToRefreshLayout refreshLayout;

    @BindView(R2.id.recycle_view)
    RecyclerView recyclerView;

    protected RecyclerView.Adapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_refresh;
    }

    @CallSuper
    @Override
    protected void initView() {
        adapter = createAdapter();
        refreshLayout.setOnPullRefreshListener(this);
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(adapter);
    }

    @CallSuper
    @Override
    public void dismissLoading() {
        super.dismissLoading();
        stopRefresh();
    }

    @CallSuper
    @Override
    public void showLoading() {
        super.showLoading();
        hideEmptyView();
    }

    /**
     * 停止刷新
     */
    protected void stopRefresh() {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();

    }

    protected RecyclerView getRecyclerView() {
        return recyclerView;
    }

    protected PullToRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract RecyclerView.Adapter createAdapter();
}
