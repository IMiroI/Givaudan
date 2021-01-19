package com.givaudanmatthieu.github.domain.repository

import com.givaudanmatthieu.github.domain.model.UserRepo
import com.givaudanmatthieu.github.domain.model.UserShort

interface UserRepository {

    suspend fun searchUser(search: String): List<UserShort>

    suspend fun getUserRepo(text: String): List<UserRepo>

}