package com.example.todocomposemyself.presentation.ui.actionbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.todocomposemyself.core.Action
import com.example.todocomposemyself.data.ToDoTask

@ExperimentalMaterial3Api
@Composable
fun TaskAppBar(
    selectTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    if(selectTask == null){
        TopAppBar(
            navigationIcon = {
                NavigateIcon(navigateToListScreen = navigateToListScreen)
            },
            title = { Text(text = "新增Task") },
            actions = { AddAction(navigateToListScreen = navigateToListScreen) },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                titleContentColor = Color.Black,
                containerColor = Color.LightGray
            )
        )
    }else{
        TopAppBar(
            navigationIcon = {
                NavigateIcon(navigateToListScreen = navigateToListScreen)
            },
            title = { Text(text = selectTask.title) },
            actions = { UpdateAction(navigateToListScreen = navigateToListScreen) },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                titleContentColor = Color.Black,
                containerColor = Color.LightGray
            )
        )
    }

}

@Composable
fun AddAction(navigateToListScreen: (Action) -> Unit) {
    IconButton(onClick = { navigateToListScreen(Action.NO_ACTION) }) {
        Icon(imageVector = Icons.Filled.Done, contentDescription = "完成")
    }
}

@Composable
fun UpdateAction(navigateToListScreen: (Action) -> Unit) {
    IconButton(onClick = { navigateToListScreen(Action.NO_ACTION) }) {
        Icon(imageVector = Icons.Filled.Check, contentDescription = "更新")
    }
}

@Composable
fun NavigateIcon(navigateToListScreen: (Action) -> Unit) {
    IconButton(onClick = { navigateToListScreen(com.example.todocomposemyself.core.Action.NO_ACTION) }) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "返回")
    }
}