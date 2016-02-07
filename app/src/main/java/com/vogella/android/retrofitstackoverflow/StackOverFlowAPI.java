package com.vogella.android.retrofitstackoverflow;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Sifat on 2/4/2016.
 */
public interface StackOverFlowAPI {
    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<StackOverFlowQuestions> loadQuestions(@Query("tagged") String tags);
}
