package com.edu.android_shitproject.tools;

import com.edu.android_shitproject.dao.ShitService;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Ming on 2015/12/31.
 */
public class HttpUtils {

    private static ShitService service;

    static {
        service = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ShitService.class);
    }

    public static ShitService getService() {
        return service;
    }
}
