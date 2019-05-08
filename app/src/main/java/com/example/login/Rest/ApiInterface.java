package com.example.login.Rest;

import com.example.login.Model.Data;
import com.example.login.Model.Result;
import com.example.login.Model.ResultTask;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("/account/login?channel=mobile")
    Call<Data> login(@Query("email") String email, @Query("password") String password);

    @GET("/tasks/medisagi/{page}/10")
    Call<Result> getTask(@Path("page") int page);

}