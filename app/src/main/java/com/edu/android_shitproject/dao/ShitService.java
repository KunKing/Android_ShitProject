package com.edu.android_shitproject.dao;

import com.edu.android_shitproject.entity.ShitItem;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Ming on 2015/12/29.
 */
public interface ShitService {
    /**
     *
     * @param type
     * @param page @Query("page")  是 get  @Field 是 post
     * @return
     */
    @GET("article/list/{type}")
    Call<ShitItem> getList(@Path("type") String type, @Query("page") int page);


}
