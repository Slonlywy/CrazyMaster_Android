package com.example.yunwen.master_richtext.richText.listener;

import java.util.ArrayList;

/**
 * Created by chenhaohui on 16/5/21.
 */
public interface OnTextViewClickListener {

    void imageClicked(ArrayList<String> imageUrls, int position);

    void textLinkClicked(String url, String name);
}