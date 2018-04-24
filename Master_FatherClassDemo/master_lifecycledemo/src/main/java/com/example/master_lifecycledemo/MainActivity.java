package com.example.master_lifecycledemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {

    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_RESULT_REQUEST = 333;
    private Uri the_leader_img;
    private Bitmap photo;
    private ImageView mIv_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv_picture = (ImageView) findViewById(R.id.iv_picture);
    }

    public void getPhoto(View view){
        Intent intentFromGallery = new Intent();
        // 设置文件类型
        intentFromGallery.setType("image/*");
        intentFromGallery.setAction(Intent.ACTION_PICK);
        startActivityForResult(intentFromGallery, CODE_GALLERY_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data==null){
            return;
        }else {
            if (resultCode==RESULT_OK){
               switch (requestCode){
                   case CODE_GALLERY_REQUEST:
                       cropRawPhoto(data.getData());
                       break;
                   case CODE_RESULT_REQUEST:
                       if (data != null) {
                           setImageToHeadView(data);
                       }
                       break;
               }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void cropRawPhoto(Uri uri) {
        the_leader_img = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX , aspectY :宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        int output_X = 300;
        int output_Y = 300;
        // outputX , outputY : 裁剪图片宽高
        intent.putExtra("outputX", output_X);
        intent.putExtra("outputY", output_Y);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CODE_RESULT_REQUEST);
    }

    private void setImageToHeadView(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            photo = extras.getParcelable("data");
            mIv_picture.setImageBitmap(photo);
        }
    }

}
