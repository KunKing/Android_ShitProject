package com.edu.android_shitproject.dao;

import com.edu.android_shitproject.entity.ShitCommentsEntity;
import com.edu.android_shitproject.entity.ShitItemEntity;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Ming on 2015/12/29.
 */
public interface ShitItemService {
    /**
     *
     * @param userId
     * @param page @Query("page")  是 get  @Field 是 post
     * @return
     */
    @GET("article/{userId}/comments")
    Call<ShitCommentsEntity> getList(@Path("userId") String userId, @Query("page") int page);

}
