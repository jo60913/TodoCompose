package com.huangliner.todocompose.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TaskAppBar(
                todoTask = selectTask,
                navigationToListScreen = { action->
                    if (action == Action.NO_ACTION) {
                        navigationToListScreen(action)
                    } else {
                        if (sharedViewModel.validateFields()) {
                            navigationToListScreen(action)
                        } else {
                            displayToast(context = context)
                        }
                    }
                }
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

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Fields Empty.",
        Toast.LENGTH_SHORT
    ).show()
}
