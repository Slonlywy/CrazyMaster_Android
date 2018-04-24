package com.example.yunwen.master_webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WuxianjiWebViewActivity extends AppCompatActivity {

    private WebView mWv_wuxianji;
    private ProgressBar mPb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wuxianji_web_view);

        mWv_wuxianji = (WebView) findViewById(R.id.wv_wuxianji);
        mPb = (ProgressBar) findViewById(R.id.pb);

        mWv_wuxianji.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWv_wuxianji.loadUrl(url);
                return false;
            }
        });

        WebSettings settings = mWv_wuxianji.getSettings();
        settings.setJavaScriptEnabled(true);
        mWv_wuxianji.loadUrl("http://wechat.infinitus.com.cn/wechat-front/html5/build/saleAids/display.html?openId=oDaA9uAZ7kSOUaUk_3lQrjo4CrhE&literatureId=108&staffNum=337045138&resource=undefined");

        mWv_wuxianji.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress<100){
                    mWv_wuxianji.setVisibility(View.GONE);
                    mPb.setVisibility(View.VISIBLE);
                }else {
                    mPb.setVisibility(View.GONE);
                    mWv_wuxianji.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
