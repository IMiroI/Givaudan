package com.givaudanmatthieu.github.data.repository

import com.givaudanmatthieu.github.data.api.GithubApi
import com.givaudanmatthieu.github.data.model.GithubRepo
import com.givaudanmatthieu.github.data.model.GithubUserShort
import com.givaudanmatthieu.github.domain.model.UserRepo
import com.givaudanmatthieu.github.domain.model.UserShort
import com.givaudanmatthieu.github.domain.repository.UserRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepository: UserRepository {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(GithubApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(GithubApi::class.java)

    override suspend fun searchUser(search: String): List<UserShort> {
        return api.searchUser(search).users.map {
            it.toUserShort()
        }
    }

    override suspend fun getUserRepo(text: String): List<UserRepo> {
        return api.getUserRepo(text).map {
            it.toUserRepos()
        }
    }
}

fun GithubUserShort.toUserShort() = UserShort(this.id, this.login, this.avatar)

fun GithubRepo.toUserRepos() = UserRepo(
    this.id,
    this.name,
    this.description,
    this.language,
    this.forks,
    this.watchers,
    this.license?.name,
)