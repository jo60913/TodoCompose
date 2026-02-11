package com.huangliner.todocompose.navigation

import android.util.Log
import androidx.navigation.NavController
import com.example.to_docompose.util.Action
import com.example.to_docompose.util.Constants.LIST_SCREEN

class Screens(navController: NavController) {
    val list: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
    val task: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
}