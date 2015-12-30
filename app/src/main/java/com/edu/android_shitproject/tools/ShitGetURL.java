package com.edu.android_shitproject.tools;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ming on 2015/12/29.
 */
public class ShitGetURL {

    private static final String TAG = "ShitGetURL";

    // 获取头像
    public static String getIconURL(long id, String icon) {
        String url = "http://pic.qiushibaike.com/system/avtnew/%s/%s/thumb/%s";
        return String.format(url, id / 10000, id, icon);
    }

    // 获取 内容图片
    public static String getImageURL(String image) {
        String url = "http://pic.qiushibaike.com/system/pictures/%s/%s/%s/%s";
        Pattern pattern = Pattern.compile("(\\d+)\\d{4}");
        Matcher matcher = pattern.matcher(image);
        matcher.find();
        Log.d(TAG, "getImageURL: " + matcher.group());
        // TODO: 2015/12/29 检测网络  工具类 返回师傅是 wifi  medium 或者 3g small
        return String.format(url, matcher.group(1), matcher.group(), "small", image);
    }

    public static String getCommentURL(long id){
        String url = "http://m2.qiushibaike.com/article/%d/comments?page=2";
        return String.format(url,id);
    }
}
