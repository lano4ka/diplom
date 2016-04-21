package com.sveta.diplom.api;

import com.sveta.diplom.domain.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by User on 20.04.2016.
 */
public interface AuthService {
    @GET("/auth")
    Call<User> login(@Header("Authorization") String authorization);
}
