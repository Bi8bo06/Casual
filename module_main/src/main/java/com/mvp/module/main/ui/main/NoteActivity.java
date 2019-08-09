package com.mvp.module.main.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

import com.mvp.module.R;

public class NoteActivity extends Activity {
    private WebView mWebView;
    private Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.node_activity);
        mWebView = (WebView) findViewById(R.id.webview);

    }
}
