package com.example.composeapiclient.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapiclient.core.Resource
import com.example.composeapiclient.domain.model.User
import com.example.composeapiclient.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow<Resource<List<User>>>(Resource.Loading())
    val uiState: StateFlow<Resource<List<User>>> = _uiState

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _uiState.value = Resource.Loading()
            try {
                _uiState.value = getUsersUseCase()
                Log.d("UserViewModel", "Users fetched successfully: " +  _uiState.value)
            }catch (e: Exception){
                _uiState.value = Resource.Error(e.message ?: "Unknown error")
            }

        }

    }

    fun getUserById(userId: Int?): User? {

        val users = (_uiState.value as? Resource.Success)?.data

        return users?.find { it.id == userId }

    }


}