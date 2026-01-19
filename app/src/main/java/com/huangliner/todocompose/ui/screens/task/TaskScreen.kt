package com.huangliner.todocompose.ui.screens.task

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.to_docompose.util.Action

@Composable
fun TaskScreen(
    navigationToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = { TaskAppBar(navigationToListScreen = navigationToListScreen) },
        content = { Text(text = "測試")},
    )
}