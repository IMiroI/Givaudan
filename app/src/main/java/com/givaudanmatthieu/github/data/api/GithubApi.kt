package com.givaudanmatthieu.github.data.api

import com.givaudanmatthieu.github.data.model.GithubRepo
import com.givaudanmatthieu.github.data.model.GithubSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("/search/users")
    suspend fun searchUser(
        @Query("q") login: String,
    ) : GithubSearchResponse

    @GET("/users/{login}/repos")
    suspend fun getUserRepo(
        @Path("login") login: String,
    ) : List<GithubRepo>

}