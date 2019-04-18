package webview.com.mywebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webview);

        mWebView.loadUrl("http://222.240.51.117:8081");
//        mWebView.loadUrl("http://www.baidu.com");

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        webSettings.setJavaScriptEnabled(true);

        webSettings.setDomStorageEnabled(true);

        mWebView.setWebViewClient(new WebViewClient() {
            // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
