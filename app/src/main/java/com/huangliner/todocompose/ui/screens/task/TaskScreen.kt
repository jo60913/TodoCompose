package com.huangliner.todocompose.ui.screens.task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.util.Action
import com.huangliner.todocompose.ui.viewmodel.SharedViewModel

@Composable
fun TaskScreen(
    navigationToListScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel,
    selectTask: ToDoTask?
) {

    val title by sharedViewModel.title
    val priority by sharedViewModel.priority
    val description by sharedViewModel.description
    Scaffold(
        topBar = {
            TaskAppBar(
                navigationToListScreen = navigationToListScreen
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                TaskContent(
                    title = title,
                    onTitleChange = { title -> sharedViewModel.updateTitle(title) },
                    priority = priority,
                    onPrioritySelected = { priority -> sharedViewModel.updatePriority(priority) },
                    description = description,
                    onDescriptionChange =  { desc -> sharedViewModel.updateDescription(desc) }
                )
            }
        },
    )
}