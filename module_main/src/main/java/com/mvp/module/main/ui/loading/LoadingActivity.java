package com.mvp.module.main.ui.loading;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.jaredrummler.android.widget.AnimatedSvgView;
import com.mvp.common.base.BaseActivity;
import com.mvp.common.utils.ActivityToActivity;
import com.mvp.module.R;
import com.mvp.module.R2;
import com.mvp.module.main.ui.main.MainActivity;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * Describe：应用启动页
 */
public class LoadingActivity extends BaseActivity {
    @BindView(R2.id.animated_svg_view)
    AnimatedSvgView mSvgView;
    @BindView(R2.id.activity_svg)
    RelativeLayout mActivitySvg;

    private long loadingTime = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSvg(ModelSVG.values()[4]);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        handler.sendEmptyMessageDelayed(0, loadingTime);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ActivityToActivity.toActivity(mContext, MainActivity.class);
        }
    };

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_loading;
    }

    private void setSvg(ModelSVG modelSvg) {
        mSvgView.setGlyphStrings(modelSvg.glyphs);
        mSvgView.setFillColors(modelSvg.colors);
        mSvgView.setViewportSize(modelSvg.width, modelSvg.height);
        mSvgView.setTraceResidueColor(0x32000000);
        mSvgView.setTraceColors(modelSvg.colors);
        mSvgView.rebuildGlyphData();
        mSvgView.start();
    }
}
