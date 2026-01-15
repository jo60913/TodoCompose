package com.huangliner.todocompose.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.data.repositories.ToDoRepository
import com.example.to_docompose.util.RequestState
import com.example.to_docompose.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel() {
    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")
    private val _allTask = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)

    val allTask = _allTask.asStateFlow()

    fun getAllTask(){
        _allTask.value = RequestState.Loading
        try {
            viewModelScope.launch {
                toDoRepository.getAllTasks
                    .collect {
                        _allTask.value = RequestState.Success(it)
                    }
            }
        }catch (e:Exception) {
            _allTask.value = RequestState.Error(e)
        }
    }
}