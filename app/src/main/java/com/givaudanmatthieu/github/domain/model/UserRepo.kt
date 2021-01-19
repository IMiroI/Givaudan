package com.givaudanmatthieu.github.domain.model

import java.util.*

data class UserRepo(
    val id: Int,
    val name: String,
    val description: String,
    val language: String,
    val forks: Int,
    val watchers: Int,
    val license: String,
)