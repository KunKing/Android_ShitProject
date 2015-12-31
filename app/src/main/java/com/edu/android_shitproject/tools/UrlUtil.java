package com.edu.android_shitproject.tools;

public class UrlUtil {


    // 专享
    public final static String URL_HOT_SUGGEST = "http://m2.qiushibaike.com/article/list/suggest?page=";
    // 视频
    public final static String URL_VIDEO = "http://m2.qiushibaike.com/article/list/video?page=";

    // 纯文
    public final static String URL_TEXT = "http://m2.qiushibaike.com/article/list/text?page=";

    // 纯图
    public final static String URL_IMG = "http://m2.qiushibaike.com/article/list/image?page=";

    // 最新
    public final static String URL_HOT_LATEST = "http://m2.qiushibaike.com/article/list/latest?page=";

    //评论
    public final static String Comment = "http://m2.qiushibaike.com/article/%d/comments?page=2";

    //头像获取(+ id去掉后4位 + "/" + id + "/thumb/" + icon图片名.jpg)
    //userIcon======http://pic.qiushibaike.com/system/avtnew/1499/14997026/thumb/20140404194843.jpg
    public final static String URL_USER_ICON="http://pic.qiushibaike.com/system/avtnew/%s/%s/thumb/%s";
    //内容图片获取(+图片名从数字开始去掉后4位+图片名从数字开始数全部+"/"+"/"+small或者medium+"/"+图片名)
    //====图片Url=http://pic.qiushibaike.com/system/pictures/7128/71288069/small/app71288069.jpg
    public final static String URL_IMAGE= "http://pic.qiushibaike.com/system/pictures/%s/%s/%s/%s";


}

 
