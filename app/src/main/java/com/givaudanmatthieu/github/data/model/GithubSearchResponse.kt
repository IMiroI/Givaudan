package com.givaudanmatthieu.github.data.model

import com.google.gson.annotations.SerializedName

data class GithubSearchResponse(
        @SerializedName("items")
        val users: List<GithubUserShort>,
        @SerializedName("total_count")
        val resultNumber: Int,
)
