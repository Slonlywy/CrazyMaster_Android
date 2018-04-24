package com.example.yunwen.master_webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText wv_url;
    private WebView wv_show;
    private Button wv_search;
    private WebView wv_show2;

    String replace = "<html>" +
            "<body>" +
            "<p>" +
            "①<span style=\"color: rgb(255, 0, 0);\">经销商申请进度/结果查询：</span>可<span style=\"color: rgb(0, 0, 0);\">通过无限极中国网站/APP→我→业务大厅→办理进度查询或留意短信通知</span>是否成功申请；</p><p>当月录入的申请，一般情况下，5个工作日内审核生效，具体时间建议以分公司实际处理为准。</p><p>②如有证照上传等系统操作疑问，请联系4008001188人工服务，或<a class=\"robot_people\" href=\"javascript:;\">在线客服</a>进行咨询</p>" +
            "</body></html>";
    private Button mBt_js;
    private Button mBt_js2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv_url = (EditText) findViewById(R.id.wv_url);
        wv_show = (WebView) findViewById(R.id.wv_show);
        wv_show2 = (WebView) findViewById(R.id.wv_show2);
        wv_search = (Button) findViewById(R.id.wv_search);
        mBt_js = (Button) findViewById(R.id.bt_js);
        mBt_js2 = (Button) findViewById(R.id.bt_js2);


        mBt_js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WebView_JsActivity.class);
                startActivity(intent);
            }
        });


        mBt_js2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JS_WebViewActivity.class);
                startActivity(intent);
            }
        });



        wv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = wv_url.getText().toString().trim();
                //WebView加载url
                wv_show.loadUrl(url);
            }
        });


        WebSettings settings = wv_show2.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(true);

        if (replace.contains("href=\"javascript:;\"")){
            replace=replace.replace("href=\"javascript:;\"","href=\"https://www.baidu.com\"");
        }
        Log.e("Html",replace);
        wv_show2.loadDataWithBaseURL(null, replace, "text/html", "utf-8", null);

        wv_show2.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("URL",url);
                if (url.equals("https://www.baidu.com/")){
                    Intent intent=new Intent();
                    intent.setAction(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:759670589@qq.com"));
                }
                return true;
            }
        });
    }



}
