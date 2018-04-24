package com.example.administrator.master_download;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String Url="http://pic32.photophoto.cn/20140711/0011024086081224_b.jpghttp://pic32.photophoto.cn/20140711/0011024086081224_b.jpg";
    private String Url2="http://services.gradle.org/distributions/gradle-4.4.1-bin.zip.sha256";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button download= (Button) findViewById(R.id.download);
        download.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.download:
                downLoadPicture();
                break;
        }
    }

    private void downLoadPicture(){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(Url2));
        request.setDestinationInExternalPublicDir(checkFile(),"hwj_down_picture");
        DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        dm.enqueue(request);
    }

    public String checkFile(){
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            File sDcardFile = Environment.getExternalStorageDirectory();
            String path = sDcardFile.getPath() + "/download_hwj";
            File file = new File(path);
            if (!file.exists()){
                file.mkdirs();
            }
            return path;
        }else {
            Toast.makeText(this, "无Sd卡", Toast.LENGTH_SHORT).show();
            return "";
        }
    }
}