package com.example.yunwen.master_webview;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class JS_WebViewActivity extends AppCompatActivity {

    private Button mBt_js1;
    private Button mBt_js2;
    private WebView mWv_html;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js__web_view);

        mBt_js1 = (Button) findViewById(R.id.bt_js1);
        mBt_js2 = (Button) findViewById(R.id.bt_js2);
        mWv_html = (WebView) findViewById(R.id.wv_html);

        WebSettings settings = mWv_html.getSettings();
        settings.setJavaScriptEnabled(true);

        mWv_html.loadUrl("file:///android_asset/web.html");

        mWv_html.addJavascriptInterface(JS_WebViewActivity.this,"android");

        mBt_js1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWv_html.loadUrl("javascript:javacalljs()");
            }
        });

        mBt_js2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWv_html.loadUrl("javascript:javacalljswith(\" + \"'http://blog.csdn.net/Leejizhou'\" + \")");
            }
        });

    }

    @JavascriptInterface
    public void startFunction(){
      runOnUiThread(new Runnable() {
          @Override
          public void run() {
              Toast.makeText(JS_WebViewActivity.this, "调用Js", Toast.LENGTH_SHORT).show();
          }
      });
    }

    @JavascriptInterface
    public void startFunction(final String text){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(JS_WebViewActivity.this).setMessage(text).show();

            }
        });
    }
}
