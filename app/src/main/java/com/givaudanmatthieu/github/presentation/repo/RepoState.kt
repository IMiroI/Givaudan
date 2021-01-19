package com.givaudanmatthieu.github.presentation.repo

import com.givaudanmatthieu.github.domain.model.UserRepo
import com.givaudanmatthieu.github.domain.model.UserShort

sealed class RepoState {
    class SuccessState(val repos: List<UserRepo>) : RepoState()

    object ErrorState : RepoState()

    object LoadingState : RepoState()
}