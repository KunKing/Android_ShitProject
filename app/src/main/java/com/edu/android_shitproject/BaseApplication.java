package com.edu.android_shitproject;

import android.app.Application;
import android.graphics.Bitmap;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

/**
 * Created by Ming on 2015/12/30.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Picasso picasso = new Picasso.Builder(this)
                .memoryCache(new LruCache(10 << 20))
                .downloader(new OkHttpDownloader(getCacheDir(), 30 << 20))
                .defaultBitmapConfig(Bitmap.Config.RGB_565)
                .build();
        // 设定之后 全部都生效
        Picasso.setSingletonInstance(picasso);
    }
}
