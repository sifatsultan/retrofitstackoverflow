package com.vogella.android.retrofitstackoverflow;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Sifat on 2/4/2016.
 */
public interface WordPressAPI {
    @GET("/wp-json/wp/v2/posts")
    Call<List<WordpressPost>> loadPosts();

    @GET("/wp-json/wp/v2/media")
    Call<List<WordpressMedia>> loadMedia();
}
