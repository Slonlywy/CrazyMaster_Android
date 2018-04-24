package com.example.yunwen.master_webview;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.vise.log.ViseLog;

public class WebView_JsActivity extends AppCompatActivity {

    private WebView mWv_js;
    private WebSettings mSettings;
    private ProgressBar mTv_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //实例化webview
        mWv_js = (WebView) findViewById(R.id.wv_js);
        mTv_progress = (ProgressBar) findViewById(R.id.wv_progress);



        mSettings = mWv_js.getSettings();
        //可以js交互
        mWv_js.getSettings().setJavaScriptEnabled(true);
        //自适应屏幕
        mWv_js.getSettings().setUseWideViewPort(true);


        //可以缩放
        mWv_js.getSettings().setSupportZoom(true);//支持缩放，默认为true。是下面那个的前提。
        mWv_js.getSettings().setBuiltInZoomControls(true);//设置内置的缩放控件。若为false，则该WebView不可缩放

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mWv_js.getSettings().setDisplayZoomControls(false);//隐藏原生的缩放控件
        }


        /**
         * 当加载 html 页面时，WebView会在/data/data/包名目录下生成 database 与 cache 两个文件夹
         * 请求的 URL记录保存在 WebViewCache.db，而 URL的内容是保存在 WebViewCache 文件夹下
         */

        //其他细节操作
        mSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存

        //LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
        //LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
        //LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
        //LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。

        mSettings.setAllowFileAccess(true); //设置可以访问文件
        mSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        mSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        mSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        mSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        mSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        mSettings.setLoadWithOverviewMode(true);

        //在当前页面加载网页
        mWv_js.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                ViseLog.d("拦截到Url"+url);
                view.loadUrl(url);
                return false;
            }


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                ViseLog.d("开始加载.....");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                ViseLog.d("结束加载.....");
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                ViseLog.d("错误："+errorCode+"\n"+description);
                //可以判断  无网络时加载本地Html
            }

        });


       //打开新的页面显示
        mWv_js.setWebChromeClient(new WebChromeClient(){
            /**
             * 获取进度条
             * @param view
             * @param newProgress
             */
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress<100){
                    mTv_progress.setVisibility(View.VISIBLE);
                    mTv_progress.setProgress(newProgress);
                }else{
                    mTv_progress.setVisibility(View.GONE);
                }
            }


            /**
             * 获取网页Title
             * @param view
             * @param title
             */
            @Override
            public void onReceivedTitle(WebView view, String title) {
                ViseLog.d(title);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                new AlertDialog.Builder(WebView_JsActivity.this)
                        .setTitle("JsAlert")
                        .setMessage(message)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                result.confirm();
                            }
                        }).setCancelable(false)
                        .show();
                return true;
            }
        });

        //加载地址Url
        mWv_js.loadUrl("http://wechat.infinitus.com.cn/wechat-front/html5/build/saleAids/display.html?openId=oDaA9uAZ7kSOUaUk_3lQrjo4CrhE&literatureId=108&staffNum=337045138&resource=undefined");

    }
}
