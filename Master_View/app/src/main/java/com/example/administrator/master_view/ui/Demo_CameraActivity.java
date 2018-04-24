package com.example.administrator.master_view.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.master_view.R;
import com.vise.log.ViseLog;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 相机拍摄
 * create by 黄伟嘉 on 2017/12/19
 * Camera类
 */
public class Demo_CameraActivity extends AppCompatActivity implements View.OnClickListener {

    //存储类型
    private static final int CAMERA_TYPE_IMAGE = 1;
    private static final int CAMERA_TYPE_VIDEO = 2;
    //返回结果码
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;

    private Button mBt_captureImage;
    private Button mBt_captureVideo;
    //存储文件
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__camera);

        initView();
        initEvent();
    }

    private void initEvent() {
        mBt_captureImage.setOnClickListener(this);
        mBt_captureVideo.setOnClickListener(this);
    }

    private void initView() {
        mBt_captureImage = (Button) findViewById(R.id.bt_capture_image);
        mBt_captureVideo = (Button) findViewById(R.id.bt_capture_video);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_capture_image:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri image_Uri = getOutPutMediaFileUri(CAMERA_TYPE_IMAGE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, image_Uri);
                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
                break;
            case R.id.bt_capture_video:
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                ViseLog.d(data.getData().toString());
            } else if (resultCode == RESULT_CANCELED) {
                ViseLog.d("取消了");
            } else {
                ViseLog.d("获取失败");
            }
        }
    }

    /**
     * 创建一个存储路径
     *
     * @param type 存储格式类型
     * @return
     */
    private File getOutPutMediaFile(int type) {
        //创建一个存储路径，调用context.getExternalFilesDir方法，则改文件夹随着应用删除，且其他应用不能修改删除
        File myCameraAppDir = new File(this.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "MyCameraApp");

        if (!myCameraAppDir.exists()) {
            myCameraAppDir.mkdirs();
        }


        //获取时间
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        if (type == CAMERA_TYPE_IMAGE) {
            file = new File(myCameraAppDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
        } else if (type == CAMERA_TYPE_VIDEO) {
            file = new File(myCameraAppDir.getPath() + File.separator + "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }
        return file;
    }

    /**
     * 获取存储的Uri
     *
     * @param type
     * @return
     */
    private Uri getOutPutMediaFileUri(int type) {
        return Uri.fromFile(getOutPutMediaFile(type));
    }
}
