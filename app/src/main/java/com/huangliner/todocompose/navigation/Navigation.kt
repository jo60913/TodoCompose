package com.huangliner.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_docompose.util.Constants.LIST_SCREEN
import com.huangliner.todocompose.navigation.destinations.listComposable
import com.huangliner.todocompose.navigation.destinations.taskComposable

@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task
        )

        taskComposable (
            navigateToListScreen = screen.list
        )
    }
}