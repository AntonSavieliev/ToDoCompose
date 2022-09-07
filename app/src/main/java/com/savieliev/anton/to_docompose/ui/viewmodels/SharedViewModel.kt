package com.savieliev.anton.to_docompose.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savieliev.anton.to_docompose.data.models.ToDoTask
import com.savieliev.anton.to_docompose.data.repositories.ToDoRepository
import com.savieliev.anton.to_docompose.util.RequestState
import com.savieliev.anton.to_docompose.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<ToDoTask>>> = _allTasks

    fun getAllTasks() {
        viewModelScope.launch {
            _allTasks.value = RequestState.Loading
            try {
                repository.getAllTasks.collect {
                    _allTasks.value = RequestState.Success(it)
                }
            } catch (e: Exception) {
                _allTasks.value = RequestState.Error(e)
            }
        }
    }
}
