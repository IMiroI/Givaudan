package com.givaudanmatthieu.github.data.model

import com.google.gson.annotations.SerializedName

data class GithubLicense(
        @SerializedName("name")
        val name: String?,
)
