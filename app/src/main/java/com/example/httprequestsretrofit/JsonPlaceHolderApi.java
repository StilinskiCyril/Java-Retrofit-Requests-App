package com.example.httprequestsretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface JsonPlaceHolderApi {
    @GET("posts")
    //use an array for multiple user query instances
    Call<List<Post>> getPosts(@Query("userId") Integer[] userId,
                              @Query("_sort") String sort,
                              @Query("_order") String order);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    //updates all the fields
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    //updates the only requested fields
    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}
