package com.huangliner.todocompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.data.repositories.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel() {

    private val _allTask = MutableStateFlow<List<ToDoTask>>(emptyList())

    val allTask = _allTask.asStateFlow()

    fun getAllTask(){
        viewModelScope.launch {
            toDoRepository.getAllTasks
                .collect{
                    _allTask.value = it
                }
        }
    }
}