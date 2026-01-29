package com.huangliner.todocompose.navigation.destinations

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.util.Action
import com.example.to_docompose.util.Constants.TASK_ARGUMENT_KEY
import com.example.to_docompose.util.Constants.TASK_SCREEN
import com.huangliner.todocompose.ui.screens.task.TaskScreen
import com.huangliner.todocompose.ui.viewmodel.SharedViewModel

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        Log.e("測試","task id ${taskId}")

        LaunchedEffect(key1 = taskId) {
            sharedViewModel.getSelectedTask(taskId = taskId)
        }

        val selectTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = selectTask) {
            if (selectTask != null || taskId == -1)
                sharedViewModel.updateTaskFields(selectedTask = selectTask)
        }

        TaskScreen(
            navigationToListScreen = navigateToListScreen,
            sharedViewModel= sharedViewModel,
            selectTask = selectTask
        )
    }
}