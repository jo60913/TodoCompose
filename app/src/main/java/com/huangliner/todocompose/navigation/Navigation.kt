package com.huangliner.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_docompose.util.Constants.LIST_SCREEN
import com.huangliner.todocompose.navigation.destinations.listComposable
import com.huangliner.todocompose.navigation.destinations.taskComposable
import com.huangliner.todocompose.ui.viewmodel.SharedViewModel

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task,
            sharedViewModel = sharedViewModel
        )

        taskComposable (
            navigateToListScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
    }
}