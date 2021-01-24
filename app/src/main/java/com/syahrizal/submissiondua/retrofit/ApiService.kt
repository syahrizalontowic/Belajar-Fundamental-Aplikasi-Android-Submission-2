package com.syahrizal.submissiondua.retrofit

import com.syahrizal.submissiondua.model.detailuser.DetailUser
import com.syahrizal.submissiondua.model.repository.Repository
import com.syahrizal.submissiondua.model.user.ResponseUser
import com.syahrizal.submissiondua.model.user.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    @Headers("Authorization:7e3602f9c4fab4537c2747ddb04c81a517f15f5a")
    fun getSearchData(
        @Query("q") query: String
    ) : Call<ResponseUser>


    @GET("users/{username}")
    @Headers("Authorization:7e3602f9c4fab4537c2747ddb04c81a517f15f5a")
    fun getDetailUser(
        @Path("username") username : String
    ) : Call<DetailUser>


    @GET("users/{username}/followers")
    @Headers("Authorization:7e3602f9c4fab4537c2747ddb04c81a517f15f5a")
    fun getFollowersData(
        @Path("username") username : String,
        @Query("page") page : String
    ) : Call<List<User>>


    @GET("users/{username}/following")
    @Headers("Authorization:7e3602f9c4fab4537c2747ddb04c81a517f15f5a")
    fun getFollowingData(
        @Path("username") username : String,
        @Query("page") page : String
    ) : Call<List<User>>


    @GET("users/{username}/repos")
    @Headers("Authorization:7e3602f9c4fab4537c2747ddb04c81a517f15f5a")
    fun getRepositoryData(
        @Path("username") username : String
    ) : Call<List<Repository>>

}