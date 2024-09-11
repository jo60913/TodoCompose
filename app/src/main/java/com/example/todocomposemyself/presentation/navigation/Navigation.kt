package com.example.todocomposemyself.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todocomposemyself.core.LIST_ARGUMENT_KEY
import com.example.todocomposemyself.core.LIST_SCREEN
import com.example.todocomposemyself.core.TASK_ARGUMENT_KEY
import com.example.todocomposemyself.core.TASK_SCREEN
import com.example.todocomposemyself.core.toAction
import com.example.todocomposemyself.presentation.ui.screen.ListScreen
import com.example.todocomposemyself.presentation.ui.screen.TaskScreen
import com.example.todocomposemyself.viewmodel.SharedViewModel

@ExperimentalMaterial3Api
@Composable
fun SetUpNavigation(
    naviController: NavHostController,
    viewModel: SharedViewModel,
) {
    NavHost(
        navController = naviController,
        startDestination = LIST_SCREEN
    ) {
        composable(
            route = LIST_SCREEN,
            arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
            ListScreen(
                naviController = naviController,
                viewModel = viewModel
            )
        }

        composable(
            route = TASK_SCREEN,
            arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val taskID = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
            LaunchedEffect(key1 = taskID){
                viewModel.getSelectedTask(taskId = taskID)
            }
            TaskScreen(
                naviController = naviController,
                viewModel = viewModel
            )
        }
    }
}