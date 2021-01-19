package com.givaudanmatthieu.github.presentation.repo

import android.app.Application
import androidx.lifecycle.*
import com.givaudanmatthieu.github.data.repository.GithubRepository
import com.givaudanmatthieu.github.domain.repository.UserRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class RepoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository = GithubRepository()

    private val _state = MutableLiveData<RepoState>()
    val state: LiveData<RepoState> get() = _state

    fun getUserRepo(text: String) {
        _state.value = RepoState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = RepoState.SuccessState(repository.getUserRepo(text))
            } catch (e: Exception) {
                _state.value = RepoState.ErrorState
            }
        }
    }

}